package com.markby.offer.time_efficiency;

// 面试题42：连续子数组的最大和
// 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
// 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
public class GreatestSumOfSubarrays {
    boolean g_InvalidInput = false;

    int FindGreatestSumOfSubArray(int[] pData) {
        if (pData == null) {
            g_InvalidInput = true;
            return 0;
        }

        g_InvalidInput = false;

        int nCurSum = 0;
        int nGreatestSum = 0x80000000;

        for (int i = 0; i < pData.length; ++i) {
            if (nCurSum <= 0)
                nCurSum = pData[i];
            else
                nCurSum += pData[i];

            if (nCurSum > nGreatestSum)
                nGreatestSum = nCurSum;
        }

        return nGreatestSum;
    }

    // ====================测试代码====================
    void test(String testName, int[] pData, int expected, boolean expectedFlag) {
        if (testName != null)
            System.out.printf("%s begins: \n", testName);

        int result = FindGreatestSumOfSubArray(pData);
        if (result == expected && expectedFlag == g_InvalidInput)
            System.out.printf("Passed.\n");
        else
            System.out.printf("Failed.\n");
    }

    // 1, -2, 3, 10, -4, 7, 2, -5
    void test1() {
        int data[] = {1, -2, 3, 10, -4, 7, 2, -5};
        test("test1", data, 18, false);
    }

    // 所有数字都是负数
    // -2, -8, -1, -5, -9
    void test2() {
        int data[] = {-2, -8, -1, -5, -9};
        test("test2", data, -1, false);
    }

    // 所有数字都是正数
    // 2, 8, 1, 5, 9
    void test3() {
        int data[] = {2, 8, 1, 5, 9};
        test("test3", data, 25, false);
    }

    // 无效输入
    void test4() {
        test("test4", null, 0, true);
    }

    public static void main(String[] args) {
        GreatestSumOfSubarrays sum = new GreatestSumOfSubarrays();

        sum.test1();
        sum.test2();
        sum.test3();
        sum.test4();
    }

}
