package com.markby.offer.materialize_abstractproblem_with_examples;

import com.markby.offer.utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 面试题32（一）：不分行从上往下打印二叉树
// 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
public class PrintTreeFromTopToBottom {

    public int[] levelOrder(BinaryTreeNode root) {
        if (root == null)
            return new int[0];

        Queue<BinaryTreeNode> treeNodeQueue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            BinaryTreeNode temp = treeNodeQueue.remove();
            list.add(temp.val);

            if (temp.left != null)
                treeNodeQueue.add(temp.left);

            if (temp.right != null)
                treeNodeQueue.add(temp.right);
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    // ====================测试代码====================
    void test(String testName, BinaryTreeNode pRoot) {
        if (testName != null)
            System.out.printf("%s begins: \n", testName);

        BinaryTreeNode.printTree(pRoot);

        System.out.print("The nodes from top to bottom, from left to right are: \n");
        int[] level = levelOrder(pRoot);


        for (int num : level) {
            System.out.print(num + ", ");
        }

        System.out.print("\n\n");
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

        test("Test1", pNode10);

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

        test("Test2", pNode5);

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

        test("Test3", pNode1);
    }

    // 树中只有1个结点
    void test4() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        test("Test4", pNode1);

    }

    // 树中没有结点
    void test5() {
        test("Test5", null);
    }

    public static void main(String[] args) {
        PrintTreeFromTopToBottom tree = new PrintTreeFromTopToBottom();

        tree.test1();
        tree.test2();
        tree.test3();
        tree.test4();
        tree.test5();
    }

}
