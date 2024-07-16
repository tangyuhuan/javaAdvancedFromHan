package chapter18.tankgame5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**p608 坦克大战0.5版
 * 增加功能：
 * 1.我方坦克在发射的子弹消亡后,才能发射新的子弹 (只要发射的子弹还没有消亡，就不能发射新子弹)==>扩展：发射多颗子弹怎么办(控制在我们的面板上，最多只能有5颗子弹)
 * 2.让敌人坦克发射的子弹消亡后，才可以发射子弹
 * 3.当敌人的坦克击中我方坦克时，我方坦克消失，并出现爆炸效果
 * 思路：编写方法，判断敌人的坦克是否击中我的坦克
 *
 * @author tyh
 * @version 1.0
 */

//重点！！！为了让Panel不停的重绘子弹，需要将MyPanel实现Runnable 当作一个线程使用，否则paint只运行一次，就看不到子弹运行的效果
public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克，放到Vector（选用Vector是因为其线程安全）
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;
    //定义一个Vector 用于存放炸弹
    Vector<Bomb> bombs = new Vector<>();
    //说明，当子弹击中坦克时，加入一个Bomb对象到bombs

    //定义三张炸弹图片 用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        hero = new Hero(600,100);//初始化自己的坦克
        hero.setSpeed(20);
        //初始化敌人坦克
        for(int i=0;i<enemyTankSize;i++){
            //创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank(100*(i+1),0);
            //设置方向向下
            enemyTank.setDirect(2);
            //创建敌人坦克对象时，启动线程
            new Thread(enemyTank).start();
            //给enemyTank加入一颗子弹
            Shot shot = new Shot(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirect());
            //加入enemyTank的Vector成员
            enemyTank.shots.add(shot);
            //启动shot对象
            new Thread(shot).start();
            //加入集合
            enemyTanks.add(enemyTank);

        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);//调用父类的方法完成初始化
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 750);//填充矩形给一个黑色的背景
        //画出自己的坦克--封装方法
        System.out.println("hero.isLive"+hero.isLive);
        if(hero!=null && hero.isLive){
            drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);//此处体会面向对象的思想
        }
        //画出敌人的坦克，遍历Vector
        for(int i=0;i<enemyTanks.size();i++){
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //判断当前坦克是否还存活
            if(enemyTank.isLive){ //当敌人坦克时存活的，才画出该坦克
                drawTank(enemyTank.getX(), enemyTank.getY(),g,enemyTank.getDirect(),0);
                //画出enemy所有子弹

                for(int j=0;j<enemyTank.shots.size();j++){
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制
                    if(shot.isLive){
                        g.fill3DRect(shot.x, shot.y, 5, 5,false);
                    }else{
                        //从Vector移除,否则一直画
                        enemyTank.shots.remove(j);
                    }
                }
                //让敌人的坦克自由随机的上下左右移动
//                moveRandom(enemyTank,(int)(Math.random()*700), (int)(Math.random()*4));
            }
        }
        //画出hero射击的子弹，由一颗改为遍历集合
/*        if(hero.shot!=null && hero.shot.isLive==true){
            g.setColor(Color.yellow);
            g.fill3DRect(hero.shot.x, hero.shot.y, 5, 5,false);
        }*/
        //将hero子弹集合shots遍历取出绘制
        for(int i=0;i<hero.shots.size();i++){
            Shot shot = hero.shots.get(i);
            if(shot!=null && shot.isLive==true){
                g.setColor(Color.yellow);
                g.fill3DRect(shot.x, shot.y, 5, 5,false);
            }else{//如果该shot对象已经无效，就从该集合中移除
                hero.shots.remove(shot);
            }
        }
        //如果bombs集合中有对象，就画出
        for(int i=0;i<bombs.size();i++){
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画出对应的图片
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(bomb.life>6){
                g.drawImage(image1,bomb.x, bomb.y, 60,60,this);
            }else if(bomb.life > 3){
                g.drawImage(image2,bomb.x, bomb.y, 60,60,this);
            }else{
                g.drawImage(image3,bomb.x, bomb.y, 60,60,this);
            }
            //让炸弹的生命值减少
            bomb.lifeDown();
            //如果bomb life为0，就从bombs的集合中删除
            if(bomb.life == 0){
                bombs.remove(bomb);
            }
        }
        //我的实现
        //当我方的坦克击中敌人的坦克时，敌人的坦克就消失
