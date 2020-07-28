package com.markby.offer.tree;

import com.markby.offer.utils.BinaryTreeNode;

public class ReConstructBinaryTree {
    /**
     * 递归
     * <p>
     * 运行时间：193ms
     * 占用内存：22772k
     *
     * @param pre
     * @param in
     * @return
     */
    public static BinaryTreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static BinaryTreeNode reConstructBinaryTree(
            int[] pre,
            int pre_start,
            int pre_end,
            int[] in,
            int in_start,
            int in_end) {

        if (pre_start > pre_end || in_start > in_end) {
            return null;
        }
        BinaryTreeNode t = new BinaryTreeNode(pre[pre_start]);
        for (int i = in_start; i <= in_end; i++) {
            if (pre[pre_start] == in[i]) {

                t.left = reConstructBinaryTree(
                        pre,
                        pre_start + 1,
                        pre_start + i - in_start,
                        in,
                        in_start,
                        i - 1);
                t.right = reConstructBinaryTree(
                        pre,
                        i - in_start + pre_start + 1,
                        pre_end,
                        in,
                        i + 1,
                        in_end);
            }

        }

        return t;
    }

    // ====================测试代码====================
    private static void test(String testName, int[] preOrder, int[] inOrder, int length) {
        if (testName != null)
            System.out.printf("%s begins:\n", testName);

        System.out.printf("The preOrder sequence is: ");
        for (int i = 0; i < length; ++i)
            System.out.printf("%d ", preOrder[i]);
        System.out.printf("\n");

        System.out.printf("The inOrder sequence is: ");
        for (int i = 0; i < length; ++i)
            System.out.printf("%d ", inOrder[i]);
        System.out.printf("\n");


        BinaryTreeNode root = reConstructBinaryTree(preOrder, inOrder);
        BinaryTreeNode.printTree(root);
    }

    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static void test1() {

        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};

        test("test1", preOrder, inOrder, preOrder.length);
    }

    public static void main(String[] args) {
        test1();
    }

}
