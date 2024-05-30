package chapter14.collection_;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * p504 测试题
 *
 * @author tyh
 * @version 1.0
 */
/**
 * 创建  3个 Dog {name, age}  对象，放入到 ArrayList 中，赋给 List 引用
 * 用迭代器和增强for循环两种方式来遍历
 * 重写Dog 的toString方法， 输出name和age
 */
public class CollectionExercise {
    public static void main(String[] args) {
        ArrayList<Dog> arrayList = new ArrayList<>();
        arrayList.add(new Dog("Dog1", 1));
        arrayList.add(new Dog("Dog2", 2));
        arrayList.add(new Dog("Dog3", 3));
        for (Dog o :arrayList) {
            System.out.println(o);
        }
        System.out.println("Iterator遍历");
        Iterator<Dog> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Dog next =  iterator.next();
            System.out.println(next);

        }

    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}