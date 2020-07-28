package com.markby.offer.Knowledge_transfer_ability;

// 面试题56（二）：数组中唯一只出现一次的数字
// 题目：在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请
// 找出那个吃出现一次的数字。
public class NumberAppearingOnce {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;

        int[] bitSum = new int[32];
        for (int num : nums) {
            int bitMask = 1;
            for (int j = 31; j >= 0; --j) {
                int bit = num & bitMask;
                if (bit != 0)
                    bitSum[j] += 1;

                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; ++i) {
            result = result << 1;
            result += bitSum[i] % 3;
        }

        return result;
    }

    // ====================测试代码====================
    void test(String testName, int[] numbers, int expected) {
        int result = singleNumber(numbers);
        if (result == expected)
            System.out.println(testName + " passed.\n");
        else
            System.out.println(testName + " FAILED.\n");
    }

    // 所有数字都是正数，唯一的数字是最小的
    void test1() {
        int[] numbers = {1, 1, 2, 2, 2, 1, 3};
        int expected = 3;
        test("test1", numbers, expected);
    }

    // 所有数字都是正数，唯一的数字的大小位于中间
    void test2() {
        int[] numbers = {4, 3, 3, 2, 2, 2, 3};
        int expected = 4;
        test("test2", numbers, expected);
    }

    // 所有数字都是正数，唯一的数字是最大的
    void test3() {
        int[] numbers = {4, 4, 1, 1, 1, 7, 4};
        int expected = 7;
        test("test3", numbers, expected);
    }

    // 唯一的数字是负数
    void test4() {
        int[] numbers = {-10, 214, 214, 214};
        int expected = -10;
        test("test4", numbers, expected);
    }

    // 除了唯一的数字，其他数字都是负数
    void test5() {
        int[] numbers = {-209, 3467, -209, -209};
        int expected = 3467;
        test("test5", numbers, expected);
    }

    // 重复的数字有正数也有负数
    void test6() {
        int[] numbers = {1024, -1025, 1024, -1025, 1024, -1025, 1023};
        int expected = 1023;
        test("test6", numbers, expected);
    }

    // 所有数字都是负数
    void test7() {
        int[] numbers = {-1024, -1024, -1024, -1023};
        int expected = -1023;
        test("test7", numbers, expected);
    }

    // 唯一的数字是0
    void test8() {
        int[] numbers = {-23, 0, 214, -23, 214, -23, 214};
        int expected = 0;
        test("test8", numbers, expected);
    }

    // 除了唯一的数字，其他数字都是0
    void test9() {
        int[] numbers = {0, 3467, 0, 0, 0, 0, 0, 0};
        int expected = 3467;
        test("test9", numbers, expected);
    }

    public static void main(String[] args) {
        NumberAppearingOnce num = new NumberAppearingOnce();

        num.test1();
        num.test2();
        num.test3();
        num.test4();
        num.test5();
        num.test6();
        num.test7();
        num.test8();
        num.test9();
    }

}
