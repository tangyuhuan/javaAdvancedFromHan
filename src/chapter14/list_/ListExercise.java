package chapter14.list_;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**p506 List接口练习
 * @author tyh
 * @version 1.0
 */
        /*
        添加10个以上的元素(比如String "hello" )，在2号位插入一个元素"韩顺平教育"，
        获得第5个元素，删除第6个元素，修改第7个元素，在使用迭代器遍历集合，
        要求:使用List的实现类ArrayList完成。
         */
public class ListExercise {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add("hello" + i);
        }
        list.add(1,"韩顺平教育");
        //获得第5个元素
        System.out.println("第五个元素"+list.get(4));;
        //删除第6个元素
        System.out.println("第六个元素"+list.remove(5));
        //删除第7个元素
        list.set(6,"替换");
        //在使用迭代器遍历集合
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next =  iterator.next();
            System.out.println(next);
        }
    }
}
