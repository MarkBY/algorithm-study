package com.markby.offer.bitOperation;

public class NumberOf1InBinary {
    public int numberOf1(int n) {

        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public int numberOf1_1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    // ====================测试代码====================
    void test(int number, int expected) {
        int actual = numberOf1(number);
        if (actual == expected)
            System.out.printf("Solution1: Test for %d passed.\n", number);
        else
            System.out.printf("Solution1: Test for %d failed.\n", number);

        actual = numberOf1_1(number);
        if (actual == expected)
            System.out.printf("Solution2: Test for %d passed.\n", number);
        else
            System.out.printf("Solution2: Test for %d failed.\n", number);

        System.out.println();
    }

    public static void main(String[] args) {
        NumberOf1InBinary number = new NumberOf1InBinary();

        // 输入0，期待的输出是0
        number.test(0, 0);

        // 输入1，期待的输出是1
        number.test(1, 1);

        // 输入10，期待的输出是2
        number.test(10, 2);

        // 输入0x7FFFFFFF，期待的输出是31
        number.test(0x7FFFFFFF, 31);

        // 输入0xFFFFFFFF（负数），期待的输出是32
        number.test(0xFFFFFFFF, 32);

        // 输入0x80000000（负数），期待的输出是1
        number.test(0x80000000, 1);
    }
}
