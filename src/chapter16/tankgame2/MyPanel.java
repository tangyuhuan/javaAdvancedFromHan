package chapter16.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**p573 坦克大战绘图区
 * p574 绘制坦克
 * p577 绘制坦克上下左右
 * p579 绘制敌人坦克
 * p600 坦克发子弹思路
 * @author tyh
 * @version 1.0
 */
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克，放到Vector（选用Vector是因为其线程安全）
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(100,100);//初始化自己的坦克
        hero.setSpeed(10);
        //初始化敌人坦克
        for(int i=0;i<enemyTankSize;i++){
            //创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank(100*(i+1),0);
            //设置方向向下
            enemyTank.setDirect(2);
            //加入集合
            enemyTanks.add(enemyTank);
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);//调用父类的方法完成初始化
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 750);//填充矩形给一个黑色的背景
        //画出自己的坦克--封装方法
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);//此处体会面向对象的思想
        //画出敌人的坦克，遍历Vector
        for(int i=0;i<enemyTankSize;i++){
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(),g,enemyTank.getDirect(),0);
        }
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
            case 0://敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //我们的坦克
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克方向，来绘制坦克
        //direct 表示方向（0向上 1向右 2向下 3向左）
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
                break;
            case 1://表示向右
                //填充矩形fillRect(intx,inty,intwidth,intheight)
                g.fill3DRect(x, y, 60, 10,false);//画出坦克上边轮子
                g.fill3DRect(x, y+30, 60, 10,false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20,false);//画出坦克盖子
                //填充椭圆fillOval(intx,inty,intwidth,intheight)
                g.fillOval(x+20, y+10, 20, 20);//画出圆形盖子
                //画直线drawLine(intx1,inty1,intx2,inty2)
                g.drawLine(x+30, y+20, x+60, y+20);//画出炮筒
                break;
            case 2://表示向上
                //填充矩形fillRect(intx,inty,intwidth,intheight)
                g.fill3DRect(x, y, 10, 60,false);//画出坦克左边轮子
                g.fill3DRect(x+30, y, 10, 60,false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40,false);//画出坦克盖子
                //填充椭圆fillOval(intx,inty,intwidth,intheight)
                g.fillOval(x+10, y+20, 20, 20);//画出圆形盖子
                //画直线drawLine(intx1,inty1,intx2,inty2)
                g.drawLine(x+20, y+30, x+20, y+60);//画出炮筒
                break;
            case 3://表示向左
                //填充矩形fillRect(intx,inty,intwidth,intheight)
                g.fill3DRect(x, y, 60, 10,false);//画出坦克上边轮子
                g.fill3DRect(x, y+30, 60, 10,false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20,false);//画出坦克盖子
                //填充椭圆fillOval(intx,inty,intwidth,intheight)
                g.fillOval(x+20, y+10, 20, 20);//画出圆形盖子
                //画直线drawLine(intx1,inty1,intx2,inty2)
                g.drawLine(x+30, y+20, x, y+20);//画出炮筒
                break;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //处理wdsa 键按下的情况,(0: 向上 1 向右 2 向下 3 向左 )
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_S:
                //改变坦克的方向
                hero.setDirect(2);
                //修改坦克的坐标 y += 1
                //hero.setY(hero.getY()+1);//这种写法没有体现面向对象的思想
                hero.moveDown();
                break;
            case KeyEvent.VK_W:
                hero.setDirect(0);
                hero.moveUp();
                break;
            case KeyEvent.VK_A:
                hero.setDirect(3);
                hero.moveLeft();
                break;
            case KeyEvent.VK_D:
                hero.setDirect(1);
                hero.moveRight();
                break;
            case KeyEvent.VK_J:

                break;
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
