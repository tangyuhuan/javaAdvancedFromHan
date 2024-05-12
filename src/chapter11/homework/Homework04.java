package chapter11.homework;

/**p437 家庭作业3-编程题4
 * 注意思想
 * @author tyh
 * @version 1.0
 */
/*
1.计算器接口具有work方法，功能是运算，有一个手机类Cellphone，
   定义方法testWork测试计算功能，调用计算接口的work方法，
2.要求调用CellPhone对象 的testWork方法，使用上 匿名内部类

 */
//老师的实现（思想更好，更灵活传入work方法）：

public class Homework04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        //老韩解读
        //1. 匿名内部类是
        /*
            new ICalculate() {
                @Override
                public double work(double n1, double n2) {
                    return n1 + n2;
                }
            }, 同时也是一个对象
            他的编译类型 ICalculate, 他的运行类型就是 匿名内部类
         */
        cellphone.testWork(new Calculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 10, 8);//18.0

        cellphone.testWork(new Calculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 * n2;
            }
        }, 10, 8);
    }
}
interface Calculate{
    //work方法 是完成计算，但是题没有具体要求，所以自己设计
    //至于该方法完成怎样的计算，我们交给匿名内部类完成
    public double work(double n1, double n2) ;
}
//Calculate calculate,
class Cellphone{
    //老韩解读，当我们调用testWork方法时，直接传入一个实现了ICalculate接口的匿名内部类即可
    //该匿名内部类，可以灵活的实现work,完成不同的计算任务
    public void testWork(Calculate calculate, double n1, double n2){
        double result = calculate.work(n1,n2);
        System.out.println("计算后的结果"+result);
    }
}


/*
我的实现：
public class Homework04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        System.out.println(cellphone.testWork(1.2,1.1));
    }
}
interface Calculate{
    public double work(double n1, double n2);
}
//Calculate calculate,
class Cellphone{
    public double testWork(double n1, double n2){
        Calculate cal = new Calculate(){
            @Override
            public double work(double n1, double n2) {
                return n1+n2;
            }
        };
        return cal.work(n1,n2);
    }
}*/
