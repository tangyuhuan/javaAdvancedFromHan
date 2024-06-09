package chapter14.homework;

/**p552集合家庭作业5 ！！重复练习
 * @author tyh
 * @version 1.0
 * 下面的代码会不会抛出异常？从源码层面说明原因
 *TreeSet treeSet = new TreeSet();
 * treeSet.add(new Person());
 */
import java.util.TreeSet;

/*public class Homework05 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        //分析源码
        //add 方法，因为 TreeSet() 构造器没有传入Comparator接口的匿名内部类
        //所以在底层 Comparable<? super K> k = (Comparable<? super K>) key;
        //即 把 Perosn转成 Comparable类型
        treeSet.add(new Person());//class chapter14.homework.Person cannot be cast to class java.lang.Comparable
        treeSet.add(new Person());
        treeSet.add(new Person());
        treeSet.add(new Person());
        System.out.println(treeSet);
    }
}*/
//class Person {
//    public Person() {
//    }
//}
/*
class Person implements Comparable<Person> {
    @Override
    public int compareTo(Person o) {
        return 0;//永远只能加一个对象
    }
}*/
