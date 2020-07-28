package com.markby.offer.integrity;

// 面试题19：正则表达式匹配
// 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'
// 表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题
// 中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"
// 和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。

public class RegularExpressions {

    public boolean isMatch1(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // 分成空正则和非空正则两种
                if (j == 0) {
                    dp[i][j] = i == 0;
                } else {
                    // 非空正则分为两种情况 * 和 非*
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        // 碰到 * 了，分为看和不看两种情况
                        // 不看
                        if (j >= 2) {
                            dp[i][j] |= dp[i][j - 2];
                        }
                        // 看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }


    public boolean isMatch(String s, String p) {
        // 如果字符串长度为0，需要检测下正则串
        if (s.length() == 0) {
            // 如果正则串长度为奇数，必定不匹配，比如 "."、"ab*",必须是 a*b*这种形式，*在奇数位上
            if (p.length() % 2 != 0) return false;
            int i = 1;
            while (i < p.length()) {
                if (p.charAt(i) != '*') return false;
                i += 2;
            }
            return true;
        }
        // 如果字符串长度不为0，但是正则串没了，return false
        if (p.length() == 0) return false;
        // c1 和 c2 分别是两个串的当前位，c3是正则串当前位的后一位，如果存在的话，就更新一下
        char c1 = s.charAt(0), c2 = p.charAt(0), c3 = 'a';
        if (p.length() > 1) {
            c3 = p.charAt(1);
        }
        // 和dp一样，后一位分为是 '*' 和不是 '*' 两种情况
        if (c3 != '*') {
            // 如果该位字符一样，或是正则串该位是 '.',也就是能匹配任意字符，就可以往后走
            if (c1 == c2 || c2 == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                // 否则不匹配
                return false;
            }
        } else {
            // 如果该位字符一样，或是正则串该位是 '.'，和dp一样，有看和不看两种情况
            if (c1 == c2 || c2 == '.') {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                // 不一样，那么正则串这两位就废了，直接往后走
                return isMatch(s, p.substring(2));
            }
        }

    }


    // ====================测试代码====================
    void test(String testName, String string, String pattern, boolean expected) {
        if (testName != null)
            System.out.printf("%s begins: ", testName);

        if (isMatch(string, pattern) == expected)
            System.out.printf("Passed.\n");
        else
            System.out.printf("FAILED.\n");
    }

    public static void main(String[] args) {
        RegularExpressions re = new RegularExpressions();

        /*输入:
        s = "mississippi"
        p = "mis*is*p*."
        输出: false*/
        re.test("Test00", "mississippi", "mis*is*p*.", false);
        re.test("Test01", "", "", true);
        re.test("Test02", "", ".*", true);
        re.test("Test03", "", ".", false);
        re.test("Test04", "", "c*", true);
        re.test("Test05", "a", ".*", true);
        re.test("Test06", "a", "a.", false);
        re.test("Test07", "a", "", false);
        re.test("Test08", "a", ".", true);
        re.test("Test09", "a", "ab*", true);
        re.test("Test10", "a", "ab*a", false);
        re.test("Test11", "aa", "aa", true);
        re.test("Test12", "aa", "a*", true);
        re.test("Test13", "aa", ".*", true);
        re.test("Test14", "aa", ".", false);
        re.test("Test15", "ab", ".*", true);
        re.test("Test16", "ab", ".*", true);
        re.test("Test17", "aaa", "aa*", true);
        re.test("Test18", "aaa", "aa.a", false);
        re.test("Test19", "aaa", "a.a", true);
        re.test("Test20", "aaa", ".a", false);
        re.test("Test21", "aaa", "a*a", true);
        re.test("Test22", "aaa", "ab*a", false);
        re.test("Test23", "aaa", "ab*ac*a", true);
        re.test("Test24", "aaa", "ab*a*c*a", true);
        re.test("Test25", "aaa", ".*", true);
        re.test("Test26", "aab", "c*a*b", true);
        re.test("Test27", "aaca", "ab*a*c*a", true);
        re.test("Test28", "aaba", "ab*a*c*a", false);
        re.test("Test29", "bbbba", ".*a*a", true);
        re.test("Test30", "bcbbabab", ".*a*a", false);
    }


}
