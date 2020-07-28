package com.markby.offer.Knowledge_transfer_ability;

import com.markby.offer.utils.BinaryTreeNode;

// 面试题55（一）：二叉树的深度
// 题目：输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过的
// 结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
public class TreeDepth {

    public int maxDepth(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;

        return Math.max(left, right);
    }

    // ====================测试代码====================
    void test(String testName, BinaryTreeNode pRoot, int expected) {
        int result = maxDepth(pRoot);
        if (expected == result)
            System.out.println(testName + " passed.\n");
        else
            System.out.println(testName + " FAILED.\n");
    }

    //            1
    //         /      \
    //        2        3
    //       /\         \
    //      4  5         6
    //        /
    //       7
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
        BinaryTreeNode.connectTreeNodes(pNode3, null, pNode6);
        BinaryTreeNode.connectTreeNodes(pNode5, pNode7, null);

        test("test1", pNode1, 4);

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
    void test2() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNode1, pNode2, null);
        BinaryTreeNode.connectTreeNodes(pNode2, pNode3, null);
        BinaryTreeNode.connectTreeNodes(pNode3, pNode4, null);
        BinaryTreeNode.connectTreeNodes(pNode4, pNode5, null);

        test("test2", pNode1, 5);

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
    void test3() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNode1, null, pNode2);
        BinaryTreeNode.connectTreeNodes(pNode2, null, pNode3);
        BinaryTreeNode.connectTreeNodes(pNode3, null, pNode4);
        BinaryTreeNode.connectTreeNodes(pNode4, null, pNode5);

        test("test3", pNode1, 5);
    }

    // 树中只有1个结点
    void test4() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        test("test4", pNode1, 1);

    }

    // 树中没有结点
    void test5() {
        test("test5", null, 0);
    }

    public static void main(String[] args) {
        TreeDepth depth = new TreeDepth();

        depth.test1();
        depth.test2();
        depth.test3();
        depth.test4();
        depth.test5();
    }
}
