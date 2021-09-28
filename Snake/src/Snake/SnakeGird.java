package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author shkstart
 * @create 2021-09-27 18:54
 */
public class SnakeGird extends JPanel {

    Food food = new Food();

     Snake snake= new Snake(food);

    ImageIcon imageIcon = new ImageIcon("Snake/瑟提.png");

    SnakeThread snakeThread=new SnakeThread();




    SnakeGird(){
        this.setBounds(0,0,900,600);

        this.setBackground(Color.black);

        snakeThread.start();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.keyboard(e);
            }
        });
    }






    @Override
    public void paint(Graphics g) {
        super.paint(g);
        imageIcon.paintIcon(this,g,0,0);

        snake.move();

        snake.draw(g);

        food.draw(g);
    }








    class SnakeThread extends Thread{
        boolean flag = true;

        @Override
        public void run() {
            while(Snake.isAlive&&flag){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if(Snake.isAlive){
                    repaint();

                }
            }
            if(!flag == false){
                JOptionPane.showMessageDialog(SnakeGird.this,"游戏结束");
            }
        }

        public void stopThread(){
            flag = false;
        }



    }

}
