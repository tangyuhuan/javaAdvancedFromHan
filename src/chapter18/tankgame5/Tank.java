package chapter18.tankgame5;

/**
 * @author tyh
 * @version 1.0
 */
public class Tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标
    private int direct = 0;//坦克方向 0 上1 右 2下 3左
    private int speed = 1;
    boolean isLive = true;
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    //控制我方的坦克和敌人的坦克在规定范围内移动
    //上右下左移动方法
    public void moveUp() {
        if(y<0){
            return;
        }
        y -= speed;
    }
    public void moveRight() {
        if(x+60>1000){
           return;
        }
        x += speed;
    }
    public void moveDown() {
        if(y+60>750){
            return;
        }
        y += speed;
    }
    public void moveLeft() {
        if(x<0){
            return;
        }
        x -= speed;
    }
//    //发射子弹
//    public void fireABullet(){
//
//    }
}
