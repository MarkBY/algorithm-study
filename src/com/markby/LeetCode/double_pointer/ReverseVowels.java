package com.markby.LeetCode.double_pointer;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowels {

    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        char[] chars = s.toCharArray();
        while (i <= j) {
            char ci = chars[i];
            char cj = chars[j];
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

    //======================test===========================
    public void test(String testName, String s, String expected) {
        System.out.println(testName + " begin:");

        String result = reverseVowels(s);

        if (result.equals(expected))
            System.out.println("passed.");
        else
            System.out.println("Failed.");

        System.out.println();
    }

    void test1() {
        String testName = "test1";
        String s = "hello";
        String expected = "holle";

        test(testName, s, expected);
    }

    void test2() {
        String testName = "test2";
        String s = "leetcode";
        String expected = "leotcede";

        test(testName, s, expected);
    }

    void mainTest() {
        test1();
        test2();
    }

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();

        reverseVowels.mainTest();
    }
}
