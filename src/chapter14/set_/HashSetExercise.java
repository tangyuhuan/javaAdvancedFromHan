package chapter14.set_;

/**p526 HashSet最佳实践 ！！重复练习
 * @author tyh
 * @version 1.0
 */

import java.util.HashSet;
import java.util.Objects;

/**
 定义一个Employee类，该类包含：private成员属性name,age 要求:
 创建3个Employee 对象放入 HashSet中
 当 name和age的值相同时，认为是相同员工, 不能添加到HashSet集合中

 */
public class HashSetExercise {
    public static void main(String[] args) {
        HashSet<Employee> set = new HashSet();
        Employee e1 =new Employee("linlin",32);
        Employee e2 =new Employee("linlin",32);
        Employee e3 =new Employee("jack",30);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        System.out.println(set);
    }
}
class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return age == employee.age && Objects.equals(name, employee.name);
    }

//    记得要重写hashCode()，如果对象的name和age值相同，则返回相同的hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
