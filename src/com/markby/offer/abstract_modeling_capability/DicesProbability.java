package com.markby.offer.abstract_modeling_capability;

import java.util.Arrays;

// 面试题60：n个骰子的点数
// 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s
// 的所有可能的值出现的概率。
public class DicesProbability {
    int maxValue = 6;

    // 方法1
    public double[] twoSum(int n) {
        if (n < 1)
            return new double[0];

        int maxSum = n * maxValue;
        int[] pProbabilities = new int[maxSum - n + 1];
        for (int i = n; i <= maxSum; ++i)
            pProbabilities[i - n] = 0;

        Probability(n, pProbabilities);

        double total = Math.pow((double) maxValue, n);
        double[] result = new double[6 * n - n + 1];
        int index = 0;
        for (int i = n; i <= maxSum; ++i) {
            double ratio = (double) pProbabilities[i - n] / total;
            result[index++] = ratio;
        }

        return result;
    }

    void Probability(int number, int[] pProbabilities) {
        for (int i = 1; i <= maxValue; ++i)
            Probability(number, number, i, pProbabilities);
    }

    void Probability(int original, int current, int sum,
                     int[] pProbabilities) {
        if (current == 1) {
            pProbabilities[sum - original]++;
        } else {
            for (int i = 1; i <= maxValue; ++i) {
                Probability(original, current - 1, i + sum, pProbabilities);
            }
        }
    }


    // 方法2
    public double[] twoSum1(int n) {
        if (n < 1)
            return new double[0];

        int[][] pProbabilities = new int[2][maxValue * n + 1];

        int flag = 0;
        for (int i = 1; i <= maxValue; ++i)
            pProbabilities[flag][i] = 1;

        for (int k = 2; k <= n; ++k) {
            for (int i = 0; i < k; ++i)
                pProbabilities[1 - flag][i] = 0;

            for (int i = k; i <= maxValue * k; ++i) {
                pProbabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= maxValue; ++j)
                    pProbabilities[1 - flag][i] += pProbabilities[flag][i - j];
            }

            flag = 1 - flag;
        }

        double total = Math.pow((double) maxValue, n);
        double[] result = new double[6 * n - n + 1];
        int index = 0;
        for (int i = n; i <= maxValue * n; ++i) {
            double ratio = (double) pProbabilities[flag][i] / total;
            result[index++] = ratio;
        }
        return result;
    }

    // ====================测试代码====================
    void Test(int n) {
        System.out.println("Test for " + n + " begins:\n");

        double[] result = twoSum(n);

        System.out.println(Arrays.toString(result));

        System.out.println();
    }


    public static void main(String[] args) {

        DicesProbability dicesProbability = new DicesProbability();

        dicesProbability.mainTest();
    }

    void mainTest() {
        Test(1);
        Test(2);
        Test(3);
        Test(4);

        Test(11);

        Test(0);
    }
}
