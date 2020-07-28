package com.markby.offer.dynamicprogramming_greedyalgorithm;

public class CuttingRope {

    public int cutRope(int target) {
        if (target < 2)
            return 0;
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;

        int[] products = new int[target + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= target; ++i) {
            max = 0;
            for (int j = 1; j <= i / 2; ++j) {
                int product = products[j] * products[i - j];
                if (max < product)
                    max = product;

                products[i] = max;
            }
        }
        max = products[target];

        return max;
    }

    // ====================贪婪算法====================
    public int cutRope2(int target) {
        if (target < 2)
            return 0;
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;
        // 尽可能多地减去长度为3的绳子段
        int timesOf3 = target / 3;

        // 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段。
        // 此时更好的方法是把绳子剪成长度为2的两段，因为2*2 > 3*1。
        if (target - timesOf3 * 3 == 1)
            timesOf3 -= 1;

        int timesOf2 = (target - timesOf3 * 3) / 2;

        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }

    // ====================测试代码====================
    void test(String testName, int length, int expected) {
        int result1 = cutRope(length);
        if (result1 == expected)
            System.out.println("Solution1 for " + testName + " passed.");
        else
            System.out.println("Solution1 for " + testName + " FAILED.");

        int result2 = cutRope2(length);
        if (result2 == expected)
            System.out.println("Solution2 for " + testName + " passed.");
        else
            System.out.println("Solution2 for " + testName + " FAILED.");
    }

    void test1() {
        int length = 1;
        int expected = 0;
        test("test1", length, expected);
    }

    void test2() {
        int length = 2;
        int expected = 1;
        test("test2", length, expected);
    }

    void test3() {
        int length = 3;
        int expected = 2;
        test("test3", length, expected);
    }

    void test4() {
        int length = 4;
        int expected = 4;
        test("test4", length, expected);
    }

    void test5() {
        int length = 5;
        int expected = 6;
        test("test5", length, expected);
    }

    void test6() {
        int length = 6;
        int expected = 9;
        test("test6", length, expected);
    }

    void test7() {
        int length = 7;
        int expected = 12;
        test("test7", length, expected);
    }

    void test8() {
        int length = 8;
        int expected = 18;
        test("test8", length, expected);
    }

    void test9() {
        int length = 9;
        int expected = 27;
        test("test9", length, expected);
    }

    void test10() {
        int length = 10;
        int expected = 36;
        test("test10", length, expected);
    }

    void test11() {
        int length = 50;
        int expected = 86093442;
        test("test11", length, expected);
    }

    public static void main(String[] args) {
        CuttingRope cutRope = new CuttingRope();
        cutRope.test1();
        cutRope.test2();
        cutRope.test3();
        cutRope.test4();
        cutRope.test5();
        cutRope.test6();
        cutRope.test7();
        cutRope.test8();
        cutRope.test9();
        cutRope.test10();
        cutRope.test11();
    }

}
