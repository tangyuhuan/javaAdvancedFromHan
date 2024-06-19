package chapter17.ticket;

/**p587多线程售票问题
 * @author tyh
 * @version 1.0
 * 使用多线程，模拟三个窗口同时售票 100 张(本案例会出现票数超卖（互斥同步问题）)
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
        SellTicket02  sellTicket04 = new SellTicket02();
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