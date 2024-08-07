package chapter17.method;
/**p590 线程插队：t2.join();让t2 线程先执行完毕
 * 插队：在t1线程中调用t2.join() 实现插队，即执行完t2所有任务后再执行t1，插队是一定成功的
 * @author tyh
 * @version 1.0
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();
        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);//休眠1秒
            System.out.println("主线程(老大) 吃了 " + i +  " 包子");
            if(i==5){
                System.out.println("主线程(小弟) 让 子线程(老大) 先吃");
                //join, 线程插队
                t2.join();// 这里相当于让t2 线程先执行完毕,在t1线程中调用t2.join() 实现插队，即执行完t2所有任务后再执行t1，插队是一定成功的
//                Thread.yield();//礼让（让出cpu，让其他的线程先执行），不一定成功..
                //yield() 方法是一个静态方法，用于暗示当前线程愿意放弃其当前的时间片，允许其他线程执行。然而，它只是向线程调度器提出建议，调度器可能会忽略这个建议。具体行为取决于操作系统和 JVM 的线程调度策略。
                System.out.println("线程(老大) 吃完了 主线程(小弟) 接着吃..");
            }
        }
    }
}

class T2 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);//休眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程(老大) 吃了 " + i +  " 包子");
        }
    }
}