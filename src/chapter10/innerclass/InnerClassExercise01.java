package chapter10.innerclass;

/*
p419匿名内部类实践
 */
public class InnerClassExercise01 {
    public static void main(String[] args) {
//
        //匿名内部类可以当做实参直接传递，简洁高效
        f1(new IL(){
            @Override
            public void show() {
                System.out.println("这是一副名画~~...");
            }
        });
        //传统方法
        f1(new Picture());
    }
//
//    //静态方法,形参是接口类型
    public static void f1(IL il) {
        il.show();
    }
}
//接口
interface IL {
    void show();
}
//类->实现IL => 编程领域 (硬编码,比较死板的写法，不推荐)
class Picture implements IL {

    @Override
    public void show() {
        System.out.println("这是一副名画XX...");
    }
}

