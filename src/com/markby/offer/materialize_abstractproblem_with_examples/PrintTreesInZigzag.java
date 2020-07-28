package com.markby.offer.materialize_abstractproblem_with_examples;

import com.markby.offer.utils.BinaryTreeNode;

import java.util.*;

public class PrintTreesInZigzag {
    public List<List<Integer>> levelOrder1(BinaryTreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();

        Queue<BinaryTreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> levelList = new ArrayList<>();
        int printRemain = 1;
        int nextLevel = 0;
        boolean zigzag = false;
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
                if (zigzag) {
                    Collections.reverse(levelList);
                    zigzag = false;
                } else {
                    zigzag = true;
                }
                resultList.add(levelList);
                levelList = new ArrayList<>();
                printRemain = nextLevel;
                nextLevel = 0;
            }

        }

        return resultList;

    }

    public List<List<Integer>> levelOrder(BinaryTreeNode root) {

        Deque<BinaryTreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) deque.add(root);
        while (!deque.isEmpty()) {
            // 打印奇数层
            List<Integer> tmp = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                BinaryTreeNode node = deque.removeFirst();
                tmp.add(node.val);
                // 先左后右加入下层节点
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            res.add(tmp);
            if (deque.isEmpty()) break; // 若为空则提前跳出
            // 打印偶数层
            tmp = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                BinaryTreeNode node = deque.removeLast();
                tmp.add(node.val);
                // 先右后左加入下层节点
                if (node.right != null) deque.addFirst(node.right);
                if (node.left != null) deque.addFirst(node.left);
            }
            res.add(tmp);
        }
        return res;
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
        System.out.printf("10 6 \n");
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

    //                8
    //        4              12
    //     2     6       10      14
    //   1  3  5  7     9 11   13  15
    void test7() {
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode12 = new BinaryTreeNode(12);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);
        BinaryTreeNode pNode10 = new BinaryTreeNode(10);
        BinaryTreeNode pNode14 = new BinaryTreeNode(14);
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode7 = new BinaryTreeNode(7);
        BinaryTreeNode pNode9 = new BinaryTreeNode(9);
        BinaryTreeNode pNode11 = new BinaryTreeNode(11);
        BinaryTreeNode pNode13 = new BinaryTreeNode(13);
        BinaryTreeNode pNode15 = new BinaryTreeNode(15);

        BinaryTreeNode.connectTreeNodes(pNode8, pNode4, pNode12);
        BinaryTreeNode.connectTreeNodes(pNode4, pNode2, pNode6);
        BinaryTreeNode.connectTreeNodes(pNode12, pNode10, pNode14);
        BinaryTreeNode.connectTreeNodes(pNode2, pNode1, pNode3);
        BinaryTreeNode.connectTreeNodes(pNode6, pNode5, pNode7);
        BinaryTreeNode.connectTreeNodes(pNode10, pNode9, pNode11);
        BinaryTreeNode.connectTreeNodes(pNode14, pNode13, pNode15);

        System.out.printf("====Test7 Begins: ====\n");
        System.out.printf("Expected Result is:\n");
        System.out.printf("8 \n");
        System.out.printf("12 4 \n");
        System.out.printf("2 6 10 14 \n");
        System.out.printf("15 13 11 9 7 5 3 1 \n\n");

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

    public static void main(String[] args) {
        PrintTreesInZigzag printTree = new PrintTreesInZigzag();

        printTree.test1();
        printTree.test2();
        printTree.test3();
        printTree.test4();
        printTree.test5();
        printTree.test6();
        printTree.test7();
    }

}
