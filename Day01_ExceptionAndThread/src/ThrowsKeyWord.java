import java.io.FileNotFoundException;
import java.io.IOException;

/*
throws：异常处理的第一种方式---交给调用方处理
******作用：
    当方法内部抛出异常对象的时候，那么我们就必须处理这个异常对象
******使用格式:在方法声明时使用
    可以使用throws关键字处理异常对象，会把异常对象声明抛出给方法的调用者处理(自己不处理,给别人处理),
    最终交给JW处理-->中断处理
    修饰符 返回值 类型 方法名(参数列表）throws AAAExcepiton,BBBExcepiton...{
        throw nelw AAAExcepiton("产生原因");
        throl neww 8BBExcepiton("产生原因"");
    }
*******注意：
        1.throws关键字必预写在方法声明处
        2.throws关键字后边声明的异常必须是Exception或者是Exception的子类
        3.方法内部如果抛出了多个异常对象，那么throws后边必须也声明多个异常
            如果抛出的多个异常对象有子父类关系,那么直接声明父类异常即可
        4.调用了一个声明抛出异常的方法，我们就必须的处理声明的异常
            要么继续使用throws声明抛出,交给方法的调用者处理，最终交给JVM
            要么try...catch自己处理异常
*/
public class ThrowsKeyWord {
    //public static void main(String[] args) throws FileNotFoundException ,IOException{
    //因为FileNotFoundException继承了IOException
    public static void main(String[] args) throws IOException{
        readFile("c:\\a.tx");
    }

    public static void readFile(String fileName) throws FileNotFoundException,IOException{
        if (!fileName.equals("c:\\a.txt")) {
            //报错，因为FileNotFoundException是一个编译期异常，必须处理，所以可以使用throws抛出这个异常让方法的调用者处理
            throw new FileNotFoundException("路径错误");
        }

        if (!fileName.endsWith(".txt")){
            throw new IOException("文件类型错误");
        }
    }
}
