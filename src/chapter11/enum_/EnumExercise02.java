package chapter11.enum_;

/**p431 Enum使用细节
 * @author 韩顺平
 * @version 1.0
 */
public class EnumExercise02 {
    public static void main(String[] args) {
        //获取到所有的枚举对象，数组
        Week[] values = Week.values();
        System.out.println("===所有星期的信息如下===");
        for(Week week : values) {
            System.out.println(week);
        }
    }
}

/*
声明Week枚举类，其中包含星期一至星期日的定义；
MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
使用values 返回所有的枚举数组, 并遍历 , 输出左图效果

 */

enum Week   {
    //定义Week的枚举对象
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),THURSDAY("星期四"),FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期七");
    private String day;
    private Week(String day) {//构造器
        this.day = day;
    }

    @Override
    public String toString() {
        return day;
    }
}


