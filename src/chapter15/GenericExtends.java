package chapter15;
//p565泛型的继承和通配符
//
import java.util.ArrayList;
import java.util.List;

/**
 * @author 韩顺平
 * @version 1.0
 * 泛型的继承和通配符
 */
public class GenericExtends {
    public static void main(String[] args) {

        Object o = new String("xx");//Object引用指向子类String对象，ok


        //Java中数组是协变的：当B是A的子类时，B[]也可以被视为A[]的子类。这是数组的一个特性，在Java中数组是协变的。
        //然而，泛型不是协变的。即使B是A的子类，List<B>不能被视为List<A>的子类。
        //每个数组在运行时都知道其元素类型，而泛型集合不知道（由于类型擦除）。

        //泛型没有继承性
        //List<Object> list = new ArrayList<String>();//错误


        //举例说明下面三个方法的使用
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();

        //如果是 List<?> c ，可以接受任意的泛型类型
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);

        //List<? extends AA> c： 表示 上限，可以接受 AA或者AA子类
//        printCollection2(list1);//×，Object
//        printCollection2(list2);//×，String
        printCollection2(list3);//√
        printCollection2(list4);//√
        printCollection2(list5);//√

        //List<? super AA> c: 支持AA类以及AA类的父类，不限于直接父类
        printCollection3(list1);//√
//        printCollection3(list2);//×，string
        printCollection3(list3);//√
//        printCollection3(list4);//×，BB
//        printCollection3(list5);//×，CC


        //冒泡排序

        //插入排序

        //....


    }
    // ? extends AA 表示 上限，可以接受 AA或者AA子类
    public static void printCollection2(List<? extends AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }

    //说明: List<?> 表示 任意的泛型类型都可以接受
    public static void printCollection1(List<?> c) {
        for (Object object : c) { // 通配符，取出时，就是Object
            System.out.println(object);
        }
    }



    // ? super 子类类名AA:支持AA类以及AA类的父类，不限于直接父类，
    //规定了泛型的下限
    public static void printCollection3(List<? super AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }

}

class AA {
}

class BB extends AA {
}

class CC extends BB {
}

