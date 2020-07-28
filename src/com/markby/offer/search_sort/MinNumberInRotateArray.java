package com.markby.offer.search_sort;

// 面试题11：旋转数组的最小数字
// 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
// {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
public class MinNumberInRotateArray {
    /**
     * @param array
     * @return
     */
    public int minNumberInRotateArray1(int[] array) {
        if (array == null)
            return 0;

        int length = array.length;
        int start = 0;
        int end = length - 1;
        int indexMid = start;
        while (array[start] >= array[end]) {
            // 如果start和end指向相邻的两个数，
            // 则start指向第一个递增子数组的最后一个数字，
            // end指向第二个子数组的第一个数字，也就是数组中的最小数字
            if (end - start == 1) {
                indexMid = end;
                break;
            }

            // 如果下标为start、end和indexMid指向的三个数字相等，
            // 则只能顺序查找
            indexMid = (start + end) / 2;
            if (array[start] == array[end] && array[indexMid] == array[start])
                return MinInOrder(array, start, end);

            // 缩小查找范围
            if (array[indexMid] >= array[start])
                start = indexMid;
            else if (array[indexMid] <= array[end])
                end = indexMid;
        }

        return array[indexMid];
    }

    int MinInOrder(int[] numbers, int index1, int index2) {
        int result = numbers[index1];
        for (int i = index1 + 1; i <= index2; ++i) {
            if (result > numbers[i])
                result = numbers[i];
        }

        return result;
    }

    /**
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array == null)
            return 0;

        int length = array.length;
        int start = 0;
        int end = length - 1;
        int middle = start;

        int result = array[0];

        if (array[start] < array[end])
            return result;


        while (start + 1 != end) {

            if (array[start] == array[end] && array[middle] == array[start]) {
                for (int i : array) {
                    if (result > i)
                        result = i;
                }
                return result;
            }
            middle = (start + end) / 2;

            if (array[middle] >= array[start])
                start = middle;
            if (array[middle] <= array[end])
                end = middle;
        }


        return array[end];
    }

    // ====================测试代码====================
    void test(int[] numbers, int expected) {
        int result = 0;
        try {
            int length = numbers.length;
            result = minNumberInRotateArray(numbers);

            for (int i = 0; i < length; ++i)
                System.out.printf("%d ", numbers[i]);

            if (result == expected)
                System.out.printf("\tpassed\n");
            else
                System.out.printf("\tfailed\n");
        } catch (Exception e) {
            if (numbers == null)
                System.out.printf("Test passed.\n");
            else
                System.out.printf("Test failed.\n");
        }
    }

    public static void main(String[] args) {
        MinNumberInRotateArray min = new MinNumberInRotateArray();
        // 典型输入，单调升序的数组的一个旋转
        int array1[] = {3, 4, 5, 1, 2};
        min.test(array1, 1);

        // 有重复数字，并且重复的数字刚好的最小的数字
        int array2[] = {3, 4, 5, 1, 1, 2};
        min.test(array2, 1);

        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int array3[] = {3, 4, 5, 1, 2, 2};
        min.test(array3, 1);

        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int array4[] = {1, 0, 1, 1, 1};
        min.test(array4, 0);

        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int array5[] = {1, 2, 3, 4, 5};
        min.test(array5, 1);

        // 数组中只有一个数字
        int array6[] = {2};
        min.test(array6, 2);

        // 输入null
        min.test(null, 0);
    }


}
