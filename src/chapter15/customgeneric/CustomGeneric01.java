package chapter15.customgeneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//【每次一个技术点】泛型之类型擦除
//泛型有哪些限制？为什么？————类型擦除导致的弊端
//https://www.bilibili.com/video/BV1ed4y1T7Ty/?spm_id_from=333.788&vd_source=9096009d98e9575f0e391c12407212da
public class CustomGeneric01 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        System.out.println(integers.getClass());//class java.util.ArrayList
        System.out.println(integers.getClass() == strings.getClass());//true，就只有ArrayList类型，这种擦除泛型后的类型称为原始类型

//        类型擦除导致的弊端：
//        1.泛型类型参数不能是基本数据类型（只能是引用类型），如 int、long 等。必须使用它们的包装类，例如 Integer、Long 等。
//        （由于类型擦除，Object类型不能存放基本类型的值。解决办法：使用对应的包装类型来代替，例如Integer代替int。）
        List<Integer> integers2 = new ArrayList<>();
//        List<int> int1 = new ArrayList<>();//Error

//        2.运行时只能对原始类型进行类型检测，无法判断带泛型的类型
        List<Integer> obj = new ArrayList<>();
        if (obj instanceof List) {
        }

//        if (obj instanceof List<String>) {//ERROR
//        }
//        if (obj instanceof T) {//ERROR
//        }

//        String[] strings2 = randomTwo("1","2","3");
        Object[] oo = new Object[3];
        String[] strings3 = (String[]) oo;//Object[]无法强制转换为String[]从而抛出异常
        System.out.println(strings3.getClass());
    }
    //如果允许实例化泛型数组，类型擦除后，会因为Object[]无法强制转换为String[]从而抛出异常
//    public static<T> T[] randomTwo(T... t){
//        T[] array = new T[2]; //4.不能实例化泛型数组,编译错误
//        return array;
//    }
}
class A{}

/*
class IUsb1<U,R>{
    U data = new U();//3.不能实例化类型参数，因为运行时无法确定具体类型，无法知道U是否存在无参构造器
    R[] array = new R[2]; //4.不能实例化泛型数组，否则类型擦除后容易引发类型转换异常
}
*/
