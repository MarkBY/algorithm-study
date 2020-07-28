package com.markby.offer.Balance_of_time_efficiency_and_space_efficiency;

// 面试题51：数组中的逆序对
// 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组
// 成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
public class InversePairs {

    int[] auxiliary;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        auxiliary = new int[nums.length];

        return reversePairs(nums, 0, nums.length - 1);
    }

    int reversePairs(int[] nums, int low, int high) {
        if (high <= low)
            return 0;

        int res = 0;
        int mid = low + (high - low) / 2;
        res += reversePairs(nums, low, mid);
        res += reversePairs(nums, mid + 1, high);

        if (nums[mid] <= nums[mid + 1])
            return res;

        int i = mid, j = high;
        for (int k = low; k <= high; k++)
            auxiliary[k] = nums[k];

        for (int k = high; k >= low; k--)
            if (j <= mid)
                nums[k] = auxiliary[i--];
            else if (i < low)
                nums[k] = auxiliary[j--];
            else if (auxiliary[i] > auxiliary[j]) {
                res += j - mid;
                nums[k] = auxiliary[i--];
            } else {
                nums[k] = auxiliary[j--];
            }

        return res;
    }

    // ====================测试代码====================
    void test(String testName, int[] data, int expected) {
        if (testName != null)
            System.out.println(testName + " begins: ");
        int res = reversePairs(data);
        System.out.println(res);
        if (res == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("Failed.\n");
    }

    void test1() {
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        int expected = 3;

        test("test1", data, expected);
    }

    // 递减排序数组
    void test2() {
        int[] data = {6, 5, 4, 3, 2, 1};
        int expected = 15;

        test("test2", data, expected);
    }

    // 递增排序数组
    void test3() {
        int[] data = {1, 2, 3, 4, 5, 6};
        int expected = 0;

        test("test3", data, expected);
    }

    // 数组中只有一个数字
    void test4() {
        int[] data = {1};
        int expected = 0;

        test("test4", data, expected);
    }


    // 数组中只有两个数字，递增排序
    void test5() {
        int[] data = {1, 2};
        int expected = 0;

        test("test5", data, expected);
    }

    // 数组中只有两个数字，递减排序
    void test6() {
        int[] data = {2, 1};
        int expected = 1;

        test("test6", data, expected);
    }

    // 数组中有相等的数字
    void test7() {
        int[] data = {1, 2, 1, 2, 1};
        int expected = 3;

        test("test7", data, expected);
    }

    void test8() {
        int expected = 0;

        test("test8", null, expected);
    }

    void test9() {
        int[] data = {1, 3, 2, 3, 1};
        int expected = 4;

        test("test7", data, expected);
    }


    public static void main(String[] args) {
        InversePairs pairs = new InversePairs();

        pairs.test1();
        pairs.test2();
        pairs.test3();
        pairs.test4();
        pairs.test5();
        pairs.test6();
        pairs.test7();
        pairs.test8();
        pairs.test9();
    }

}
