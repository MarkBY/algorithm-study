package com.markby.offer.materialize_abstractproblem_with_examples;

import com.markby.offer.utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathInTree {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {

        findPath(root, sum);

        return result;
    }

    public void findPath(BinaryTreeNode root, int sum) {
        if (root == null) return;
        path.add(root.val);
        sum -= root.val;
        // 如果是叶结点，并且路径上结点的和等于输入的值
        // 把这条路径加入到结果集中
        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }

        // 如果不是叶结点，则遍历它的子结点
        findPath(root.left, sum);
        findPath(root.right, sum);

        // 在返回到父结点之前，在路径上删除当前结点，
        path.remove(path.size() - 1);
    }

    // ====================测试代码====================
    void test(String testName, BinaryTreeNode pRoot, int expectedSum) {
        if (testName != null)
            System.out.printf("%s begins:\n", testName);

        List<List<Integer>> resultList = pathSum(pRoot, expectedSum);

        for (List<Integer> integers : resultList) {
            for (Integer num : integers) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
        result.clear();
        System.out.printf("\n");
    }

    //            10
    //         /      \
    //        5        12
    //       /\        
    //      4  7     
    // 有两条路径上的结点和为22
    void test1() {
        BinaryTreeNode pNode10 = new BinaryTreeNode(10);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode12 = new BinaryTreeNode(12);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode7 = new BinaryTreeNode(7);

        BinaryTreeNode.connectTreeNodes(pNode10, pNode5, pNode12);
        BinaryTreeNode.connectTreeNodes(pNode5, pNode4, pNode7);

        System.out.printf("Two paths should be found in test1.\n");
        test("test1", pNode10, 22);

    }

    //            10
    //         /      \
    //        5        12
    //       /\        
    //      4  7     
    // 没有路径上的结点和为15
    void test2() {
        BinaryTreeNode pNode10 = new BinaryTreeNode(10);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode12 = new BinaryTreeNode(12);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode7 = new BinaryTreeNode(7);

        BinaryTreeNode.connectTreeNodes(pNode10, pNode5, pNode12);
        BinaryTreeNode.connectTreeNodes(pNode5, pNode4, pNode7);

        System.out.printf("No paths should be found in test2.\n");
        test("test2", pNode10, 15);

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
    // 有一条路径上面的结点和为15
    void test3() {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);

        BinaryTreeNode.connectTreeNodes(pNode5, pNode4, null);
        BinaryTreeNode.connectTreeNodes(pNode4, pNode3, null);
        BinaryTreeNode.connectTreeNodes(pNode3, pNode2, null);
        BinaryTreeNode.connectTreeNodes(pNode2, pNode1, null);

        System.out.printf("One path should be found in test3.\n");
        test("test3", pNode5, 15);

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
    // 没有路径上面的结点和为16
    void test4() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);

        BinaryTreeNode.connectTreeNodes(pNode1, null, pNode2);
        BinaryTreeNode.connectTreeNodes(pNode2, null, pNode3);
        BinaryTreeNode.connectTreeNodes(pNode3, null, pNode4);
        BinaryTreeNode.connectTreeNodes(pNode4, null, pNode5);

        System.out.printf("No paths should be found in test4.\n");
        test("test4", pNode1, 16);
    }

    // 树中只有1个结点
    void test5() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);

        System.out.printf("One path should be found in test5.\n");
        test("test5", pNode1, 1);
    }

    // 树中没有结点
    void test6() {
        System.out.printf("No paths should be found in test6.\n");
        test("test6", null, 0);
    }

    public static void main(String[] args) {
        PathInTree path = new PathInTree();

        path.test1();
        path.test2();
        path.test3();
        path.test4();
        path.test5();
        path.test6();
    }

}
