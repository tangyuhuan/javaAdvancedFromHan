package chapter17.method;

/**p592 守护线程
 * 用户线程：即工作线程，当线程的任务执行完或通知方式结束
 * 守护线程：一般是为工作线程服务的，当所有的用户线程结束，守护线程自动结束
 * 常见的守护线程：垃圾回收机制
 * @author tyh
 * @version 1.0
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //如果我们希望当main线程结束后，子线程自动结束
        //,只需将子线程设为守护线程即可
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("AA is working");
            Thread.sleep(500);

        }
    }
}
class MyDaemonThread extends Thread {
    @Override
    public void run() {
        for (; ; ) {//无限循环
            System.out.println("BB is chatting");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}