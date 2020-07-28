package com.markby.offer.time_efficiency;

// 面试题46：把数字翻译成字符串
// 题目：给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成"a"，1翻
// 译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。例
// 如12258有5种不同的翻译，它们分别是"bccfi"、"bwfi"、"bczi"、"mcfi"和
// "mzi"。请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
public class TranslateNumbersToStrings {

    public int translateNum(int num) {
        if (num < 0)
            return 0;

        if (num <= 9)
            return 1;

        int ba = num % 100;

        if (ba <= 9 || ba >= 26)
            return translateNum(num / 10);
        else
            return translateNum(num / 10) + translateNum(num / 100);

    }

    // ====================测试代码====================
    void Test(String testName, int number, int expected) {
        if (translateNum(number) == expected)
            System.out.println(testName + " passed.");
        else
            System.out.println(testName + " FAILED.");
    }

    void Test1() {
        int number = 0;
        int expected = 1;
        Test("Test1", number, expected);
    }

    void Test2() {
        int number = 10;
        int expected = 2;
        Test("Test2", number, expected);
    }

    void Test3() {
        int number = 125;
        int expected = 3;
        Test("Test3", number, expected);
    }

    void Test4() {
        int number = 126;
        int expected = 2;
        Test("Test4", number, expected);
    }

    void Test5() {
        int number = 426;
        int expected = 1;
        Test("Test5", number, expected);
    }

    void Test6() {
        int number = 100;
        int expected = 2;
        Test("Test6", number, expected);
    }

    void Test7() {
        int number = 101;
        int expected = 2;
        Test("Test7", number, expected);
    }

    void Test8() {
        int number = 12258;
        int expected = 5;
        Test("Test8", number, expected);
    }

    void Test9() {
        int number = -100;
        int expected = 0;
        Test("Test9", number, expected);
    }

    public static void main(String[] args) {
        TranslateNumbersToStrings translate = new TranslateNumbersToStrings();

        translate.Test1();
        translate.Test2();
        translate.Test3();
        translate.Test4();
        translate.Test5();
        translate.Test6();
        translate.Test7();
        translate.Test8();
        translate.Test9();
    }

}
