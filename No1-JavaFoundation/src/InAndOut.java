import java.io.*;

/**
 * @author Chen Manman
 * @since 2022/12/2 15:15
 */

public class InAndOut {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        //从 BufferedReader 对象读取一个字符要使用 read() 方法
//        char c;
//        do {
//            c = (char) br.read();
//            System.out.println(c);
//        } while (c != 'q');
//
//        //从标准输入读取一个字符串需要使用 BufferedReader 的 readLine() 方法。
//        String str;
//        do {
//            str = br.readLine();
//            System.out.println(str);
//        } while (!str.equals("end"));

        InputStream f = new FileInputStream("E:/1-学习记录及资料/2-研究生/1-实验室、科研/2-态势感知项目/降效需求-20220820.txt");
        System.out.println(f);
    }
}
