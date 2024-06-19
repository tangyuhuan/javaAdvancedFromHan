package chapter17.method;

/**
 * p591线程插队练习
 *
 * @author tyh
 * @version 1.0
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi");
            if (i == 5) {
                Thread thread = new Thread(new T3());
                thread.start();//启动子线程 输出 hello...
                thread.join();//立即将thread子线程，插入到main线程，让thread先执行
            }
        }
        System.out.println("主线程结束");

    }
}

class T3 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello");

        }
        System.out.println("子线程结束");
    }
}
