package com.markby.offer.time_efficiency;

// 面试题44：数字序列中某一位的数字
// 题目：数字以0123456789101112131415…的格式序列化到一个字符序列中。在这
// 个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一
// 个函数求任意位对应的数字。

public class DigitsInSequence {

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';

    }

    // ====================测试代码====================
    void test(String testName, int inputIndex, int expectedOutput) {
        if (findNthDigit(inputIndex) == expectedOutput)
            System.out.println(testName + " passed.");
        else
            System.out.println(testName + " FAILED.");
    }

    int test_main() {
        test("Test1", 0, 0);
        test("Test2", 1, 1);
        test("Test3", 9, 9);
        test("Test4", 10, 1);
        test("Test5", 189, 9);  // 数字99的最后一位，9
        test("Test6", 190, 1);  // 数字100的第一位，1
        test("Test7", 1000, 3); // 数字370的第一位，3
        test("Test8", 1001, 7); // 数字370的第二位，7
        test("Test9", 1002, 0); // 数字370的第三位，0
        return 0;
    }

    public static void main(String[] args) {
        DigitsInSequence sequence = new DigitsInSequence();

        sequence.test_main();
    }


}
