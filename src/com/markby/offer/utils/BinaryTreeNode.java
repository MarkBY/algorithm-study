package com.markby.offer.utils;

import java.util.*;

/**
 * 二叉树类
 */
public class BinaryTreeNode {

    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    /**
     * 构造方法
     *
     * @param x 节点值
     */
    public BinaryTreeNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    /**
     * 打印一个节点
     * 包括它的左子树和右子树
     *
     * @param pNode 树节点
     */
    public static void printTreeNode(BinaryTreeNode pNode) {
        if (pNode != null) {
            System.out.printf("value of this node is: %d\n", pNode.val);

            if (pNode.left != null)
                System.out.printf("value of its left child is: %d.\n", pNode.left.val);
            else
                System.out.printf("left child is null.\n");

            if (pNode.right != null)
                System.out.printf("value of its right child is: %d.\n", pNode.right.val);
            else
                System.out.printf("right child is null.\n");
        } else {
            System.out.printf("this node is null.\n");
        }

        System.out.printf("\n");
    }


    /**
     * 先序打印整棵二叉树
     *
     * @param pRoot 根节点
     */
    public static void printTree(BinaryTreeNode pRoot) {
        if (pRoot != null) {
            printTreeNode(pRoot);
            preOrderRecursively(pRoot.left);
            preOrderRecursively(pRoot.right);
        }
    }

    /**
     * 连接树的节点
     *
     * @param pParent 根节点
     * @param pLeft   左子树
     * @param pRight  右子树
     */
    public static void connectTreeNodes(BinaryTreeNode pParent, BinaryTreeNode pLeft, BinaryTreeNode pRight) {
        if (pParent != null) {
            pParent.left = pLeft;
            pParent.right = pRight;
        }
    }

    /**
     * 先序遍历（递归）
     *
     * @param root 根节点
     */
    public static void preOrderRecursively(BinaryTreeNode root) {
        if (root != null) {
            printTreeNode(root);
            preOrderRecursively(root.left);
            preOrderRecursively(root.right);
        }
    }

    /**
     * 先序遍历（非递归）
     *
     * @param root 根节点
     */
    public static void preOrderIteratively(BinaryTreeNode root) {
        if (null == root)
            return;
        Stack<BinaryTreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);
        while (!treeNodeStack.isEmpty()) {
            BinaryTreeNode pNode = treeNodeStack.pop();
            printTreeNode(pNode);
            if (pNode.right != null)
                treeNodeStack.push(pNode.right);
            if (pNode.left != null)
                treeNodeStack.push(pNode.left);
        }
//        while ( null != pNode || !stackTreeNode.isEmpty()){
//            if (null != pNode){
//                stackTreeNode.push(pNode);
//                printTreeNode(pNode);
//                pNode = pNode.left;
//            }else {
//                pNode = stackTreeNode.pop();
//                pNode = pNode.right;
//            }
//        }
    }

    /**
     * 中序遍历（递归）
     *
     * @param root 根节点
     */
    public static void inOrderRecursively(BinaryTreeNode root) {
        if (root != null) {
            inOrderRecursively(root.left);
            printTreeNode(root);
            inOrderRecursively(root.right);
        }
    }

    /**
     * 中序遍历（非递归）
     *
     * @param root 根节点
     */
    public static void inOrderIteratively(BinaryTreeNode root) {
        if (null == root)
            return;
        Stack<BinaryTreeNode> stackTreeNode = new Stack<>();
        BinaryTreeNode pNode = root;

        while (null != pNode || !stackTreeNode.isEmpty()) {
            if (null != pNode) {
                stackTreeNode.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stackTreeNode.pop();
                printTreeNode(pNode);
                pNode = pNode.right;
            }
        }
    }

    /**
     * 后序遍历（递归）
     *
     * @param root 根节点
     */
    public static void postOrderRecursively(BinaryTreeNode root) {
        if (root != null) {
            postOrderRecursively(root.left);
            postOrderRecursively(root.right);
            printTreeNode(root);
        }
    }

    /**
     * 很巧妙的方法：
     * <p>
     * 前序：根->左->右
     * 后序：左->右->根
     * <p>
     * 那么可以把后序当作：根->右->左，然后再反转一下即可。
     * <p>
     * 相当于用两个栈
     * 后序遍历（非递归）
     *
     * @param root 根节点
     */
    public static void postOrderIteratively(BinaryTreeNode root) {
        if (root == null)
            return;
        List<BinaryTreeNode> list = new ArrayList<>();

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();

            list.add(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        //反转
        Collections.reverse(list);
        for (BinaryTreeNode node : list) {
            printTreeNode(node);
        }

    }

    /**
     * 用一个节点用于记录上一个访问的节点
     * 判断他是不是节点的右子树
     *
     * @param root 根节点
     */
    public static void postOrderIteratively1(BinaryTreeNode root) {
        if (root == null)
            return;

        Stack<BinaryTreeNode> treeNodeStack = new Stack<>();
        BinaryTreeNode pNode = root;
        BinaryTreeNode pPre = null;
        while (pNode != null || !treeNodeStack.isEmpty()) {
            while (pNode != null) {
                treeNodeStack.push(pNode);
                pNode = pNode.left;
            }
            pNode = treeNodeStack.peek();
            if (pNode.right == null || pNode.right == pPre) {
                printTreeNode(pNode);
                treeNodeStack.pop();
                pPre = pNode;
                pNode = null;
            } else
                pNode = pNode.right;
        }
    }

    /**
     * 用一个栈实现非递归后序遍历
     * 用null标识他是否为根节点
     *
     * @param root 根节点
     */
    public static void postOrderIteratively2(BinaryTreeNode root) {
        if (root == null)
            return;

        Stack<BinaryTreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);
        while (!treeNodeStack.isEmpty()) {
            BinaryTreeNode pNode = treeNodeStack.peek();
            if (pNode == null) {
                treeNodeStack.pop();
                printTreeNode(treeNodeStack.pop());
                continue;
            }

            treeNodeStack.push(null);
            if (pNode.right != null)
                treeNodeStack.push(pNode.right);
            if (pNode.left != null)
                treeNodeStack.push(pNode.left);

        }

    }

    /**
     * 用队列实现二叉树的层次遍历
     *
     * @param root 根节点
     */
    public static void levelOrder(BinaryTreeNode root) {
        if (null == root)
            return;
        Queue<BinaryTreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            BinaryTreeNode pNode = treeNodeQueue.remove();
            printTreeNode(pNode);
            if (pNode.left != null)
                treeNodeQueue.add(pNode.left);
            if (pNode.right != null)
                treeNodeQueue.add(pNode.right);
        }
    }

    public static void main(String[] args) {

        //            8
        //        6      10
        //       5 7    9  11
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

//        System.out.println("==================先序遍历（递归）=====================");
//        preOrderRecursively(pNode8);
//        System.out.println("==================先序遍历（非递归）====================");
//        preOrderIteratively(pNode8);
//        System.out.println("==================中序遍历（递归）=====================");
//        inOrderRecursively(pNode8);
//        System.out.println("==================中序遍历（非递归）====================");
//        inOrderIteratively(pNode8);
//        System.out.println("==================后序遍历（递归）=====================");
//        postOrderRecursively(pNode8);
//        System.out.println("==================后序遍历（非递归）=====================");
//        postOrderIteratively2(pNode8);
        System.out.println("==================层次遍历=====================");
        levelOrder(pNode8);

    }

}
