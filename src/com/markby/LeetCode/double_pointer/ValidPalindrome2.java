package com.markby.LeetCode.double_pointer;

// 680. Valid Palindrome II (Easy)
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                low++;
                high--;
            } else {
                boolean flag1 = true, flag2 = true;
                for (int i = low, j = high - 1; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low + 1, j = high; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }

    public boolean validPalindrome1(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    //======================test===========================
    public void test(String testName, String s, boolean expected) {
        System.out.println(testName + " begin:");

        boolean success = validPalindrome(s);

        if (success == expected)
            System.out.println("passed.");
        else
            System.out.println("Failed.");

        System.out.println();
    }

    void test1() {
        String testName = "test1";
        String s = "aba";

        test(testName, s, true);
    }

    void test2() {
        String testName = "test2";
        String s = "abca";

        test(testName, s, true);
    }

    void mainTest() {
        test1();
        test2();
    }

    public static void main(String[] args) {
        ValidPalindrome2 validPalindrome2 = new ValidPalindrome2();

        validPalindrome2.mainTest();
    }
}
