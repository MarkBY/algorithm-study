package com.markby.LeetCode.double_pointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 524. Longest Word in Dictionary through Deleting (Medium)
public class LongestWordinDictionarythroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        List<String> result = new ArrayList<>();
        d.forEach(str -> {
            int pos = 0;
            boolean flag = true; //是否把该字符添加进result;
            for (int i = 0; i < str.length(); i++) { //遍历str，判断是否在s中可以通过删除其他字符出现
                if (pos == s.length()) {
                    flag = false;
                    break;
                }
                char c = str.charAt(i);
                pos = s.indexOf(c, pos) + 1;
                if (pos == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) result.add(str);
        });
        //对result进行排序
        Collections.sort(result, (s1, s2) -> {
            if (s1.length() == s2.length()) return s1.compareTo(s2);
            return s2.length() - s1.length();
        });
        //如果答案不存在，则返回空字符串
        if (result.size() == 0) return "";
        else return result.get(0);
    }

    public String findLongestWord1(String s, List<String> d) {
        String result = "";

        for (String str : d) {
            if (str.length() >= result.length()) {
                if (isSubsequence(s, str)) {
                    if (str.length() > result.length()) {
                        result = str;
                    } else if (str.compareTo(result) < 0) {
                        result = str;
                    }
                }
            }
        }
        return result;
    }

    boolean isSubsequence(String s1, String s2) {
        if (s2.length() > s1.length())
            return false;

        int index = 0;

        for (int i = 0; i < s2.length(); i++){
            if (index == s1.length()) {
                return false;
            }
            char c = s2.charAt(i);
            index = s1.indexOf(c, index) + 1;
            if (index == 0)
                return false;
        }
        return true;
    }

    //=======================test==================================
    void test(String testName, String s, List<String> d, String expected) {
        System.out.println(testName + " begin:");

        String result = findLongestWord(s, d);

        if (result.equals(expected))
            System.out.println("passed.");
        else
            System.out.println("Failed.");

        System.out.println();
    }

    void test1() {
        // s = "abpcplea", d = ["ale","apple","monkey","plea"]
        String s = "abpcplea";
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");

        String expected = "apple";
        test("test1", s, d, expected);

    }

    void mainTest() {
        test1();
    }

    public static void main(String[] args) {
        LongestWordinDictionarythroughDeleting longestWordinDictionarythroughDeleting = new LongestWordinDictionarythroughDeleting();
        longestWordinDictionarythroughDeleting.mainTest();
    }

}
