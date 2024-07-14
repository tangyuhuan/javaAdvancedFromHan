package chapter17.threaduse;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/** 创建线程的四种方式
 * 1.继承 Thread 类并重写 run() 方法，见Thread01.java
 * 2.实现 Runnable 接口并传入 Thread 类的构造函数
 * 3.使用 Callable 和 Future 接口创建线程
 * 这种方式可以获取线程执行的返回值，需要定义一个类实现 Callable 接口，并实现 call() 方法，
 * 然后创建 FutureTask 类的实例并将该类的实例传入 Thread 类的构造函数即可启动线程。
 * @author tyh
 * @version 1.0
 */
public class Thread04 {
    public static void main(String[] args) {
        //创建异步任务
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        //启动线程
        new Thread(task).start();
        try {
            //等待执行完成，并获取返回结果
            String result = task.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        // 线程执行的代码
        return "result";
    }
}