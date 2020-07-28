package com.markby.offer.Knowledge_transfer_ability;

// 面试题58（二）：左旋转字符串
// 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
// 请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数
// 字2，该函数将返回左旋转2位得到的结果"cdefgab"。
public class LeftRotateString {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public String reverseLeftWords1(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

    // ====================测试代码====================
    void test(String testName, String input, int num, String expectedResult) {
        if (testName != null)
            System.out.println(testName + " begins: ");

        String result = reverseLeftWords(input, num);

        if (expectedResult.equals(result))
            System.out.println("Passed.\n\n");
        else
            System.out.println("Failed.\n\n");
    }

    // 功能测试
    void test1() {
        String input = "abcdefg";
        String expected = "cdefgab";

        test("test1", input, 2, expected);
    }

    // 边界值测试
    void test2() {
        String input = "abcdefg";
        String expected = "bcdefga";

        test("test2", input, 1, expected);
    }

    // 边界值测试
    void test3() {
        String input = "abcdefg";
        String expected = "gabcdef";

        test("test3", input, 6, expected);
    }

    // 鲁棒性测试
    void test4() {
        test("test4", null, 6, "");
    }

    // 鲁棒性测试
    void test5() {
        String input = "abcdefg";
        String expected = "abcdefg";

        test("test5", input, 0, expected);
    }

    // 鲁棒性测试
    void test6() {
        String input = "abcdefg";
        String expected = "abcdefg";

        test("test6", input, 7, expected);
    }

    public static void main(String[] args) {
        LeftRotateString string = new LeftRotateString();

        string.test1();
        string.test2();
        string.test3();
        string.test4();
        string.test5();
        string.test6();
    }

}
