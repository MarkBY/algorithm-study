package com.markby.offer.integrity;

// 面试题16：数值的整数次方
// 题目：实现函数double Power(double base, int exponent)，求base的exponent
// 次方。不得使用库函数，同时不需要考虑大数问题。
public class Power {
    boolean g_InvalidInput = false;

    public double power(double base, int exponent) {
        g_InvalidInput = false;
        if (equal(base, 0) && exponent < 0) {
            g_InvalidInput = true;
            return 0;
        }

        int absExponent = Math.abs(exponent);
        double result = powerWithAbsExponent(base, absExponent);
        if (exponent < 0)
            result = 1.0 / result;
        return result;
    }

    public double powerWithAbsExponent(double base, int exponent) {
        if (base == 1 || exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        double result = powerWithAbsExponent(base, exponent >> 1);
        result *= result;

        if ((exponent & 0x1) == 1)
            result *= base;
        return result;
    }

    boolean equal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
            return true;
        else
            return false;
    }

    // ====================测试代码====================
    void test(String testName, double base, int exponent, double expectedResult, boolean expectedFlag) {
        double result = power(base, exponent);
        if (equal(result, expectedResult) && g_InvalidInput == expectedFlag)
            System.out.println(testName + " passed");
        else
            System.out.println(testName + " FAILED");
    }

    public static void main(String[] args) {
        Power power = new Power();
        // 底数、指数都为正数
        power.test("Test1", 2, 3, 8, false);

        // 底数为负数、指数为正数
        power.test("Test2", -2, 3, -8, false);

        // 指数为负数
        power.test("Test3", 2, -3, 0.125, false);

        // 指数为0
        power.test("Test4", 2, 0, 1, false);

        // 底数、指数都为0
        power.test("Test5", 0, 0, 1, false);

        // 底数为0、指数为正数
        power.test("Test6", 0, 4, 0, false);

        // 底数为0、指数为负数
        power.test("Test7", 0, -4, 0, true);

        // 底数为0、指数为负数
        power.test("Test8", 3, 9, 19683, false);

        // 底数为0、指数为负数
        power.test("Test9", 1, 9, 1, false);

    }

}
