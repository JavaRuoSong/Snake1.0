package Snake;

import javax.swing.*;
import java.awt.*;

/**
 * @author shkstart
 * @create 2021-09-27 18:44
 */
public class SnakeWindow extends JFrame {

    SnakeGird snakeGird = new SnakeGird();
     Anniu anniu= new Anniu(snakeGird);

    public SnakeWindow(){
        this.setBounds(100,50,900,700);//设置窗口大小
        this.setLayout(null);//添加组件
        this.setVisible(true);//设置窗口可见
//        this.setBackground(Color.black);//设置背景颜色
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭状态
        this.setResizable(false);//窗口不可改变大小
        this.add(snakeGird);//添加snakeGrid
        snakeGird.setFocusable(true);
        snakeGird.requestFocus();
        this.add(anniu);

    }

    public static void main(String[] args) {
        new SnakeWindow();
    }
}
