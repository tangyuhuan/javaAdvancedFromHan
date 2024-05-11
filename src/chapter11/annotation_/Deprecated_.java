package chapter11.annotation_;

/**p433 Deprecated注解
 * @author 韩顺平
 * @version 1.0
 */
public class Deprecated_ {
    public static void main(String[] args) {
        A a = new A();
        a.hi();
        System.out.println(a.n1);
    }
}

//老韩解读
//1. @Deprecated 修饰某个元素, 表示该元素已经过时
//2. 即不在推荐使用，但是仍然可以使用
//3. 查看 @Deprecated 注解类的源码
//4. 可以修饰方法，类，字段, 包, 参数  等等
//5. @Deprecated的用处： 可以做版本升级过渡使用
/*
@Documented //指定被该元Annotation修饰的Annotation类将被javadoc工具提取成文档，生成文档时可以看到该注解
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Deprecated {
}
 */
@Deprecated
class A {
    @Deprecated
    public int n1 = 10;
    @Deprecated
    public void hi(){

    }
}
