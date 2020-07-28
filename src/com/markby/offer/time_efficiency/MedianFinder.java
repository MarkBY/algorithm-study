package com.markby.offer.time_efficiency;

import java.util.PriorityQueue;
import java.util.Queue;

// 面试题41：数据流中的中位数
// 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么
// 中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
// 那么中位数就是所有数值排序之后中间两个数的平均值。

public class MedianFinder {
    Queue<Integer> A, B;

    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }


    // ====================测试代码====================
    void test(String testName, MedianFinder numbers, double expected) {
        if (testName != null)
            System.out.printf("%s begins: ", testName);

        if (Math.abs(numbers.findMedian() - expected) < 0.0000001)
            System.out.printf("Passed.\n");
        else
            System.out.printf("FAILED.\n");
    }

    public static void main(String[] args) {
        MedianFinder numbers = new MedianFinder();

        numbers.addNum(5);
        numbers.test("test2", numbers, 5);

        numbers.addNum(2);
        numbers.test("test3", numbers, 3.5);

        numbers.addNum(3);
        numbers.test("test4", numbers, 3);

        numbers.addNum(4);
        numbers.test("test6", numbers, 3.5);

        numbers.addNum(1);
        numbers.test("test5", numbers, 3);

        numbers.addNum(6);
        numbers.test("test7", numbers, 3.5);

        numbers.addNum(7);
        numbers.test("test8", numbers, 4);

        numbers.addNum(0);
        numbers.test("test9", numbers, 3.5);

        numbers.addNum(8);
        numbers.test("test10", numbers, 4);
    }
}
