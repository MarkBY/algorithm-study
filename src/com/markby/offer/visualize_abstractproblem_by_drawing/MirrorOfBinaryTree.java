package com.markby.offer.visualize_abstractproblem_by_drawing;

import com.markby.offer.utils.BinaryTreeNode;

import java.util.Stack;

// 面试题27：二叉树的镜像
// 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
public class MirrorOfBinaryTree {

    // 循环
    public void MirrorIteratively(BinaryTreeNode root) {
        if (root == null)
            return;

        Stack<BinaryTreeNode> stackTreeNode = new Stack<>();
        stackTreeNode.push(root);

        while (stackTreeNode.size() > 0) {
            BinaryTreeNode pNode = stackTreeNode.pop();

            BinaryTreeNode temp = pNode.left;
            pNode.left = pNode.right;
            pNode.right = temp;

            if (null != pNode.left)
                stackTreeNode.push(pNode.left);
            if (null != pNode.right)
                stackTreeNode.push(pNode.right);
        }
    }

    // 递归MirrorRecursively
    public void MirrorRecursively(BinaryTreeNode root) {
        if (root == null)
            return;
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        MirrorRecursively(root.left);
        MirrorRecursively(root.right);
    }


    // ====================测试代码====================
    // 测试完全二叉树：除了叶子节点，其他节点都有两个子节点
    //            8
    //        6      10
    //       5 7    9  11
    void test1() {
        System.out.printf("=====Test1 starts:=====\n");
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

        BinaryTreeNode.printTree(pNode8);

        System.out.printf("=====Test1: MirrorRecursively=====\n");
        MirrorRecursively(pNode8);
        BinaryTreeNode.printTree(pNode8);

        System.out.printf("=====Test1: MirrorIteratively=====\n");
        MirrorIteratively(pNode8);
        BinaryTreeNode.printTree(pNode8);

    }

    // 测试二叉树：出叶子结点之外，左右的结点都有且只有一个左子结点
    //            8
    //          7
    //        6
    //      5
    //    4
    void test2() {
        System.out.printf("=====Test2 starts:=====\n");
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode7 = new BinaryTreeNode(7);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);

        BinaryTreeNode.connectTreeNodes(pNode8, pNode7, null);
        BinaryTreeNode.connectTreeNodes(pNode7, pNode6, null);
        BinaryTreeNode.connectTreeNodes(pNode6, pNode5, null);
        BinaryTreeNode.connectTreeNodes(pNode5, pNode4, null);

        BinaryTreeNode.printTree(pNode8);

        System.out.printf("=====Test2: MirrorRecursively=====\n");
        MirrorRecursively(pNode8);
        BinaryTreeNode.printTree(pNode8);

        System.out.printf("=====Test2: MirrorIteratively=====\n");
        MirrorIteratively(pNode8);
        BinaryTreeNode.printTree(pNode8);

    }

    // 测试二叉树：出叶子结点之外，左右的结点都有且只有一个右子结点
    //            8
    //             7
    //              6
    //               5
    //                4
    void test3() {
        System.out.printf("=====Test3 starts:=====\n");
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode7 = new BinaryTreeNode(7);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);

        BinaryTreeNode.connectTreeNodes(pNode8, null, pNode7);
        BinaryTreeNode.connectTreeNodes(pNode7, null, pNode6);
        BinaryTreeNode.connectTreeNodes(pNode6, null, pNode5);
        BinaryTreeNode.connectTreeNodes(pNode5, null, pNode4);

        BinaryTreeNode.printTree(pNode8);

        System.out.printf("=====Test3: MirrorRecursively=====\n");
        MirrorRecursively(pNode8);
        BinaryTreeNode.printTree(pNode8);

        System.out.printf("=====Test3: MirrorIteratively=====\n");
        MirrorIteratively(pNode8);
        BinaryTreeNode.printTree(pNode8);

    }

    // 测试空二叉树：根结点为空指针
    void test4() {
        System.out.printf("=====Test4 starts:=====\n");
        BinaryTreeNode pNode = null;

        BinaryTreeNode.printTree(pNode);

        System.out.printf("=====Test4: MirrorRecursively=====\n");
        MirrorRecursively(pNode);
        BinaryTreeNode.printTree(pNode);

        System.out.printf("=====Test4: MirrorIteratively=====\n");
        MirrorIteratively(pNode);
        BinaryTreeNode.printTree(pNode);
    }

    // 测试只有一个结点的二叉树
    void test5() {
        System.out.printf("=====Test5 starts:=====\n");
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);

        BinaryTreeNode.printTree(pNode8);

        System.out.printf("=====Test4: MirrorRecursively=====\n");
        MirrorRecursively(pNode8);
        BinaryTreeNode.printTree(pNode8);

        System.out.printf("=====Test4: MirrorIteratively=====\n");
        MirrorIteratively(pNode8);
        BinaryTreeNode.printTree(pNode8);
    }

    public static void main(String[] args) {
        MirrorOfBinaryTree tree = new MirrorOfBinaryTree();

        tree.test1();
        tree.test2();
        tree.test3();
        tree.test4();
        tree.test5();
    }

}
