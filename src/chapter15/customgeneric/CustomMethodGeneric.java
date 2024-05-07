package chapter15.customgeneric;

import java.util.ArrayList;

/*p563 自定义泛型方法
注意区分37行 普通的成员方法，刚好用到了泛型类的泛型参数  VS   泛型方法 的区别
*/
public class CustomMethodGeneric {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("宝马", 100);//当调用方法时，传入参数，编译器，就会确定类型
        System.out.println("=======");
        car.fly(300, 100.1);//当调用方法时，传入参数，编译器，就会确定类型

        Fish<String,ArrayList> fish = new Fish<>();//泛型类中的泛型参数，实例化时需要指定具体类型
        fish.hello(new ArrayList(),11.3f); //泛型方法中的泛型参数，会根据调用进行类型推导
    }
}

//泛型方法，可以定义在普通类中, 也可以定义在泛型类中
//普通类
class Car{
    public void run() {//普通方法
    }
    //说明 泛型方法
    //1. <T,R> 就是泛型
    //2. 是提供给 fly使用的
    public <T,R> void fly(T t,R r) {//泛型方法
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}
class Fish<T,R>{//泛型类
    public void run() {//普通方法
    }
    //说明
    //1. 下面hi方法不是泛型方法，只是普通的成员方法，刚好用到了泛型类的泛型参数而已
    //2. 是hi方法使用了类声明的 泛型
    public void hi(T t){

    }
    //泛型方法，可以使用类声明的泛型R，也可以使用自己声明泛型K
    //泛型方法和泛型类没有必然关系，可以在泛型类/普通类中定义
    public<K> void hello(R r, K k) {//泛型方法
        System.out.println(r.getClass());
        System.out.println(k.getClass());
    }

    //静态方法要使用泛型，就必须定义成泛型方法
    public static <K> void helloS(K k) {//泛型方法
        System.out.println(k.getClass());
    }
}