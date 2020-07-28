package com.markby.offer.integrity;

// 面试题21：调整数组顺序使奇数位于偶数前面
// 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
// 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
public class ReorderArray {
    public int[] exchange1(int[] nums) {

        if (nums == null || nums.length == 0)
            return nums;

        int i = 0;
        int j = nums.length - 1;
        while (i != j && i < nums.length) {
            if (nums[i] % 2 == 0) {
                while (j != i && j > 0) {
                    if (nums[j] % 2 != 0) {
                        swap(nums, i, j);
                        j--;
                        break;
                    }
                    j--;
                }
                if (i == j)
                    break;
            }
            i++;
        }

        return nums;
    }

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;

        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            while (begin < end && !isEven(nums[begin]))
                begin++;
            while (begin < end && isEven(nums[end]))
                end--;
            if (begin < end)
                swap(nums, begin, end);
        }

        return nums;
    }

    // even 偶数，odd 奇数
    boolean isEven(int n) {
        return (n & 1) == 0;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // ====================测试代码====================
    void PrintArray(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return;

        for (int i = 0; i < numbers.length; ++i)
            System.out.printf("%d\t", numbers[i]);

        System.out.printf("\n");
    }

    void test(String testName, int[] numbers) {
        if (testName != null)
            System.out.printf("%s begins:\n", testName);


        System.out.printf("Test for solution 1:\n");
        PrintArray(numbers);
        exchange(numbers);
        PrintArray(numbers);


    }

    void test1() {
        int numbers[] = {1, 2, 3, 4, 5, 6, 7};
        test("Test1", numbers);
    }

    void test2() {
        int numbers[] = {2, 4, 6, 1, 3, 5, 7};
        test("Test2", numbers);
    }

    void test3() {
        int numbers[] = {1, 3, 5, 7, 2, 4, 6};
        test("Test3", numbers);
    }

    void test4() {
        int numbers[] = {1};
        test("Test4", numbers);
    }

    void test5() {
        int numbers[] = {2};
        test("Test5", numbers);
    }

    void test6() {
        test("Test6", null);
    }

    void test7() {
        int numbers[] = {8, 10, 3, 20, 12, 4, 10, 8, 4, 0, 5, 17, 7, 20, 3};
        test("Test7", numbers);
    }

    public static void main(String[] args) {
        ReorderArray order = new ReorderArray();
        order.test1();
        order.test2();
        order.test3();
        order.test4();
        order.test5();
        order.test6();
        order.test7();
    }
}
