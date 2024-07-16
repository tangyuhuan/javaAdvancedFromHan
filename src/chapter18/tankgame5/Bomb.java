package chapter18.tankgame5;

/**p605 坦克爆炸
 * @author tyh
 * @version 1.0
 * 坦克爆炸效果原理：新增Bomb类，在三张图片间快速切换
 */
public class Bomb {
    int x,y;//炸弹坐标
//    life设置为9时第一个坦克没有爆炸效果，原因为drawImage方法需要裁剪图片，生成缓存，这一步是异步的且消耗时间，把life变长就行了
//    还有一个办法是drawImage前先休眠一下
    int life = 9;//炸弹生命周期
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //减少生命值
    public void lifeDown(){//配合出现图片的爆炸效果
        if(life>0){
            life--;
        }else{
            isLive = false;
        }
    }
}
