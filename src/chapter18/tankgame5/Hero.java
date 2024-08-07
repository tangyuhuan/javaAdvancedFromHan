package chapter18.tankgame5;


import java.util.Vector;

/**p601 我方发射子弹
 * @author tyh
 * @version 1.0
 */
public class Hero extends Tank {
    //定义一个Shot对象，表示一个射击（线程）
    Vector<Shot> shots = new Vector<>();
    Shot shot = null;
    //如果子类和父类中出现同名的成员变量时，尽管同名，但他们是两个完全无关的变量，在子类中访问的是定义在子类中的变量，在父类中访问的是定义在父类中的变量
    //可以看Cat的例子
//    boolean isLive = true;
    public Hero(int x, int y) {
        super(x, y);
    }
    //射击
    public void fireBullet() {
        System.out.println("this.isLive"+super.isLive);
        //控制最多5颗子弹
        if(shots.size() == 5) {
            return;
        }
//        Shot shot = null;
        //创建Shot对象，要根据当前Hero对象的位置和方向来创建Shot
        switch (getDirect()){
            case 0://表示向上
                shot = new Shot(getX()+20,getY(),0);
                break;
            case 1://表示向右
                shot = new Shot(getX()+60,getY()+20,1);
                break;
            case 2://表示向下
                shot = new Shot(getX()+20,getY()+60,2);
                break;
            case 3://表示向左
                shot = new Shot(getX(),getY()+20,3);
                break;
        }
        //把新创建的shot放入到shots
        shots.add(shot);
        //启动射击的线程
        new Thread(shot).start();//启动第1个线程
    }
}
