package chapter12.try_;

/**p451 try catch练习！！重复理解
 * catch里有return（保存到临时变量），finally里没有return
 * 当try有异常，catch有return语句时，程序执行到try中有异常的地方，异常被捕获，跳转到catch代码块，
 * 执行到return语句时，同样只是保存return 表达式的值，然后再去执行finally代码块，执行完finally再回去执行return
 * 如果return的数据是引用数据类型，而在finally中对该引用数据类型的属性值的改变起作用，try中的return语句返回的就是在finally中改变后的该属性的值
 * 基础类型就不会改变
 * @author 韩顺平
 * @version 1.0
 */
public class TryCatchExercise03 {
}

class ExceptionExe01 {
    public static int method() {
        int i = 1;//i = 1
        try {
            i++;// i=2
            String[] names = new String[3];
            if (names[1].equals("tom")) { //空指针
                System.out.println(names[1]);
            } else {
                names[3] = "hspedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i;  // i = 3 => 保存临时变量 temp = 3;这里的return不会马上执行，返回的是临时变量
        } finally {
            ++i; //i = 4
            System.out.println("i=" + i);// i = 4
            //return ++i; //finally代码中最好不要包含return，程序会提前退出，也就是说返回的值不是try或catch中的值
        }
    }

    public static void main(String[] args) {
        System.out.println(method());// 3
    }
}