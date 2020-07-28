package com.markby.offer.materialize_abstractproblem_with_examples;

// 面试题33：二叉搜索树的后序遍历序列
// 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
public class SquenceOfBST {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null)
            return false;

        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int start, int end) {
        if (start >= end)
            return true;

        // 在二叉搜索树中左子树的结点小于根结点
        int i = start;
        while (postorder[i] < postorder[end])
            i++;

        // 在二叉搜索树中右子树的结点大于根结点
        int j = i;
        while (j < end) {
            if (postorder[j++] < postorder[end])
                return false;
        }

        // 判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > start)
            left = verifyPostorder(postorder, start, i - 1);

        // 判断右子树是不是二叉搜索树
        boolean right = true;
        if (i < end - 1)
            right = verifyPostorder(postorder, i, end - 1);

        return left && right;
    }

    // ====================测试代码====================
    void test(String testName, int[] sequence, boolean expected) {
        if (testName != null)
            System.out.printf("%s begins: ", testName);

        if (verifyPostorder(sequence) == expected)
            System.out.printf("passed.\n");
        else
            System.out.printf("failed.\n");
    }

    void test0() {
        int data[] = {1, 2, 5, 10, 6, 9, 4, 3};
        test("Test0", data, false);

    }

    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    void test1() {
        int data[] = {4, 8, 6, 12, 16, 14, 10};
        test("Test1", data, true);
    }

    //           5
    //          / \
    //         4   7
    //            /
    //           6
    void test2() {
        int data[] = {4, 6, 7, 5};
        test("Test2", data, true);
    }

    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    void test3() {
        int data[] = {1, 2, 3, 4, 5};
        test("Test3", data, true);
    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    void test4() {
        int data[] = {5, 4, 3, 2, 1};
        test("Test4", data, true);
    }

    // 树中只有1个结点
    void test5() {
        int data[] = {5};
        test("Test5", data, true);
    }

    void test6() {
        int data[] = {7, 4, 6, 5};
        test("Test6", data, false);
    }

    void test7() {
        int data[] = {4, 6, 12, 8, 16, 14, 10};
        test("Test7", data, false);
    }

    void test8() {
        test("Test8", null, false);
    }

    void test9() {
        test("Test8", new int[0], true);
    }

    public static void main(String[] args) {
        SquenceOfBST bst = new SquenceOfBST();

        bst.test0();
        bst.test1();
        bst.test2();
        bst.test3();
        bst.test4();
        bst.test5();
        bst.test6();
        bst.test7();
        bst.test8();
        bst.test9();

    }

}
