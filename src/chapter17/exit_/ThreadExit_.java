package chapter17.exit_;

/**
 * p588通知线程退出
 *启动一个线程，要求在main线程中去停止线程t
 * @author tyh
 * @version 1.0
 */
public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException{
        AThread t = new AThread();
        new Thread(t).start();
        //如果希望main线程去控制t1 线程的终止, 必须可以修改 loop
        //让t1 退出run方法，从而终止 t1线程 -> 通知方式

        //让主线程休眠 10 秒，再通知 t1线程退出
        System.out.println("main线程休眠3s...");
        Thread.sleep(3 * 1000);
        t.setLoop(false);

    }
}

class AThread implements Runnable {
    private boolean loop=true;

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);// 让当前线程休眠50ms
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "运行中 ");
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}