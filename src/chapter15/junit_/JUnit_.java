package chapter15.junit_;

import org.junit.jupiter.api.Test;

/*p566 Junit使用
Junit：java语言单元测试框架,建议用5版本
*/
/**
 * @author 韩顺平
 * @version 1.0
 */
public class JUnit_ {
    public static void main(String[] args) {
        //传统方式
        //new JUnit_().m1();
        //new JUnit_().m2();

    }


    @Test
    public void m1() {
        System.out.println("m1方法被调用");
    }

    @Test
    public void m2() {
        System.out.println("m2方法被调用");
    }

    @Test
    public void m3() {
        System.out.println("m3方法被调用");
    }
}
