package chapter17.homework;


import java.util.Scanner;

/**p598 线程家庭作业1
 * @author tyh
 * @version 1.0
 * 1.在main方法中启动两个线程
 * 2.第一个线程循环随机打印1-100以内的整数
 * 3.直到第二个线程从键盘读取了Q命令
 */
public class Homework01 {
    public static void main(String[] args) {
        A a = new A(true);
        a.start();
        B b = new B(a);//一定要注意 B线程必须持有A线程对象，就可以通过通知方式终止A线程，后自己退出
        b.start();

    }
}
class A extends Thread{
    private boolean flag;

    public A(boolean flag) {
        this.flag = flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        //输出1-100数字
        while (flag) {
            System.out.println(Thread.currentThread().getName()+" "+(int)(Math.random()*100+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
//直到第2个线程从键盘读取了“Q”命令
class B extends Thread {
    private A a;
    private Scanner scanner = new Scanner(System.in);

    public B(A a) {//构造器中直接传入A类对象
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入你指令(Q)表示退出:");
            char key = scanner.next().toUpperCase().charAt(0);
            if(key=='Q'){
                a.setFlag(false);
                System.out.println("b线程退出.");
                break;
            }
        }
    }
}