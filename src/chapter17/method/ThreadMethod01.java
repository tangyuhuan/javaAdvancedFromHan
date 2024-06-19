package chapter17.method;

/**p589 中断线程
 * interrupt中断线程，并没有真的结束线程，一般用于中断正在休眠的线程（提前终止了休眠），中断不等于终止
 * sleep线程的静态方法，使当前线程休眠
 * @author tyh
 * @version 1.0
 */
public class ThreadMethod01{
    public static void main(String[] args) throws InterruptedException{
        //测试线程相关的方法
        T t = new T();
        t.setName("老韩");
        t.setPriority(Thread.NORM_PRIORITY);//5
        t.start();//启动子线程

        //主线程打印5 hi ,然后我就中断 子线程的休眠
        for(int i = 0; i < 2; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }

        System.out.println(t.getName() + " 线程的优先级 =" + t.getPriority());//1
        t.interrupt();//interrupt提前终止了休眠
    }
}
class T extends Thread { //自定义的线程类
    int count = 0;
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+(++count));
            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中~~~");
                Thread.sleep(20000);//20秒
            } catch (InterruptedException e) {
                //当该线程执行到一个interrupt 方法时，就会catch 一个 异常, 可以加入自己的业务代码
                //InterruptedException 是捕获到一个中断异常.
                System.out.println("线程被中断了");
//                throw new RuntimeException(e);
            }

        }
    }
}