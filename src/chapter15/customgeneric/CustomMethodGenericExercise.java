package chapter15.customgeneric;
//p563自定义泛型方法练习
//注意泛型方法节点&方法中使用泛型的区别
/**
 * @author 韩顺平
 * @version 1.0
 */
public class CustomMethodGenericExercise {
    public static void main(String[] args) {
        //T->String, R->Integer, M->Double
        Apple<String, Integer, Double> apple = new Apple<>();
        apple.fly(10);//10 会被自动装箱 Integer10, 输出Integer
        apple.fly(new Dog());//Dog
        System.out.println(apple instanceof Apple<String, Integer, Double>);
    }
}

class Apple<T, R, M> {//自定义泛型类
    //泛型方法，泛型E归方法fly使用
    public <E> void fly(E e) {  //泛型方法
        System.out.println(e.getClass().getSimpleName());
    }//e.getClass().getSimpleName()只显示类名，e.getClass()显示包名.类名

    //public void eat(U u) {}//错误，因为U没有声明
    public void run(M m) {
    } //ok
}

class Dog {
}



