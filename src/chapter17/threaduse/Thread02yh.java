package chapter17.threaduse;

/**自己实现p585 Runnable创建线程，同Thread02.java
 * @author tyh
 * @version 1.0
 */
public class Thread02yh {
    public static void main(String[] args) {
//        Dog2 dog = new Dog2();
//        Thread t1 = new Thread(dog);
//        t1.start();

        Tiger2 tiger2 = new Tiger2();
        ThreadProxy2 t2 = new ThreadProxy2(tiger2);
        t2.start();


    }
}

class Tiger2 implements Runnable{
    @Override
    public void run() {
        System.out.println("tiger:"+Thread.currentThread().getName());
    }
}
class ThreadProxy2 implements Runnable {
    private Runnable target = null;

    @Override
    public void run() {
       if(target != null){
           target.run();
       }
    }

    public ThreadProxy2(Runnable target) {
        this.target = target;
    }

    public void start(){
        this.start0();
    }
    public void start0(){
        this.run();
    }
}
class Dog2 implements Runnable{
    int count = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("喵喵"+ (++count)+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(count==10){
                break;
            }
        }
    }
}