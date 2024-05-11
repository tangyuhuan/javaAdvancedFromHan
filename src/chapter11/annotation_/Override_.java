package chapter11.annotation_;

import java.lang.annotation.Target;

/**p432 Override注解
 *  //注解的作用：提供信息给编译器：Override注解注解不会被编译进入.class文件，它们在编译后就被编译器扔掉了。
 *  //可以查看out文件夹中的Son.class
 *
 * @author 韩顺平
 * @version 1.0
 */
public class Override_ {
    public static void main(String[] args) {
        Son son = new Son();
        son.say();
    }
}
class Father{//父类

    public void fly(){
        int i = 0;
        System.out.println("Father fly...");
    }
    public void say(){}

}
class Son extends Father {//子类
    //老韩解读
    //1. @Override 注解放在fly方法上，表示子类的fly方法时重写了父类的fly
    //2. 这里如果没有写 @Override 还是重写了父类fly，即@Override不写也没事
    //3. 如果你写了@Override注解，编译器就会去检查该方法是否真的重写了父类的
    //   方法，如果的确重写了，则编译通过，如果没有构成重写，则编译错误
    //4. 看看 @Override的定义
    //   解读： 如果发现 @interface 表示一个 注解类，不是接口
    /*
        @Target(ElementType.METHOD)// @Target是修饰注解的注解，称为元注解，指定注解可以在哪些地方使用
        @Retention(RetentionPolicy.SOURCE) //元注解Retention，指定注解的作用范围：3种，source（.java文件）、class、runtime、
        public @interface Override {
        }
     */
    @Override   //说明
    public void fly() {
        System.out.println("Son fly....");
    }

    public void say() {
        System.out.println("say");
    }
}


//Son.class
//class Son extends Father {
//    Son() {
//    }
//
//    public void fly() {
//        System.out.println("Son fly....");
//    }
//
//    public void say() {
//        System.out.println("say");
//    }
//}
