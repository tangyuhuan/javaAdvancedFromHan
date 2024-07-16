package chapter18.tankgame5;

import java.util.Vector;

/**p609 敌方移动发射
 *  * 增加功能：
 *  * 1.我方坦克在发射的子弹消亡后,才能发射新的子弹 (只要发射的子弹还没有消亡，就不能发射新子弹)==>扩展：发射多颗子弹怎么办(控制在我们的面板上，最多只能有5颗子弹)
 *  * 2.让敌人坦克发射的子弹消亡后，可以接着发射子弹
 *  * 3.当敌人的坦克击中我方坦克时，我方坦克消失，并出现爆炸效果
 * p578绘制敌人坦克
 * @author tyh
 * @version 1.0
 */
public class EnemyTank extends Tank implements Runnable {
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while(true){
            //让敌人坦克发射的子弹消亡后，可以接着发射子弹!!重要
            //这里判断如果shots size()<1,说明集合里已经没有子弹了,就创建一颗子弹放入集合，并启动
            //如果shots.size() < 3 就是控制敌人可以发3颗子弹
            if(isLive && shots.size() < 1){
                //判断坦克的方向，创建对应的子弹
                Shot shot = null;
                //创建Shot对象，要根据当前Hero对象的位置和方向来创建Shot
                switch (this.getDirect()){
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
                shots.add(shot);
                //启动shot对象
                new Thread(shot).start();
            }
//            moveRandom();
//            moveRandom(this,(int)(Math.random()*700), (int)(Math.random()*4));
            switch(getDirect()){
                case 0://表示向上
                    //重要！！不能移动了一步就马上转方向
                    //让坦克保持一个方向走30步
                    for(int i=0;i<30;i++){
                        moveUp();
                        //如果没有sleep会一下子闪到30步
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1://表示向右
                    for(int i=0;i<30;i++){
                        moveRight();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2://表示向下
                    for(int i=0;i<30;i++){
                        moveDown();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3://表示向左
                    for(int i=0;i<30;i++){
                        moveLeft();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }

            //随机改变坦克方向0-3
            setDirect((int)(Math.random()*4));
            //多线程编程一定要考虑退出条件，该线程什么时候结束
            if(!isLive){
                break;
            }

        }

    }

    public void moveRandom(){
        switch(getDirect()){
            case 0://表示向上
                this.moveUp();
                break;
            case 1://表示向右
                this.moveRight();
                break;
            case 2://表示向下
                this.moveDown();
                break;
            case 3://表示向左
                this.moveLeft();
                break;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //让敌人的坦克自由随机的上下左右移动
/*    public void moveRandom(EnemyTank enemyTank,int random,int randomDirection){
        System.out.println(random+","+randomDirection);
        switch(randomDirection){
            case 0://表示向上
                for(int i=0;i<=random;i++){
                    enemyTank.moveUp();
                    System.out.println("moveUp");
                }
                break;
            case 1://表示向右
                for(int i=0;i<=random;i++){
                    enemyTank.moveRight();
                    System.out.println("moveRight");
                }
                break;
            case 2://表示向下
                for(int i=0;i<=random;i++){
                    enemyTank.moveDown();
                    System.out.println("moveDown");
                }
                break;
            case 3://表示向左
                for(int i=0;i<=random;i++){
                    enemyTank.moveLeft();
                    System.out.println("moveLeft");
                }
                break;
        }
    }*/
}
