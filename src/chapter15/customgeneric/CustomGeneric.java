package chapter15.customgeneric;

import java.util.Arrays;

public class CustomGeneric {
    public static void main(String[] args) {
        Tiger<Double,String,Integer> g = new Tiger<>("John");
        g.setT(10.9);
//        g.setT("hihi");//T是Double类型，给字符串，错误
        System.out.println(g);
        Tiger g2 = new Tiger("John");//写法ok，注意T,R,M="Object"
        g2.setT("hi2");//T是"Object"，string是object的子类
        System.out.println(g2);
    }
}
    //老韩解读
//1. Tiger 后面泛型，所以我们把 Tiger 就称为自定义泛型类
//2, T, R, M 泛型的标识符, 一般是单个大写字母
//3. 泛型标识符可以有多个.
//4. 普通成员可以使用泛型 (属性、方法)
//5. 使用泛型的数组，不能初始化
//6. 静态方法中不能使用类的泛型
    class Tiger<T, R, M> {//泛型标识符可以有多个.
        String name;
        T t;
        R r;
        M m;
        //使用泛型的数组，不能初始化: 因为数组在new 不能确定T的类型，就无法在内存开空间
        //T[] ts = new T[10];
        T[] ts;

        public Tiger(String name) {
            this.name = name;
        }

        public Tiger(String name, T t, R r, M m) {
            this.name = name;
            this.t = t;
            this.r = r;
            this.m = m;
        }
        //如果静态方法和静态属性使用了泛型，JVM就无法完成初始化(M只是一个标识，JVM还不知道具体是什么类型)
        //具体的类型要对象创建时才知道
        //而静态是和类相关的，在类加载时，对象还没有创建
/*        static M m2;
        public static void m1(M m){

        }*/

        //方法使用泛型
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public R getR() {
            return r;
        }

        public void setR(R r) {//方法使用到泛型
            this.r = r;
        }

        public M getM() {//返回类型可以使用泛型.
            return m;
        }

        public void setM(M m) {
            this.m = m;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        @Override
        public String toString() {
            return "Tiger{" +
                    "name='" + name + '\'' +
                    ", r=" + r +
                    ", m=" + m +
                    ", t=" + t +
                    ", ts=" + Arrays.toString(ts) +
                    '}';
        }

    }

