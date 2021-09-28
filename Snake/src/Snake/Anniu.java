package Snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author shkstart
 * @create 2021-09-28 11:30
 */
public class Anniu extends JPanel {
    public static boolean isMove = true;
    SnakeGird snakeGird;
    Anniu(SnakeGird snakeGird){
        this.snakeGird = snakeGird;
        this.setBounds(0,600,900,100);
        JButton zanting = new JButton("暂停游戏");
        JButton jixu = new JButton("继续游戏");
        JButton remake = new JButton("重新开始");
        this.add(zanting);
        this.add(jixu);
        this.add(remake);

        zanting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isMove = false;
            }
        });

        jixu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isMove = true;
                snakeGird.setFocusable(true);
                snakeGird.requestFocus();
            }
        });

        remake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakeGird.snakeThread.stopThread();

                Food food = new Food();
                snakeGird.food = food;
                snakeGird.snake = new Snake(food);
                Snake.isAlive = true;
                isMove = true;
                SnakeGird.SnakeThread st = snakeGird.new SnakeThread();
                snakeGird.snakeThread = st;
                st.start();

                snakeGird.setFocusable(true);
                snakeGird.requestFocus();

            }
        });




    }
}
