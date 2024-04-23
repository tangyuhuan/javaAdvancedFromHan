package chapter15.generic;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public double getSal() {
        return sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        int i = this.getName().compareTo(o.getName());
        if(i != 0) {
            return i;
        }
        //下面是对birthday的比较，因此，我们最好把这个比较，放在MyDate类完成
        //封装后，将来可维护性和复用性，就大大增强.
        return this.getBirthday().compareTo(o.getBirthday());
    }
}
