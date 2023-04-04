import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Chen Manman
 * @since 2023/4/4 10:23
 */
public class Reflection {
    //---------------------------------------获取Class对象的4种方式-------------------------------------
//    public static void main(String[] args) throws ClassNotFoundException {
//        //1、知道具体类的情况下可以使用：
//        Class i = Integer.class;
//        System.out.println(i);
//        Method[] declaredMethods = i.getDeclaredMethods();
////        for (Method method : declaredMethods) {
////            System.out.println(method.getName());
////        }
//        //2、知道具体类的情况下，通过对象实例instance.getClass()获取：
//        String s = new String();
//        Class ss = s.getClass();
//        System.out.println(ss);
//        //3、通过 Class.forName()传入类的全路径获取：
//        Class  l = Class.forName("java.util.ArrayList");
//        System.out.println(l);
//        //4、通过类加载器xxxClassLoader.loadClass()传入类路径获取:
//        Class aClass = ClassLoader.getSystemClassLoader().loadClass("java.util.ArrayList");
//        System.out.println(aClass);
//    }

    //-----------------------------------------反射的一些基本操作--------------------------------------

    //1、创建一个我们要使用反射操作的类 TestReflection。
    public static class TestReflection {
        private final String val;

        public TestReflection() {
            val = "manTest";
        }

        public void publicMethod(String s) {
            System.out.println("I love" + s);
        }

        private void privateMethod() {
            System.out.println("val is" + val);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class t1 = TestReflection.class;
        TestReflection tt = new TestReflection();
        Class t2 = tt.getClass();
        Class t3 = ClassLoader.getSystemClassLoader().loadClass("Reflection$TestReflection");

        Class t4 = Class.forName("Reflection$TestReflection"); //获取TestReflection 类的Class 对象
        TestReflection testReflectionInstance = (TestReflection) t4.newInstance(); //创建实例
        //获取 TestReflection 类中定义的所有方法
        Method[] methods = t4.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        //获取指定方法并调用
        Method publicMethod = t4.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(testReflectionInstance, " yj");

        //获取指定参数并对参数进行修改
        Field val = t4.getDeclaredField("val");
        //为了对类中的参数进行修改我们取消安全检查
        val.setAccessible(true);
        val.set(testReflectionInstance, " value");

        //调用 private 方法,同时为了调用private方法我们取消安全检查
        Method privateMethod = t4.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(testReflectionInstance);
    }

}
