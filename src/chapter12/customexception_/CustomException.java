package chapter12.customexception_;

/**p455 自定义异常:通常做法是自定义一个类继承RuntimeException
 * @author tyh
 * @version 1.0
 */
public class CustomException {
    public static void main(String[] args) {
        int age = 180;
        if(!(age >= 18 && age <= 120)) {
            //这里我们可以通过构造器，设置信息
            throw new AgeException("年龄需要在 18~120之间");
        }
        System.out.println("你的年龄范围正确.");
    }
}
//自定义一个异常
//老韩解读
//1. 一般情况下，我们自定义异常是继承 RuntimeException
//2. 即把自定义异常做成 运行时异常，好处时，我们可以使用默认的处理机制
//3. 即比较方便
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}