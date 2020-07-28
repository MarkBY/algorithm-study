package com.markby.offer.array;

public class Find {

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        boolean bool = find(5, array);
        System.out.println(bool);


    }

    /**
     * 左下角
     * <p>
     * 运行时间：138ms
     * 占用内存：16284k
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int[][] array) {
        if (array == null)
            return false;

        int row = array.length - 1;
        int col = 0;

        while (col <= array[0].length - 1 && row >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                col++;
            } else {
                row--;
            }
        }

        return false;
    }

    /**
     * 右上角
     * <p>
     * 运行时间：184ms
     * 占用内存：17764k
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean find1(int target, int[][] array) {
        if (array == null)
            return false;

        int row = 0;
        int col = array[0].length - 1;

        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }
}
