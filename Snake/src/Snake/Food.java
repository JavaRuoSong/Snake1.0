package Snake;

import java.awt.*;

/**
 * @author shkstart
 * @create 2021-09-28 0:09
 */
public class Food {
    int row;
    int col;

    Food() {
        row = 10;
        col = 10;
    }

    public void show(){
        row = (int)(Math.random()*28);
        col = (int)(Math.random()*43);
    }

    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillRect(col*20,row*20,20,20);

    }

    public Rectangle getZuoBiao(){
        return new Rectangle(col*20,row*20,20,20);
    }

}
