package com.chenmm;

import java.util.ArrayList;
import java.util.List;

/*
异常的注意事项
 */
public class ExceptionNote {
    public static void main(String[] args) {
        /*
        多个异常使用捕获又该如何处理呢?|
            1．多个异常分别处理。
            2．多个异常一次捕获，多次处理。
            3．多个异常一次捕获一次处理。
         */

        /*2．多个异常一次捕获，多次处理。
        catch里边定义的异常变量,如果有子父类关系,那么子类的异常变量必须写在上边，否则就会报错，
        因为抛出的异常对象,会从上到下依次赋值给catch中定义的异常变量
        ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException
         */
        try {
            int[] a = {1, 2, 3};
            System.out.println(a[3]);
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                list.add(i + 1);
            }
            System.out.println(list.get(3));
        }
//        catch (ArrayIndexOutOfBoundsException e){
//            System.out.println(e);
//        }catch (IndexOutOfBoundsException e){
//            System.out.println(e);
//        }


        /*3．多个异常一次捕获一次处理。
         */
        catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("后续代码");
    }
}
