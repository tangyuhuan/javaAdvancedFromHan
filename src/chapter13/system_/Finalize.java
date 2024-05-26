package chapter13.system_;

/**p327 finalize
 * @author tyh
 * @version 1.0
 */
public class Finalize {
    public static void main(String[] args) {
        Car bmw = new Car("BMW");//bmw指向Car对象
        bmw = null;//当某个对象没有任何引用时，（Car对象就是一个垃圾）jvm就认为这个对象是一个垃圾对象，就会用垃圾回收机制来销毁该对象（销毁前调用该对象的finalize方法）
        //,程序员就可以在 finalize中，写自己的业务逻辑代码(比如释放资源：数据库连接,或者打开文件..)
        //,如果程序员不重写 finalize,那么就会调用 Object类的 finalize, 即默认处理
        //,如果程序员重写了finalize, 就可以实现自己的逻辑

        //注意：垃圾回收器有算法，不是一变成垃圾就回收
        //垃圾回收器的调用是由系统来决定的（不是一变成垃圾就回收），也也可以通过System.gc()主动触发垃圾回收机制
        System.gc();//只是建议进行一次回收，并不是强制，所以System.out.println("销毁汽车"+name);可能输出也可能不输出
        System.out.println("exit");//先输出

        //注意：实际开发中几乎不会用finalize
    }
}
class Car{
    private String name;

    public Car(String name) {
        this.name = name;
    }
    //finalize（jdk9开始弃用）
    @Override
    protected void finalize() throws Throwable {
        System.out.println("销毁汽车"+name);
    }
}