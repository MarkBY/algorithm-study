package com.markby.offer.time_efficiency;

public class MoreThanHalfNumber {

    public int majorityElement1(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;

    }

    boolean g_bInputInvalid = false;

    public int majorityElement(int[] nums) {
        if (CheckInvalidArray(nums))
            return 0;

        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (nums[i] == result)
                times++;
            else
                times--;
        }

        if (!CheckMoreThanHalf(nums, result))
            result = 0;

        return result;
    }


    boolean CheckInvalidArray(int[] numbers) {
        g_bInputInvalid = false;
        if (numbers == null && numbers.length <= 0)
            g_bInputInvalid = true;

        return g_bInputInvalid;
    }

    boolean CheckMoreThanHalf(int[] numbers, int number) {
        int length = numbers.length;
        int times = 0;
        for (int i = 0; i < length; ++i) {
            if (numbers[i] == number)
                times++;
        }

        boolean isMoreThanHalf = true;
        if (times * 2 <= length) {
            g_bInputInvalid = true;
            isMoreThanHalf = false;
        }

        return isMoreThanHalf;
    }


    // ====================测试代码====================
    void test(String testName, int[] numbers, int expectedValue, boolean expectedFlag) {
        if (testName != null)
            System.out.printf("%s begins: \n", testName);
        if (numbers == null) {
            System.out.println("numbers is null");
            return;
        }
        int length = numbers.length;

        int[] copy = new int[length];
        for (int i = 0; i < length; ++i)
            copy[i] = numbers[i];

        System.out.printf("test for solution: ");
        int result = majorityElement(copy);
        if (result == expectedValue && g_bInputInvalid == expectedFlag)
            System.out.printf("Passed.\n");
        else
            System.out.printf("Failed.\n");
    }

    // 存在出现次数超过数组长度一半的数字
    void test1() {
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        test("test1", numbers, 2, false);
    }

    // 不存在出现次数超过数组长度一半的数字
    void test2() {
        int numbers[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        test("test2", numbers, 0, true);
    }

    // 出现次数超过数组长度一半的数字都出现在数组的前半部分
    void test3() {
        int numbers[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        test("test3", numbers, 2, false);
    }

    // 出现次数超过数组长度一半的数字都出现在数组的后半部分
    void test4() {
        int numbers[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        test("test4", numbers, 2, false);
    }

    // 输入空指针
    void test5() {
        int numbers[] = {1};
        test("test5", numbers, 1, false);
    }

    // 输入空指针
    void test6() {
        test("test6", null, 0, true);
    }

    public static void main(String[] args) {
        MoreThanHalfNumber number = new MoreThanHalfNumber();

        number.test1();
        number.test2();
        number.test3();
        number.test4();
        number.test5();
        number.test6();
    }

}
