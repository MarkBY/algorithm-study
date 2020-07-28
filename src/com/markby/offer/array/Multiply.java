package com.markby.offer.array;

public class Multiply {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};

        int[] result = multiply(A);
        for (int num : result) {
            System.out.println(num);
        }
    }

    /**
     * 运行时间：13ms
     * <p>
     * 占用内存：9396k
     *
     * @param A
     * @return
     */
    public static int[] multiply(int[] A) {
        int length = A.length;

        int[] result = new int[length];

        result[0] = 1;

        int temp = 1;
        for (int i = 0; i < length - 1; i++) {
            temp *= A[i];
            result[i + 1] = temp;
        }

        temp = 1;
        for (int i = length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            result[i] *= temp;
        }

        return result;
    }

    /**
     * 运行时间：14ms
     * <p>
     * 占用内存：9424k
     *
     * @param A
     * @return
     */
    public static int[] multiply1(int[] A) {
        int length = A.length;

        int[] result = new int[length];
        int[] T1 = new int[length];
        int[] T2 = new int[length];

        T1[0] = 1;
        T2[length - 1] = 1;

        int temp1 = 1;
        int temp2 = 1;
        for (int i = 0; i < length - 1; i++) {
            T1[i + 1] = temp1 * A[i];
            temp1 = T1[i + 1];

            T2[length - 2 - i] = temp2 * A[length - 1 - i];
            temp2 = T2[length - 2 - i];
        }

        for (int i = 0; i < length; i++) {
            result[i] = T1[i] * T2[i];
        }

        return result;
    }
}
