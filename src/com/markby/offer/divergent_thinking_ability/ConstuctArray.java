package com.markby.offer.divergent_thinking_ability;

// 面试题66：构建乘积数组
// 题目：给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其
// 中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
public class ConstuctArray {

    public int[] constructArr(int[] a) {
        if(a.length == 0) return new int[0];

        int[] b = new int[a.length];
        b[0] = 1;

        for(int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }

        int tmp = 1;
        for(int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }

    public int[] constructArr1(int[] a) {
        if (a == null || a.length == 0)
            return new int[0];

        int[][] aux = new int[a.length][2];

        aux[0][0] = 1;
        aux[a.length - 1][1] = 1;
        for (int i = 1; i < a.length; i++) {
            int start = i;
            int end = a.length - start - 1;
            aux[start][0] = a[start - 1] * aux[start - 1][0];
            aux[end][1] = a[end + 1] * aux[end + 1][1];
        }

        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++)
            result[i] = aux[i][0] * aux[i][1];

        return result;
    }

    //================= Test Code =================
    boolean EqualArrays(int[] input, int[] expected) {
        int length1 = input.length;
        int length2 = expected.length;

        if (length1 != length2)
            return false;

        for (int i = 0; i < length1; ++i) {
            if (input[i] != expected[i])
                return false;
        }

        return true;
    }

    void test(String testName, int[] input, int[] expected) {
        System.out.println(testName + " Begins: ");

        int[] result = constructArr(input);
        if (EqualArrays(result, expected))
            System.out.println("Passed.\n");
        else
            System.out.println("FAILED.\n");
    }

    void test1() {
        // 输入数组中没有0
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {120, 60, 40, 30, 24};

        test("Test1", input, expected);

    }

    void test2() {
        // 输入数组中有一个0
        int[] input = {1, 2, 0, 4, 5};
        int[] expected = {0, 0, 40, 0, 0};

        test("Test2", input, expected);

    }

    void test3() {
        // 输入数组中有两个0
        int[] input = {1, 2, 0, 4, 0};
        int[] expected = {0, 0, 0, 0, 0};

        test("Test3", input, expected);
    }

    void test4() {
        // 输入数组中有正、负数
        int[] input = {1, -2, 3, -4, 5};
        int[] expected = {120, -60, 40, -30, 24};

        test("Test4", input, expected);
    }

    void test5() {
        // 输入输入中只有两个数字
        int[] input = {1, -2};
        int[] expected = {-2, 1};

        test("Test5", input, expected);
    }

    void mainTest() {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void main(String[] args) {
        ConstuctArray constuctArray = new ConstuctArray();

        constuctArray.mainTest();
    }
}
