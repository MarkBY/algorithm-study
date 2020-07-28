package com.markby.offer.time_efficiency;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// 面试题40：最小的k个数
// 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
// 这8个数字，则最小的4个数字是1、2、3、4。
public class KLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }


        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;

    }

    public int[] getLeastNumbers1(int[] arr, int k) {

        if (arr == null) return new int[0];
        if (arr.length <= k) return arr;

        buildMinHeap(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int temp = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
            result[i] = temp;

            adjustHeap(arr, 0, arr.length - 1 - i);
        }


        return result;
    }

    public void buildMinHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            adjustHeap(arr, i, arr.length - 1);
    }

    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] > arr[k + 1]) k++;

            if (arr[k] < temp) {
                arr[i] = arr[k];
                i = k;
            } else break;
        }
        arr[i] = temp;
    }

    // ====================测试代码====================
    void test(String testName, int[] data, int n, int[] expectedResult, int k) {
        if (testName != null)
            System.out.printf("%s begins: \n", testName);

        if (expectedResult == null)
            System.out.printf("The input is invalid, we don't expect any result.\n");
        else {
            System.out.printf("Expected result: \n");
            System.out.println(Arrays.toString(expectedResult));
        }

        System.out.printf("Result for solution:\n");
        int[] result = getLeastNumbers(data, k);
        System.out.printf("The actual output numbers are:\n");
        System.out.println(Arrays.toString(result));
        System.out.printf("\n\n");
    }

    // k小于数组的长度
    void test1() {
        int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int expected[] = {1, 2, 3, 4};
        test("test1", data, data.length, expected, expected.length);
    }

    // k等于数组的长度
    void test2() {
        int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int expected[] = {1, 2, 3, 4, 5, 6, 7, 8};
        test("test2", data, data.length, expected, expected.length);
    }

    // k大于数组的长度
    void test3() {
        int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] expected = null;
        test("test3", data, data.length, expected, 10);
    }

    // k等于1
    void test4() {
        int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int expected[] = {1};
        test("test4", data, data.length, expected, expected.length);
    }

    // k等于0
    void test5() {
        int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] expected = null;
        test("test5", data, data.length, expected, 0);
    }

    // 数组中有相同的数字
    void test6() {
        int data[] = {4, 5, 1, 6, 2, 7, 2, 8};
        int expected[] = {1, 2};
        test("test6", data, data.length, expected, expected.length);
    }

    // 输入空指针
    void test7() {
        int[] expected = null;
        test("test7", null, 0, expected, 0);
    }

    public static void main(String[] args) {
        KLeastNumbers numbers = new KLeastNumbers();

        numbers.test1();
        numbers.test2();
        numbers.test3();
        numbers.test4();
        numbers.test5();
        numbers.test6();
        numbers.test7();
    }
}
