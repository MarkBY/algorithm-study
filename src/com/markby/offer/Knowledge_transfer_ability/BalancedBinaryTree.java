package com.markby.offer.Knowledge_transfer_ability;

import com.markby.offer.utils.BinaryTreeNode;

// 面试题55（二）：平衡二叉树
// 题目：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中
// 任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
public class BalancedBinaryTree {

    public boolean isBalanced(BinaryTreeNode root) {
        return recur(root) != -1;
    }

    private int recur(BinaryTreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


    // ====================测试代码====================
    void test(String testName, BinaryTreeNode pRoot, boolean expected) {
        if (testName != null)
            System.out.println(testName + " begins:\n");

        if (isBalanced(pRoot) == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("Failed.\n");

    }

    // 完全二叉树
    //             1
    //         /      \
    //        2        3
    //       /\       / \
    //      4  5     6   7
    void test1() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);
        BinaryTreeNode pNode7 = new BinaryTreeNode(7);

        BinaryTreeNode.connectTreeNodes(pNode1, pNode2, pNode3);
        BinaryTreeNode.connectTreeNodes(pNode2, pNode4, pNode5);
        BinaryTreeNode.connectTreeNodes(pNode3, pNode6, pNode7);

        test("test1", pNode1, true);
    }

    // 不是完全二叉树，但是平衡二叉树
    //             1
    //         /      \
    //        2        3
    //       /\         \
    //      4  5         6
    //        /
    //       7
    void test2() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);
        BinaryTreeNode pNode7 = new BinaryTreeNode(7);

        BinaryTreeNode.connectTreeNodes(pNode1, pNode2, pNode3);
        BinaryTreeNode.connectTreeNodes(pNode2, pNode4, pNode5);
        BinaryTreeNode.connectTreeNodes(pNode3, null, pNode6);
        BinaryTreeNode.connectTreeNodes(pNode5, pNode7, null);

        test("test2", pNode1, true);

    }

    // 不是平衡二叉树
    //             1
    //         /      \
    //        2        3
    //       /\
    //      4  5
    //        /
    //       6
    void test3() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);

        BinaryTreeNode.connectTreeNodes(pNode1, pNode2, pNode3);
        BinaryTreeNode.connectTreeNodes(pNode2, pNode4, pNode5);
        BinaryTreeNode.connectTreeNodes(pNode5, pNode6, null);

        test("test3", pNode1, false);
    }


    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    void test4() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNode1, pNode2, null);
        BinaryTreeNode.connectTreeNodes(pNode2, pNode3, null);
        BinaryTreeNode.connectTreeNodes(pNode3, pNode4, null);
        BinaryTreeNode.connectTreeNodes(pNode4, pNode5, null);

        test("test4", pNode1, false);

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
    void test5() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNode1, null, pNode2);
        BinaryTreeNode.connectTreeNodes(pNode2, null, pNode3);
        BinaryTreeNode.connectTreeNodes(pNode3, null, pNode4);
        BinaryTreeNode.connectTreeNodes(pNode4, null, pNode5);

        test("test5", pNode1, false);
    }

    // 树中只有1个结点
    void test6() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        test("test6", pNode1, true);

    }

    // 树中没有结点
    void test7() {
        test("test7", null, true);
    }

    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();

        tree.test1();
        tree.test2();
        tree.test3();
        tree.test4();
        tree.test5();
        tree.test6();
        tree.test7();
    }

}
