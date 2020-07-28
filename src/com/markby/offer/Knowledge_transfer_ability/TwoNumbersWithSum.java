package com.markby.offer.Knowledge_transfer_ability;

import java.util.HashMap;
import java.util.Map;

// 面试题57（一）：和为s的两个数字
// 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们
// 的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
public class TwoNumbersWithSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <=1)
            return new int[] {0, 0};

        int start = 0;
        int end = nums.length - 1;
        while ( start < end){
            if (nums[start] + nums[end] ==target)
                break;
            else if (nums[start] + nums[end] > target)
                end--;
            else
                start++;
        }

        return new int[] {nums[start], nums[end]};
    }

    // ====================测试代码====================
    void Test(String testName, int[] data, int sum) {
        if (testName != null)
            System.out.println(testName + " begins: ");

        int[] result = twoSum(data, sum);

        if (result[0] + result[1] == sum)
            System.out.println("Passed. \n");
        else
            System.out.println("FAILED. \n");

    }

    // 存在和为s的两个数字，这两个数字位于数组的中间
    void Test1() {
        int[] data = {1, 2, 4, 7, 11, 15};
        Test("Test1", data, 15);
    }

    // 存在和为s的两个数字，这两个数字位于数组的两段
    void Test2() {
        int[] data = {1, 2, 4, 7, 11, 16};
        Test("Test2", data, 17);
    }

    // 不存在和为s的两个数字
    void Test3() {
        int[] data = {1, 2, 4, 7, 11, 16};
        Test("Test3", data, 10);
    }

    // 鲁棒性测试
    void Test4() {
        Test("Test4", null, 0);
    }

    public static void main(String[] args) {
        TwoNumbersWithSum sum = new TwoNumbersWithSum();

        sum.Test1();
        sum.Test2();
        sum.Test3();
        sum.Test4();
    }

}
