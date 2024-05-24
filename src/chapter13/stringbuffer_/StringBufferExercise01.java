package chapter13.stringbuffer_;

/**p476 StringBuffer练习！！重复练习
 * @author 韩顺平
 * @version 1.0
 */
public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;// ok
        StringBuffer sb = new StringBuffer(); //ok
        sb.append(str);//需要看源码 , 底层调用的是 AbstractStringBuilder 的 appendNull
        System.out.println(sb.length());//4，将null对象转成了['n','u','l','l']

        System.out.println(sb);//null
        //下面的构造器，会抛出NullpointerException
        StringBuffer sb1 = new StringBuffer(str);//看底层源码 int length = str.length(); 会抛出NullPointerException
        System.out.println(sb1);

    }
}
