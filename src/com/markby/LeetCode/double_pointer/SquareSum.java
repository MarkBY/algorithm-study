package com.markby.LeetCode.double_pointer;

// 633. Sum of Square Numbers (Easy)
public class SquareSum {
    public boolean judgeSquareSum(int c) {

        int start = 0;
        int end = (int)Math.sqrt(c);
        while (start <= end){
            int sum = start * start + end * end;
            if (sum == c)
                return true;
            else if (sum > c)
                end--;
            else
                start++;
        }
        return false;
    }
    //======================test===========================
    public void test(String testName, int c, boolean expected){
        System.out.println(testName + " begin:");

        boolean success = judgeSquareSum(c);

        if (success == expected)
            System.out.println("passed.");
        else
            System.out.println("Failed.");

        System.out.println();
    }

    void test1(){
        String testName = "test1";
        int c = 5;

        test(testName, c, true);
    }

    void test2(){
        String testName = "test2";
        int c = 3;

        test(testName, c, false);
    }

    void test3(){
        String testName = "test3";
        int c = 4;

        test(testName, c, true);
    }

    void mainTest(){
        test1();
        test2();
        test3();
    }

    public static void main(String[] args) {
        SquareSum sum = new SquareSum();

        sum.mainTest();
    }
}
