package IO;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.Buffer;

/**
 * @author Chen Manman
 * @since 2023/7/20 20:17
 * IO 即 Input/Output，输入和输出。
 * 数据输入到计算机内存的过程即输入，反之输出到外部存储（比如数据库，文件，远程主机）的过程即输出。
 * 数据传输过程类似于水流，因此称为 IO 流。
 * IO 流在 Java 中分为输入流和输出流，而根据数据的处理方式又分为字节流和字符流。
 */
public class IOStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //-----------------------------------------InputStream:字节输入流----------------------------------------------
        try (InputStream fis = new FileInputStream("E:\\2-Project\\JAVA\\JavaLearn\\No2-JavaSenior\\src\\IOinput.txt")) {
            System.out.println("Number of remaining bytes:"
                    + fis.available()); //available()：返回输入流中可以读取的字节数。
            int content;
            long skip = fis.skip(2); //skip(long n)：忽略输入流中的 n 个字节 ,返回实际忽略的字节数。
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            //read()：返回输入流中下一个字节的数据。返回的值介于 0 到 255 之间。如果未读取任何字节，则代码返回 -1 ，表示文件结束。
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //--------------------------------------BufferedInputStream：字节缓冲输入流-------------------------------
        // 通过 readAllBytes() 读取输入流所有字节并将其直接赋值给一个 String 对象。
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("E:\\2-Project\\JAVA\\JavaLearn\\No2-JavaSenior\\src\\IOinput.txt"));
//        String result = new String(bufferedInputStream.readAllBytes()); //java 9中才有的方法
//        System.out.println(result);
        //-----------------------------------DataInputStream:读取指定类型数据-------------------------------------
        //DataInputStream不能单独使用，必须结合其它流，比如 FileInputStream
        FileInputStream fileInputStream = new FileInputStream("E:\\2-Project\\JAVA\\JavaLearn\\No2-JavaSenior\\src\\IOinput.txt");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        dataInputStream.readBoolean();
        dataInputStream.readInt();
        //----------------------------------ObjectInputStream:从输入流中读取 Java 对象（反序列化）--------------------
        //ObjectOutputStream 用于将对象写入到输出流(序列化)。
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\2-Project\\JAVA\\JavaLearn\\No2-JavaSenior\\src\\IOinput.txt"));
//        Object obj = (Object) objectInputStream.readObject();
//        objectInputStream.close();


        //------------------------------------------------FileOutputStream---------------------------------------------------
        try (FileOutputStream output = new FileOutputStream("E:\\2-Project\\JAVA\\JavaLearn\\No2-JavaSenior\\src\\IOoutput.txt")) {
            byte[] array = "JavaGuide".getBytes();
            output.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //------------------------------------------------BufferedOutputStream----------------------------------------------
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
        //---------------------------------------------------DataOutputStream-------------------------------------------------
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        dataOutputStream.writeBoolean(true);// 输出任意数据类型
        dataOutputStream.writeByte(1);// 输出任意数据类型
        //-------------------------------------------------ObjectOutputStream-------------------------------------------------
        // ObjectOutputStream将对象写入到输出流(ObjectOutputStream，序列化)。
        ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
//        Person person = new Person("Guide哥", "JavaGuide作者");
//        output.writeObject(person);


        //********************************       InputStreamReader:字节流转换为字符流的桥梁              *********************
        //-------------------------------------------- FileReader:字符输入流 ----------------------------------------
        try (FileReader fr = new FileReader("E:\\2-Project\\JAVA\\JavaLearn\\No2-JavaSenior\\src\\IOinputChar.txt")) {
            int content;
            long skip = fr.skip(3);
            System.out.println();
            System.out.println("skip:" + skip);
            System.out.print("content is:");
            while ((content = fr.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //********************************      OutputStreamWriter:字节流转换为字符流的桥梁         *********************
        //-------------------------------------------- FileWriter:字符输出流 ----------------------------------------
        try (Writer o = new FileWriter("E:\\2-Project\\JAVA\\JavaLearn\\No2-JavaSenior\\src\\IOoutputChar.txt")) {
            o.write("hhhh，我是陈熳熳。");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //BufferedReader、BufferedWriter同BufferedInputStream、BufferedOutputStream；前两者是字符，后两者是字节
        System.out.println();
    }
}
