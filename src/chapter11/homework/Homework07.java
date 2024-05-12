package chapter11.homework;

/**
 * p440 家庭作业5-编程题7
 * @author tyh
 * @version 1.0
 */
/*
有一个Car2类，有属性temperature（温度），车内有Air（空调）类，有吹风的功能flow，
Air会监视车内的温度，如果温度超过40度则吹冷气。如果温度低于0度则吹暖气，
如果在这之间则关掉空调。实例化具有不同温度的Car对象，调用空调的flow方法，
测试空调吹的风是否正确 . //体现 类与类的包含关系的案例 类(内部类【成员内部类】)
 */
public class Homework07 {
    public static void main(String[] args) {
        Car3 car = new Car3(43.2);
        car.getAir().flow();
        Car3 car21 = new Car3(-1);
        car21.getAir().flow();
        Car3 car22 = new Car3(20);
        car22.getAir().flow();
    }
}
class Car3 {
    private double temperature;

    public Car3(double temperature) {
        this.temperature = temperature;
    }

    class Air{
        public void flow(){
            if(temperature > 40){
                System.out.println("吹冷气");
            }else if(temperature < 0){
                System.out.println("吹暖气");
            }else{
                System.out.println("关空调");
            }
        }
    }
    public Air getAir(){
        Air air = new Air();
        return air;
    }
}