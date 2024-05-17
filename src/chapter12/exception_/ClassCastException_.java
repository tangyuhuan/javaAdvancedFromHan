package chapter12.exception_;

/**p446 五大运行时异常之————ClassCastException
 * @author 韩顺平
 * @version 1.0
 */
public class ClassCastException_ {
    public static void main(String[] args) {
        A b = new B(); //向上转型，编译类型是A，实际指向B类的对象
        B b2 = (B)b;//向下转型，这里是OK
        C c2 = (C)b;//这里抛出ClassCastException，B和C无关
    }
}
class A {}
class B extends A {}
class C extends A {}

