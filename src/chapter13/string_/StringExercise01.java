package chapter13.string_;

/**p467 String创建解析
 * @author 韩顺平
 * @version 1.0
 */
public class StringExercise01 {
    public static void main(String[] args) {
        String a = "abc";
        String b ="abc";
        System.out.println(a.equals(b));//T，比较的是字符串存放的value数组
        System.out.println(a==b); //T，都指向常量池的同一个对象，地址一样

    }
}
