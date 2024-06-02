package chapter14.set_;

import chapter15.generic.MyDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

/**p527 HashSet思考题
 * @author tyh
 * @version 1.0
 */
//1.创建3个Employee2（属性包括name sal birthday(MyDate类型)）放入HashSet中
//2.当name和birthday相同时，认为是相同的员工，不能添加到HashSet中
public class HashSetExercise2 {
    public static void main(String[] args) {
        Employee2 e1 = new Employee2("lin",2000,new MyDate(2024,2,8));
        Employee2 e2 = new Employee2("lin",2000,new MyDate(2024,2,8));
        Employee2 e3 = new Employee2("jack",2000,new MyDate(2024,2,8));
        System.out.println(e1.equals(e2));
        HashSet<Employee2> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        System.out.println(set);
    }
}
class Employee2{
    private String name;
    private int salary;
    private MyDate birthday;

    public Employee2(String name, int salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee2 employee2)) return false;
        boolean birequals = birthday.getYear()==employee2.birthday.getYear()?birthday.getMonth()==employee2.birthday.getMonth()?birthday.getDay()==employee2.birthday.getDay():false:false;
        return salary == employee2.salary && Objects.equals(name, employee2.name) && birequals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, birthday.getYear(), birthday.getMonth(), birthday.getDay());
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}
