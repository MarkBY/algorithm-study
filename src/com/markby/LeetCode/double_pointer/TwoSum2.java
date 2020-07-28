package com.markby.LeetCode.double_pointer;

//Leetcode ：167. Two Sum II - Input array is sorted (Easy)
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length == 0)
            return new int[0];

        int index1 = 0;
        int index2 = numbers.length - 1;

        while (index1 < index2){
            int sum = numbers[index1] + numbers[index2];
            if (sum == target) {
                break;
            }else if (sum > target){
                index2--;
            }else {
                index1++;
            }
        }

        return new int[]{index1 + 1, index2 + 1};
    }
    //======================test===========================
    public void test(String testName, int[] numbers, int target, int[] expected){
        System.out.println(testName + " begin:");

        int[] result = twoSum(numbers, target);
        boolean success = true;
        if (result.length != expected.length)
            success = false;
        for (int i = 0; i < result.length; i++){
            if(result[i] != expected[i]){
                success = false;
                break;
            }
        }

        if (success)
            System.out.println("passed.");
        else
            System.out.println("Failed.");


    }

    void test1(){
        String testName = "test1";
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {1,2};

        test(testName, numbers, target, expected);
    }

    void mainTest(){
        test1();
    }

    public static void main(String[] args) {
        TwoSum2 twoSum2 = new TwoSum2();
        twoSum2.mainTest();
    }
}
