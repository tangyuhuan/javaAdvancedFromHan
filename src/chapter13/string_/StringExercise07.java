package chapter13.string_;

/**
 * @author tyh
 * @version 1.0
 */
public class StringExercise07 {
    public static void main(String[] args) {
        //如下代码创建了几个对象？
        String a = "Hello"+"ABC";
        //答：一个对象，String a = "Hello"+"ABC";会优化为 a = "HelloABC";
    }
}
