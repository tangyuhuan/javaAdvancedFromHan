package chapter18.tankgame4;

/**p601 射击子弹
 * @author tyh
 * @version 1.0
 */
public class Shot implements Runnable{
    int x;//子弹的横坐标
    int y;//子弹的纵坐标
    int direct = 0;//子弹方向 0 上1 右 2下 3左
    int speed = 5;//子弹速度
    boolean isLive = true;//子弹是否还存活

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //要线程休眠一会儿，再画一颗子弹
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch(direct) {
                case 0://表示向上
                    y -= speed;
                    break;
                case 1://表示向右
                    x += speed;
                    break;
                case 2://表示向下
                    y += speed;
                    break;
                case 3://表示向左
                    x -= speed;
                    break;
            }
//            System.out.println("子弹x："+x+"子弹y："+y);
            //当子弹移动到面板的边界时，就应该销毁线程
            //当子弹碰到敌人坦克时，也应该结束线程
            if(!(x>=0&&x<=1000&&y>=0&&y<=750 && isLive)){
                isLive = false;
                System.out.println("子弹线程退出");
                break;
            }
        }

    }
}
