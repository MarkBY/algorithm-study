package com.markby.offer.materialize_abstractproblem_with_examples;

import com.markby.offer.utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 面试题32（二）：分行从上到下打印二叉树
// 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层
// 打印到一行。
public class PrintTreesInLines {
    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();

        Queue<BinaryTreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> levelList = new ArrayList<>();
        int printRemain = 1;
        int nextLevel = 0;
        while (!treeNodeQueue.isEmpty()) {
            BinaryTreeNode temp = treeNodeQueue.remove();
            levelList.add(temp.val);
            printRemain--;

            if (temp.left != null) {
                treeNodeQueue.add(temp.left);
                nextLevel++;
            }
            if (temp.right != null) {
                treeNodeQueue.add(temp.right);
                nextLevel++;
            }

            if (printRemain == 0) {
                resultList.add(levelList);
                levelList = new ArrayList<>();
                printRemain = nextLevel;
                nextLevel = 0;
            }

        }

        return resultList;
    }

    // ====================测试代码====================
    //            8
    //        6      10
    //       5 7    9  11
    void test1() {
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);
        BinaryTreeNode pNode10 = new BinaryTreeNode(10);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode7 = new BinaryTreeNode(7);
        BinaryTreeNode pNode9 = new BinaryTreeNode(9);
        BinaryTreeNode pNode11 = new BinaryTreeNode(11);

        BinaryTreeNode.connectTreeNodes(pNode8, pNode6, pNode10);
        BinaryTreeNode.connectTreeNodes(pNode6, pNode5, pNode7);
        BinaryTreeNode.connectTreeNodes(pNode10, pNode9, pNode11);

        System.out.printf("====Test1 Begins: ====\n");
        System.out.printf("Expected Result is:\n");
        System.out.printf("8 \n");
        System.out.printf("6 10 \n");
        System.out.printf("5 7 9 11 \n\n");

        System.out.printf("Actual Result is: \n");
        List<List<Integer>> resultList = levelOrder(pNode8);
        for (List<Integer> integers : resultList) {
            for (Integer num : integers) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
        System.out.printf("\n");

    }

    //            5
    //          4
    //        3
    //      2
    void test2() {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);

        BinaryTreeNode.connectTreeNodes(pNode5, pNode4, null);
        BinaryTreeNode.connectTreeNodes(pNode4, pNode3, null);
        BinaryTreeNode.connectTreeNodes(pNode3, pNode2, null);

        System.out.printf("====Test2 Begins: ====\n");
        System.out.printf("Expected Result is:\n");
        System.out.printf("5 \n");
        System.out.printf("4 \n");
        System.out.printf("3 \n");
        System.out.printf("2 \n\n");

        System.out.printf("Actual Result is: \n");
        List<List<Integer>> resultList = levelOrder(pNode5);
        for (List<Integer> integers : resultList) {
            for (Integer num : integers) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
        System.out.printf("\n");

    }

    //        5
    //         4
    //          3
    //           2
    void test3() {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);

        BinaryTreeNode.connectTreeNodes(pNode5, null, pNode4);
        BinaryTreeNode.connectTreeNodes(pNode4, null, pNode3);
        BinaryTreeNode.connectTreeNodes(pNode3, null, pNode2);

        System.out.printf("====Test3 Begins: ====\n");
        System.out.printf("Expected Result is:\n");
        System.out.printf("5 \n");
        System.out.printf("4 \n");
        System.out.printf("3 \n");
        System.out.printf("2 \n\n");

        System.out.printf("Actual Result is: \n");
        List<List<Integer>> resultList = levelOrder(pNode5);
        for (List<Integer> integers : resultList) {
            for (Integer num : integers) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
        System.out.printf("\n");

    }

    void test4() {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);

        System.out.printf("====Test4 Begins: ====\n");
        System.out.printf("Expected Result is:\n");
        System.out.printf("5 \n\n");

        System.out.printf("Actual Result is: \n");
        List<List<Integer>> resultList = levelOrder(pNode5);
        for (List<Integer> integers : resultList) {
            for (Integer num : integers) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
        System.out.printf("\n");

    }

    void test5() {
        System.out.printf("====Test5 Begins: ====\n");
        System.out.printf("Expected Result is:\n");

        System.out.printf("Actual Result is: \n");
        List<List<Integer>> resultList = levelOrder(null);
        for (List<Integer> integers : resultList) {
            for (Integer num : integers) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
        System.out.printf("\n");
    }

    //        100
    //        /
    //       50
    //         \
    //         150
    void test6() {
        BinaryTreeNode pNode100 = new BinaryTreeNode(100);
        BinaryTreeNode pNode50 = new BinaryTreeNode(50);
        BinaryTreeNode pNode150 = new BinaryTreeNode(150);

        BinaryTreeNode.connectTreeNodes(pNode100, pNode50, null);
        BinaryTreeNode.connectTreeNodes(pNode50, null, pNode150);

        System.out.printf("====Test6 Begins: ====\n");
        System.out.printf("Expected Result is:\n");
        System.out.printf("100 \n");
        System.out.printf("50 \n");
        System.out.printf("150 \n\n");

        System.out.printf("Actual Result is: \n");
        List<List<Integer>> resultList = levelOrder(pNode100);
        for (List<Integer> integers : resultList) {
            for (Integer num : integers) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        PrintTreesInLines printTree = new PrintTreesInLines();

        printTree.test1();
        printTree.test2();
        printTree.test3();
        printTree.test4();
        printTree.test5();
        printTree.test6();
    }

}
