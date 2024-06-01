package chapter14.list_;

import java.util.ArrayList;
import java.util.Arrays;

/**p510 p511 ArrayList注意事项（底层结构和源码分析）
 * @author 韩顺平
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ArrayListSource {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = Arrays.copyOf(a1, 10);//a2:[1,2,3,4,5,0,0,0,0,0]
        Object[] elementData = new Object[10];
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = i;
        }

        elementData = Arrays.copyOf(elementData, 15);//[1,2,3,4,5,6,7,8,9,10,null,null,null,null,null];

/*        ArrayList维护了一个Object类型的数组， transient 表示瞬间的、短暂的，表示该属性不会被序列化
        transient Object[] elementData; // non-private to simplify nested class access
        */
        //老韩解读源码
        //注意，注意，注意，Idea 默认情况下，Debug 显示的数据是简化后的，如果希望看到完整的数据
        //需要做设置.∑´Í
        //使用无参构造器创建ArrayList对象
        ArrayList list = new ArrayList();
//        ArrayList list = new ArrayList(8);
        //使用for给list集合添加 1-10数据
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        //使用for给list集合添加 11-15数据
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);//再次扩容为15*1.5=22
        list.add(200);
        list.add(null);

    }
}
