package com.markby.offer.visualize_abstractproblem_by_drawing;


import com.markby.offer.utils.BinaryTreeNode;

// 面试题28：对称的二叉树
// 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和
// 它的镜像一样，那么它是对称的。
public class SymmetricalBinaryTree {
    public boolean isSymmetrical(BinaryTreeNode root) {
        if (root == null)
            return true;

        return isSymmetrical(root.left, root.right);
    }

    public boolean isSymmetrical(BinaryTreeNode pLeft, BinaryTreeNode pRight) {
        if (pLeft == null && pRight == null)
            return true;
        else if ((pLeft == null && pRight != null) || (pLeft != null && pRight == null))
            return false;
        else if (pLeft.val != pRight.val)
            return false;

        return isSymmetrical(pLeft.left, pRight.right) && isSymmetrical(pLeft.right, pRight.left);
    }

    // ====================测试代码====================
    void test(String testName, BinaryTreeNode pRoot, boolean expected) {
        if (testName != null)
            System.out.printf("%s begins: ", testName);

        if (isSymmetrical(pRoot) == expected)
            System.out.printf("Passed.\n");
        else
            System.out.printf("FAILED.\n");
    }

    //            8
    //        6      6
    //       5 7    7 5
    void test1() {
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode61 = new BinaryTreeNode(6);
        BinaryTreeNode pNode62 = new BinaryTreeNode(6);
        BinaryTreeNode pNode51 = new BinaryTreeNode(5);
        BinaryTreeNode pNode71 = new BinaryTreeNode(7);
        BinaryTreeNode pNode72 = new BinaryTreeNode(7);
        BinaryTreeNode pNode52 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNode8, pNode61, pNode62);
        BinaryTreeNode.connectTreeNodes(pNode61, pNode51, pNode71);
        BinaryTreeNode.connectTreeNodes(pNode62, pNode72, pNode52);

