package chapter13.string_;

/**p471 String对象特性2
 * @author 韩顺平
 * @version 1.0
 */
public class StringExercise09 {
    public static void main(String[] args) {
        String s1 = "hspedu";  //s1 指向池中的 “hspedu”
        String s2 = "java"; // s2 指向池中的 “java”
        String s5 = "hspedujava"; //s5 指向池中的 “hspedujava”
        String s6 = (s1 + s2).intern();//s6 指向池中的   “hspedujava”，intern返回常量池的地址
        System.out.println(s5 == s6); //T
        System.out.println(s5.equals(s6));//T

    }
}
