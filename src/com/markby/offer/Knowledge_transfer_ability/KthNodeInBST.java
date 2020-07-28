package com.markby.offer.Knowledge_transfer_ability;

import com.markby.offer.utils.BinaryTreeNode;

// 面试题54：二叉搜索树的第k个结点
// 题目：给定一棵二叉搜索树，请找出其中的第k大的结点。
public class KthNodeInBST {

    int k;

    public int kthLargest(BinaryTreeNode root, int k) {
        this.k = k;
        BinaryTreeNode pNode = visit(root);

        return pNode.val;
    }

    BinaryTreeNode visit(BinaryTreeNode root) {
        BinaryTreeNode target = null;
        if (root.right != null)
            target = visit(root.right);
        if (target == null) {
            k--;
            if (k == 0)
                target = root;
        }
        if (target == null && root.left != null)
            target = visit(root.left);

        return target;
    }

    // ====================测试代码====================
    void test(String testName, BinaryTreeNode pRoot, int k, int expected) {
        if (testName != null)
            System.out.println(testName + " begins: ");

        int target = kthLargest(pRoot, k);
        System.out.println(target);
        if (target == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("FAILED.\n");
    }

    //         3
    //        / \
    //       1   4
    //        \
    //         2
    void test1() {
        String testName = "test1";
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);

        BinaryTreeNode.connectTreeNodes(pNode3, pNode1, pNode4);
        BinaryTreeNode.connectTreeNodes(pNode1, null, pNode2);

        test(testName, pNode3, 1, 4);

    }

    //       5
    //      / \
    //     3   6
    //    / \
    //   2   4
    //  /
    // 1
    void test2() {
        String testName = "test2";
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);

        BinaryTreeNode.connectTreeNodes(pNode5, pNode3, pNode6);
        BinaryTreeNode.connectTreeNodes(pNode3, pNode2, pNode4);
        BinaryTreeNode.connectTreeNodes(pNode2, pNode1, null);

        test(testName, pNode5, 3, 4);

    }


    public static void main(String[] args) {
        KthNodeInBST node = new KthNodeInBST();

        node.test1();
        node.test2();
    }

}
