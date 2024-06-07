package chapter14.homework;

/**p549集合家庭作业2
 * @author tyh
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 使用ArrayList 完成对 对象 Car {name, price} 的各种操作
 * 1.add:添加单个元素
 * 2.remove:删除指定元素
 * 3.contains:查找元素是否存在
 * 4.size:获取元素个数
 * 5.isEmpty:判断是否为空
 * 6.clear:清空
 * 7.addAll:添加多个元素
 * 8.containsAll:查找多个元素是否都存在
 * 9.removeAll：删除多个元素
 * 使用增强for和 迭代器来遍历所有的car , 需要重写 Car 的toString方法
 */
public class Homework02 {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        Car bmw = new Car("bmw",300000);
        Car benz = new Car("benz",500000);
        cars.add(bmw);
        cars.add(benz);
        cars.add(new Car("audi",400000));
        System.out.println(cars.contains(bmw));
        System.out.println(cars.size());
        System.out.println(cars.isEmpty());
//        cars.clear();
        System.out.println(cars.toString());
        ArrayList<Car> car2 = new ArrayList<>();
        car2.add(bmw);
        car2.add(benz);
        cars.addAll(car2);//cars.addAll(cars);
        System.out.println(cars.containsAll(car2));
//        cars.removeAll(car2);//相当于清空

        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car next =  iterator.next();
            System.out.println(next);
        }
        for(Car car : cars) {
            System.out.println(car);
        }
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
}
