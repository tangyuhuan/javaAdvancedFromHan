package chapter13.homework;

/**p496 字符串统计
 * @author tyh
 * @version 1.0
 */

/**
 * 输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字
 * 思路分析
 * (1) 遍历字符串，如果 char 在 '0'~'9' 就是一个数字
 * (2) 如果 char 在 'a'~'z' 就是一个小写字母
 * (3) 如果 char 在 'A'~'Z' 就是一个大写字母
 * (4) 使用三个变量来记录 统计结果
 */
//a 97 z 122
//A 65 Z 90
//0 48 9 57
public class Homework04 {
    public static void main(String[] args) {
        String str = "ssdsdAAAA11";
        cout(str);
    }
    public static void cout(String str){
        if (str == null) {
            System.out.println("输入不能为 null");
            return;
        }
        char[] chars = str.toCharArray();
        int isLower = 0;
        int isUpper = 0;
        int isDigit = 0;
        int otherCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if((chars[i]>=48)&&(chars[i]<=57)){
                isDigit++;
            }else if((chars[i]>=65)&&(chars[i]<=90)){
                isUpper++;
            }else if((chars[i]>=97)&&(chars[i]<=122)){
                isLower++;
            }else{
                otherCount++;
            }
        }
        String out = String.format("小写字母有:%d,大写字母有%d,数字有:%d,其他字符有：%d",isLower,isUpper,isDigit,otherCount);
        //format后格式化规则查看java api文档：https://doc.qzxdp.cn/jdk/17/zh/api/java.base/java/util/Formatter.html#syntax
        System.out.println(out);
    }
}
