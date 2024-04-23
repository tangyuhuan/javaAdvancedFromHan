package chapter15.generic;

import java.util.*;

/**
 * @author 韩顺平
 * @version 1.0
 */
/*泛型使用举例
再次体会：泛型E具体的数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型
* */
@SuppressWarnings({"all"})
public class GenericExercise {
    public static void main(String[] args) {
        //使用泛型方式给HashSet 放入3个学生对象
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("John", 10));
        students.add(new Student("Jane", 20));
        students.add(new Student("Jack", 30));
        //遍历
        for(Student student:students){
            System.out.println(student);
        }
        //使用泛型方式给HashMap 放入3个学生对象
        //K -> String name ,V->Student
        HashMap<String,Student> studentMap = new HashMap<>();
        studentMap.put("John",new Student("John", 10));
        studentMap.put("Jane",new Student("Jane", 20));
        studentMap.put("Jack",new Student("Jack", 30));
        System.out.println("===================================");
//        for(Student student:studentMap.values()){
//            System.out.println(student);
//        }
//        for(String str:studentMap.keySet()){
//            studentMap.get(str);
//        }



        /*
            public class HashMap<K,V>  {}
         */


        /*
        public Set<Map.Entry<K,V>> entrySet() {
            Set<Map.Entry<K,V>> es;
            return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
        }
         */
        /*
            public final Iterator<Map.Entry<K,V>> iterator() {
                return new EntryIterator();
            }
         */
        //迭代器 EntrySet
        Set<Map.Entry<String, Student>> entries = studentMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Student> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());

        }

    }
}
/**
 * 创建  3个学生对象
 * 放入到HashSet中学生对象, 使用.
 * 放入到  HashMap中，要求 Key 是 String name, Value 就是 学生对象
 * 使用两种方式遍历
 */
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
