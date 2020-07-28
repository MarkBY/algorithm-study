package com.markby.offer.Knowledge_transfer_ability;

import java.util.Deque;
import java.util.LinkedList;

// 面试题59（一）：滑动窗口的最大值
// 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
// 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
// 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，
public class MaxInSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k > nums.length)
            return new int[]{};

        int[] result = new int[nums.length - k + 1];
        int index = 0;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++){
            if (i >= k)
                result[index++] = nums[deque.peekFirst()];

            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.removeLast();
            if (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.removeFirst();

            deque.addLast(i);
        }

        result[index] = nums[deque.peekFirst()];

        return result;
    }

    // ====================测试代码====================
    void test(String testName, int[] num, int size, int[] expected) {
        if (testName != null)
            System.out.println( testName + " begins: ");

        int[] result = maxSlidingWindow(num, size);
        boolean success = true;
        
        for (int i = 0; i < result.length; i++){
            if (result[i] != expected[i])
                success = false;
        }

        if (success)
            System.out.println("Passed.\n");
        else
            System.out.println("FAILED.\n");
    }

    void test1() {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};

        int[] expected = {4, 4, 6, 6, 6, 5};

        int size = 3;

        test("test1", num, size, expected);
    }

    void test2() {
        int[] num = {1, 3, -1, -3, 5, 3, 6, 7};
        
        int[] expected = {3, 3, 5, 5, 6, 7};
        
         int size = 3;

        test("test2", num, size, expected);
    }

    // 输入数组单调递增
    void test3() {
        int[] num = {1, 3, 5, 7, 9, 11, 13, 15};

        int[] expected = {7, 9, 11, 13, 15};
        
         int size = 4;

        test("test3", num, size, expected);
    }

    // 输入数组单调递减
    void test4() {
        int[] num = {16, 14, 12, 10, 8, 6, 4};

        int[] expected = {16, 14, 12};
        

         int size = 5;

        test("test4", num, size, expected);
    }

    // 滑动窗口的大小为1
    void test5() {
        int[] num = {10, 14, 12, 11};

        int[] expected = {10, 14, 12, 11};

         int size = 1;

        test("test5", num, size, expected);
    }

    // 滑动窗口的大小等于数组的长度
    void test6() {
        int[] num = {10, 14, 12, 11};
        
        int[] expected = {14};
        
         int size = 4;

        test("test6", num, size, expected);
    }

    // 滑动窗口的大小为0
    void test7() {
        int[] num = {10, 14, 12, 11};
        
        int[] expected = {};
         
        int size = 0;

        test("test7", num, size, expected);
    }

    // 滑动窗口的大小大于输入数组的长度
    void test8() {
        int[] num = {10, 14, 12, 11};
        
        int[] expected = {};

         int size = 5;

        test("test8", num, size, expected);
    }

    // 输入数组为空
    void test9() {
        int[] num = null;
        int[] expected = null;

         int size = 5;

        test("test9", num, size, expected);
    }

    public static void main(String[] args) {
        MaxInSlidingWindow max = new MaxInSlidingWindow();

        max.test1();
        max.test2();
        max.test3();
        max.test4();
        max.test5();
        max.test6();
        max.test7();
        max.test8();
        max.test9();
    }

}
