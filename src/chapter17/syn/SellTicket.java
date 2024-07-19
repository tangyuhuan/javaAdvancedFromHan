package chapter17.syn;

/**p594、595 线程同步机制、互斥锁！！重要
 * @author tyh
 * @version 1.0
 * 通过同步机制，解决票数超卖（注意多个线程必须是同一个对象的：一个对象放到三个线程里面，三个线程操作的是同一个对象）
 */
public class SellTicket {
    public static void main(String[] args) {
/*
        SellTicket01 sellTicket01 = new SellTicket01();
        SellTicket01 sellTicket02 = new SellTicket01();
        SellTicket01 sellTicket03 = new SellTicket01();
        //这里我们会出现票数超卖（互斥同步问题）
        sellTicket01.start();
        sellTicket02.start();
        sellTicket03.start();
*/

        System.out.println("===使用实现接口方式来售票=====");
//        SellTicket02  sellTicket04 = new SellTicket02();
//        new Thread(sellTicket04).start();//第 1 个线程-窗口
//        new Thread(sellTicket04).start();//第 2 个线程-窗口
//        new Thread(sellTicket04).start();//第 3 个线程-窗口
        SellTicket03 sellTicket04 = new SellTicket03();
        new Thread(sellTicket04).start();//第 1 个线程-窗口
        new Thread(sellTicket04).start();//第 2 个线程-窗口
        new Thread(sellTicket04).start();//第 3 个线程-窗口

    }
}
class SellTicket01 extends Thread{
    private static int ticketNum = 100;
    @Override
    public void run() {
        while(true){
            if(ticketNum <= 0){
                System.out.println("售票结束");
                break;
            }
            //休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"售出一张票，还剩余"+(--ticketNum));
        }
    }
}
class SellTicket02 implements Runnable{
    private static int ticketNum = 100;
    @Override
    public void run() {
        while(true){
            if(ticketNum <= 0){
                System.out.println("售票结束");
                break;
            }
            //休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"售出一张票，还剩余"+(--ticketNum));
        }
    }
}

//实现接口方式，通过Synchronized实现线程同步
class SellTicket03 implements Runnable{
    private static int ticketNum = 100;
    private boolean loop = true;//控制run方法的变量
    Object object = new Object();
    //同步方法（静态的）的锁为当前类本身
    //1.public synchronized static void m1(){} 锁是加在 SellTicket03.class
    //2.如果在静态方法中，实现一个同步代码块.
        /*
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
     */
    public synchronized static void m1(){}
    public static void m2(){
        synchronized (SellTicket03.class){ //同步方法静态的，锁为当前类本身，此处不能为this
            System.out.println("m2");
        }
    }

    //同步方法（非静态的）的锁可以是this，也可以是其他对象（要求是同一个对象）：同一时刻，只能有一个线程来执行sell办法，要执行先得持有锁
    //老韩说明
    //1. 方法加锁，同步方法：public synchronized void sell() {} 就是一个同步方法，这时锁在 this对象
    //2. 也可以代码块加锁，同步代码块， 互斥锁还是在this对象
    public /*synchronized*/ void sell(){
        synchronized(/*this*/object){ //如果synchronized(new Object())就不能满足多个线程的锁对象是同一个
            if(ticketNum <= 0){
                System.out.println("售票结束");
                loop = false;
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"售出一张票，还剩余"+(--ticketNum));
        }
    }
    @Override
    public void run() {
        while(loop){
            //如果直接给run方法加synchronized，相当于单线程了
            sell();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}