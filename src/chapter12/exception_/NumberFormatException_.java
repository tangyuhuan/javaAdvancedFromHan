package chapter12.exception_;

/**p446 五大运行时异常之————NumberFormatException
 * @author 韩顺平
 * @version 1.0
 */
public class NumberFormatException_ {
    public static void main(String[] args) {
        String name = "韩顺平教育";
        //将String 转成 int
        int num = Integer.parseInt(name);//抛出NumberFormatException
        System.out.println(num);//1234
    }
}
