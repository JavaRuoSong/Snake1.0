package Snake;


import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author shkstart
 * @create 2021-09-27 21:46
 */
public class Snake {
    public static final int span = 20;
    public static final String up = "u";
    public static final String down = "d";
    public static final String left = "l";
    public static final String right = "r";
    public static boolean isAlive = true;
    Node body;
    Node head;
    Node tail;
    Food food;
    Snake(Food food){
        body = new Node(5,20,left);
        head = body;
        tail = body;
        this.food = food;
    }


    class Node{
        int row;
        int col;
        String dir;//方向
        Node next;//后继节点
        Node pre;//前驱节点
        Node(int row,int col,String dir){
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
        public void draw1(Graphics g){
            g.fillOval(col*span,row*span,span,span);
        }


    }

    public void draw(Graphics g){
        g.setColor(Color.red);
        for(Node n = head; n!=null ;n= n.next){
            n.draw1(g);
            g.setColor(Color.PINK);
        }

    }

    public void keyboard(KeyEvent k){
        switch (k.getKeyCode()){
            case KeyEvent.VK_UP:
                if(head.dir.equals(down)){
                    break;
                }
                head.dir = up;
                break;
            case KeyEvent.VK_DOWN:
                if(head.dir.equals(up)){
                    break;
                }
                head.dir = down;
                break;
            case KeyEvent.VK_LEFT:
                if(head.dir.equals(right)){
                    break;
                }
                head.dir = left;
                break;
            case KeyEvent.VK_RIGHT:
                if(head.dir.equals(left)){
                    break;
                }
                head.dir = right;
                break;
            default:
                break;
        }

    }

    public void addHead(){
        Node node  =null;
        switch (head.dir){
            case "l":
                node = new Node(head.row,head.col-1,head.dir);
                break;
            case "r":
                node = new Node(head.row,head.col+1,head.dir);
                break;
            case "u":
                node = new Node(head.row-1,head.col,head.dir);
                break;
            case "d":
                node = new Node(head.row+1,head.col,head.dir);
                break;

            default:
                break;
        }
        node.next = head;
        head.pre = node;
        head = node;


    }

    public void deleteTail(){
        tail.pre.next = null;
        tail = tail.pre;
    }

    public void move(){
        addHead();
        if(this.getSnakeRectangle().intersects(food.getZuoBiao())){
            food.show();
        }else {
        deleteTail();
        }
        DeadOrAlive();
    }

    public Rectangle getSnakeRectangle(){
        return new Rectangle(head.col*span,head.row*span,span,span);
    }

    public void DeadOrAlive(){
        if(head.col <0||head.row <0||head.row>29||head.col>44 ){
            isAlive = false;
        }
        for(Node n = head.next;n!=null;n= n.next){
            if(head.col == n.col&&head.row== n.row){
                isAlive = false;
            }
        }
    }


}
