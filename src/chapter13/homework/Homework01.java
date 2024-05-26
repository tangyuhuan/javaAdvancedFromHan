package chapter13.homework;

/**
 * p494 String反转!!重复练习
 *
 * @author tyh
 * @version 1.0
 */

/**
 * (1) 将字符串中指定部分进行反转。比如将"abcdef"反转为"aedcbf"
 * (2) 编写方法 public static String reverse(String  str, int start , int end) 搞定
 * 思路分析
 * (1) 先把方法定义确定
 * (2) 把 String 转成 char[] ，因为char[] 的元素是可以交换的
 * (3) 画出分析示意图：用两个指针，分别初始化为start、end，交换后、各向中间移动一位
 * (4) 代码实现
 */

public class Homework01 {
    public static void main(String[] args) {
        System.out.println(reverse("abcdef", 1, 5));
    }


    public static String reverse(String str, int start, int end) {
        //对输入的参数做一个验证
        //老韩重要的编程技巧分享!!!
        //(1) 写出正确的情况
        //(2) 然后取反即可
        //(3) 这样写，你的思路就不乱
        if (!(str != null && start > 0 && end < str.length() && start < end)) {
            throw new RuntimeException("参数不正确");
        }
        char[] chars = str.toCharArray();
        char temp;//交换辅助变量
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        //使用chars 重新构建一个String 返回即可
        return new String(chars);
    }
}

/*我的实现
public class Homework01 {
    public static void main(String[] args) {
        System.out.println(reverse("abcdef",1,5));
    }
    public static String reverse(String str,int start,int end) {
        String sb3 = str.substring(start,end+1);
        StringBuilder sb4 =new StringBuilder(sb3).reverse();
        String sb5 = end+1<str.length()?str.substring(end+1):"";
        return str.substring(0,start)+sb4+sb5;
    }
}*/
