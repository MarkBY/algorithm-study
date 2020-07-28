package com.markby.offer.Knowledge_transfer_ability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 面试题57（二）：为s的连续正数序列
// 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
// 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、
// 4～6和7～8。
public class ContinuousSquenceWithSum {

    public int[][] findContinuousSequence(int target) {
        int start = 1, end = 2;
        int curSum = start + end;
        List<int[]> res = new ArrayList<>();

        while (start <= target/2){
            if (curSum == target) {
                int[] tmp = creatArray(start, end);
                res.add(tmp);
                curSum -= start++;
            }else if (curSum > target){
                curSum -= start++;
            }else {
                curSum += ++end;
            }

        }

        return res.toArray(new int[res.size()][]);
    }

    public int[] creatArray(int start, int end){
        int[] result = new int[end - start + 1];
        int index = 0;
        for (int i = start; i <= end; i++){
            result[index++] = i;
        }

        return result;
    }

    // ====================测试代码====================
    void test(String testName, int sum)
    {
        if(testName != null)
            System.out.printf("%s for %d begins: \n", testName, sum);

        int[][] result = findContinuousSequence(sum);

        for (int[] nums : result){
            System.out.println(Arrays.toString(nums));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ContinuousSquenceWithSum sum = new ContinuousSquenceWithSum();

        sum.test("test1", 1);
        sum.test("test2", 3);
        sum.test("test3", 4);
        sum.test("test4", 9);
        sum.test("test5", 15);
        sum.test("test6", 100);
    }

}
