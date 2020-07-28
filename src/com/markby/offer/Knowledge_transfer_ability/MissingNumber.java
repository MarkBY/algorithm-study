package com.markby.offer.Knowledge_transfer_ability;

// 面试题53（二）：0到n-1中缺失的数字
// 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字
// 都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组
// 中，请找出这个数字。
public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int middle = (end + start) >> 1;

            if (nums[middle] != middle) {
                if (middle == 0 || nums[middle - 1] == middle - 1)
                    return middle;
                else
                    end = middle - 1;
            } else
                start = middle + 1;
        }


        if (start == nums.length)
            return nums.length;

        return 0;
    }


    // ====================测试代码====================
    void test(String testName, int[] numbers, int expected) {
        if (testName != null)
            System.out.println(testName + " begins: ");

        int result = missingNumber(numbers);
        if (result == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("Failed.\n");
    }

    // 缺失的是第一个数字0
    void test1() {
        int[] numbers = {1, 2, 3, 4, 5};
        int expected = 0;
        test("test1", numbers, expected);
    }

    // 缺失的是最后一个数字
    void test2() {
        int[] numbers = {0, 1, 2, 3, 4};
        int expected = 5;
        test("test2", numbers, expected);
    }

    // 缺失的是中间某个数字0
    void test3() {
        int[] numbers = {0, 1, 2, 4, 5};
        int expected = 3;
        test("test3", numbers, expected);
    }

    // 数组中只有一个数字，缺失的是第一个数字0
    void test4() {
        int[] numbers = {1};
        int expected = 0;
        test("test4", numbers, expected);
    }

    // 数组中只有一个数字，缺失的是最后一个数字1
    void test5() {
        int[] numbers = {0};
        int expected = 1;
        test("test5", numbers, expected);
    }

    // 空数组
    void test6() {
        int expected = 0;
        test("test6", null, expected);
    }

    public static void main(String[] args) {
        MissingNumber number = new MissingNumber();

        number.test1();
        number.test2();
        number.test3();
        number.test4();
        number.test5();
        number.test6();
    }
}
