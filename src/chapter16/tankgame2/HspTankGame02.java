package chapter16.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**p577 绘制坦克上右下左
 * @author tyh
 * @version 1.0
 */
public class HspTankGame02 extends JFrame {
    //定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        HspTankGame02 hspTankGame01 = new HspTankGame02();
    }

    public HspTankGame02() {
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口(画框)
        this.add(mp);
        //设置窗口的大小
        this.setSize(1000, 750);
        this.addKeyListener(mp);//让JFrame监听mp键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setVisible(true);//可以显示,当组件第一次在屏幕显示的时候，程序会自动调用paint方法
    }
}
