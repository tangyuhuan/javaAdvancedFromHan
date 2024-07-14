package chapter16.tankgame;

import javax.swing.*;
import java.awt.*;

/**
 * @author tyh
 * @version 1.0
 */
public class HspTankGame01 extends JFrame {
    //定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        HspTankGame01 hspTankGame01 = new HspTankGame01();
    }

    public HspTankGame01() {
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口(画框)
        this.add(mp);
        //设置窗口的大小
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setVisible(true);//可以显示,当组件第一次在屏幕显示的时候，程序会自动调用paint方法
    }
}