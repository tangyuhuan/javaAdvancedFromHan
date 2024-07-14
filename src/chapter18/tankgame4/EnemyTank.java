package chapter18.tankgame4;

import java.util.Vector;

/**p578绘制敌人坦克
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
