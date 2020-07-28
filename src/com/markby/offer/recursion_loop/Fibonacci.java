package com.markby.offer.recursion_loop;

public class Fibonacci {

    /**
     * 运行时间：1123ms
     * 占用内存：9352k
     *
     * @param n
     * @return
     */
    int fibonacci1(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    /**
     * 运行时间：17ms
     * 占用内存：9248k
     *
     * @param n
     * @return
     */
    int fibonacci2(int n) {
        int[] result = {0, 1};
        if (n < 2)
            return result[n];

        int fibN = 0;
        int temp1 = 0;
        int temp2 = 1;
        while (n - 1 > 0) {
            fibN = temp1 + temp2;
            temp1 = temp2;
            temp2 = fibN;
            n--;
        }
        return fibN;
    }

    int fibonacci3(int n) {
        return 0;
    }

    // ====================测试代码====================
    void test(int n, int expected) {
//        if(fibonacci1(n) == expected)
//            System.out.printf("Test for %d in solution1 passed.\n", n);
//        else
//            System.out.printf("Test for %d in solution1 failed.\n", n);

        if (fibonacci2(n) == expected)
            System.out.printf("Test for %d in solution2 passed.\n", n);
        else
            System.out.printf("Test for %d in solution2 failed.\n", n);
//
//        if(fibonacci3(n) == expected)
//            System.out.printf("Test for %d in solution3 passed.\n", n);
//        else
//            System.out.printf("Test for %d in solution3 failed.\n", n);
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        f.test(0, 0);
        f.test(1, 1);
        f.test(2, 1);
        f.test(3, 2);
        f.test(4, 3);
        f.test(5, 5);
        f.test(6, 8);
        f.test(7, 13);
        f.test(8, 21);
        f.test(9, 34);
        f.test(10, 55);

        f.test(40, 102334155);

        System.out.println(f.fibonacci2(45));

    }

}
