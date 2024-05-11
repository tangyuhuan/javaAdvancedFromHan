package chapter11.enum_;

/**p431Enum实现细节：enum实现接口
 * @author 韩顺平
 * @version 1.0
 */
public class EnumDetail {
    //Music.CLASSICMUSIC是enum为父类型的对象哦
    public static void main(String[] args) {
        Music.CLASSICMUSIC.playing();
    }
}
class A {

}

//1.使用enum关键字后，就不能再继承其它类了，因为enum会隐式继承Enum，而Java是单继承机制
//如下不被允许
//enum Season3 extends A {
//
//}
//2.enum实现的枚举类，仍然是一个类，所以还是可以实现接口的.
interface IPlaying {
    public void playing();
}
enum Music implements IPlaying {
    CLASSICMUSIC;
    @Override
    public void playing() {
        System.out.println("播放好听的音乐...");
    }
}
