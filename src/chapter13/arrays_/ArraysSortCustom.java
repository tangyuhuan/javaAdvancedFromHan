package chapter13.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**p483 Arrays模拟排序
 * @author 韩顺平
 * @version 1.0
 */
public class ArraysSortCustom {
    public static void main(String[] args) {

        int[] arr = {1, -1, 8, 0, 20};

        bubble01(arr);
        System.out.println(Arrays.toString(arr));

        //使用定制排序
        bubble02(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

//        bubble02(arr, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                int i1 = (Integer) o1;
//                int i2 = (Integer) o2;
//                return i2 - i1;// return i2 - i1;
//            }
//        });

        System.out.println("==定制排序后的情况==");
        System.out.println(Arrays.toString(arr));

    }

    //使用冒泡完成排序
    public static void bubble01(int[] arr){
        int temp = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    //从小到大
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    //结合冒泡 + 定制
    //先不写排序条件，定制成接口，后面具体选择重写
    public static void bubble02(int[] arr, Comparator c) {//Comparator接口
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //数组排序由 c.compare(arr[j], arr[j + 1])返回的值决定
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
