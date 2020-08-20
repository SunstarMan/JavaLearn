package com.chenmm;

//异常的产生过程解析
public class Exception02 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int e = getElement(a, 3);
        /*main
        new ArrayIndexOutOfBoundsException("3");
         main方法接收到了这个异常对象,main方法也没有异常的处理逻辑继续吧对象抛出给main方法的调用者JVM处理
         */
        System.out.println(e);
    }

    public static int getElement(int[] a, int index) {
        int ans = a[index];
        /*getElement
        访问了数组中的3索引而数组是没有3索引的,这时候JVM就会检测出程序会出现异常JVM会做两件事情:
        1.JVM会根据异常产生的原因创建一个异常对象 这个异常对象包含了异常产生的(内容原因，位置)
            new ArrayIndexOutOfBoundsException("3");
        2.在getElement方法中，没有异常的处理逻辑(ry..catch),那么JVM就会把异常对象抛出给方法的调用者
            main方法来处理这个异常
         */
        return ans;
    }

    /*JVM
    new ArrayIndexOutOfBoundsException("3");JVM接收到了这个异常对象,做了两件事情
        1.把异常对象(内容,原因,位置)以红色的字体打印在控制台
        2.JVM会终止当前正在执行的java程序-- >中断处理
     */
}
