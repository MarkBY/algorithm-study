package com.markby.offer.Balance_of_time_efficiency_and_space_efficiency;

// 面试题49：丑数
// 题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。求按从小到
// 大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。
// 习惯上我们把1当做第一个丑数。
public class UglyNumber {

    public int nthUglyNumber(int n) {
        if (n <= 0)
            return 0;

        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int index = 1;
        int mulIndex2 = 0;
        int mulIndex3 = 0;
        int mulIndex5 = 0;

        while (index < n) {
            int min = getMin(uglyNumbers[mulIndex2] * 2, uglyNumbers[mulIndex3] * 3, uglyNumbers[mulIndex5] * 5);

            uglyNumbers[index] = min;
            if (min >= uglyNumbers[mulIndex2] * 2)
                mulIndex2++;
            if (min >= uglyNumbers[mulIndex3] * 3)
                mulIndex3++;
            if (min >= uglyNumbers[mulIndex5] * 5)
                mulIndex5++;


            index++;
        }

        return uglyNumbers[n - 1];
    }

    int getMin(int a, int b, int c) {
        int min = Math.min(a, b);
        min = Math.min(min, c);

        return min;
    }

    // ====================测试代码====================
    void test(int index, int expected) {
        if (nthUglyNumber(index) == expected)
            System.out.println("solution passed.");
        else
            System.out.println("solution failed.");

    }

    void mainTest() {
        test(1, 1);

        test(2, 2);
        test(3, 3);
        test(4, 4);
        test(5, 5);
        test(6, 6);
        test(7, 8);
        test(8, 9);
        test(9, 10);
        test(10, 12);
        test(11, 15);

        test(1500, 859963392);

        test(0, 0);
    }

    public static void main(String[] args) {
        UglyNumber number = new UglyNumber();

        number.mainTest();
    }
}