        test("Test1", pNode8, true);

    }

    //            8
    //        6      9
    //       5 7    7 5
    void test2() {
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode61 = new BinaryTreeNode(6);
        BinaryTreeNode pNode9 = new BinaryTreeNode(9);
        BinaryTreeNode pNode51 = new BinaryTreeNode(5);
        BinaryTreeNode pNode71 = new BinaryTreeNode(7);
        BinaryTreeNode pNode72 = new BinaryTreeNode(7);
        BinaryTreeNode pNode52 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNode8, pNode61, pNode9);
        BinaryTreeNode.connectTreeNodes(pNode61, pNode51, pNode71);
        BinaryTreeNode.connectTreeNodes(pNode9, pNode72, pNode52);

        test("Test2", pNode8, false);

    }

    //            8
    //        6      6
    //       5 7    7
    void test3() {
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode61 = new BinaryTreeNode(6);
        BinaryTreeNode pNode62 = new BinaryTreeNode(6);
        BinaryTreeNode pNode51 = new BinaryTreeNode(5);
        BinaryTreeNode pNode71 = new BinaryTreeNode(7);
        BinaryTreeNode pNode72 = new BinaryTreeNode(7);

        BinaryTreeNode.connectTreeNodes(pNode8, pNode61, pNode62);
        BinaryTreeNode.connectTreeNodes(pNode61, pNode51, pNode71);
        BinaryTreeNode.connectTreeNodes(pNode62, pNode72, null);

        test("Test3", pNode8, false);
    }

    //               5
    //              / \
    //             3   3
    //            /     \
    //           4       4
    //          /         \
    //         2           2
    //        /             \
    //       1               1
    void test4() {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode31 = new BinaryTreeNode(3);
        BinaryTreeNode pNode32 = new BinaryTreeNode(3);
        BinaryTreeNode pNode41 = new BinaryTreeNode(4);
        BinaryTreeNode pNode42 = new BinaryTreeNode(4);
        BinaryTreeNode pNode21 = new BinaryTreeNode(2);
        BinaryTreeNode pNode22 = new BinaryTreeNode(2);
        BinaryTreeNode pNode11 = new BinaryTreeNode(1);
        BinaryTreeNode pNode12 = new BinaryTreeNode(1);

        BinaryTreeNode.connectTreeNodes(pNode5, pNode31, pNode32);
        BinaryTreeNode.connectTreeNodes(pNode31, pNode41, null);
        BinaryTreeNode.connectTreeNodes(pNode32, null, pNode42);
        BinaryTreeNode.connectTreeNodes(pNode41, pNode21, null);
        BinaryTreeNode.connectTreeNodes(pNode42, null, pNode22);
        BinaryTreeNode.connectTreeNodes(pNode21, pNode11, null);
        BinaryTreeNode.connectTreeNodes(pNode22, null, pNode12);

        test("Test4", pNode5, true);

    }


    //               5
    //              / \
    //             3   3
    //            /     \
    //           4       4
    //          /         \
    //         6           2
    //        /             \
    //       1               1
    void test5() {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode31 = new BinaryTreeNode(3);
        BinaryTreeNode pNode32 = new BinaryTreeNode(3);
        BinaryTreeNode pNode41 = new BinaryTreeNode(4);
        BinaryTreeNode pNode42 = new BinaryTreeNode(4);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);
        BinaryTreeNode pNode22 = new BinaryTreeNode(2);
        BinaryTreeNode pNode11 = new BinaryTreeNode(1);
        BinaryTreeNode pNode12 = new BinaryTreeNode(1);

        BinaryTreeNode.connectTreeNodes(pNode5, pNode31, pNode32);
        BinaryTreeNode.connectTreeNodes(pNode31, pNode41, null);
        BinaryTreeNode.connectTreeNodes(pNode32, null, pNode42);
        BinaryTreeNode.connectTreeNodes(pNode41, pNode6, null);
        BinaryTreeNode.connectTreeNodes(pNode42, null, pNode22);
        BinaryTreeNode.connectTreeNodes(pNode6, pNode11, null);
        BinaryTreeNode.connectTreeNodes(pNode22, null, pNode12);

        test("Test5", pNode5, false);

    }

    //               5
    //              / \
    //             3   3
    //            /     \
    //           4       4
    //          /         \
    //         2           2
    //                      \
    //                       1
    void test6() {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode31 = new BinaryTreeNode(3);
        BinaryTreeNode pNode32 = new BinaryTreeNode(3);
        BinaryTreeNode pNode41 = new BinaryTreeNode(4);
        BinaryTreeNode pNode42 = new BinaryTreeNode(4);
        BinaryTreeNode pNode21 = new BinaryTreeNode(2);
        BinaryTreeNode pNode22 = new BinaryTreeNode(2);
        BinaryTreeNode pNode12 = new BinaryTreeNode(1);

        BinaryTreeNode.connectTreeNodes(pNode5, pNode31, pNode32);
        BinaryTreeNode.connectTreeNodes(pNode31, pNode41, null);
        BinaryTreeNode.connectTreeNodes(pNode32, null, pNode42);
        BinaryTreeNode.connectTreeNodes(pNode41, pNode21, null);
        BinaryTreeNode.connectTreeNodes(pNode42, null, pNode22);
        BinaryTreeNode.connectTreeNodes(pNode21, null, null);
        BinaryTreeNode.connectTreeNodes(pNode22, null, pNode12);

        test("Test6", pNode5, false);
    }

    // 只有一个结点
    void test7() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        test("Test7", pNode1, true);
    }

    // 没有结点
    void test8() {
        test("Test8", null, true);
    }

    // 所有结点都有相同的值，树对称
    //               5
    //              / \
    //             5   5
    //            /     \
    //           5       5
    //          /         \
    //         5           5
    void test9() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(5);
        BinaryTreeNode pNode21 = new BinaryTreeNode(5);
        BinaryTreeNode pNode22 = new BinaryTreeNode(5);
        BinaryTreeNode pNode31 = new BinaryTreeNode(5);
        BinaryTreeNode pNode32 = new BinaryTreeNode(5);
        BinaryTreeNode pNode41 = new BinaryTreeNode(5);
        BinaryTreeNode pNode42 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNode1, pNode21, pNode22);
        BinaryTreeNode.connectTreeNodes(pNode21, pNode31, null);
        BinaryTreeNode.connectTreeNodes(pNode22, null, pNode32);
        BinaryTreeNode.connectTreeNodes(pNode31, pNode41, null);
        BinaryTreeNode.connectTreeNodes(pNode32, null, pNode42);
        BinaryTreeNode.connectTreeNodes(pNode41, null, null);
        BinaryTreeNode.connectTreeNodes(pNode42, null, null);

        test("Test9", pNode1, true);

    }

    // 所有结点都有相同的值，树不对称
    //               5
    //              / \
    //             5   5
    //            /     \
    //           5       5
    //          /       /
    //         5       5
    void test10() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(5);
        BinaryTreeNode pNode21 = new BinaryTreeNode(5);
        BinaryTreeNode pNode22 = new BinaryTreeNode(5);
        BinaryTreeNode pNode31 = new BinaryTreeNode(5);
        BinaryTreeNode pNode32 = new BinaryTreeNode(5);
        BinaryTreeNode pNode41 = new BinaryTreeNode(5);
        BinaryTreeNode pNode42 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNode1, pNode21, pNode22);
        BinaryTreeNode.connectTreeNodes(pNode21, pNode31, null);
        BinaryTreeNode.connectTreeNodes(pNode22, null, pNode32);
        BinaryTreeNode.connectTreeNodes(pNode31, pNode41, null);
        BinaryTreeNode.connectTreeNodes(pNode32, pNode42, null);
        BinaryTreeNode.connectTreeNodes(pNode41, null, null);
        BinaryTreeNode.connectTreeNodes(pNode42, null, null);

        test("Test10", pNode1, false);
    }

    public static void main(String[] args) {
        SymmetricalBinaryTree tree = new SymmetricalBinaryTree();

        tree.test1();
        tree.test2();
        tree.test3();
        tree.test4();
        tree.test5();
        tree.test6();
        tree.test7();
        tree.test8();
        tree.test9();
        tree.test10();
    }

}
