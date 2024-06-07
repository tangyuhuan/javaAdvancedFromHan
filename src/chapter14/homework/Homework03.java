package chapter14.homework;

/**p550集合家庭作业3
 * @author tyh
 * @version 1.0
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 按要求完成下列任务
 * 1）使用HashMap类实例化一个Map类型的对象m，键（String）和值（int）分别用于存储员工的姓名和工资，
 * 存入数据如下：	jack—650元；tom—1200元；smith——2900元；
 * 2）将jack的工资更改为2600元
 * 3）为所有员工工资加薪100元；
 * 4）遍历集合中所有的员工
 * 5）遍历集合中所有的工资
 */

public class Homework03 {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap();
        hashMap.put("jack",650);//int->Integer
        hashMap.put("tom",1200);
        hashMap.put("smith",2900);
        hashMap.put("jack",2600);
        Set<String> set = hashMap.keySet();
        System.out.println("遍历集合中所有的员工");
        //keySet
        for(String str:set){
            hashMap.put(str,hashMap.get(str)+100);
            System.out.println(str+":"+hashMap.get(str));
        }
        //遍历 EntrySet
        System.out.println("遍历集合");
        Set<Map.Entry<String, Integer>> entrySet =  hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.println("====遍历所有的工资====");
        hashMap.values().forEach(System.out::println);
    }
}
