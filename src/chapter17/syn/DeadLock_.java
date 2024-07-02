package chapter17.syn;

/**p596 模拟线程死锁
 * @author tyh
 * @version 1.0
 */
public class DeadLock_ {
    public static void main(String[] args) {
        //模拟死锁现象
        DeadLockDemo A = new DeadLockDemo(false);
        DeadLockDemo B = new DeadLockDemo(true);
        A.setName("线程A ");
        B.setName("线程B ");
        A.start();
        B.start();

    }
}
//线程
class DeadLockDemo extends Thread {
    static Object o1 = new Object();// 保证多线程，共享一个对象,这里使用static
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }
    //下面业务逻辑的分析
    //1. 如果flag 为 T, 线程A 就会先得到/持有 o1 对象锁, 然后尝试去获取 o2 对象锁
    //2. 如果线程A 得不到 o2 对象锁，就会Blocked
    //3. 如果flag 为 F, 线程B 就会先得到/持有 o2 对象锁, 然后尝试去获取 o1 对象锁
    //4. 如果线程B 得不到 o1 对象锁，就会Blocked
    @Override
    public void run() {
        if(flag){
            //因为加了互斥锁（必须拿到锁才能执行代码），所以形成同步代码
            synchronized (o1){//对象互斥锁, 下面就是同步代码
                System.out.println(Thread.currentThread().getName()+"进入1");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName()+"进入2");
                }
            }
        }else{
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+"进入3");
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName()+"进入4");
                }
            }
        }
    }
}