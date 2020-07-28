package com.markby.offer.tree;

public class GetNext {
    public static TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;

        TreeLinkNode next = null;
        // 右节点不为空
        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while (right.left != null)
                right = right.left;

            next = right;
        } else if (pNode.right == null) {
            /*next = pNode.parent;
            if (next.left == pNode)
                return next;
            else{
                if (next.parent.right == next)
                    return null;
                while (next.parent != null){
                    next = next.parent;
                }
                return next;
            }*/
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode parent = pNode.parent;
            while (parent != null && pCurrent == parent.right) {
                pCurrent = parent;
                parent = parent.parent;
            }

            next = parent;
        }
        return next;
    }

    static void test(String testName, TreeLinkNode node, TreeLinkNode expected) {
        if (testName != null)
            System.out.printf("%s begins: ", testName);

        TreeLinkNode next = getNext(node);
        if (next == expected)
            System.out.printf("Passed.\n");
        else
            System.out.printf("FAILED.\n");
    }

    //            8
    //        6      10
    //       5 7    9  11
    static void test1_7() {
        TreeLinkNode pNode8 = new TreeLinkNode(8);
        TreeLinkNode pNode6 = new TreeLinkNode(6);
        TreeLinkNode pNode10 = new TreeLinkNode(10);
        TreeLinkNode pNode5 = new TreeLinkNode(5);
        TreeLinkNode pNode7 = new TreeLinkNode(7);
        TreeLinkNode pNode9 = new TreeLinkNode(9);
        TreeLinkNode pNode11 = new TreeLinkNode(11);

        TreeLinkNode.connectTreeNodes(pNode8, pNode6, pNode10);
        TreeLinkNode.connectTreeNodes(pNode6, pNode5, pNode7);
        TreeLinkNode.connectTreeNodes(pNode10, pNode9, pNode11);

        test("test1", pNode8, pNode9);
        test("test2", pNode6, pNode7);
        test("test3", pNode10, pNode11);
        test("test4", pNode5, pNode6);
        test("test5", pNode7, pNode8);
        test("test6", pNode9, pNode10);
        test("test7", pNode11, null);

    }

    //            5
    //          4
    //        3
    //      2
    static void test8_11() {
        TreeLinkNode pNode5 = new TreeLinkNode(5);
        TreeLinkNode pNode4 = new TreeLinkNode(4);
        TreeLinkNode pNode3 = new TreeLinkNode(3);
        TreeLinkNode pNode2 = new TreeLinkNode(2);

        TreeLinkNode.connectTreeNodes(pNode5, pNode4, null);
        TreeLinkNode.connectTreeNodes(pNode4, pNode3, null);
        TreeLinkNode.connectTreeNodes(pNode3, pNode2, null);

        test("test8", pNode5, null);
        test("test9", pNode4, pNode5);
        test("test10", pNode3, pNode4);
        test("test11", pNode2, pNode3);

    }

    //        2
    //         3
    //          4
    //           5
    static void test12_15() {
        TreeLinkNode pNode2 = new TreeLinkNode(2);
        TreeLinkNode pNode3 = new TreeLinkNode(3);
        TreeLinkNode pNode4 = new TreeLinkNode(4);
        TreeLinkNode pNode5 = new TreeLinkNode(5);

        TreeLinkNode.connectTreeNodes(pNode2, null, pNode3);
        TreeLinkNode.connectTreeNodes(pNode3, null, pNode4);
        TreeLinkNode.connectTreeNodes(pNode4, null, pNode5);

        test("test12", pNode5, null);
        test("test13", pNode4, pNode5);
        test("test14", pNode3, pNode4);
        test("test15", pNode2, pNode3);

    }

    static void test16() {
        TreeLinkNode pNode5 = new TreeLinkNode(5);

        test("test16", pNode5, null);

    }

    public static void main(String[] args) {
        test1_7();
        test8_11();
        test12_15();
        test16();

    }
}

class TreeLinkNode {
    int val;
    public TreeLinkNode left = null;
    public TreeLinkNode right = null;
    public TreeLinkNode parent = null;

    public TreeLinkNode(int val) {
        this.val = val;
    }

    public static void connectTreeNodes(TreeLinkNode parent, TreeLinkNode left, TreeLinkNode right) {
        if (parent != null) {
            parent.left = left;
            parent.right = right;

            if (left != null)
                left.parent = parent;
            if (right != null)
                right.parent = parent;
        }
    }

    public static void printTreeNode(TreeLinkNode node) {
        if (node != null) {
            System.out.printf("value of this node is: %d\n", node.val);

            if (node.left != null)
                System.out.printf("value of its left child is: %d.\n", node.left.val);
            else
                System.out.printf("left child is null.\n");

            if (node.right != null)
                System.out.printf("value of its right child is: %d.\n", node.right.val);
            else
                System.out.printf("right child is null.\n");
        } else {
            System.out.printf("this node is null.\n");
        }

        System.out.printf("\n");
    }

    public static void printTree(TreeLinkNode root) {
        printTreeNode(root);

        if (root != null) {
            if (root.left != null)
                printTreeNode(root.left);
            if (root.right != null)
                printTreeNode(root.right);
        }
    }
}