package com.markby.offer.robustness;

import com.markby.offer.utils.BinaryTreeNode;

// 面试题26：树的子结构
// 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
public class SubstructureInTree {

    public boolean isSubStructure(BinaryTreeNode A, BinaryTreeNode B) {
        return (A != null && B != null) && (isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));

//        if (A == null || B == null)
//            return false;
//
//        if (isSame(A, B) == true)
//            return true;
//
//        boolean boolRight = false;
//        boolean boolLeft = false;
//
//
//        boolRight = isSubStructure(A.right, B);
//
//        boolLeft = isSubStructure(A.left, B);
//
//        return boolLeft || boolRight;
    }

    public boolean isSame(BinaryTreeNode A, BinaryTreeNode B) {
        if (B == null)
            return true;

        if (A == null || A.val != B.val)
            return false;

        return isSame(A.right, B.right) && isSame(A.left, B.left);
    }

    // ====================测试代码====================
    void test(String testName, BinaryTreeNode pRoot1, BinaryTreeNode pRoot2, boolean expected) {
        if (isSubStructure(pRoot1, pRoot2) == expected)
            System.out.printf("%s passed.\n", testName);
        else
            System.out.printf("%s failed.\n", testName);
    }

    // 树中结点含有分叉，树B是树A的子结构
    //                  8                8
    //              /       \           / \
    //             8         7         9   2
    //           /   \
    //          9     2
    //               / \
    //              4   7
    void test1() {
        BinaryTreeNode pNodeA1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = new BinaryTreeNode(7);
        BinaryTreeNode pNodeA4 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeA5 = new BinaryTreeNode(2);
        BinaryTreeNode pNodeA6 = new BinaryTreeNode(4);
        BinaryTreeNode pNodeA7 = new BinaryTreeNode(7);

        BinaryTreeNode.connectTreeNodes(pNodeA1, pNodeA2, pNodeA3);
        BinaryTreeNode.connectTreeNodes(pNodeA2, pNodeA4, pNodeA5);
        BinaryTreeNode.connectTreeNodes(pNodeA5, pNodeA6, pNodeA7);

        BinaryTreeNode pNodeB1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = new BinaryTreeNode(2);

        BinaryTreeNode.connectTreeNodes(pNodeB1, pNodeB2, pNodeB3);

        test("Test1", pNodeA1, pNodeB1, true);

    }

    // 树中结点含有分叉，树B不是树A的子结构
    //                  8                8
    //              /       \           / \
    //             8         7         9   2
    //           /   \
    //          9     3
    //               / \
    //              4   7
    void test2() {
        BinaryTreeNode pNodeA1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = new BinaryTreeNode(7);
        BinaryTreeNode pNodeA4 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeA5 = new BinaryTreeNode(3);
        BinaryTreeNode pNodeA6 = new BinaryTreeNode(4);
        BinaryTreeNode pNodeA7 = new BinaryTreeNode(7);

        BinaryTreeNode.connectTreeNodes(pNodeA1, pNodeA2, pNodeA3);
        BinaryTreeNode.connectTreeNodes(pNodeA2, pNodeA4, pNodeA5);
        BinaryTreeNode.connectTreeNodes(pNodeA5, pNodeA6, pNodeA7);

        BinaryTreeNode pNodeB1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = new BinaryTreeNode(2);

        BinaryTreeNode.connectTreeNodes(pNodeB1, pNodeB2, pNodeB3);

        test("Test2", pNodeA1, pNodeB1, false);

    }

    // 树中结点只有左子结点，树B是树A的子结构
    //                8                  8
    //              /                   /
    //             8                   9
    //           /                    /
    //          9                    2
    //         /
    //        2
    //       /
    //      5
    void test3() {
        BinaryTreeNode pNodeA1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeA4 = new BinaryTreeNode(2);
        BinaryTreeNode pNodeA5 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNodeA1, pNodeA2, null);
        BinaryTreeNode.connectTreeNodes(pNodeA2, pNodeA3, null);
        BinaryTreeNode.connectTreeNodes(pNodeA3, pNodeA4, null);
        BinaryTreeNode.connectTreeNodes(pNodeA4, pNodeA5, null);

        BinaryTreeNode pNodeB1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = new BinaryTreeNode(2);

        BinaryTreeNode.connectTreeNodes(pNodeB1, pNodeB2, null);
        BinaryTreeNode.connectTreeNodes(pNodeB2, pNodeB3, null);

        test("Test3", pNodeA1, pNodeB1, true);

    }

    // 树中结点只有左子结点，树B不是树A的子结构
    //                8                  8
    //              /                   /
    //             8                   9
    //           /                    /
    //          9                    3
    //         /
    //        2
    //       /
    //      5
    void test4() {
        BinaryTreeNode pNodeA1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeA4 = new BinaryTreeNode(2);
        BinaryTreeNode pNodeA5 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNodeA1, pNodeA2, null);
        BinaryTreeNode.connectTreeNodes(pNodeA2, pNodeA3, null);
        BinaryTreeNode.connectTreeNodes(pNodeA3, pNodeA4, null);
        BinaryTreeNode.connectTreeNodes(pNodeA4, pNodeA5, null);

        BinaryTreeNode pNodeB1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = new BinaryTreeNode(3);

        BinaryTreeNode.connectTreeNodes(pNodeB1, pNodeB2, null);
        BinaryTreeNode.connectTreeNodes(pNodeB2, pNodeB3, null);

        test("Test4", pNodeA1, pNodeB1, false);

    }

    // 树中结点只有右子结点，树B是树A的子结构
    //       8                   8
    //        \                   \
    //         8                   9
    //          \                   \
    //           9                   2
    //            \
    //             2
    //              \
    //               5
    void test5() {
        BinaryTreeNode pNodeA1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeA4 = new BinaryTreeNode(2);
        BinaryTreeNode pNodeA5 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNodeA1, null, pNodeA2);
        BinaryTreeNode.connectTreeNodes(pNodeA2, null, pNodeA3);
        BinaryTreeNode.connectTreeNodes(pNodeA3, null, pNodeA4);
        BinaryTreeNode.connectTreeNodes(pNodeA4, null, pNodeA5);

        BinaryTreeNode pNodeB1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = new BinaryTreeNode(2);

        BinaryTreeNode.connectTreeNodes(pNodeB1, null, pNodeB2);
        BinaryTreeNode.connectTreeNodes(pNodeB2, null, pNodeB3);

        test("Test5", pNodeA1, pNodeB1, true);

    }

    // 树A中结点只有右子结点，树B不是树A的子结构
    //       8                   8
    //        \                   \
    //         8                   9
    //          \                 / \
    //           9               3   2
    //            \
    //             2
    //              \
    //               5
    void test6() {
        BinaryTreeNode pNodeA1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeA4 = new BinaryTreeNode(2);
        BinaryTreeNode pNodeA5 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNodeA1, null, pNodeA2);
        BinaryTreeNode.connectTreeNodes(pNodeA2, null, pNodeA3);
        BinaryTreeNode.connectTreeNodes(pNodeA3, null, pNodeA4);
        BinaryTreeNode.connectTreeNodes(pNodeA4, null, pNodeA5);

        BinaryTreeNode pNodeB1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = new BinaryTreeNode(3);
        BinaryTreeNode pNodeB4 = new BinaryTreeNode(2);

        BinaryTreeNode.connectTreeNodes(pNodeB1, null, pNodeB2);
        BinaryTreeNode.connectTreeNodes(pNodeB2, pNodeB3, pNodeB4);

        test("Test6", pNodeA1, pNodeB1, false);

    }

    // 树A为空树
    void test7() {
        BinaryTreeNode pNodeB1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = new BinaryTreeNode(3);
        BinaryTreeNode pNodeB4 = new BinaryTreeNode(2);

        BinaryTreeNode.connectTreeNodes(pNodeB1, null, pNodeB2);
        BinaryTreeNode.connectTreeNodes(pNodeB2, pNodeB3, pNodeB4);

        test("Test7", null, pNodeB1, false);

    }

    // 树B为空树
    void test8() {
        BinaryTreeNode pNodeA1 = new BinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = new BinaryTreeNode(9);
        BinaryTreeNode pNodeA3 = new BinaryTreeNode(3);
        BinaryTreeNode pNodeA4 = new BinaryTreeNode(2);

        BinaryTreeNode.connectTreeNodes(pNodeA1, null, pNodeA2);
        BinaryTreeNode.connectTreeNodes(pNodeA2, pNodeA3, pNodeA4);

        test("Test8", pNodeA1, null, false);

    }

    // 树A和树B都为空
    void test9() {
        test("Test9", null, null, false);
    }

    // 树A和树B都为空
    //       1                   3
    //      / \
    //     2   3
    //    /
    //   4
    void test10() {
        BinaryTreeNode pNodeA1 = new BinaryTreeNode(1);
        BinaryTreeNode pNodeA2 = new BinaryTreeNode(2);
        BinaryTreeNode pNodeA3 = new BinaryTreeNode(3);
        BinaryTreeNode pNodeA4 = new BinaryTreeNode(4);

        BinaryTreeNode.connectTreeNodes(pNodeA1, pNodeA2, pNodeA3);
        BinaryTreeNode.connectTreeNodes(pNodeA2, pNodeA4, null);

        BinaryTreeNode pNodeB1 = new BinaryTreeNode(8);

        test("Test10", pNodeA1, pNodeB1, false);
    }

    public static void main(String[] args) {
        SubstructureInTree tree = new SubstructureInTree();

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
