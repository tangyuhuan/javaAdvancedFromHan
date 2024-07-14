package chapter16.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author tyh
 * @version 1.0
 */
public class DrawCircle extends JFrame {//JFrame对应窗口,可以理解成是一个画框
    //定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口(画框)
        this.add(mp);
        //设置窗口的大小
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可以显示,当组件第一次在屏幕显示的时候，程序会自动调用paint方法
    }
}

//1.先定义一个MyPanel,继承JPanel类，画图形，就在面板上画
class MyPanel extends JPanel {
    //1.MyPanel对象就是一个画板
    //2.Graphicsg把g理解成一支画笔
    //3.Graphics提供了很多绘图的方法

    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类的方法完成初始化
        System.out.println("paint方法被调用了~");
        //演示绘制不同的图形..
        //画直线drawLine(intx1,inty1,intx2,inty2)
        g.drawLine(100, 100, 200, 200);
        //画矩形边框 drawRect(intx,inty,intwidth,intheight)
        g.drawRect(10, 10, 100, 100);
        //画椭圆边框drawOval(intx,inty,intwidth,intheight)
        g.drawOval(100, 100, 200, 200);
        //填充矩形fillRect(intx,inty,intwidth,intheight)
        g.fillRect(10, 10, 100, 100);
        //设置画笔的颜色
        g.setColor(Color.blue);
        //填充椭圆fillOval(intx,inty,intwidth,intheight)
        g.fillOval(100, 100, 200, 200);
        //画图片drawImage(Image img,int x,int y,..)
        //1.获取图片资源,/bg.png表示在该项目的根目录(out/javaAdvancedFromHan)去获取bg.png图片资源
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("./bg.png"));
        g.drawImage(image, 10, 10, this);
//        g.drawImage(image,10,10,175,221,this);
        //画字符串drawString(Stringstr,intx,inty)//写字
        //给画笔设置颜色和字体
        g.setColor(Color.red);
        g.setFont(new Font("隶书",Font.BOLD,50));
        //这里设置的100，100，是"北京你好"左下角
        g.drawString("北京你好",100,100);
    }
}