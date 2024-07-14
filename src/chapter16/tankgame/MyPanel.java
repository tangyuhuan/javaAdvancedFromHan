package chapter16.tankgame;

import javax.swing.*;
import java.awt.*;

/**p573 坦克大战绘图区
 * p574 绘制坦克
 * @author tyh
 * @version 1.0
 */
public class MyPanel extends JPanel {
    //定义我的坦克
    Hero hero = null;
    public MyPanel() {
        hero = new Hero(100,100);//初始化

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);//调用父类的方法完成初始化
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 750);//填充矩形给一个黑色的背景
        //画出坦克--封装方法
        drawTank(hero.getX(),hero.getY(),g,0,0);//此处体会面向对象的思想

    }
    //编写方法，画出坦克
    /**
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   坦克类型
     */
    public void drawTank(int x,int y,Graphics g,int direct,int type) {
        //根据不同类型坦克，设置不同颜色
        switch (type){
            //设置画笔的颜色
            case 0://我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌人的坦克
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克方向，来绘制坦克
        switch (direct){
            case 0://表示向上
                //填充矩形fillRect(intx,inty,intwidth,intheight)
                g.fill3DRect(x, y, 10, 60,false);//画出坦克左边轮子
                g.fill3DRect(x+30, y, 10, 60,false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40,false);//画出坦克盖子
                //填充椭圆fillOval(intx,inty,intwidth,intheight)
                g.fillOval(x+10, y+20, 20, 20);//画出圆形盖子
                //画直线drawLine(intx1,inty1,intx2,inty2)
                g.drawLine(x+20, y+30, x+20, y);//画出炮筒
        }
    }

}
