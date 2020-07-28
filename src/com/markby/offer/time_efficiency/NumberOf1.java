package com.markby.offer.time_efficiency;

// 面试题43：从1到n整数中1出现的次数
// 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如
// 输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。

public class NumberOf1 {

    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;

        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;

            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;

        }

        return res;
    }

    // ====================测试代码====================
    void test(String testName, int n, int expected) {
        if (testName != null)
            System.out.printf("%s begins: \n", testName);

        if (countDigitOne(n) == expected)
            System.out.printf("passed.\n");
        else
            System.out.printf("failed.\n");

        System.out.printf("\n");
    }

    void test() {
        test("test1", 1, 1);
        test("test2", 5, 1);
        test("test3", 10, 2);
        test("test4", 55, 16);
        test("test5", 99, 20);
        test("test6", 10000, 4001);
        test("test7", 21345, 18821);
        test("test8", 0, 0);
    }

    public static void main(String[] args) {
        NumberOf1 num = new NumberOf1();

        num.test();
    }

}
