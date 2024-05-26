package chapter13.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**p485 Java_Arrays课堂练习!!重复练习
 * @author tyh
 * @version 1.0
 */
//老师的实现，注意compare中的转换
public class ArrayExercise {
    public static void main(String[] args) {
        /*
        案例：自定义Book类，里面包含name和price，按price排序(从大到小)。
        要求使用两种方式排序 , 有一个 Book[] books = 4本书对象.

        使用前面学习过的传递 实现Comparator接口匿名内部类，也称为定制排序。
        [同学们完成这个即可 10min  ],
        可以按照 price (1)从大到小 (2)从小到大 (3) 按照书名长度从大到小

         */
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘20年", 5);
        books[3] = new Book("java从入门到放弃~", 300);

        //(1)price从大到小
        //compare需要返回一个int ，if (c.compare(pivot, a[mid]) < 0) 内部只判断跟0的关系
        Arrays.sort(books, new Comparator() {
            //这里是对Book数组排序，因此  o1 和 o2 就是Book对象
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                //不能用强转，会损失精度
                double priceVal = book2.getPrice() - book1.getPrice();
                //这里老师进行了一个转换
                //如果发现返回结果和我们输出的不一致，就修改一下返回的 1 和 -1
                if(priceVal > 0) {
                    return  1;//只要是正数，不一定非要1
                } else  if(priceVal < 0) {
                    return -1;//只要是负数，不一定非要-1
                } else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(books));
        //(2)price从小到大
        Arrays.sort(books, new Comparator() {
            //这里是对Book数组排序，因此  o1 和 o2 就是Book对象
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                double priceVal = book2.getPrice() - book1.getPrice();
                //这里老师进行了一个转换
                //如果发现返回结果和我们输出的不一致，就修改一下返回的 1 和 -1
                if(priceVal > 0) {
                    return  -1;
                } else  if(priceVal < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(books));
        //(3)按照书名长度从大到小

        Arrays.sort(books, new Comparator() {
            //这里是对Book数组排序，因此  o1 和 o2 就是Book对象
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                //要求按照书名的长度来进行排序
                return book2.getName().length() - book1.getName().length();
            }
        });


        System.out.println(Arrays.toString(books));

    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

/*我的实现
public class ArrayExercise {
    public static void main(String[] args) {
        *//*
        案例：自定义Book类，里面包含name和price，按price排序(从大到小)。
        要求使用两种方式排序 , 有一个 Book[] books = 4本书对象.

        使用前面学习过的传递 实现Comparator接口匿名内部类，也称为定制排序。[同学们完成这个即可 10min  ],
        可以按照 price (1)从大到小 (2)从小到大 (3) 按照书名长度从大到小
         *//*
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘20年", 5);
        books[3] = new Book("java从入门到放弃~", 300);
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPrice()- o2.getPrice();
            }
        });
        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getPrice()- o1.getPrice();
            }
        });
        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getName().length()- o1.getName().length();
            }
        });
        System.out.println(Arrays.toString(books));
    }

}
class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}*/
