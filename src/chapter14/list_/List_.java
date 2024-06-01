package chapter14.list_;

import java.util.ArrayList;
import java.util.List;

/*** p505 List接口方法
 * @author 韩顺平
 * @version 1.0
 */
public class List_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //1. List集合类中元素有序(即添加顺序和取出顺序一致)、且可重复 [案例]
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("hsp");
        //元素内容是可以重复的
        list.add("tom");
        System.out.println("list=" + list);
        //2. List集合中的每个元素都有其对应的顺序索引，即支持索引（List的底层是个数组）
        //   索引是从0开始的
        System.out.println(list.get(3));//hsp
        //3.
    }
}
