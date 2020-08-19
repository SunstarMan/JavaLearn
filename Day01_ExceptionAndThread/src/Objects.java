/*
obects类中的静态方法:
public static <T> T requireNonNuLL(T obj):查看指定引用对象不是nulL。
源码:
        public static <r> T requireNonNuLL(T obj) {
            if (obj == nulL){
                throw new NulLpointerException();
                return obj;
            }
 */
public class Objects {
    public static void main(String[] args) {
        method(null);
    }
    public static void method(Object object){
        //对传递过来的参数进行合法性校验--------自己写判断方法
//        if (object==null){
//            throw new NullPointerException("传入的对象的值是null");
//        }

        java.util.Objects.requireNonNull(object);//功能同上面的if判断语句
        java.util.Objects.requireNonNull(object,"传入的对象的值是null");
    }
}
