package com.markby.offer.visualize_abstractproblem_by_drawing;

// 面试题29：顺时针打印矩阵
// 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
public class PrintMatrix {

    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return new int[0];

        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        int[] result = new int[(bottom + 1) * (right + 1)];
        int index = 0;


        while (true) {
            // 从左上向右上打印
            for (int i = left; i <= right; i++)
                result[index++] = matrix[left][i];
            if (++top > bottom) break;
            // 从右上向右下打印
            for (int i = top; i <= bottom; i++)
                result[index++] = matrix[i][right];
            if (--right < left) break;
            // 从右下向左下打印
            for (int i = right; i >= left; i--)
                result[index++] = matrix[bottom][i];
            if (--bottom < top) break;
            // 从左下向左上打印
            for (int i = bottom; i >= top; i--)
                result[index++] = matrix[i][left];
            if (++left > right) break;
        }
//        int start = 0;
//        while (columns >start * 2 && rows > start * 2){
//
//            int endX = columns - 1 - start;
//            int endY = rows - 1 - start;
//
//            // 从左上向右上打印
//            for (int i = start; i <= endX; i++){
//                result[index++] = matrix[start][i];
//            }
//
//            // 从右上向右下打印
//            if (endY > start)
//                for (int i = start +1; i <= endY; i++){
//                    result[index++] = matrix[i][endX];
//                }
//
//            // 从右下向左下打印
//            if (endX > start && endY > start)
//                for (int i = endX - 1; i >= start; i--){
//                    result[index++] = matrix[endY][i];
//                }
//
//            // 从左下向左上打印
//            if (endX > start && endY > start)
//                for (int i = endY - 1; i >= start+1; i--){
//                    result[index++] = matrix[i][start];
//                }
//
//            start++;
//        }

        return result;
    }

    // ====================测试代码====================
    void test(int columns, int rows) {
        System.out.printf("Test Begin: %d columns, %d rows.\n", columns, rows);

        if (columns < 1 || rows < 1)
            return;

        int[][] numbers = new int[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                numbers[i][j] = i * columns + j + 1;
            }
        }

        int[] result = spiralOrder(numbers);

        for (int num : result) {
            System.out.print(num + ", ");
        }

        System.out.printf("\n");


    }

    public static void main(String[] args) {

        PrintMatrix matrix = new PrintMatrix();
        /*
        1
        */
        matrix.test(1, 1);

        /*
        1    2
        3    4
        */
        matrix.test(2, 2);

        /*
        1    2    3    4
        5    6    7    8
        9    10   11   12
        13   14   15   16
        */
        matrix.test(4, 4);

        /*
        1    2    3    4    5
        6    7    8    9    10
        11   12   13   14   15
        16   17   18   19   20
        21   22   23   24   25
        */
        matrix.test(5, 5);

        /*
        1
        2
        3
        4
        5
        */
        matrix.test(1, 5);

        /*
        1    2
        3    4
        5    6
        7    8
        9    10
        */
        matrix.test(2, 5);

        /*
        1    2    3
        4    5    6
        7    8    9
        10   11   12
        13   14   15
        */
        matrix.test(3, 5);

        /*
        1    2    3    4
        5    6    7    8
        9    10   11   12
        13   14   15   16
        17   18   19   20
        */
        matrix.test(4, 5);

        /*
        1    2    3    4    5
        */
        matrix.test(5, 1);

        /*
        1    2    3    4    5
        6    7    8    9    10
        */
        matrix.test(5, 2);

        /*
        1    2    3    4    5
        6    7    8    9    10
        11   12   13   14    15
        */
        matrix.test(5, 3);

        /*
        1    2    3    4    5
        6    7    8    9    10
        11   12   13   14   15
        16   17   18   19   20
        */
        matrix.test(5, 4);
    }

}
