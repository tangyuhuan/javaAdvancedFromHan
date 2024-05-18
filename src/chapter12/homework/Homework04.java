package chapter12.homework;

/**p457异常课后作业2
 * 写出程序运行结果
 * @author tyh
 * @version 1.0
 */
public class Homework04 {
    public static void main(String[] args) {//main方法
        try {
            showExce();
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");
            return; //如果此处有return，执行完finally内容再回去执行catch中的return，D不会打印
        } finally {
            System.out.println("C");
            return;
        }
//        System.out.println("D");
    }

    public static void showExce() throws Exception {
        throw new Exception();
    }
}
