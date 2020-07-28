package com.markby.offer.divergent_thinking_ability;

import java.util.Arrays;

// 面试题64：求1+2+…+n
// 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
// 等关键字及条件判断语句（A?B:C）。
public class Accumulate {

    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    // ====================测试代码====================
    int expectedResult(int n){
        return (1 + n) * n / 2;
    }

    void test(String testName, int n, int expected){
        System.out.println("Test for " + n + " begins:\n");

        int result = sumNums(n);

        System.out.println(result);

        if (result == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("FAILED.\n");
    }

    void test1(){
        int n = 1;
        test("test1", n, expectedResult(n));
    }

    void test2(){
        int n = 3;
        test("test2", n, expectedResult(n));
    }

    void test3(){
        int n = 5;
        test("test3", n, expectedResult(n));
    }

    void test4(){
        int n = 10;
        test("test4", n, expectedResult(n));
    }

    void test5(){
        int n = 12;
        test("test5", n, expectedResult(n));
    }

    void test6(){
        int n = 15;
        test("test6", n, expectedResult(n));
    }

    public static void main(String[] args) {
        Accumulate accumulate = new Accumulate();

        accumulate.test1();
        accumulate.test2();
        accumulate.test3();
        accumulate.test4();
        accumulate.test5();
        accumulate.test6();
    }

}
