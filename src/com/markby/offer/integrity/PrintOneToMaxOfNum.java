package com.markby.offer.integrity;

// 面试题17：打印1到最大的n位数
// 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
// 打印出1、2、3一直到最大的3位数即999。
public class PrintOneToMaxOfNum {
    // ====================方法一====================
    void print1ToMaxOfNDigits_1(int n) {
        if (n <= 0)
            return;

        char[] number = new char[n];
        for (int i = 0; i < number.length; i++)
            number[i] = '0';

        while (!increment(number)) {
            printNumber(number);
        }
    }

    // 字符串number表示一个数字，在 number上增加1
    // 如果做加法溢出，则返回true；否则为false
    boolean increment(char[] number) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = number.length;

        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLength - 1)
                nSum++;
            if (nSum >= 10) {
                if (i == 0)
                    isOverflow = true;
                else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                number[i] = (char) ('0' + nSum);
                break;
            }
        }

        return isOverflow;
    }

    // ====================方法二======================
    void print1ToMaxOfNDigits_2(int n) {
        if (n <= 0)
            return;

        char[] number = new char[n];

        for (int i = 0; i < 10; ++i) {
            number[0] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            if (Integer.valueOf(new String(number)) != 0) {
                printNumber(number);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    // ====================公共函数====================
    // 字符串number表示一个数字，数字有若干个0开头
    // 打印出这个数字，并忽略开头的0
    void printNumber(char[] number) {
        System.out.print(Integer.valueOf(new String(number)) + "\t");

    }
//    void PrintNumber(char[] number)
//    {
//        boolean isBeginning0 = true;
//        int nLength = number.length;
//
//        for (int i = 0; i < nLength; ++i)
//        {
//            if (isBeginning0 && number[i] != '0')
//                isBeginning0 = false;
//
//            if (!isBeginning0)
//            {
//                System.out.printf("%c", number[i]);
//            }
//        }
//
//        System.out.printf("\t");
//    }

    // ====================测试代码====================
    void test(int n) {
        System.out.printf("Test for %d begins:\n", n);

        print1ToMaxOfNDigits_1(n);
        System.out.println();
        print1ToMaxOfNDigits_2(n);

        System.out.printf("\nTest for %d ends.\n", n);
    }

    public static void main(String[] args) {

        PrintOneToMaxOfNum print = new PrintOneToMaxOfNum();
        print.test(1);
        print.test(2);
        print.test(3);
        print.test(0);
        print.test(-1);

    }

}
