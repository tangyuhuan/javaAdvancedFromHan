package chapter14.collection_;

import java.util.ArrayList;

/**p509 ArrayList注意事项
 * @author 韩顺平
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ArrayListDetail {
    public static void main(String[] args) {
        //ArrayList 是线程不安全的, 可以看源码 没有 synchronized
        /*
            public boolean add(E e) {
                ensureCapacityInternal(size + 1);  // Increments modCount!!
                elementData[size++] = e;
                return true;
            }
         */
        //ArrayList可以加入null 并且是使用数组来实现数据存储的
        //ArrayList基本等同于vector，除了ArrayList是线程不安全（执行效率高）多线程情况下不建议使用
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("jack");
        arrayList.add(null);
        arrayList.add("hsp");
        System.out.println(arrayList);
    }
}
