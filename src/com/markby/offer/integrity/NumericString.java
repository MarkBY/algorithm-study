package com.markby.offer.integrity;

// 面试题20：表示数值的字符串
// 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
// 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
// “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
public class NumericString {

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)
            return false;

        // 标记是否遇到相应的情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        char[] str = s.trim().toCharArray();

        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                numSeen = true;
            } else if (str[i] == '.') {
                // .之前不能出现.或者e
                if (dotSeen || eSeen)
                    return false;

                dotSeen = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                // e出现之前不能出现e，必须出现数
                if (eSeen || !numSeen)
                    return false;

                eSeen = true;
                // 重置numSeen，排除123e或者123e+的情况，确保e之后也出现数
                numSeen = false;
            } else if (str[i] == '-' || str[i] == '+') {
                // +-出现在0位置或者e/E的后面第一个位置才是合法的
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false;
            } else {
                return false;
            }
        }

        return numSeen;
    }


    // ====================测试代码====================
    void test(String testName, String str, boolean expected) {
        if (testName != null)
            System.out.printf("%s begins: ", testName);

        if (isNumber(str) == expected)
            System.out.printf("Passed.\n");
        else
            System.out.printf("FAILED.\n");
    }

    public static void main(String[] args) {
        NumericString num = new NumericString();

        num.test("Test1", "100", true);
        num.test("Test2", "123.45e+6", true);
        num.test("Test3", "+500", true);
        num.test("Test4", "5e2", true);
        num.test("Test5", "3.1416", true);
        num.test("Test6", "600.", true);
        num.test("Test7", "-.123", true);
        num.test("Test8", "-1E-16", true);
        num.test("Test9", "1.79769313486232E+308", true);

        System.out.printf("\n\n");

        num.test("Test10", "12e", false);
        num.test("Test11", "1a3.14", false);
        num.test("Test12", "1+23", false);
        num.test("Test13", "1.2.3", false);
        num.test("Test14", "+-5", false);
        num.test("Test15", "12e+5.4", false);
        num.test("Test16", ".", false);
        num.test("Test17", ".e1", false);
        num.test("Test18", "e1", false);
        num.test("Test19", "+.", false);
        num.test("Test20", "", false);
        num.test("Test21", null, false);
    }

}
