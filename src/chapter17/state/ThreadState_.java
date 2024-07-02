package chapter17.state;

/**p593 线程7大状态
 * @author tyh
 * @version 1.0
 */
public class ThreadState_ {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        System.out.println(t1.getName()+" "+t1.getState());//NEW,RUNNABLE
        t1.start();

        while(Thread.State.TERMINATED != t1.getState()){
            Thread.sleep(1000);
            System.out.println(t1.getName()+" "+t1.getState());//Thread.sleep 会导致进入 TIMED_WAITING
        }
        System.out.println(t1.getName()+" "+t1.getState());
    }
}
class T extends Thread {
    @Override
    public void run() {
        while(true){
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("子线程:"+i);
            }
            break;
        }
    }
}
