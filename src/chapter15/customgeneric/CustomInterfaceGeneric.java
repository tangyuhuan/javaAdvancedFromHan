package chapter15.customgeneric;
//p562自定义泛型接口
public class CustomInterfaceGeneric {

}

//2. 泛型接口的类型, 在继承接口或者实现接口时确定
interface IA extends IUsb<String,Double> {

}
//当我们去实现IA接口时，因为IA在继承IUsu 接口时，指定了U 为String R为Double
//，在实现IUsu接口的方法时，使用String替换U, 是Double替换R
class AA implements IA {
    @Override
    public Double get(String s) {
        return 0.0;
    }

    @Override
    public void hi(Double aDouble) {

    }

    @Override
    public void run(Double r1, Double r2, String u1, String u2) {

    }

    @Override
    public Double method(String u1, String u2) {
        return IA.super.method(u1, u2);
    }
}
//2. 泛型接口的类型, 在继承接口或者实现接口时确定
//给U 指定Integer 给 R 指定了 Float
//所以，当我们实现IUsb方法时，会使用Integer替换U, 使用Float替换R
class BB implements IUsb<Float,Double> {

    @Override
    public Double get(Float aFloat) {
        return 0.0;
    }

    @Override
    public void hi(Double aDouble) {

    }

    @Override
    public void run(Double r1, Double r2, Float u1, Float u2) {

    }

}
//3.没有指定类型，默认为Object
//这种写法不规范哦，不建议。建议直接写成 IUsb<Object,Object>
class CC implements IUsb {//等价 class CC implements IUsb<Object,Object>
    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void hi(Object o) {

    }

    @Override
    public void run(Object r1, Object r2, Object u1, Object u2) {

    }

}
//如果静态方法和静态属性使用了泛型，JVM就无法完成初始化(M只是一个标识，JVM还不知道具体是什么类型)
//具体的类型要对象创建时才知道
//而静态是和类相关的，在类加载时，对象还没有创建

/*
 *  泛型接口使用的说明
 *  1. 接口中，静态成员也不能使用泛型，因为是静态成员（静态是和类相关的，类加载早于对象的创建，而泛型的具体类型要对象创建时才知道）
 *  2. 泛型接口的类型, 在继承接口或者实现接口时确定
 *  3. 没有指定类型，默认为Object
 */

/*
1.接口中只能包含抽象方法，同时接口必须是抽象的，所以定义接口时必须用abstract修饰
2.接口中抽象方法必须用public修饰
3.接口中的变量前面会被默认加上public static final的，即接口中没有变量，都是常量

正因为如上规定，java编译器允许我们在编写接口代码时
1.可省略修饰接口的abstract
2.可省略修饰接口方法的public和abstract
3.可省略接口中变量的public static final*/
interface IUsb<U,R>{
    int n =10;//接口中的变量前面会被默认加上public static final的，即接口中没有变量，都是常量
    //U name;//接口中的成员都是静态性质的 'chapter15.customgeneric.IUsb.this' cannot be referenced from a static context
//    public abstract R get(U u);//
    //普通方法中，可以使用接口泛型
    R get(U u);
    void hi(R r);
    void run(R r1,R r2,U u1,U u2);
    //在jdk8 中，可以在接口中，使用默认方法, 也是可以使用泛型
    default R method(U u1,U u2){
        return null;
    }

}