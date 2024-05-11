package chapter11.enum_;
//p425自定义类实现枚举

/**
 * @author 韩顺平
 * @version 1.0
 */
public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING);
    }
}

//演示字定义枚举实现
class Season {//类
    private String name;
    private String desc;//描述

    //定义了四个对象, 固定.
    //对枚举对象/属性使用final+static共同修饰，实现底层优化
    //枚举对象名通常使用全部大写、常量的命名规范
    //枚举对象根据需要，也可以有多个属性Enumeration02
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season WINTER = new Season("冬天", "寒冷");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season SUMMER = new Season("夏天", "炎热");


    //1. 将构造器私有化,目的防止 直接被 new
    //2. 去掉setXxx方法, 防止属性被修改
    //3. 在Season 内部，直接创建固定的对象
    //4. 优化，可以加入 final 修饰符,否则外部Season.SPRING = Season.AUTUMN;可以修改的
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
    public void make(){
        System.out.println("ssss");
    }
}