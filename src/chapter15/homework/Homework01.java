package chapter15.homework;


import org.junit.jupiter.api.Test;

import java.util.*;
//p567 泛型家庭作业

/**
 * 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。
 * <p>
 * 分别创建以下方法：
 * (1) public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
 * (2) public T get(String id)：从 map 中获取 id 对应的对象
 * (3) public void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
 * (4) public List<T> list()：返回 map 中存放的所有 T 对象
 * (5) public void delete(String id)：删除指定 id 对象
 * <p>
 * 定义一个 User 类：
 * 该类包含：private成员变量（int类型） id，age；（String 类型）name。
 * <p>
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 * <p>
 * 思路分析
 * 1. 定义User类
 * 2. 定义Dao<T>泛型类
 */

public class Homework01 {
    public static void main(String[] args) {
    }
    @Test
    public void test(){
        User u1 = new User(001, 19, "lili1");
        User u2 = new User(002, 20, "lili2");
        User u3 = new User(003, 21, "lili3");
        DAO<User> dao = new DAO<>();
        dao.save("001", u1);
        dao.save("002", u2);
        dao.save("003", u3);
        List<User> list = dao.list();
        System.out.println("list=" + list);

        dao.update("003", new User(3, 58, "milan"));
        dao.delete("001");//删除
        System.out.println("===修改后====");
        list = dao.list();
        System.out.println("list=" + list);


    }
}

class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        this.map.put(id, entity);
    }

    public T get(String id) {
        return this.map.get(id);
    }

    public void update(String id, T entity) {
        this.map.put(id, entity);
    }

    //返回 map 中存放的所有 T 对象
    //遍历map [k-v],将map的 所有value(T entity),封装到ArrayList返回即可
    public List<T> list() {
        List<T> list = new ArrayList<>();

        Set<String> keySet = this.map.keySet();
        for (String key : keySet) {
            //map.get(key) 返回就是 User对象->ArrayList
            list.add(map.get(key));//也可以直接使用本类的 get(String id)
        }
        return list;
    }

    public void delete(String id) {
        this.map.remove(id);
    }
}

class User {
    private int id, age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
