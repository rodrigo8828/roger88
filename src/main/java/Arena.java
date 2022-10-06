import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;

public class Arena {
    private int width; //campos
    private int heigth;
    private Hero hero;

    public Arena(int w, int h){ //construtor
        width = w;
        heigth = h;
        hero = new Hero(new Position(10,10));

    }
    private boolean canHeroMove(Position position){
        if(position.getX() <= width && position.getY() <= heigth && position.getX() >= 0 && position.getY() >= 0 ){
            return true;
        }
        else{
            return false;
        }
    }
    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
    public int getWidth(){ //sempre publics com valor do campo
        return width;
    }
    public int getHeigth(){
        return heigth;
    }
    public void setWidth(int xx){  //sempre voids e iguala ao campo
        width = xx;
    }
    public void setHeigth(int yy){
        heigth = yy;
    }
    //gets e sets

   public void processKey(KeyStroke key){
       System.out.println(key);
       if (key.getKeyType() == KeyType.ArrowUp){
           moveHero(hero.moveUp());
       }
       if (key.getKeyType() == KeyType.ArrowDown){
           moveHero(hero.moveDown());
       }
       if(key.getKeyType() == KeyType.ArrowRight){
           moveHero(hero.moveRight());
       }
       if(key.getKeyType() == KeyType.ArrowLeft){
           moveHero(hero.moveLeft());
       }
    }
    public void draw(TerminalScreen screen){
        hero.draw(screen);

    }
    public void setPosition(Position position){
        hero.setPosition(position);
    }
}
