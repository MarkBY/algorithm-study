package com.markby.LeetCode.double_pointer;

// 88. Merge Sorted Array (Easy)
public class MergeSortedArray {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int p = nums1.length - 1;

        while (0 <= p && 0 <= p2) {
            nums1[p--] = p1 >= 0 && nums1[p1] >= nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        return nums1;
    }

    //======================test===========================

    public void test(String testName, int[] nums1, int m, int[] nums2, int n, int[] expected) {
        System.out.println(testName + " begin:");

        int[] result = merge(nums1, m, nums2, n);

        boolean success = true;
        for (int i = 0; i < expected.length; i++) {
            if (result[i] != expected[i])
                success = false;
        }

        if (success)
            System.out.println("passed.");
        else
            System.out.println("Failed.");

        System.out.println();
    }

    void test1() {
        String testName = "test1";
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        int[] expected = {1, 2, 2, 3, 5, 6};

        test(testName, nums1, m, nums2, n, expected);
    }

    //[0]
    //0
    //[1]
    //1
    void test2() {
        String testName = "test2";
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m = 0, n = 1;
        int[] expected = {1};

        test(testName, nums1, m, nums2, n, expected);
    }

    void mainTest() {
        test1();
        test2();
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        mergeSortedArray.mainTest();
    }
}
