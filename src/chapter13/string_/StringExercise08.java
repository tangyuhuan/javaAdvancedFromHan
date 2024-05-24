package chapter13.string_;

/**p470 String对象特性！！重复理解
 * @author 韩顺平
 * @version 1.0
 */
public class StringExercise08 {
    public static void main(String[] args) {
        String a = "hello"; //创建 a对象
        String b = "abc";//创建 b对象
        //老韩解读，jdk8如下处理，jdk17不同
        //1. 先 创建一个 StringBuilder sb = StringBuilder()
        //2. 执行  sb.append("hello");
        //3. sb.append("abc");
        //4. String c= sb.toString() //toString方法底层是new，所以c指向堆中的对象
        //最后其实是 c 指向堆中的对象(String) value[] -> 池中 "helloabc"
        String c = a + b;//创建了几个对象？画出内存图
        String d = "helloabc";
        System.out.println(c == d);//真还是假? 是false，c 指向堆中的对象(String) value[] -> 池中 "helloabc"，d是直接指向池中 "helloabc"
        String e = "hello" + "abc";//直接看池， e指向常量池
        System.out.println(d == e);//真还是假? 是true
        //重要规则：String c1 = "ab"+"cd";常量相加看的是池，String c1 = a+b;变量相加是在堆中
        //学习思路：一定尽量看源码学习，否则永远成不了高手
    }
}
