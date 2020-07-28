package com.markby.offer.abstract_modeling_capability;

// 面试题63：股票的最大利润
// 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股
// 票可能获得的利润是多少？例如一只股票在某些时间节点的价格为{9, 11, 8, 5,
// 7, 12, 16, 14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能
// 收获最大的利润11。
public class MaximalProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int min = prices[0];
        int result = 0;

        for (int i = 1; i < prices.length; i++ ){
            if (min > prices[i])
                min = prices[i];
            if (result < prices[i] - min)
                result = prices[i] - min;
        }

        return result;
    }
    // ==================== test Code ====================
    void test(String testName, int[] numbers, int expected) {
        if (testName != null)
            System.out.println( testName + " begins: ");

        if (maxProfit(numbers) == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("FAILED.\n");
    }

    void test1() {
        int[] numbers = {4, 1, 3, 2, 5};
        test("test1", numbers, 4);
    }

    // 价格递增
    void test2() {
        int[] numbers = {1, 2, 4, 7, 11, 16};
        test("test2", numbers, 15);
    }

    // 价格递减
    void test3() {
        int[] numbers = {16, 11, 7, 4, 2, 1};
        test("test3", numbers, 0);
    }

    // 价格全部相同
    void test4() {
        int[] numbers = {16, 16, 16, 16, 16};
        test("test4", numbers, 0);
    }

    void test5() {
        int[] numbers = {9, 11, 5, 7, 16, 1, 4, 2};
        test("test5", numbers, 11);
    }

    void test6() {
        int[] numbers = {2, 4};
        test("test6", numbers, 2);
    }

    void test7() {
        int[] numbers = {4, 2};
        test("test7", numbers, -2);
    }

    void test8() {
        test("test8", null, 0);
    }

    void mainTest() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    public static void main(String[] args) {
        MaximalProfit max = new MaximalProfit();

        max.mainTest();
    }
}
