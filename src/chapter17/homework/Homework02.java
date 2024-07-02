package chapter17.homework;

/**p599 线程家庭作业2 ！！重复理解原理
 * @author tyh
 * @version 1.0
 * 1.有2个用户分别从同一个卡上取钱
 * 2.每次都取1000，当余额不足时就不能取款时
 * 3.不能出现超取现象=》线程同步问题
 */
public class Homework02 {
    public static void main(String[] args) throws InterruptedException {
        Card card = new Card();
        new Thread(card).start();
        new Thread(card).start();

    }
}
//线程同步要解决的就是对关键数据的操作问题，每一轮都是抢锁执行代码
//编程取款的线程
//1.因为这里涉及到多个线程共享资源，所以我们使用实现Runnable方式
class Card implements Runnable{
    private static int num = 10000;
    private boolean loop = true;//控制run方法的变量
    public synchronized void getCash(){
        if(num>0){
            System.out.println(Thread.currentThread().getName()+"取走1000，余额"+(num-=1000));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
            loop = false;
        }
    }
    @Override
    public void run() {
        while(loop){
            //解读
            //1. 这里使用 synchronized 实现了线程同步
            //2. 当多个线程执行到这里时，就会去争夺 this对象锁
            //3. 哪个线程争夺到(获取)this对象锁，就执行 synchronized 代码块, 执行完后，会释放this对象锁
            //4. 争夺不到this对象锁，就blocked ，准备继续争夺
            //5. this对象锁是非公平锁.
            getCash();
        }

    }
}