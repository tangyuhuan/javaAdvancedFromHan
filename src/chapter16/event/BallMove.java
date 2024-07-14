package chapter16.event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**p575 小球移动案例
 * @author tyh
 * @version 1.0
 * 演示小球通过键盘控制上下左右的移动-> 讲解Java的事件控制
 */
public class BallMove extends JFrame {
    private MyPanel mp = null;
    public BallMove(){
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口(画框)
        this.add(mp);
        //设置窗口的大小
        this.setSize(400, 300);
        //虽然面板可以监听键盘事件了，但是JFrame是不知道的
        //让窗口JFrame 对象可以监听键盘事件, 即可以监听到面板发生的键盘事件
        //this.addKeyListener(new KeyListener() {}) 以下利用了多态
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可以显示,当组件第一次在屏幕显示的时候，程序会自动调用paint方法
    }
    public static void main(String[] args) {
        new BallMove();
    }
}

//事件监听器接口有很多种，此处只关注键盘按下事件，故用KeyListener
//1.先定义一个MyPanel,继承JPanel类，画图形，就在面板上画
//KeyListener是监听器，可以监听键盘事件
class MyPanel extends JPanel implements KeyListener {

    //为了让小球可以移动, 把他的左上角的坐标(x,y)设置变量
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类的方法完成初始化
        //填充椭圆fillOval(intx,inty,intwidth,intheight)
        g.fillOval(x, y, 20, 20);

    }
    //有字符输出时，该方法就会触发
    //KeyEvent e就是事件对象，把此信息传递给事件的监听者
    //事件源---------（事件/对象）-----------事件监听者（里面写事件处理方法）
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //当某个键按下，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyCode() + "被按下..");
        //根据用户按下的不同键，来处理小球的移动 (上下左右的键)
        //在java中，会给每一个键，分配一个值(int)
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            y++;
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            y--;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        //让面板重绘
        this.repaint();
    }
    //当某个键释放(松开)，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}