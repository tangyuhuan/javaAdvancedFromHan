package chapter13.homework;

import java.util.Objects;

/**p497 String内存布局测试题！！重复练习
 * 重点在于Animal类是否重写了equals方法
 * @author tyh
 * @version 1.0
 */
public class Homework05 {
    public static void main(String[] args) {
        String s1 = "hspedu";
        Animal a = new Animal(s1);
        Animal b = new Animal(s1);
        System.out.println(a == b);
        System.out.println(a.equals(b));//没有重写equals方法的话，还是等价于==
        System.out.println(a.name == b.name);
        String s4 = new String("hspedu");
        String s5 = "hspedu";

        System.out.println(s1 == s4);
        System.out.println(s4 == s5);

        //注意：此处t1指向堆中的value数组，value数组指向常量池中"hellohspedu"
        String t1 = "hello" + s1; //底层是先创建一个StringBuilder，将hello加进入，再将s1的内容加进入，再创建堆中的string返回给t1
        String t2 = "hellohspedu";
        System.out.println(t1 == t2);//false
        System.out.println(t1.intern() == t2);

        //理解如下
        String str = "a";
        str += "b";
        str += "c";
        String str2 = "abc";
        System.out.println(str==str2);//false


    }
}

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Animal animal)) return false;
//        return Objects.equals(name, animal.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(name);
//    }
}

