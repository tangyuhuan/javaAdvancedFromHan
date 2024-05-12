package chapter11.homework;

/**p437 家庭作业2-编程题3
 * @author tyh
 * @version 1.0
 */
/*
按要求实现下列问题： 1min完成 -> 抽象类的使用
动物类Animal包含了抽象方法  shout()；
Cat类继承了Animal，并实现方法shout，打印“猫会喵喵叫”
Dog类继承了Animal，并实现方法shout，打印“狗会汪汪叫”
在测试类中实例化对象Animal cat =new  Cat(),并调用cat的shout方法
在测试类中实例化对象Animal dog=new  Dog(),并调用dog的shout方法

 */
public class Homework03 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.shout();
        Animal dog = new Dog();
        dog.shout();
    }
}
abstract class Animal{
    abstract void shout();
}
class Cat extends Animal{
    @Override
    void shout() {
        System.out.println("猫会喵喵叫");
    }
}
class Dog extends Animal{
    @Override
    void shout() {
        System.out.println("狗会汪汪叫");
    }
}