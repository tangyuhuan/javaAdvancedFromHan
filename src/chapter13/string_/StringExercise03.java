package chapter13.string_;

/**p468 String测试题1
 * @author 韩顺平
 * @version 1.0
 */
public class StringExercise03 {
    public static void main(String[] args) {
        String a = "hsp"; //a 指向 常量池的 “hsp”
        String b =new String("hsp");//b 指向堆中对象
        System.out.println(a.equals(b)); //T，比较的是字符串存放的value数组，字符串的内容
        System.out.println(a==b); //F
        //b.intern() 方法返回常量池地址
        System.out.println(a==b.intern()); //T //intern方法自己先查看API
        System.out.println(b==b.intern()); //F，b指向堆，b.intern返回常量池的地址

    }
}
