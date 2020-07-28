package com.markby.offer.simplify_complexproblem_by_decompose;

import java.util.HashMap;
import java.util.Map;

// 面试题35：复杂链表的复制
// 题目：请实现函数Node Clone(Node pHead)，复
// 制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个
// 结点外，还有一个m_pSibling 指向链表中的任意结点或者null。
public class CopyComplexList {

    // hash
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node pNode = head;
        Node copyHeadNode = new Node(head.val);
        Node pCopyNode = copyHeadNode;
        Map<Node, Node> nodeMap1 = new HashMap<>();
        Map<Node, Node> nodeMap2 = new HashMap<>();
        nodeMap1.put(pCopyNode, pNode);
        nodeMap2.put(pNode, pCopyNode);
        pNode = pNode.next;

        while (pNode != null) {
            Node temp = new Node(pNode.val);
            nodeMap1.put(temp, pNode);
            nodeMap2.put(pNode, temp);
            pNode = pNode.next;

            pCopyNode.next = temp;
            pCopyNode = temp;
        }

        pCopyNode = copyHeadNode;
        while (pCopyNode != null) {
            Node srcRandom = nodeMap1.get(pCopyNode).random;
            pCopyNode.random = srcRandom == null ? null : nodeMap2.get(srcRandom);
            pCopyNode = pCopyNode.next;
        }

        return copyHeadNode;
    }

    // 迭代
    public Node copyRandomList1(Node head) {
        if (head == null)
            return null;

        Node pNode = head;

        while (pNode != null) {
            Node temp = new Node(pNode.val);

            temp.next = pNode.next;
            pNode.next = temp;
            pNode = temp.next;
        }

        pNode = head;
        while (pNode != null) {
            Node srcTemp = pNode.random;
            Node destTemp = pNode.next;

            destTemp.random = srcTemp == null ? null : srcTemp.next;

            pNode = destTemp.next;
        }

        Node headNode = head;
        Node copyHeadNode = head.next;
        pNode = copyHeadNode;
        while (headNode != null) {
            headNode.next = headNode.next.next;
            headNode = headNode.next;

            if (pNode.next == null)
                break;

            pNode.next = pNode.next.next;
            pNode = pNode.next;

        }

        return copyHeadNode;
    }

    // ====================测试代码====================
    void test(String testName, Node pHead) {
        if (testName != null)
            System.out.printf("%s begins:\n", testName);

        System.out.printf("The original list is:\n");
        Node.printList(pHead);

        Node pClonedHead = copyRandomList(pHead);

        System.out.printf("The cloned list is:\n");
        Node.printList(pClonedHead);
    }

    //          -----------------
    //         \|/              |
    //  1-------2-------3-------4-------5
    //  |       |      /|\             /|\
    //  --------+--------               |
    //          -------------------------
    void test1() {
        Node pNode1 = new Node(1);
        Node pNode2 = new Node(2);
        Node pNode3 = new Node(3);
        Node pNode4 = new Node(4);
        Node pNode5 = new Node(5);

        Node.buildNodes(pNode1, pNode2, pNode3);
        Node.buildNodes(pNode2, pNode3, pNode5);
        Node.buildNodes(pNode3, pNode4, null);
        Node.buildNodes(pNode4, pNode5, pNode2);

        test("Test1", pNode1);
    }

    // m_pSibling指向结点自身
    //          -----------------
    //         \|/              |
    //  1-------2-------3-------4-------5
    //         |       | /|\           /|\
    //         |       | --             |
    //         |------------------------|
    void test2() {
        Node pNode1 = new Node(1);
        Node pNode2 = new Node(2);
        Node pNode3 = new Node(3);
        Node pNode4 = new Node(4);
        Node pNode5 = new Node(5);

        Node.buildNodes(pNode1, pNode2, null);
        Node.buildNodes(pNode2, pNode3, pNode5);
        Node.buildNodes(pNode3, pNode4, pNode3);
        Node.buildNodes(pNode4, pNode5, pNode2);

        test("Test2", pNode1);
    }

    // m_pSibling形成环
    //          -----------------
    //         \|/              |
    //  1-------2-------3-------4-------5
    //          |              /|\
    //          |               |
    //          |---------------|
    void test3() {
        Node pNode1 = new Node(1);
        Node pNode2 = new Node(2);
        Node pNode3 = new Node(3);
        Node pNode4 = new Node(4);
        Node pNode5 = new Node(5);

        Node.buildNodes(pNode1, pNode2, null);
        Node.buildNodes(pNode2, pNode3, pNode4);
        Node.buildNodes(pNode3, pNode4, null);
        Node.buildNodes(pNode4, pNode5, pNode2);

        test("Test3", pNode1);
    }

    // 只有一个结点
    void test4() {
        Node pNode1 = new Node(1);
        Node.buildNodes(pNode1, null, pNode1);

        test("test4", pNode1);
    }

    // 鲁棒性测试
    void test5() {
        test("Test5", null);
    }

    public static void main(String[] args) {
        CopyComplexList copy = new CopyComplexList();

        copy.test1();
        copy.test2();
        copy.test3();
        copy.test4();
        copy.test5();
    }

}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static void buildNodes(Node pNode, Node pNext, Node pSibling) {
        if (pNode != null) {
            pNode.next = pNext;
            pNode.random = pSibling;
        }
    }

    public static void printList(Node pHead) {
        Node pNode = pHead;
        while (pNode != null) {
            System.out.printf("The value of this node is: %d.\n", pNode.val);

            if (pNode.random != null)
                System.out.printf("The value of its sibling is: %d.\n", pNode.random.val);
            else
                System.out.printf("This node does not have a sibling.\n");

            System.out.printf("\n");

            pNode = pNode.next;
        }
    }
}