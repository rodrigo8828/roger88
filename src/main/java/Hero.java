import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;

public class Hero {
    private int x;
    private int y;

    public Hero(int xx, int yy) {
        int x = xx;
        int y = yy;
    }
    public void moveUp(){
        setY(y-1);
    }
    public void moveRight(){
        setX(x+1);
    }
    public void moveLeft(){
        setX(x-1);
    }
    public void moveDown(){
        setY(y+1);
    }
    public void draw(TerminalScreen screen) {
        screen.setCharacter(getX(), getY(), TextCharacter.fromCharacter('X')[0]);
    }
    private int getX(){
        return x;
    }
    private int getY(){
        return y;
    }
    private void setX(int xx){
        x = xx;
    }
    private void setY(int yy){
        y = yy;
    }

}

