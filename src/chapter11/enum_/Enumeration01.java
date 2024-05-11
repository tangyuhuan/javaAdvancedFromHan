package chapter11.enum_;//package com.hspedu.enum_;

//p424枚举类引出
///**
// * @author 韩顺平
// * @version 1.0
// */
//public class Enumeration01 {
//    public static void main(String[] args) {
//        //使用
//        Season spring = new Season("春天", "温暖");
//        Season winter = new Season("冬天", "寒冷");
//        Season summer = new Season("夏天", "炎热");
//        Season autumn = new Season("秋天", "凉爽");
////        autumn.setName("XXX");
////        autumn.setDesc("非常的热..");
//        //因为对于季节而已，他的对象(具体值)，是固定的四个，不会有更多
//        //按老师的这个设计类的思路，不能体现季节是固定的四个对象，而且可以通过set随便改
//        //目标：创建season对象有两个特点：1.季节的值是有限的几个值，提供出春夏秋冬四个固定的对象 2.只读，不需要修改
//        //因此，这样的设计不好===> 枚举类[枚: 一个一个 举： 例举 , 即把具体的对象一个一个例举出来的类
//        // 就称为枚举类]
//        Season other = new Season("红天", "~~~");
//    }
//}
//class Season{//类
//    private String name;
//    private String desc;//描述
//
//    public Season(String name, String desc) {
//        this.name = name;
//        this.desc = desc;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//}
