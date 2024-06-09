package chapter14.homework;


import java.util.TreeSet;

/**p551集合家庭作业4 ！！重复练习
 * 题目：https://www.yuque.com/cicismom/shg8y7/waxs4gob5cbc489c#HqdFH
 * @author 韩顺平
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Homework04 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add("hsp");
        treeSet.add("tom");
        treeSet.add("king");
        treeSet.add("hsp");//加入不了
        System.out.println(treeSet);

    }
}
