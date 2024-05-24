package chapter13.stringbuffer_;

/**p475 StringBuffer结构解析
 * @author 韩顺平
 * @version 1.0
 */
public class StringBuffer01 {
    public static void main(String[] args) {
        //老韩解读
        //1. StringBuffer 的直接父类 是 AbstractStringBuilder
        //2. StringBuffer 实现了 Serializable, 即StringBuffer的对象可以串行化
        //3. 在其父类AbstractStringBuilder中 有属性 char[] value,不是final （jdk17中是byte[] value;）
        //   所以StringBuffer保存的是字符串变量，每次更新就是更改值，效率较高。（String保存的是字符串常量，每次更新就是更改地址，效率低）
        //   该 value 数组存放 字符串内容，因此是存放在堆中的（不是常量池）
        //4. StringBuffer 是一个 final类，不能被继承
        //5. 因为StringBuffer 字符内容是存在 char[] value, 所有在变化(增加/删除)
        //   不用每次都更换地址(即不是每次创建新对象)， 所以效率高于 String

        StringBuffer stringBuffer = new StringBuffer("hello");

    }
}
