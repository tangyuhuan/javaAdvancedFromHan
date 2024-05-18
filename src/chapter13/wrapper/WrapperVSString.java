package chapter13.wrapper;

/**p462 包装类方法
 * @author 韩顺平
 * @version 1.0
 */
public class WrapperVSString {
    public static void main(String[] args) {
        //包装类(Integer)->String
        Integer i = 100;//自动装箱
        //方式1
        String str1 = i + "";
        //方式2
        String str2 = i.toString();
        //方式3
        String str3 = String.valueOf(i);//String.valueOf接收一个对象

        //String -> 包装类(Integer)
        String str4 = "12345";
        //方式1
        Integer i2 = Integer.parseInt(str4);//使用到自动装箱
        //方式2
        Integer i3 = new Integer(str4);//构造器，不建议使用，java9之后移除
        //方式3
        Integer i4 = Integer.valueOf(str4);
        System.out.println(i4);

        System.out.println("ok~~");

    }
}
