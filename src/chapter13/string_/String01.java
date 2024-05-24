package chapter13.string_;


import java.util.Arrays;

/**p466 String结构解析，理解String底层是final byte[] value
 * @author 韩顺平
 * @version 1.0
 */
public class String01 {
    public static void main(String[] args) {
        //1.String 对象用于保存字符串，也就是一组字符序列
        //2. "jack" 字符串常量, 双引号括起的字符序列
        //3. 字符串的字符使用Unicode字符编码，一个字符(不区分字母还是汉字)占两个字节，char占两个字节
        //4. String 类有很多构造器，构造器的重载
        //   常用的有 String  s1 = new String(); //
        //String  s2 = new String(String original);
        //String  s3 = new String(char[] a);
        //String  s4 =  new String(char[] a,int startIndex,int count)
        //String s5 = new String(byte[] b)
        //5. String 类实现了接口 Serializable【String 可以串行化:可以在网络传输】
        //                 接口 Comparable [String 对象可以比较大小],实现compareTo方法
        //6. String 是final 类，不能被其他的类继承
        //7. String 有属性 private final char value[]; 用于存放字符串内容
        //8. jdk1.8及之前String底层为 char[ ] 数组，jdk1.9及以后String底层使用的是 byte[ ]数组，
        //private final byte[] value;
        // 一定要注意：value 是一个final类型， 不可以修改(需要功力)：即value不能指向
        //   新的地址，但是单个字符内容是可以变化

        String name = "jack";// "jack" 是字符串常量, 双引号括起的字符序列，name是变量
        name = "tom";
        final char[] value = {'a','b','c'};
        char[] v2 = {'t','o','m'};
        value[0] = 'H';//单个字符内容是可以变化
        //value = v2; //但不可以修改 value地址

/*        byte[] b = {'a','b','c'};
        String s5 = new String(b);
        System.out.println(s5);*/
        String str = " convert String to byte Array in Java " ;
        byte [] bytearray = str.getBytes();//1个字节8位，保存-128到127的值
        System.out.println(Arrays.toString(bytearray));

    }
}
