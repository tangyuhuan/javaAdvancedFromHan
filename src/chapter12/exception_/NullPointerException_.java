package chapter12.exception_;

/**p446 五大运行时异常之————NullPointerException
 * @author 韩顺平
 * @version 1.0
 */
public class NullPointerException_ {
    public static void main(String[] args) {

        String name = null;
        System.out.println(name.length());
    }
}
