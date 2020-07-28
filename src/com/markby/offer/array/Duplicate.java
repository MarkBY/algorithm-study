package com.markby.offer.array;

// 面试题3（一）：找出数组中重复的数字
// 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
// 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
// 那么对应的输出是重复的数字2或者3。

/**
 * com.makBY.offer.array.Duplicate 重复
 */
public class Duplicate {

    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 0, 4};
        //int[] numbers ={};
        int length = numbers.length;
        int[] duplication = new int[length];
        boolean b = getDuplicate(numbers, length, duplication);
        System.out.println(b);
        for (int num : numbers) {
            System.out.println(num);
        }
        System.out.println();
        for (int num : duplication) {
            System.out.println(num);
        }

    }

    /**
     * 在排序的同时找
     * <p>
     * 运行时间：18ms
     * 占用内存：9556k
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean getDuplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                // swap numbers[i] and numbers[numbers[i]]
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }

        }
        return false;
    }

    /**
     * hash
     * <p>
     * 运行时间：17ms
     * 占用内存：9648k
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean getDuplicate2(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }
        int[] hash = new int[length];
        for (int num : numbers) {
            int index = num % length;
            hash[index]++;
            if (hash[index] >= 2) {
                duplication[0] = num;
                return true;
            }
        }
        return false;
    }

}
