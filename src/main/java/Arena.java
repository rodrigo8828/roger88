import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class Arena {
    private int width; //campos
    private int height;
    private Hero hero;

    public Arena( int width, int height ) { //construtor
        this.width = width;
        this.height = height;
        this.hero = new Hero( new Position( 10, 10 ) );
    }

    private boolean canHeroMove(Position position) {
        if (position.getX() <= width && position.getY() <= height && position.getX() >= 0 && position.getY() >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void moveHero(Position position) {
        if ( canHeroMove(position) ){
            hero.setPosition(position);
        }
    }

    public int getWidth() { //sempre publics com valor do campo
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int xx) {  //sempre voids e iguala ao campo
        width = xx;
    }

    public void setHeight(int yy) {
        height = yy;
    }
    //gets e sets

    public void processKey(KeyStroke key) {
        System.out.println(key);
        if (key.getKeyType() == KeyType.ArrowUp) {
            moveHero(hero.moveUp());
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            moveHero(hero.moveDown());
        }
        if (key.getKeyType() == KeyType.ArrowRight) {
            moveHero(hero.moveRight());
        }
        if (key.getKeyType() == KeyType.ArrowLeft) {
            moveHero(hero.moveLeft());
        }
    }

    public void draw( TextGraphics graphics ) {
        graphics.setBackgroundColor( TextColor.Factory.fromString( "#220022" ) );
        graphics.fillRectangle( new TerminalPosition(0, 0), new TerminalSize(width, height), ' ' );

        hero.draw( graphics );
    }

    public void setPosition(Position position) {
        hero.setPosition(position);
    }
}
