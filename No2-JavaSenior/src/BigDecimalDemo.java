import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @author Chen Manman
 * @since 2023/7/20 11:19
 * 为了避免精度丢失，可以使用 BigDecimal 来进行浮点数的运算
 * 浮点数之间的等值判断，基本数据类型不能用 == 来比较，包装数据类型不能用 equals 来判断。因为存在精度丢失
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        float a = 2.0f - 1.9f;
        float b = 1.8f - 1.7f;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);

        //推荐使用BigDecimal(String val)构造方法或者 BigDecimal.valueOf(double val) 静态方法来创建对象
        BigDecimal b1 = new BigDecimal("2.0");
        BigDecimal b2 = new BigDecimal("1.9");
        BigDecimal sub12 = b1.subtract(b2);
        System.out.println(sub12);
        BigDecimal b3 = new BigDecimal("1.8");
        BigDecimal b4 = new BigDecimal("1.7");
        BigDecimal sub34 = b3.subtract(b4);
        System.out.println(sub34);
        System.out.println(sub12.compareTo(sub34));

        //比较大小：a.compareTo(b)。返回-1表示 a<b，0表示 a=b, 1表示 a>b。该方法比较的时候会忽略精度。
        //保留几位小数：a.setScale(3,RoundingMode.HALF_DOWN)
        //加：add
        //减:subtract
        //乘:multiply
        //除:divide,使用时尽量使用 3 个参数版本，并且RoundingMode 不要选择 UNNECESSARY，否则很可能会遇到 ArithmeticException（无法除尽出现无限循环小数的时候），其中 scale 表示要保留几位小数，roundingMode 代表保留规则
        System.out.println(b1.divide(b2, 2, RoundingMode.HALF_UP));// 1.05
        System.out.println(b1.divide(b2));// 无法除尽，抛出 ArithmeticException 异常
        /*
        小数保留规则：
        public enum RoundingMode {
           // 2.5 -> 3 , 1.6 -> 2
           // -1.6 -> -2 , -2.5 -> -3
			 UP(BigDecimal.ROUND_UP),

           // 2.5 -> 2 , 1.6 -> 1
           // -1.6 -> -1 , -2.5 -> -2
			 DOWN(BigDecimal.ROUND_DOWN),

		   // 2.5 -> 3 , 1.6 -> 2
           // -1.6 -> -1 , -2.5 -> -2
			 CEILING(BigDecimal.ROUND_CEILING),

		   // 2.5 -> 2 , 1.6 -> 1
           // -1.6 -> -2 , -2.5 -> -3
			 FLOOR(BigDecimal.ROUND_FLOOR),

   	       // 2.5 -> 3 , 1.6 -> 2
           // -1.6 -> -2 , -2.5 -> -3
			 HALF_UP(BigDecimal.ROUND_HALF_UP),
          //......
        }
         */
    }
}
