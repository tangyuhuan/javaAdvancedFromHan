package chapter14.map_;

/**p535 Map课堂练习
 * @author tyh
 * @version 1.0
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 使用HashMap添加3个员工对象，要求
 * 键：员工id
 * 值：员工对象
 *
 * 并遍历显示工资>18000的员工(遍历方式最少两种)
 * 员工类：姓名、工资、员工id
 */
@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, new Emp("lin1",19000,1));
        map.put(2, new Emp("lin2",1200,2));
        map.put(3, new Emp("lin3",20000,3));

        //遍历方式一 ：keySet-->for
        Set keySet = map.keySet();
        for(Object key : keySet) {
            Emp emp = (Emp) map.get(key);
            if(emp.getSal()>18000){
                System.out.println(emp);
            }
        }
        //遍历方式二:EntrySet -> 迭代器
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry next =  (Map.Entry)iterator.next();
            // EntrySet<Map.Entry<K,V>>
//            System.out.println(next.getClass());//实际的运行类型是HashMap$Node，static class Node<K,V> implements Map.Entry<K,V>
            Emp emp = (Emp)next.getValue();
            if(emp.getSal()>18000){
                System.out.println(emp);
            }
        }
    }
}
class Emp{
    private String name;
    private double sal;
    private int id;

    public Emp(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public double getSal() {
        return sal;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}