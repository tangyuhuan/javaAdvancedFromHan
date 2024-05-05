package chapter15.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//p560泛型课堂练习
/**
 * @author 韩顺平
 * @version 1.0
 */
@SuppressWarnings({"all"})
/**
 * 定义Employee类
 * 1) 该类包含：private成员变量name,sal,birthday，其中 birthday 为 MyDate 类的对象；
 * 2) 为每一个属性定义 getter, setter 方法；
 * 3) 重写 toString 方法输出 name, sal, birthday
 * 4) MyDate类包含: private成员变量month,day,year；并为每一个属性定义 getter, setter 方法；
 * 5) 创建该类的 3 个对象，并把这些对象放入 ArrayList 集合中（ArrayList 需使用泛型来定义），对集合中的元素进行排序，并遍历输出：
 *
 * 排序方式： 调用ArrayList 的 sort 方法 ,
 * 传入 Comparator对象[使用泛型]，先按照name排序，如果name相同，则按生日日期的先后排序。【即：定制排序】
 * 有一定难度 15min , 比较经典 泛型使用案例 GenericExercise02.java
 *
 * 关于Java的Comparator和Comparable的说明
 * 当需要排序的集合或数组不是单纯的数字型时，通常可以使用Comparator或Comparable，以简单的方式实现对象排序或自定义排序。
 * 一、Comparator  对某个对象collection进行整体排序的比较函数，可以将Comparator传递给Collections.sort或Arrays.sort。
 * 二、Comparable  对实现它的每个类的对象进行整体排序，实现此接口的对象列表（和数组）可以通过Collections.sort或Arrays.sort进行自动排序。
 * 当你实现了 Comparable 接口时，必须重写 compareTo 方法，以定义对象之间的比较逻辑。
 * 如果当前对象小于指定的对象，则返回负值
 * 如果当前对象等于指定的对象，则返回0
 * 如果当前对象大于指定的对象，则返回正值
 *
 * Comparable与Comparator的区别
 * Comparable可以被认为是一个内比较器，在实现Comparable接口的ADT内部重写compareTo方法。实现了Comparable的类具有自比较功能，类的一个对象自己就可以通过compareTo方法与类中另一个对象（或仍是自身）进行比较。
 * 而Comparator是一个外比较器，需要构建新的Comparator类来实现。作为compare方法的参数的两个对象自身可以不具备自比较功能，
 * 实现Comparator的类可以被看作一种算法的实现，作为专用的比较器为其提供比较方式。
 *
 * 实现了Comparable接口的类的对象构成的list可以直接使用Collections.sort(list)进行排序。
 * 如果list中元素所处类没有实现Comparable接口或实现了Comparable接口但想要以其他专门规则进行排序，需要使用Collections.sort(list,
 * comparator)。
 */


public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("cici",3000,new MyDate(2,8,1994)));
        employees.add(new Employee("cici",3000,new MyDate(2,7,1994)));
        employees.add(new Employee("linlin",3000,new MyDate(2,10,1994)));
        employees.add(new Employee("alice",3000,new MyDate(2,12,1994)));
        employees.add(new Employee("cici",3000,new MyDate(2,10,1994)));


        //排序方式1，实现Comparable接口的类的对象构成的list可以直接使用Collections.sort(list)进行排序。
        //让Employee实现Comparable接口，override compareTo方法
        Collections.sort(employees);

        //排序方式2，实现Comparator的类可以被看作一种算法的实现，作为专用的比较器为其提供比较方式。
        //匿名内部类，接口的泛型
/*        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //先按照name排序，如果name相同，则按生日日期的先后排序。【即：定制排序】
                //先对传入的参数进行验证
                if(!(o1 instanceof  Employee && o2 instanceof Employee)) {
                    System.out.println("类型不正确..");
                    return 0;
                }
                //比较name
                int i = o1.getName().compareTo(o2.getName());
                if(i != 0) {
                    return i;
                }
                //下面是对birthday的比较，因此，我们最好把这个比较，放在MyDate类完成
                //封装后，将来可维护性和复用性，就大大增强.
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });*/
        System.out.println("==对雇员进行排序==");
        System.out.println(employees);
    }
}



/*

public class GenericExercise02 {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom", 20000, new MyDate(1980,12,11)));
        employees.add(new Employee("jack", 12000, new MyDate(2001,12,12)));
        employees.add(new Employee("tom", 50000, new MyDate(1980,12,10)));

        System.out.println("employees=" + employees);


        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                //先按照name排序，如果name相同，则按生日日期的先后排序。【即：定制排序】
                //先对传入的参数进行验证
                if(!(emp1 instanceof  Employee && emp2 instanceof Employee)) {
                    System.out.println("类型不正确..");
                    return 0;
                }
                //比较name
                int i = emp1.getName().compareTo(emp2.getName());
                if(i != 0) {
                    return i;
                }

                //下面是对birthday的比较，因此，我们最好把这个比较，放在MyDate类完成
                //封装后，将来可维护性和复用性，就大大增强.
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });

        System.out.println("==对雇员进行排序==");
        System.out.println(employees);

    }
}
*/
