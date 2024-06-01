package chapter14.list_;

import java.util.*;

/**p508 List排序练习
 * @author tyh
 * @version 1.0
 * 使用List的实现类添加三本图书，遍历
 * 要求
 * 1）按照价格从低到高排序
 * 2）分表用ArrayList、LinkedList、Vector
 */
public class ListExercise02 {
    public static void main(String[] args) {
//        List<Book> list = new ArrayList<>();
//        List<Book> list = new LinkedList<>();
        List<Book> list = new Vector<>();
        list.add(new Book("Java Programming", "Java Programming", 50));
        list.add(new Book("Python", "Python", 40));
        list.add(new Book("PHP", "PHP", 44));
        for(Book book : list) {
            System.out.println(book);
        }
        System.out.println("排序后");
        //冒泡排序
        sort(list);
//        list.sort(new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                double diff = o2.getPrice() - o1.getPrice();
//                if(diff > 0){
//                    return 1;
//                }else if(diff < 0){
//                    return -1;
//                }else{
//                    return 0;
//                }
//            }
//        });
        for(Book book : list) {
            System.out.println(book);
        }
    }

    //静态方法
    //价格要求是从小到大
    public static void sort(List<Book> list){
        int listSize = list.size();
        for(int i=0; i<listSize-1; i++){
            for(int j=0; j<listSize-1-i; j++){
                //取出对象Book
                Book book1 = list.get(j);
                Book book2 = list.get(j + 1);
                if(book1.getPrice()>book2.getPrice()){
                    list.set(j, book2);
                    list.set(j+1,book1);
                }
            }
        }
    }
}