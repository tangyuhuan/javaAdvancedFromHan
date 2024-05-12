package chapter11.homework;

/**
 * p439 家庭作业4-编程题6
 * @author tyh
 * @version 1.0
 */
/*
此题很棒！
1.有一个交通工具接口类Vehicles，有work方法
2.有Horse类和Boat类分别实现Vehicles
3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
4.有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
5.实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
6.增加一个情况，如果唐僧过火焰山, 使用 飞机 ==> 程序扩展性, 我们前面的程序结构就非常好扩展 10min
使用代码实现上面的要求
编程 需求---->理解---->代码-->优化
实际建议每个interface、class都单独文件
 */
//老师的实现：思想更好
public class Homework06 {
    public static void main(String[] args) {
        Person tang = new Person("唐僧", new Horse());
        tang.common();//一般情况下
        tang.passRiver();//过河
        tang.common();//一般情况下
        tang.passRiver();//过河
        tang.passRiver();//过河
        tang.passRiver();//过河
        //过火焰山
        tang.passFireHill();

    }
}
interface Vehicles{
    void work();
}
class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("骑马");
    }
}
class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("坐船");
    }
}
class Airplane implements Vehicles{
    @Override
    public void work() {
        System.out.println("飞机");
    }
}
//创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
//只想要获取方法，故没有必要创建工厂对象，我们将方法做成static比较方便
class Factory{
    //马儿始终是同一匹
    private static Horse horse = new Horse();//饿汉式单例模式,在类加载的时候就立即初始化,并且创建单例对象。
    public static Horse getHorse(){
        //return new Horse();//每次都返回一匹新马，不对
        return horse;
    }

    public static Boat getBoat() {
        return new Boat();
    }
    public static Airplane getPlane() {
        return new Airplane();
    }
}
class Person{
    private String name;
    private Vehicles vehicles;
    //在创建人对象时，事先给他分配一个交通工具
    public Person(String name,Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }
    public void common() {
        //得到马儿
        //判断一下，当前的 vehicles 属性是null, 就获取一匹马
        if(!(vehicles instanceof Horse)){
            //这里使用的是多态
            vehicles = Factory.getHorse();
        }
//        Horse horse = Factory.getHorse();//这种写法浪费了构造器里给的第一个交通工具
        //这里体现使用接口调用-----接口解耦的特性
        vehicles.work();
    }
    //实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
    //这里涉及到一个编程思路，就是可以把具体的要求，封装成方法-> 这里就是编程思想
    //思考一个问题，如何不浪费，在构建对象时，传入的交通工具对象->动脑筋
    public void passRiver() {
        //先得到船
        //vehicles instanceof Boat 是判断 当前的 vehicles是不是Boat
        //(1) vehicles = null  : vehicles instanceof Boat  => false
        //(2) vehicles = 马对象 ：vehicles instanceof Boat  => false
        //(3) vehicles = 船对象 ：vehicles instanceof Boat  => true
        if(!(vehicles instanceof Boat)){//如果是null/不是船
            vehicles = Factory.getBoat();
        }
            //Boat boat = Factory.getBoat();//这种写法浪费了构造器里给的第一个交通工具
        vehicles.work();
    }
    public void passFireHill() {
        if(!(vehicles instanceof Airplane)){
            vehicles = Factory.getPlane();
        }
        vehicles.work();
//        this.vehicles = new Airplane();
//        this.vehicles.work();
    }
}

/*
我的实现
public class Homework06 {
    public static void main(String[] args) {
        String weather = "一般";
        Person person;
        if(weather.equals("一般")){
            person = new Person(new Factory().getHorse(), "唐僧");
        }else{
            person = new Person(new Factory().getBoat(), "唐僧");
        }
        person.work();

    }
}
//编写接口代码时
//1.可省略修饰接口的abstract
//2.可省略修饰接口方法的public和abstract
//3.可省略接口中变量的public static final

interface Vehicles{
    void work();
}
class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("骑马");
    }
}
class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("坐船");
    }
}
class Factory{
    public Horse getHorse(){
        return new Horse();
    }
    public Boat getBoat(){
        return new Boat();
    }
}
class Person{
    private String name;
    private Vehicles vehicles;

    public Person(Vehicles vehicles, String name) {
        this.vehicles = vehicles;
        this.name = name;
    }
    public void work() {
        vehicles.work();
    }
}
*/
