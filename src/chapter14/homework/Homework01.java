package chapter14.homework;

/**p548集合家庭作业1
 * @author tyh
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 按要求实现：
 * (1) 封装一个新闻类，包含标题和内容属性，提供get、set方法，重写toString方法，打印对象时只打印标题；
 * (2) 只提供一个带参数的构造器，实例化对象时，只初始化标题；并且实例化两个对象：
 * 新闻一：新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧
 * 新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生
 * (3) 将新闻对象添加到ArrayList集合中，并且进行倒序遍历；
 * (4) 在遍历集合过程中，对新闻标题进行处理，超过15字的只保留前15个，然后在后边加“…”
 * (5) 在控制台打印遍历出经过处理的新闻标题；
 */
public class Homework01 {
    public static void main(String[] args) {
        News n1= new News("新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"引民众担忧");
        News n2= new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");
        ArrayList<News> a= new ArrayList();
        a.add(n1);
        a.add(n2);
        for (int i = a.size()-1; i >= 0; i--) {
            String title = a.get(i).getTitle();
            System.out.println(processTitle(title));
        }
    }
    //专门写一个方法，处理新闻标题
    public static String processTitle(String title){
        if(title == null){
            return "";
        }
        if(title.length()>15){
            return title.substring(0,15)+"...";//[0,15)
        }else{
            return title;
        }
    }

}
class News{
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title ;
    }
}