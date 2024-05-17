package chapter12.try_;

import java.util.Scanner;

/**
 * p451 try catch最佳实践!!!重复练习
 * 题目：如果用户输入的不是一个整数，就提示他反复输入，直到输入一个整数为止。
 * @author tyh
 * @version 1.0
 */
public class TryCatchExercise04 {
    public static void main(String[] args) {
        //如果用户输入的不是一个整数，就提示他反复输入，直到输入一个整数为止
        //思路
        //1. 创建Scanner对象
        //2. 使用无限循环，去接收一个输入
        //3. 然后将该输入的值，转成一个int
        //4. 如果在转换时，抛出异常，说明输入的内容不是一个可以转成int的内容
        //5. 如果没有抛出异常，则break 该循环
        Scanner input = new Scanner(System.in);
        String str = "";
        int num = 0;
        while (true) {
            System.out.println("请输入一个整数：");
            str = input.nextLine();
            try {
                num = Integer.parseInt(str);//这里可能抛出异常
                break;//！！！不会抛出异常的话就退出循环
            } catch (Exception e) {
                System.out.println("输入的不是整数");
            }
        }
        System.out.println("输入的整数是："+num);
    }
}
