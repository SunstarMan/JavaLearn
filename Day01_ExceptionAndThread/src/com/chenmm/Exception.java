package com.chenmm;

/*
java.lang.Throwable:是Java语言中所有错误和异常的超类

 */
public class Exception extends Throwable {
//    public static void main(String[] args) /*throws ParseException*/ {
//        //编译期异常Exception
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");//格式化日期
//        Date date= null;
//        try {
//            date = sdf.parse("1999-0909");//把字符串格式的日期解析为date格式的日期
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(date);
//        System.out.println("后续代码");
//    }


    public static void main(String[] args) {
        int[] a={1,2,3};
        //System.out.println(a[3]);//即会出现运行时异常
        try{
            //可能出现异常的语句
            System.out.println(a[3]);//即会出现运行时异常
        }catch (java.lang.Exception e){
            //异常发生后如何处理/处理逻辑
            System.out.println(e);
        }
        System.out.println("后续代码");
        System.out.println("可以看见后面的代码");
    }
}
