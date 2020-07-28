package com.markby.offer.simplify_complexproblem_by_decompose;

import com.markby.offer.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTrees {

    // Encodes a tree to a single string.
    public String serialize(BinaryTreeNode root) {
        if (root == null) return "[]";
        Queue<BinaryTreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        String result = "[";

        while (!nodeQueue.isEmpty()) {
            BinaryTreeNode pNode = nodeQueue.remove();
            if (pNode == null)
                result += "null,";
            else result += pNode.val + ",";

            if (pNode != null) {
                nodeQueue.add(pNode.left);
                nodeQueue.add(pNode.right);
            }
        }

        result = result.substring(0, result.length() - 1);
        result += "]";

        return result;
    }

    // Decodes your encoded data to tree.
    public BinaryTreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(vals[0]));
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new BinaryTreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new BinaryTreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    // ==================== test Code ====================
    boolean isSameTree(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null)
            return true;

        if (pRoot1 == null || pRoot2 == null)
            return false;

        if (pRoot1.val != pRoot2.val)
            return false;

        return isSameTree(pRoot1.left, pRoot2.left) &&
                isSameTree(pRoot1.right, pRoot2.right);
    }

    void test(String testName, BinaryTreeNode pRoot) {
        if (testName != null)
            System.out.printf("%s begins: \n", testName);

        BinaryTreeNode.printTree(pRoot);

        String data = serialize(pRoot);
        System.out.println(data);
        BinaryTreeNode pNewRoot = deserialize(data);

        BinaryTreeNode.printTree(pNewRoot);

        if (isSameTree(pRoot, pNewRoot))
            System.out.printf("The deserialized tree is same as the oritinal tree.\n\n");
        else
            System.out.printf("The deserialized tree is NOT same as the oritinal tree.\n\n");
    }

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

        test("test1", pNode8);
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

        test("test2", pNode5);
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

        test("test3", pNode5);

    }

    void test4() {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);

        test("test4", pNode5);

    }

    void test5() {
        test("test5", null);
    }

    //        5
    //         5
    //          5
    //         5
    //        5
    //       5 5
    //      5   5
    void test6() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(5);
        BinaryTreeNode pNode2 = new BinaryTreeNode(5);
        BinaryTreeNode pNode3 = new BinaryTreeNode(5);
        BinaryTreeNode pNode4 = new BinaryTreeNode(5);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode61 = new BinaryTreeNode(5);
        BinaryTreeNode pNode62 = new BinaryTreeNode(5);
        BinaryTreeNode pNode71 = new BinaryTreeNode(5);
        BinaryTreeNode pNode72 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNode1, null, pNode2);
        BinaryTreeNode.connectTreeNodes(pNode2, null, pNode3);
        BinaryTreeNode.connectTreeNodes(pNode3, pNode4, null);
        BinaryTreeNode.connectTreeNodes(pNode4, pNode5, null);
        BinaryTreeNode.connectTreeNodes(pNode5, pNode61, pNode62);
        BinaryTreeNode.connectTreeNodes(pNode61, pNode71, null);
        BinaryTreeNode.connectTreeNodes(pNode62, null, pNode72);

        test("test6", pNode1);

    }

    public static void main(String[] args) {
        SerializeBinaryTrees trees = new SerializeBinaryTrees();

        trees.test1();
        trees.test2();
        trees.test3();
        trees.test4();
        trees.test5();
        trees.test6();

//        String data = "[1,2,3,null,null,4,5]";
//        data = data.substring(1,data.length()-1);
//
//        String[] datas = data.split(",");
//        BinaryTreeNode[] treeNodes = new BinaryTreeNode[datas.length];
//        for(int i = 0; i < datas.length; i++){
//            if ("null".equals(datas[i])) {
//                treeNodes[i] = null;
//            }else {
//                BinaryTreeNode pNode = new BinaryTreeNode(Integer.valueOf(datas[i]));
//                treeNodes[i] = pNode;
//            }
//        }
//
//        for (int i=0; i < treeNodes.length; i++){
//            if (treeNodes[i] != null){
//                treeNodes[i].left = treeNodes[(i+1) * 2 - 1];
//                treeNodes[i].right = treeNodes[(i+1) * 2];
//            }
//            int end = (i+1) * 2;
//            if (end >= treeNodes.length)
//                break;
//
//        }
//
//        System.out.println();

    }

}
