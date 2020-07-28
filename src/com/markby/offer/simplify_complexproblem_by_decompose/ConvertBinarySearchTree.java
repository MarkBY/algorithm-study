package com.markby.offer.simplify_complexproblem_by_decompose;

import com.markby.offer.utils.BinaryTreeNode;

// 面试题36：二叉搜索树与双向链表
// 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求
// 不能创建任何新的结点，只能调整树中结点指针的指向。
public class ConvertBinarySearchTree {

    BinaryTreeNode pre, head;

    BinaryTreeNode Convert(BinaryTreeNode root) {
        if (root == null) return null;
        convertNode(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void convertNode(BinaryTreeNode cur) {
        if (cur == null) return;
        convertNode(cur.left);
        if (pre == null) head = cur;
        else pre.right = cur;
        cur.left = pre;
        pre = cur;

        convertNode(cur.right);
    }

    // ====================测试代码====================
    void PrintDoubleLinkedList(BinaryTreeNode pHeadOfList) {
        if (pHeadOfList == null) {
            System.out.println("The nodes is null.");
            return;
        }
        BinaryTreeNode pNode = pHeadOfList;

        System.out.printf("The nodes from left to right are:\n");
        while (true) {
            System.out.printf("%d\t", pNode.val);

            if (pNode.right == pHeadOfList)
                break;
            pNode = pNode.right;
        }

        System.out.printf("\nThe nodes from right to left are:\n");
        while (true) {
            System.out.printf("%d\t", pNode.val);

            if (pNode.left == pHeadOfList)
                break;
            pNode = pNode.left;
        }

        System.out.printf("\n");
    }


    void test(String testName, BinaryTreeNode pRootOfTree) {
        if (testName != null)
            System.out.printf("%s begins:\n", testName);

        BinaryTreeNode.printTree(pRootOfTree);

        BinaryTreeNode pHeadOfList = Convert(pRootOfTree);

        PrintDoubleLinkedList(pHeadOfList);
        head = null;
        pre = null;
    }

    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    void test1() {
        BinaryTreeNode pNode10 = new BinaryTreeNode(10);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);
        BinaryTreeNode pNode14 = new BinaryTreeNode(14);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode12 = new BinaryTreeNode(12);
        BinaryTreeNode pNode16 = new BinaryTreeNode(16);

        BinaryTreeNode.connectTreeNodes(pNode10, pNode6, pNode14);
        BinaryTreeNode.connectTreeNodes(pNode6, pNode4, pNode8);
        BinaryTreeNode.connectTreeNodes(pNode14, pNode12, pNode16);

        test("test1", pNode10);

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
    void test2() {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);

        BinaryTreeNode.connectTreeNodes(pNode5, pNode4, null);
        BinaryTreeNode.connectTreeNodes(pNode4, pNode3, null);
        BinaryTreeNode.connectTreeNodes(pNode3, pNode2, null);
        BinaryTreeNode.connectTreeNodes(pNode2, pNode1, null);

        test("test2", pNode5);

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

        test("test3", pNode1);
    }

    // 树中只有1个结点
    void test4() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        test("test4", pNode1);
    }

    // 树中没有结点
    void test5() {
        test("test5", null);
    }

    public static void main(String[] args) {
        ConvertBinarySearchTree tree = new ConvertBinarySearchTree();

        tree.test1();
        tree.test2();
        tree.test3();
        tree.test4();
        tree.test5();

    }

}
