package chapter14.set_;

/**p530 LinkedHashSet课堂练习
 * @author tyh
 * @version 1.0
 */

import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * Car 类(属性:name,price)，  如果 name 和 price 一样，
 * 则认为是相同元素，就不能添加。 5min
 */
public class LinkedHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet<Car> set = new LinkedHashSet<>();
        set.add(new Car("奥拓",1000));
        set.add(new Car("奥迪",20000));
        set.add(new Car("法拉利",70000));
        set.add(new Car("奔驰",30000));
        set.add(new Car("法拉利",70000));
        set.add(new Car("奥迪",20000));
        System.out.println(set);
    }
}
class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    //重写equals 方法 和 hashCode
    //当 name 和 price 相同时， 就返回相同的 hashCode 值, equals返回t
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Double.compare(price, car.price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
