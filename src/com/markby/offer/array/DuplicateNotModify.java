package com.markby.offer.array;

// 面试题3（二）：不修改数组找出重复的数字
// 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
// 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
// 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
// 输出是重复的数字2或者3。
public class DuplicateNotModify {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 4, 3, 2, 6, 7};
        int result = getDuplicateNotModify(numbers, numbers.length);
        System.out.println(result);

    }

    public static int getDuplicateNotModify(int[] numbers, int length) {
        if (numbers == null || length <= 0)
            return -1;

        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(numbers, length, start, middle);
            if (start == end) {
                if (count > 1)
                    return start;
                else
                    break;
            }

            if (count > (middle - start + 1))
                end = middle;
            else
                start = middle + 1;
        }

        return -1;
    }

    public static int countRange(int[] numbers, int length, int start, int end) {
        if (numbers == null)
            return 0;
        int count = 0;
        for (int num : numbers) {
            if (num >= start && num <= end)
                count++;
        }
        return count;
    }
}
