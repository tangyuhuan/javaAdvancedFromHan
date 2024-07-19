package chapter17.threaduse;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author tyh
 * @version 1.0
 */
public class Thread05 {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(new MyThread03());
        new Thread(futureTask).start();
        try {
            String r= futureTask.get();
            System.out.println(r);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
class MyThread03 implements Callable{
    @Override
    public String call() throws Exception {
        return "结果";
    }
}