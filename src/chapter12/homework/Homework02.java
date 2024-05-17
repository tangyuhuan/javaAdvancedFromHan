package chapter12.homework;

/**p457异常课后作业2
 * 以下代码是否为发生异常？是什么异常？
 * @author tyh
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        //args.length = 0
        //1.参数不够，这里可能发生的是 ArrayIndexOutOfBoundsException
        //args[4] = null;
        if(args[4].equals("john")){//除非args[4] = null;2.可能发生NullPointerException
            System.out.println("AA");
        }else{
            System.out.println("BB");
        }
        Object o= args[2];//String->Object ，向上转型
        System.out.println(o);
        Integer i = (Integer)o;//错误，3.这里一定会发生 ClassCastException
    }
}
