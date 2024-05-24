package chapter13.string_;

/**p471 String对象特性2！！重复理解，务必手画内存图
 * @author 韩顺平
 * @version 1.0
 */
public class StringExercise10 {
    public static void main(String[] args) {

    }
}

class Test1 {
    String str = new String("hsp");
    final char[] ch = {'j', 'a', 'v', 'a'};//值能改地址不能改

    public void change(String str, char ch[]) {
        str = "java";
        ch[0] = 'h';
    }

    public static void main(String[] args) {
        Test1 ex = new Test1();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);
    }
}