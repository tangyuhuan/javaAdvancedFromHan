package chapter18.tankgame5;

/**
 * @author tyh
 * @version 1.0
 */
public class Cat extends Animal {
    //如果子类和父类中出现同名的成员变量时，尽管同名，但他们是两个完全无关的变量，在子类中访问的是定义在子类中的变量，在父类中访问的是定义在父类中的变量
    boolean alive = false;
    public Cat(int age, String name) {
        super(age, name);
    }
    public void getStatus(){
        System.out.println(super.alive);//true
        System.out.println(this.alive);//false
    }
    public static void main(String args[]){
        Cat cat = new Cat(5, "Cat");
        cat.getStatus();
    }
}
