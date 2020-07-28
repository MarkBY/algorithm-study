package com.markby.offer.time_efficiency;

import java.util.HashMap;
import java.util.Map;

// 面试题48：最长不含重复字符的子字符串
// 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子
// 字符串的长度。假设字符串中只包含从'a'到'z'的字符。
public class LongestSubstringWithoutDup {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> dir = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < chars.length; j++) {
            int i = dir.getOrDefault(chars[j], -1);
            dir.put(chars[j], j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }

        return res;
    }

    // ====================测试代码====================
    void testSolution1(String input, int expected) {
        int output = lengthOfLongestSubstring(input);
        if (output == expected)
            System.out.println("Solution passed, with input: " + input);
        else
            System.out.println("Solution FAILED, with input: " + input);
    }

    void test(String input, int expected) {
        testSolution1(input, expected);
    }

    void test1() {
        String input = "abcacfrar";
        int expected = 4;
        test(input, expected);
    }

    void test2() {
        String input = "acfrarabc";
        int expected = 4;
        test(input, expected);
    }

    void test3() {
        String input = "arabcacfr";
        int expected = 4;
        test(input, expected);
    }

    void test4() {
        String input = "aaaa";
        int expected = 1;
        test(input, expected);
    }

    void test5() {
        String input = "abcdefg";
        int expected = 7;
        test(input, expected);
    }

    void test6() {
        String input = "aaabbbccc";
        int expected = 2;
        test(input, expected);
    }

    void test7() {
        String input = "abcdcba";
        int expected = 4;
        test(input, expected);
    }

    void test8() {
        String input = "abcdaef";
        int expected = 6;
        test(input, expected);
    }

    void test9() {
        String input = "a";
        int expected = 1;
        test(input, expected);
    }

    void test10() {
        String input = "";
        int expected = 0;
        test(input, expected);
    }


    public static void main(String[] args) {
        LongestSubstringWithoutDup longest = new LongestSubstringWithoutDup();

        longest.test1();
        longest.test2();
        longest.test3();
        longest.test4();
        longest.test5();
        longest.test6();
        longest.test7();
        longest.test8();
        longest.test9();
        longest.test10();
    }
}
