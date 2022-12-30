/**
 * @author Chen Manman
 * @since 2022/12/2 15:42
 */
public class Scanner {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
//       —————————————————————— next()和nextLine()的使用————————————————
//        if (scanner.hasNext()) {
//            String s1 = scanner.next();
//            System.out.println(s1);
//        }
//
//        if (scanner.hasNextLine()) {
//            String s2 = scanner.nextLine();
//            System.out.println(s2);
//        }
//        scanner.close();

//        —————————————————hasNextXxx()和 nextXxx() 实现不同基本数据类型的输入—————————————
//        int i = 0;
//        float f = 0.0f;
//        if (scanner.hasNextInt()) {
//            i = scanner.nextInt();
//            System.out.println("整数数据：" + i);
//        } else {
//            System.out.println("输入的不是整数");
//        }
//
//        if (scanner.hasNextFloat()) {
//            f = scanner.nextFloat();
//            System.out.println("浮点数数据：" + f);
//        } else {
//            System.out.println("输入的不是浮点数");
//        }
////        scanner.close();

//        ————————————————————输入多个数据——————————————————
//        可以输入多个数字，并求其总和与平均数，每输入一个数字用回车确认，通过输入非数字来结束输入并输出执行结果：
        double sum = 0;
        int count = 0;
        while (scanner.hasNextDouble()) {
            double x = scanner.nextDouble();
            count += 1;
            sum += x;
        }
        System.out.println(count + "个数的和为" + sum);
        System.out.println(count + "个数的平均值是" + (sum / count));
        scanner.close();
    }
}
