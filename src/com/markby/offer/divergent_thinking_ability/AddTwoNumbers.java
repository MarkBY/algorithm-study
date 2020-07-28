package com.markby.offer.divergent_thinking_ability;

// 面试题65：不用加减乘除做加法
// 题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷
// 四则运算符号。
public class AddTwoNumbers {
    public int add(int a, int b) {
        do {
            int sum = a ^ b;
            int carry = (a & b) << 1;

            a = sum;
            b = carry;
        }while (b != 0);
        return a;
    }

    // ====================测试代码====================
    void test(int num1, int num2, int expected)
    {
        int result = add(num1, num2);
        if(result == expected)
            System.out.printf("%d + %d is %d. Passed\n", num1, num2, result);
        else
            System.out.printf("%d + %d is %d. FAILED\n", num1, num2, result);
    }

    void mainTest()
    {
        test(1, 2, 3);
        test(111, 899, 1010);

        test(-1, 2, 1);
        test(1, -2, -1);

        test(3, 0, 3);
        test(0, -4, -4);

        test(-2, -8, -10);
    }

    public static void main(String[] args) {
        AddTwoNumbers numbers = new AddTwoNumbers();

        numbers.mainTest();
    }

}
