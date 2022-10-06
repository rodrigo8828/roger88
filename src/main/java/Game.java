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
    private Arena arena;


    public Game(int alt,int larg) {
        try {
            arena = new Arena(17,17);
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
            arena.draw(screen);
            screen.refresh();

        }
        public void run() throws IOException {
            while (true){
                draw();
                KeyStroke key = screen.readInput();
                if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                    screen.close();
                }
                if(key.getKeyType() == KeyType.EOF){
                    break;
                }
                processKey(key);
           }
        }
    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }

    private void moveHero(Position position) {
        arena.setPosition(position);
    }


}
