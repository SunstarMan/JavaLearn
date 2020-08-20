package com.chenmm;

/*
如果finally中有return语句，返回的结果永远是finally中的结果，要避免这种情况
 */
public class FinallyReturn {
    public static void main(String[] args) {
        int val = getVal();
        System.out.println(val);
    }

    public static int getVal() {
        int a = 10;
        try {
            return a;
        } catch (Throwable e) {
            System.out.println(e);
        } finally {
            a = 100;
            return a;
        }
    }
}
