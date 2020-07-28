package com.markby.offer.Knowledge_transfer_ability;

// 面试题53（三）：数组中数值和下标相等的元素
// 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实
// 现一个函数找出数组中任意一个数值等于其下标的元素。例如，在数组{-3, -1,
// 1, 3, 5}中，数字3和它的下标相等。
public class IntegerIdenticalToIndex {

    int GetNumberSameAsIndex(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) >> 1;

            if (nums[middle] == middle)
                return middle;
            else if (nums[middle] < middle)
                start = middle + 1;
            else
                end = middle - 1;
        }

        return -1;
    }

    // ====================测试代码====================
    void test(String testName, int[] numbers, int expected) {
        if (GetNumberSameAsIndex(numbers) == expected)
            System.out.println(testName + " passed.\n");
        else
            System.out.println(testName + " FAILED.\n");
    }

    void test1() {
        int[] numbers = {-3, -1, 1, 3, 5};
        int expected = 3;
        test("test1", numbers, expected);
    }

    void test2() {
        int[] numbers = {0, 1, 3, 5, 6};
        int expected = 0;
        test("test2", numbers, expected);
    }

    void test3() {
        int[] numbers = {-1, 0, 1, 2, 4};
        int expected = 4;
        test("test3", numbers, expected);
    }

    void test4() {
        int[] numbers = {-1, 0, 1, 2, 5};
        int expected = -1;
        test("test4", numbers, expected);
    }

    void test5() {
        int[] numbers = {0};
        int expected = 0;
        test("test5", numbers, expected);
    }

    void test6() {
        int[] numbers = {10};
        int expected = -1;
        test("test6", numbers, expected);
    }

    void test7() {
        test("test7", null, -1);
    }

    public static void main(String[] args) {
        IntegerIdenticalToIndex index = new IntegerIdenticalToIndex();

        index.test1();
        index.test2();
        index.test3();
        index.test4();
        index.test5();
        index.test6();
        index.test7();
    }
}
