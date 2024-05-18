package chapter13.wrapper;

/**p461 包装类测试 ！！第二个问题重复理解
 * @author 韩顺平
 * @version 1.0
 */
public class WrapperExercise01 {
    public static void main(String[] args) {
        //1.如下代码是否正确
        Double d = 100d; //ok, 自动装箱 Double.valueOf(100d);
        Float f = 1.5f; //ok, 自动装箱 Float.valueOf(1.5f);

        //2.如下两个题目输出结果相同吗？
        Object obj1 = true? new Integer(1) : new Double(2.0);//三元运算符【是一个整体】 一真大师
        System.out.println(obj1);// 什么? 1.0，因为三元运算符看作一个整体，整体精度高优先。精度最高的是double，会提升优先级。

        Object obj2;
        if(true)
            obj2 = new Integer(1);
        else
            obj2 = new Double(2.0);
        System.out.println(obj2);//1
        //输出什么 ? 1， 分别计算，语句是独立的。

    }
}
