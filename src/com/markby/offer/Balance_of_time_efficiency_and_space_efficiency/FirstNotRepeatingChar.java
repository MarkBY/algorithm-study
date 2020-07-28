package com.markby.offer.Balance_of_time_efficiency_and_space_efficiency;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// 面试题50（一）：字符串中第一个只出现一次的字符
// 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出
// 'b'。
public class FirstNotRepeatingChar {

    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
            if (d.getValue()) return d.getKey();
        }
        return ' ';
    }


    public char firstUniqChar2(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (char c : sc)
            if (dic.get(c)) return c;
        return ' ';
    }

    public char firstUniqChar1(String s) {

        if (s == null || s.length() == 0)
            return '\0';


        int tableSize = 256;
        int[] hashTable = new int[tableSize];
        for (int i = 0; i < s.length(); i++) {
            char charAtI = s.charAt(i);
            hashTable[charAtI]++;
        }

        for (int i = 0; i < s.length(); i++) {
            char charAtI = s.charAt(i);
            if (hashTable[charAtI] == 1)
                return charAtI;
        }

        return '\0';
    }

    // ====================测试代码====================
    void test(String pString, char expected) {
        if (firstUniqChar(pString) == expected)
            System.out.println("Test passed.");
        else
            System.out.println("Test failed.");
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar nRchar = new FirstNotRepeatingChar();

        // 常规输入测试，存在只出现一次的字符
        nRchar.test("google", 'l');

        // 常规输入测试，不存在只出现一次的字符
        nRchar.test("aabccdbd", ' ');

        // 常规输入测试，所有字符都只出现一次
        nRchar.test("abcdefg", 'a');

        // 鲁棒性测试，输入nullptr
        //nRchar.test(null, ' ');
    }

}
