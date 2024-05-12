package chapter11.homework;

/**p438 家庭作业1-编程题5
 * @author tyh
 * @version 1.0
 */
/*
编一个类A，在类中定义局部内部类B，B中有一个私有final常量name，有一个方法show()打印常量name。进行测试
进阶：A中也定义一个私有的变量name，在show方法中打印测试

 */
public class Homework05 {
    public static void main(String[] args) {
        A a = new A();
        a.showB();
    }
}
class A{
    private final static String Name = "testAName";
    //注意是局部内部类，不是成员内部类
    public void showB(){
        class B{//局部内部类
            private final static String Name = "testBName";
            public void show(){
                System.out.println(Name);
                //如果内部类和外部类的属性重名，可以同 外部类.this.属性名来指定
                System.out.println(A.this.Name);
            }
        }
        B b = new  B();
        b.show();
    }
}
