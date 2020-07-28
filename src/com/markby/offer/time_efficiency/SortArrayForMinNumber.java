package com.markby.offer.time_efficiency;

import java.util.Arrays;

// 面试题45：把数组排成最小的数
// 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼
// 接出的所有数字中最小的一个。例如输入数组{3, 32, 321}，则打印出这3个数
// 字能排成的最小数字321323。
public class SortArrayForMinNumber {

    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));

        StringBuilder re = new StringBuilder();
        for (String str : strings) {
            re.append(str);
        }
        return re.toString();

    }

    public String minNumber1(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        newQuickSort(strings, 0, nums.length - 1);

        StringBuilder re = new StringBuilder();
        for (String str : strings) {
            re.append(str);
        }
        return re.toString();
    }

    void newQuickSort(String[] strings, int low, int high) {
        if (low < high) {
            int middle = partition(strings, low, high);
            newQuickSort(strings, low, middle - 1);
            newQuickSort(strings, middle + 1, high);
        }
    }

    int partition(String[] strings, int low, int high) {
        String temp = strings[low];
        while (low < high) {
            while (low < high && (temp + strings[high]).compareTo(strings[high] + temp) <= 0) high--;
            strings[low] = strings[high];
            while (low < high && (temp + strings[low]).compareTo(strings[low] + temp) >= 0) low++;
            strings[high] = strings[low];
        }

        strings[low] = temp;

        return low;
    }


    // ====================测试代码====================
    void test(String testName, int[] numbers, String expectedResult) {
        if (testName != null)
            System.out.printf("%s begins:\n", testName);

        if (expectedResult != null)
            System.out.printf("Expected result is: \t%s\n", expectedResult);

        System.out.println("Actual result is: \t" + minNumber(numbers));

        if (minNumber(numbers) != null && minNumber(numbers).equals(expectedResult))
            System.out.println("Passed.");
        else
            System.out.println("FAILED.");

        System.out.println("\n");
    }

    void test1() {
        int[] numbers = {3, 5, 1, 4, 2};
        test("test1", numbers, "12345");
    }

    void test2() {
        int[] numbers = {3, 32, 321};
        test("test2", numbers, "321323");
    }

    void test3() {
        int[] numbers = {3, 323, 32123};
        test("test3", numbers, "321233233");
    }

    void test4() {
        int[] numbers = {1, 11, 111};
        test("test4", numbers, "111111");
    }

    // 数组中只有一个数字
    void test5() {
        int[] numbers = {321};
        test("test5", numbers, "321");
    }

    void test6() {
        int[] numbers = {3, 30, 34, 5, 9};

        test("test6", numbers, "3033459");
    }

    public static void main(String[] args) {
        SortArrayForMinNumber sort = new SortArrayForMinNumber();

        sort.test1();
        sort.test2();
        sort.test3();
        sort.test4();
        sort.test5();
        sort.test6();
    }

}
