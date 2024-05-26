package chapter13.homework;

/**p495 注册处理器
 * @author tyh
 * @version 1.0
 */

/**
 * 输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
 * 要求：
 * (1) 用户名长度为2或3或4
 * (2) 密码的长度为6，要求全是数字  isDigital
 * (3) 邮箱中包含@和.   并且@在.的前面
 * <p>
 * 思路分析
 * (1) 先编写方法 userRegister(String name, String pwd, String email) {}
 * (2) 针对 输入的内容进行校核，如果发现有问题，就抛出异常，给出提示
 * (3) 单独的写一个方法，判断 密码是否全部是数字字符 boolean
 */
//老韩的实现
public class Homework02 {
    public static void main(String[] args) {
        try{
            check("cic","123456","123@21.com");
            System.out.println("恭喜你，注册成功~");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void check(String name,String password,String email){
        //注意要再加入一些校验
        if(!(name!=null&&password!=null&&email!=null)){
            throw  new RuntimeException("参数不能为null");
        }
        //第一关
        int userLength = name.length();
        if(!(userLength==2 || userLength==3 ||userLength==4)){
            throw new RuntimeException("用户名长度为2或3或4");
        }
        if(!((password.length()==6)&&isNumeric(password))){
            throw new RuntimeException("密码的长度为6，要求全是数字");
        }
        int index1 = email.indexOf("@");
        int index2 = email.indexOf(".");
        if(!(index1>0&&index2>index1)){
            throw new RuntimeException("邮箱中包含@和.   并且@在.的前面");
        }
    }
    //单独的写一个方法，判断 密码是否全部是数字字符 boolean
    public static boolean isNumeric(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}


/*
我的实现
public class Homework02 {
    public static void main(String[] args) {
        try{
            check("cic","123456","123@21.com");
            System.out.println("恭喜你，注册成功~");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void check(String name,String password,String email){

        if(!(name.length()==2 || name.length()==3 ||name.length()==4)){
            throw new RuntimeException("用户名长度为2或3或4");
        }
        if(!((password.length()==6)&&isNumeric(password))){
            throw new RuntimeException("密码的长度为6，要求全是数字");
        }
        int index1 = email.indexOf("@");
        int index2 = email.indexOf(".");
        if(!((index1!=-1)&&(index2!=-1)&&(index1<index2))){
            throw new RuntimeException("邮箱中包含@和.   并且@在.的前面");
        }
    }
    public final static boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }
}
*/
