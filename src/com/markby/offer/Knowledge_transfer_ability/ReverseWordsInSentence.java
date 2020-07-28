package com.markby.offer.Knowledge_transfer_ability;

import java.util.Arrays;

// 面试题58（一）：翻转单词顺序
// 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
// 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
// 则输出"student. a am I"。
public class ReverseWordsInSentence {

    public String reverseWords(String s) {
        if (s == null)
            return null;
        String[] strings = s.trim().split(" ");

        StringBuilder res = new StringBuilder();

        for (int i = strings.length - 1; i >=0; i--){
            if (!strings[i].equals(""))
                res.append(strings[i] + " ");
        }


        return res.toString().trim();
    }

    // ====================测试代码====================
    void test(String testName, String input, String expectedResult) {
        if (testName != null)
            System.out.println(testName + " begins: ");

        String result = reverseWords(input);

        if (expectedResult.equals(result))
            System.out.println("Passed.\n\n");
        else
            System.out.println("Failed.\n\n");
    }

    // 功能测试，句子中有多个单词
    void test1() {
        String input = "I am a student.";
        String expected = "student. a am I";

        test("test1", input, expected);
    }

    // 功能测试，句子中只有一个单词
    void test2() {
        String input = "Wonderful";
        String expected = "Wonderful";

        test("test2", input, expected);
    }

    // 鲁棒性测试
    void test3() {
        test("test3", null, "");
    }

    // 边界值测试，测试空字符串
    void test4() {
        test("test4", "", "");
    }

    // 边界值测试，字符串中只有空格
    void test5() {
        String input = "   ";
        String expected = "   ";
        test("test5", input, expected);
    }

    public static void main(String[] args) {
        ReverseWordsInSentence reverse = new ReverseWordsInSentence();

        reverse.test1();
        reverse.test2();
        reverse.test3();
        reverse.test4();
        reverse.test5();
    }
}
