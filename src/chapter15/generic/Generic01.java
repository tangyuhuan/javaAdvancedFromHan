package chapter15.generic;

import java.util.ArrayList;

/**
 * @author 韩顺平
 * @version 1.0
 */
@SuppressWarnings({"all"})
/*使用传统方法解决
1.不能对加入ArrayList中的数据类型进行约束
2.遍历的时候必须进行类型转换，数据量大情况下影响效率

---引入泛型解决问题
*/
public class Generic01 {
    public static void main(String[] args) {

        //使用传统的方法来解决(先不使用泛型)
//        ArrayList<Integer> list = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小黄", 5));

        //假如我们的程序员，不小心，添加了一只猫
        //arrayList可以放Object类型，所以把Cat交给Object是ok的，存在隐患，但是编译器发现不了
        arrayList.add(new Cat("招财猫", 8));

        //遍历
        for (Object o : arrayList) {
            //向下转型Object ->Dog
            Dog dog = (Dog) o;
            System.out.println(dog.getName() + "-" + dog.getAge());
        }

    }
}
/*
请编写程序，在ArrayList 中，添加3个Dog对象
Dog对象含有name 和 age, 并输出name 和 age (要求使用getXxx())
 */
class Dog {
    private String name;
    private int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Cat { //Cat类
    private String name;
    private int age;
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
