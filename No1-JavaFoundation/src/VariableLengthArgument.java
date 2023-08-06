/**
 * @author Chen Manman
 * @since 2023/2/15 19:55
 */
/*
教程：https://javaguide.cn/java/basis/java-basic-questions-01.html#%E6%96%B9%E6%B3%95
 */
public class VariableLengthArgument {
    //Java 的可变参数编译后实际会被转换成一个数组:
    /*
    public static void printVariable(String... args) {
        String[] var1 = args;
        int var2 = args.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String s = var1[var3];
            System.out.println(s);
        }

    }
     */
    public static void printVariable(String... args) {//表示args是可变长度的，可以是一个参数也可以是多个参数
        for (String s : args) {
            System.out.println(s);
        }
    }

    public static void printVariable(String s1, String s2) {
        System.out.println(s1 + s2);
    }

    public static void main(String[] args) {
        printVariable("afwe", "bdwe");//遇到方法重载时，会优先匹配固定参数的方法
        printVariable("fes", "gerhg", "tru", "wert");
    }
}