/*        if(hero.shot!=null && hero.shot.isLive!=false){
            for(int i=0;i<enemyTanks.size();i++) {
                //取出坦克
                EnemyTank enemyTank = enemyTanks.get(i);
                if(hero.shot.x>=enemyTank.getX() && hero.shot.x<=(enemyTank.getX()+40) && hero.shot.y>=enemyTank.getY() && hero.shot.y<=(enemyTank.getY()+60)){
                    enemyTanks.remove(i);
                    hero.shot.isLive=false;
                }
            }
        }*/
    }
    //如果我们的坦克可以发射多颗子弹
    //在判断我方子弹是否击中敌人坦克时，就需要把我们的子弹集合中所有的子弹，都取出和敌人所有的坦克，进行判断
    public void hitEnemyTank(){
        for(int i=0;i<hero.shots.size();i++) {
            Shot shot = hero.shots.get(i);
            //判断是否击中了敌人坦克
            if(shot!=null && shot.isLive!=false){//当前我的子弹还存活
                //遍历敌人所有的坦克
                for(int j=0;j<enemyTanks.size();j++) {
                    //取出坦克
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTank(shot,enemyTank);
                }
            }
        }
    }

    //什么时候判断？由于不知道什么时候，所以放在循环里比较好
    //编写方法，判断子弹是否击中坦克
    public void hitTank(Shot s, Tank tank){
        if(s!=null && s.isLive!=false){
            switch(tank.getDirect()){
                case 0://坦克向上
                case 2://坦克向下
                    if(s.x>=tank.getX() && s.x<=(tank.getX()+40) && s.y>=tank.getY() && s.y<=(tank.getY()+60)){
                        s.isLive=false;
                        tank.isLive = false;
                        //当我的子弹击中敌人的坦克后，将敌人坦克从Vector中移除
                        enemyTanks.remove(tank);
                        //创建Bomb对象，加入到bombs集合
                        Bomb bomb = new Bomb(tank.getX(),tank.getY());
                        bombs.add(bomb);
                    }
                    break;
                case 1://坦克向右
                case 3://坦克向左
                    if(s.x>=tank.getX() && s.x<=(tank.getX()+60) && s.y>=tank.getY() && s.y<=(tank.getY()+40)){
                        s.isLive=false;
                        tank.isLive = false;
                        //当我的子弹击中敌人的坦克后，将敌人坦克从Vector中移除
                        enemyTanks.remove(tank);
                        //创建Bomb对象，加入到bombs集合
                        Bomb bomb = new Bomb(tank.getX(),tank.getY());
                        bombs.add(bomb);
                    }
                    break;
            }


        }
    }
    //编写方法，判断敌人的子弹是否击中我方坦克
    public void hitHeroTank(){
        //遍历敌人所有的坦克
        for(int j=0;j<enemyTanks.size();j++) {
            //取出敌人坦克
            EnemyTank enemyTank = enemyTanks.get(j);
            for(int i=0;i<enemyTank.shots.size();i++) {
                Shot s = enemyTank.shots.get(i);
                if(s!=null && s.isLive!=false && hero.isLive) {//当敌人的子弹还存活,hero的坦克还存活
                    hitTank(s,hero);
                }
            }
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
            case 2://表示向下
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
            case KeyEvent.VK_J: //如果客户按下J，就需要发射
                //我方坦克在发射的子弹消亡后,才能发射新的子弹
                //思路：
                //1.按下J键，判断当前hero对象的子弹是否已经销毁
                //2.如果没有销毁，就不触发 fireBullet
                //3.如果已经销毁，才触发fireBullet
                //4.如果要发射多颗子弹，就使用Vector保存
                //5.在绘制我方子弹时，需要遍历Vector集合

                //判断hero的子弹是否销毁，发射一颗子弹
/*                if((hero.shot==null) || !hero.shot.isLive){
                    hero.fireBullet();
                }*/
                //发射多颗子弹的情况
                hero.fireBullet();
                break;
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔100ms，重绘区域，刷新绘图区域，子弹就移动起来了
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //在这个循环里,每隔100ms判断
            // 我们的子弹是否击中敌人坦克
            hitEnemyTank();
            // 判断敌人坦克是否击中我们
            hitHeroTank();
            this.repaint();
        }
    }





}
