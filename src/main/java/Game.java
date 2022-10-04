import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private TerminalScreen screen;
    private int x = 10;
    private int y = 10;

    public Game(int alt,int larg) {
        try {
            TerminalSize terminalSize = new TerminalSize(alt, larg);
            DefaultTerminalFactory terminalFactory = new
                    DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        private void draw() throws IOException {
            screen.clear();
            screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
            screen.refresh();

        }
        public void run() throws IOException {
            while (true){
                draw();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.Character && key.getCharacter()
                    == 'q'){
                screen.close();
            }
            if(key.getKeyType() == KeyType.EOF){
                break;
            }

                processKey(key);
           }
        }
    private void processKey(KeyStroke key) {
        System.out.println(key);
        if (key.getKeyType() == KeyType.ArrowUp){
            y=y-1;
        }
        if (key.getKeyType() == KeyType.ArrowDown){
            y =y+1;
        }
        if(key.getKeyType() == KeyType.ArrowRight){
            x=x+1;
        }
        if(key.getKeyType() == KeyType.ArrowLeft){
            x = x-1;
        }
    }


}
