package chapter15.generic;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class MyDate implements Comparable<MyDate> {
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }
/* * 当你实现了 Comparable 接口时，必须重写 compareTo 方法，以定义对象之间的比较逻辑。
   如果当前对象小于指定的对象，则返回负值
 * 如果当前对象等于指定的对象，则返回0
 * 如果当前对象大于指定的对象，则返回正值*/
    @Override
    public int compareTo(MyDate o) {//把对year-month-day的比较放在这儿
        int yearMinus = year - o.getYear();
        if(yearMinus != 0) {
            return yearMinus;
        }
        int monthMinus = month - o.getMonth();
        if(monthMinus != 0) {
            return monthMinus;
        }
        return day - o.getDay();

/*        if (this.year < o.year) {
            return -1;
        }else if (this.year > o.year) {
            return 1;
        }else{
            if (this.month < o.month) {
                return -1;
            }else if (this.month > o.month) {
                return 1;
            }else{
                if (this.day < o.day) {
                    return -1;
                }else if (this.day > o.day) {
                    return 1;
                }else{
                    return 0;
                }
            }
        }*/
    }

    //下面这样会死循环的
/*    public String returnWords(){
//        return year + "-" + month + "-" + day;
        return returnWords();
    }

    public static void main(String[] args) {
        MyDate myDate = new MyDate(1,1,1990);
        myDate.returnWords();
    }*/
}
