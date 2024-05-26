package chapter13.arrays_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**p484 Java_Arrays其他方法
 * @author 韩顺平
 * @version 1.0
 */
public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 90, 123, 567};
        // binarySearch 通过二分搜索法进行查找，要求必须排好
        // 老韩解读
        //1. 使用 binarySearch 二叉查找
        //2. 要求该数组是有序的. 如果该数组是无序的，不能使用binarySearch
        //3. 如果数组中不存在该元素，就返回 return -(low + 1);  // key not found.   low是应该在的位置
        int index = Arrays.binarySearch(arr, 567);
        System.out.println("index=" + index);

        //copyOf 数组元素的复制
        // 老韩解读
        //1. 从 arr 数组中，拷贝 arr.length个元素到 newArr数组中
        //2. 如果拷贝的长度 > arr.length 就在新数组的后面 增加 null
        //3. 如果拷贝长度 < 0 就抛出异常NegativeArraySizeException
        //4. 该方法的底层使用的是 System.arraycopy()
        Integer[] newArr = Arrays.copyOf(arr, arr.length);
        System.out.println("==拷贝执行完毕后==");
        System.out.println(Arrays.toString(newArr));

        //ill 数组元素的填充 ：使用一个元素填充数组，替换原来数组中的所有元素
        Integer[] num = new Integer[]{9,3,2};
        //老韩解读
        //1. 使用 99 去填充 num数组，可以理解成是替换原理的元素
        Arrays.fill(num, 99);
        System.out.println("==num数组填充后==");
        System.out.println(Arrays.toString(num));

        //equals 比较两个数组元素内容是否完全一致
        Integer[] arr2 = {1, 2, 90, 123};
        Integer[] arr3 = {1, 2, 90, 123};
        //老韩解读
        //1. 如果arr 和 arr2 数组的元素一样，则方法true;
        //2. 如果不是完全一样，就返回 false
        boolean equals = Arrays.equals(arr, arr2);
        System.out.println("equals=" + equals);

        //asList 将一组值，转换成一个List集合
        //老韩解读
        //1. asList方法，会将 (2,3,4,5,6,1)数据转成一个List集合
        //2. 返回的 asList 编译类型 List(接口)
        //3. asList 运行类型 java.util.Arrays#ArrayList, 是Arrays类的
        //   静态内部类 private static class ArrayList<E> extends AbstractList<E>
        //              implements RandomAccess, java.io.Serializable
        List<Integer> asList = Arrays.asList(2,3,4,5,6,1);
        System.out.println("asList=" + asList);
        System.out.println("asList的运行类型" + asList.getClass());//可以知道到底是接口的哪个实现子类

        //关于数组转ArrayList集合
        //注意：Arrays.asList确实会返回一个ArrayList对象，但是该类是Arrays类 中一个私有静态内部类，而不是常见的java.util.ArrayList类
        //这个java.util.Arrays.ArrayList类具有 set()，get()，contains()等方法，但是不具有任何添加或移除元素的任何方法。因为该类的大小(size)是固定的。
        // 为了创建出一个真正的ArrayList，代码应该如下所示：
        String[] arr5 = {"aaa","bbb"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(arr5));
//        ArrayList的构造方法可以接受一个Collection类型的对象，而我们的 java.util.Arrays.ArrayList正好也是它的一个子类。
//        实际上，更加高效的代码示例是：
        ArrayList<String> arrayList2 = new ArrayList<String>(arr5.length);
        Collections.addAll(arrayList2, arr5);
        System.out.println(arrayList2);
    }
}
