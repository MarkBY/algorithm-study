package com.markby.offer.time_efficiency;

// 面试题47：礼物的最大价值
// 题目：在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值
// （价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或
// 者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计
// 算你最多能拿到多少价值的礼物？
public class MaxValueOfGifts {

    public int maxValue(int[][] grid) {
        if (grid == null)
            return 0;

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 1; i < col; i++)
            grid[0][i] += grid[0][i - 1];
        for (int i = 1; i < row; i++)
            grid[i][0] += grid[i - 1][0];

        for (int i = 1; i < row; i++)
            for (int j = 1; j < col; j++)
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);

        return grid[row - 1][col - 1];
    }

    // ====================测试代码====================
    void test(String testName, int[][] values, int expected) {
        if (maxValue(values) == expected)
            System.out.println(testName + ": passed.");
        else
            System.out.println(testName + ": FAILED.");

    }

    void test1() {
        // 三行三列
        int[][] values = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int expected = 29;
        test("test1", values, expected);
    }

    void test2() {
        //四行四列
        int[][] values = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        int expected = 53;
        test("test2", values, expected);
    }

    void test3() {
        // 一行四列
        int values[][] = {
                {1, 10, 3, 8}
        };
        int expected = 22;
        test("test3", values, expected);
    }

    void test4() {
        int[][] values = {
                {1},
                {12},
                {5},
                {3}
        };
        int expected = 21;
        test("test4", values, expected);
    }

    void test5() {
        // 一行一列
        int[][] values = {
                {3}
        };
        int expected = 3;
        test("test5", values, expected);
    }

    void test6() {
        // 空指针
        int expected = 0;
        test("test6", null, expected);
    }

    public static void main(String[] args) {
        MaxValueOfGifts max = new MaxValueOfGifts();

        max.test1();
        max.test2();
        max.test3();
        max.test4();
        max.test5();
        max.test6();
    }

}
