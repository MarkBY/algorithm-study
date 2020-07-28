package com.markby.offer.abstract_modeling_capability;

import java.util.Arrays;

// 面试题61：扑克牌的顺子
// 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
public class ContinousCards {

    public boolean isStraight(int[] nums) {
        int length = 5;
        if (nums == null || nums.length != length)
            return false;
        int[] dp = new int[14];
        dp[0] = -3;
        int max = 0;
        int min = 13;
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]]++;
            if (dp[nums[i]] > 1) return false;
            if (nums[i] == 0) continue;
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        if (max - min > 4) return false;
        return true;
    }

    public boolean isStraight1(int[] nums) {
        int length = 5;
        if (nums == null || nums.length != length)
            return false;

        Arrays.sort(nums);

        int zeroNum = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == 0)
                zeroNum++;
            else {
                int tmp = nums[i + 1] - nums[i];
                if (tmp == 0)
                    return false;
                zeroNum -= tmp - 1;
                if (zeroNum < 0)
                    return false;
            }
        }

        return true;
    }

    // ====================测试代码====================
    void test(String testName, int[] numbers, boolean expected) {
        if (testName != null)
            System.out.println(testName + " begins: ");

        if (isStraight(numbers) == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("Failed.\n");
    }

    void test1() {
        int[] numbers = {1, 3, 2, 5, 4};
        test("test1", numbers, true);
    }

    void test2() {
        int[] numbers = {1, 3, 2, 6, 4};
        test("test2", numbers, false);
    }

    void test3() {
        int[] numbers = {0, 3, 2, 6, 4};
        test("test3", numbers, true);
    }

    void test4() {
        int[] numbers = {0, 3, 1, 6, 4};
        test("test4", numbers, false);
    }

    void test5() {
        int[] numbers = {1, 3, 0, 5, 0};
        test("test5", numbers, true);
    }

    void test6() {
        int[] numbers = {1, 3, 0, 7, 0};
        test("test6", numbers, false);
    }

    void test7() {
        int[] numbers = {1, 0, 0, 5, 0};
        test("test7", numbers, true);
    }

    void test8() {
        int[] numbers = {1, 0, 0, 7, 0};
        test("test8", numbers, false);
    }

    void test9() {
        int[] numbers = {3, 0, 0, 0, 0};
        test("test9", numbers, true);
    }

    void test10() {
        int[] numbers = {0, 0, 0, 0, 0};
        test("test10", numbers, true);
    }

    // 有对子
    void test11() {
        int[] numbers = {1, 0, 0, 1, 0};
        test("test11", numbers, false);
    }

    // 鲁棒性测试
    void test12() {
        test("test12", null, false);
    }

    void mainTest() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
    }

    public static void main(String[] args) {
        ContinousCards cards = new ContinousCards();

        cards.mainTest();
    }

}
