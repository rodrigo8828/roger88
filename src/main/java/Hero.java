import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;

public class Hero {
    private Position position;
    public Hero(Position xxx) {
        position = xxx;

    }
    public Position moveUp(){
        return new Position(position.getX(), position.getY()-1) ;
    }
    public Position moveRight(){
        return new Position(position.getX()+1, position.getY());
    }
    public Position moveLeft(){
        return new Position(position.getX()-1, position.getY());
    }
    public Position moveDown(){
        return new Position(position.getX(), position.getY()+1);
    }
    public void draw(TerminalScreen screen) {
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
    }
    private Position getPosition(){
        return position;
    }

    public void setPosition(Position p){
        position = p;
    }


}

