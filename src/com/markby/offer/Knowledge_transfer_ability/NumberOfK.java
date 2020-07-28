package com.markby.offer.Knowledge_transfer_ability;

// 面试题53（一）：数字在排序数组中出现的次数
// 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,
// 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。
public class NumberOfK {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;

        int start = getFirstTarget(nums, target, 0, nums.length - 1);
        int end = getLastTarget(nums, target, 0, nums.length - 1);

        int result = 0;

        if (start > -1 && end > -1)
            result = end - start + 1;

        return result;
    }

    int getFirstTarget(int[] nums, int target, int start, int end) {
        if (start > end)
            return -1;
        int middle = start + (end - start) / 2;
        int middleData = nums[middle];
        if (middleData == target) {
            if ((middle > 0 && nums[middle - 1] != target) || middle == 0)
                return middle;
            else
                end = middle - 1;
        } else if (middleData > target)
            end = middle - 1;
        else
            start = middle + 1;

        return getFirstTarget(nums, target, start, end);

    }

    int getLastTarget(int[] nums, int target, int start, int end) {
        if (start > end)
            return -1;
        int middle = start + (end - start) / 2;
        int middleData = nums[middle];
        if (middleData == target) {
            if ((middle < nums.length - 1 && nums[middle + 1] != target) || middle == nums.length - 1)
                return middle;
            else
                start = middle + 1;
        } else if (middleData < target)
            start = middle + 1;
        else
            end = middle - 1;

        return getLastTarget(nums, target, start, end);
    }

    // ====================测试代码====================
    void test(String testName, int[] data, int k, int expected) {
        if (testName != null)
            System.out.println(testName + "%s begins: ");

        int result = search(data, k);
        if (result == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("Failed.\n");
    }

    // 查找的数字出现在数组的中间
    void test1() {
        int[] data = {1, 2, 3, 3, 3, 3, 4, 5};
        test("test1", data, 3, 4);
    }

    // 查找的数组出现在数组的开头
    void test2() {
        int[] data = {3, 3, 3, 3, 4, 5};
        test("test2", data, 3, 4);
    }

    // 查找的数组出现在数组的结尾
    void test3() {
        int[] data = {1, 2, 3, 3, 3, 3};
        test("test3", data, 3, 4);
    }

    // 查找的数字不存在
    void test4() {
        int[] data = {1, 3, 3, 3, 3, 4, 5};
        test("test4", data, 2, 0);
    }

    // 查找的数字比第一个数字还小，不存在
    void test5() {
        int[] data = {1, 3, 3, 3, 3, 4, 5};
        test("test5", data, 0, 0);
    }

    // 查找的数字比最后一个数字还大，不存在
    void test6() {
        int[] data = {1, 3, 3, 3, 3, 4, 5};
        test("test6", data, 6, 0);
    }

    // 数组中的数字从头到尾都是查找的数字
    void test7() {
        int[] data = {3, 3, 3, 3};
        test("test7", data, 3, 4);
    }

    // 数组中的数字从头到尾只有一个重复的数字，不是查找的数字
    void test8() {
        int[] data = {3, 3, 3, 3};
        test("test8", data, 4, 0);
    }

    // 数组中只有一个数字，是查找的数字
    void test9() {
        int[] data = {3};
        test("test9", data, 3, 1);
    }

    // 数组中只有一个数字，不是查找的数字
    void test10() {
        int[] data = {3};
        test("test10", data, 4, 0);
    }

    // 鲁棒性测试，数组空指针
    void test11() {
        test("test11", null, 0, 0);
    }

    public static void main(String[] args) {
        NumberOfK number = new NumberOfK();

        number.test1();
        number.test2();
        number.test3();
        number.test4();
        number.test5();
        number.test6();
        number.test7();
        number.test8();
        number.test9();
        number.test10();
        number.test11();
    }

}
