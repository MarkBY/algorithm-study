package com.markby.offer.Knowledge_transfer_ability;

// 面试题56（一）：数组中只出现一次的两个数字
// 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
// 找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
/*
    负数在计算机中的表示（8位）：
        5 二进制表示：101
        原码：00000101
        反码：11111010
        反码加1变为补码：
        补码：11111011
        补码就是负数在计算机中的二进制表示方法。
        那么，11111011表示8位的-5，
 */
public class NumbersAppearOnce {

    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int flag = sum & (-sum);
        //此时再将两个数组两两异或就可以得到最终结果。
        int result = 0;
        for (int num : nums) {
            if ((num & flag) != 0) {
                result ^= num;
            }
        }
        return new int[]{result, result ^ sum};
    }

    // ====================测试代码====================
    void test(String testName, int[] data, int expected1, int expected2) {
        if (testName != null)
            System.out.println(testName + " begins: ");

        int[] result = singleNumbers(data);

        if ((expected1 == result[0] && expected2 == result[1]) ||
                (expected2 == result[0] && expected1 == result[1]))
            System.out.println("Passed.\n\n");
        else
            System.out.println("Failed.\n\n");
    }

    void test1() {
        int[] data = {2, 4, 3, 6, 3, 2, 5, 5};
        test("test1", data, 4, 6);
    }

    void test2() {
        int[] data = {4, 6};
        test("test2", data, 4, 6);
    }

    void test3() {
        int[] data = {4, 6, 1, 1, 1, 1};
        test("test3", data, 4, 6);
    }

    public static void main(String[] args) {
        NumbersAppearOnce appearOnce = new NumbersAppearOnce();

        appearOnce.test1();
        appearOnce.test2();
        appearOnce.test3();
    }

}
