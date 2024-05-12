package chapter11.homework;

/**p442 家庭作业5-编程题8
 * @author tyh
 * @version 1.0
 */
/*
枚举类
创建一个Color枚举类
1.有 RED,BLUE,BLACK,YELLOW,GREEN这个五个枚举值/对象；
2.Color有三个属性redValue，greenValue，blueValue，
3.创建构造方法，参数包括这三个属性，
4.每个枚举值都要给这三个属性赋值，三个属性对应的值分别是
red：255,0,0  blue:0,0,255  black:0,0,0  yellow:255,255,0  green:0,255,0
5.定义接口，里面有方法show，要求Color实现该接口
6.show方法中显示三属性的值
7. 将枚举对象在switch语句中匹配使用

 */
public class Homework08 {
    public static void main(String[] args) {

        //注意：是“将枚举对象在switch语句中匹配使用”，不是去匹配到枚举对象
        Color color = Color.BLACK;
        color.show();
        switch (color) {
            case RED:
                System.out.println("匹配到红色");
                break;
            case BLUE:
                System.out.println("匹配到蓝色");
                break;
            case YELLOW:
                System.out.println("匹配到黄色");
                break;
            case BLACK:
                System.out.println("匹配到黑色");
                break;
            default:
                System.out.println("没有匹配到..");
        }

//        String color = "RED";
//        switch(color){//switch中表达式的返回值必须是byte short int char enum string
//            case "RED":
//                Color.RED.show();
//                break;
//            case "BLUE":
//                Color.BLUE.show();
//                break;
//            case "BLACK":
//                Color.BLACK.show();
//                break;
//            case "YELLOW":
//                Color.YELLOW.show();
//                break;
//            case "GREEN":
//                Color.GREEN.show();
//                break;
//        }
    }
}
enum Color implements Show {
    RED(255,0,0),BLUE(0,0,255),BLACK(0,0,0),YELLOW(255,255,0),GREEN(0,255,0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }


    @Override
    public void show() {
        System.out.println(toString());;
    }

    @Override
    public String toString() {
        return "Color{" +
                "redValue=" + redValue +
                ", greenValue=" + greenValue +
                ", blueValue=" + blueValue +
                "} " + super.toString();
    }
}
interface Show{
    void show();
}