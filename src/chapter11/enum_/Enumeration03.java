package chapter11.enum_;

/**
 * //p426+p427 enum实现枚举类
 * 1)当我们使用enum关键字开发一个枚举类时，默认会继承Enum类,而且是一个final类[如何证明],老师使用javap工具来演示
 * 2)传统的public static final Season2 SPRING=newSeason2("春天","温暖");简化成SPRING("春天","温暖")，这里必须知道，它调用的是哪个构造器.
 * 3)如果使用无参构造器创建枚举对象，则实参列表和小括号都可以省略
 * 4)当有多个枚举对象时，使用,间隔，最后有一个分号结尾
 * 5)枚举对象必须放在枚举类的行首.
 * @author 韩顺平
 * @version 1.0
 */
public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season2.AUTUMN);
        System.out.println(Season2.SUMMER);
    }
}
//演示使用enum关键字来实现枚举类
enum  Season2 {//类


    //定义了四个对象, 固定.
//    public static final Season SPRING = new Season("春天", "温暖");
//    public static final Season WINTER = new Season("冬天", "寒冷");
//    public static final Season AUTUMN = new Season("秋天", "凉爽");
//    public static final Season SUMMER = new Season("夏天", "炎热");
    //如果使用了enum 来实现枚举类的步骤
    //1. 使用关键字 enum 替代 class
    //2. public static final Season SPRING = new Season("春天", "温暖") 直接使用
    //   SPRING("春天", "温暖") 解读 常量名(实参列表)
    //3. 如果有多个常量(对象)， 使用 ,号间隔即可
    //4. 如果使用enum 来实现枚举，要求将定义的常量对象，写在前面（枚举对象必须放在枚举类的行首）
    //5. 如果我们使用的是无参构造器，创建常量对象，则可以省略 (),即What()可以写为What
    SPRING("春天", "温暖"), WINTER("冬天", "寒冷"), AUTUMN("秋天", "凉爽"),
    SUMMER("夏天", "炎热")/*, What()*/;

    private String name;
    private String desc;//描述

    private Season2() {//无参构造器

    }

    private Season2(String name, String desc) {
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
}

