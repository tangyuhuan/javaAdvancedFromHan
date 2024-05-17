package chapter12.try_;

/**p450 try catch练习！！重复理解
 * @author 韩顺平
 * @version 1.0
 */
public class TryCatchExercise01 {
}

class Exception01 {
    public static int method() {
        try {
            String[] names = new String[3];//String[]数组，但是并没有给每个元素赋值，所以每个元素是null
            if (names[1].equals("tom")) {//NullPointerException
                System.out.println(names[1]);
            } else {
                names[3] = "hspedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {//捕获
            System.out.println("在这里捕获");
            return 3;
        } finally { //必须执行
            return 4; //返回4
        }
    }

    public static void main(String[] args) {
        System.out.println(method()); //4
    }
}
