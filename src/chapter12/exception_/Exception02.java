package chapter12.exception_;

import java.io.FileInputStream;
import java.io.IOException;

/**p447 异常课堂练习——常见编译异常
 * @author 韩顺平
 * @version 1.0
 */
public class Exception02 {
    public static void main(String[] args) {
        try {
            FileInputStream fis;
            fis = new FileInputStream("d:\\aa.jpg");
            int len;
            while ((len = fis.read()) != -1) {
                System.out.println(len);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
