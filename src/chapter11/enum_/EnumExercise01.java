package chapter11.enum_;

/**
 * p428 enum枚举类3
 * enum关键字实现枚举-课堂练习
 *
 * 在Java中，枚举（enum）类型的比较可以使用等号（==）进行。
 * Enum类中的equals()方法是使用==符号来比较两个枚举类型是否相等的。
 * 所以比较两个枚举类型，用equals()方法和等号（==）是等价的。
 * @author 韩顺平
 * @version 1.0
 */
public class EnumExercise01 {
    public static void main(String[] args) {
        Gender2 boy = Gender2.BOY;//OK
        Gender2 boy2 = Gender2.BOY;//OK
        System.out.println(boy);//输出BOY //本质就是调用 Gender2 的父类Enum的 toString()
//        public String toString() {
//            return name;
//        }
        System.out.println(boy2 == boy);  // true，因为它们引用的是同一个对象
        Gender2 girl = Gender2.GIRL;
        System.out.println(boy.equals(boy2));// true，因为它们引用的是同一个对象
        System.out.println(boy.equals(girl));// false，因为它们引用的是不同的对象
    }
}

enum Gender2{ //父类 Enum 的toString
    BOY , GIRL;//这里其实就是调用Gender类的无参构造器
    //如果这里定义了有参构造器，必须写一遍无参构造器（不写就被覆盖了）
}

