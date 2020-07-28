package com.markby.offer.recall;

// 面试题12：矩阵中的路径
// 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
// 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
// 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
// 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
// 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
// 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
// A B T G
// C F C S
// J D E H
public class StringPathInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null)
            return false;

        //标志位，初始化为false
        boolean[] visited = new boolean[rows * cols];

        int pathLength = 0;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited))
                    return true;
            }
        }
        return false;
    }

    //hasPathCore(初始矩阵，矩阵行数，矩阵列数，索引行坐标row，
    //          索引纵坐标col，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    public boolean hasPathCore(char[] matrix, int rows, int cols, int row,
                               int col, char[] str, int pathLength, boolean[] visited) {
        //先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = row * cols + col;

        //递归终止条件
        if (row < 0 || col < 0 || row >= rows || col >= cols ||
                matrix[index] != str[pathLength] || visited[index] == true)
            return false;

        //若pathLength已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if (pathLength == str.length - 1)
            return true;

        //要走的第一个位置置为true，表示已经走过了
        visited[index] = true;

        //回溯，递归寻找，每次找到了就给pathLength加一，找不到，还原
        if (hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength + 1, visited) ||
                hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength + 1, visited) ||
                hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength + 1, visited) ||
                hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength + 1, visited)) {
            return true;
        }

        //走到这，说明这一条路不通，还原，再试其他的路径
        visited[index] = false;
        return false;
    }

    // ====================测试代码====================
    void test(String testName, char[] matrix, int rows, int cols, char[] str, boolean expected) {
        if (testName != null)
            System.out.printf("%s begins: ", testName);

        if (hasPath(matrix, rows, cols, str) == expected)
            System.out.printf("Passed.\n");
        else
            System.out.printf("FAILED.\n");
    }

    //ABTG
    //CFCS
    //JDEH

    //BFCE
    void test1() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        char[] str = "BFCE".toCharArray();

        test("Test1", matrix, 3, 4, str, true);
    }

    //ABCE
    //SFCS
    //ADEE

    //SEE
    void test2() {
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "SEE".toCharArray();

        test("Test2", matrix, 3, 4, str, true);
    }

    //ABTG
    //CFCS
    //JDEH

    //ABFB
    void test3() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        char[] str = "ABFB".toCharArray();

        test("Test3", matrix, 3, 4, str, false);
    }

    //ABCEHJIG
    //SFCSLOPQ
    //ADEEMNOE
    //ADIDEJFM
    //VCEIFGGS

    //SLHECCEIDEJFGGFIE
    void test4() {
        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SLHECCEIDEJFGGFIE".toCharArray();

        test("Test4", matrix, 5, 8, str, true);
    }

    //ABCEHJIG
    //SFCSLOPQ
    //ADEEMNOE
    //ADIDEJFM
    //VCEIFGGS

    //SGGFIECVAASABCEHJIGQEM
    void test5() {
        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SGGFIECVAASABCEHJIGQEM".toCharArray();

        test("Test5", matrix, 5, 8, str, true);
    }

    //ABCEHJIG
    //SFCSLOPQ
    //ADEEMNOE
    //ADIDEJFM
    //VCEIFGGS

    //SGGFIECVAASABCEEJIGOEM
    void test6() {
        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SGGFIECVAASABCEEJIGOEM".toCharArray();

        test("Test6", matrix, 5, 8, str, false);
    }

    //ABCEHJIG
    //SFCSLOPQ
    //ADEEMNOE
    //ADIDEJFM
    //VCEIFGGS

    //SGGFIECVAASABCEHJIGQEMS
    void test7() {
        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SGGFIECVAASABCEHJIGQEMS".toCharArray();

        test("Test7", matrix, 5, 8, str, false);
    }

    //AAAA
    //AAAA
    //AAAA

    //AAAAAAAAAAAA
    void test8() {
        char[] matrix = "AAAAAAAAAAAA".toCharArray();
        char[] str = "AAAAAAAAAAAA".toCharArray();

        test("Test8", matrix, 3, 4, str, true);
    }

    //AAAA
    //AAAA
    //AAAA

    //AAAAAAAAAAAAA
    void test9() {
        char[] matrix = "AAAAAAAAAAAA".toCharArray();
        char[] str = "AAAAAAAAAAAAA".toCharArray();

        test("Test9", matrix, 3, 4, str, false);
    }

    //A

    //A
    void test10() {
        char[] matrix = "A".toCharArray();
        char[] str = "A".toCharArray();

        test("Test10", matrix, 1, 1, str, true);
    }

    //A

    //B
    void test11() {
        char[] matrix = "A".toCharArray();
        char[] str = "B".toCharArray();

        test("Test11", matrix, 1, 1, str, false);
    }

    void test12() {
        test("Test12", null, 0, 0, null, false);
    }

    public static void main(String[] args) {

        StringPathInMatrix path = new StringPathInMatrix();
        path.test1();
        path.test2();
        path.test3();
        path.test4();
        path.test5();
        path.test6();
        path.test7();
        path.test8();
        path.test9();
        path.test10();
        path.test11();
        path.test12();
    }

}
