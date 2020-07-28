package com.markby.offer.robustness;

import com.markby.offer.utils.ListNode;

// 面试题22：链表中倒数第k个结点
// 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
// 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
// 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
// 值为4的结点。
public class FindKthToTail {

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 参数不合法
        if (head == null || k <= 0)
            return null;

        ListNode pAhead = head;
        ListNode pBehind = null;

        // 使pAhead和pBehind相距k-1的距离
        for (int i = 0; i < k - 1; i++) {
            // 如果k大于节点数，返回null
            if (pAhead.next != null)
                pAhead = pAhead.next;
            else
                return null;
        }

        pBehind = head;
        // 当pAhead到达尾部时，pBehind正好到达倒数第k个节点
        while (pAhead.next != null) {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }

        return pBehind;
    }

    // ====================测试代码====================
    // 测试要找的结点在链表中间
    void test1() {
        System.out.printf("=====Test1 starts:=====\n");
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);

        System.out.printf("expected result: 4.\n");
        ListNode pNode = getKthFromEnd(pNode1, 2);
        ListNode.printListNode(pNode);

    }

    // 测试要找的结点是链表的尾结点
    void test2() {
        System.out.printf("=====Test2 starts:=====\n");
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);

        System.out.printf("expected result: 5.\n");
        ListNode pNode = getKthFromEnd(pNode1, 1);
        ListNode.printListNode(pNode);

    }

    // 测试要找的结点是链表的头结点
    void test3() {
        System.out.printf("=====Test3 starts:=====\n");
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);

        System.out.printf("expected result: 1.\n");
        ListNode pNode = getKthFromEnd(pNode1, 5);
        ListNode.printListNode(pNode);

    }

    // 测试空链表
    void test4() {
        System.out.printf("=====Test4 starts:=====\n");
        System.out.printf("expected result: null.\n");
        ListNode pNode = getKthFromEnd(null, 100);
        ListNode.printListNode(pNode);
    }

    // 测试输入的第二个参数大于链表的结点总数
    void test5() {
        System.out.printf("=====Test5 starts:=====\n");
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);

        System.out.printf("expected result: null.\n");
        ListNode pNode = getKthFromEnd(pNode1, 6);
        ListNode.printListNode(pNode);

    }

    // 测试输入的第二个参数为0
    void test6() {
        System.out.printf("=====Test6 starts:=====\n");
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);

        System.out.printf("expected result: null.\n");
        ListNode pNode = getKthFromEnd(pNode1, 0);
        ListNode.printListNode(pNode);

    }

    public static void main(String[] args) {
        FindKthToTail k = new FindKthToTail();
        k.test1();
        k.test2();
        k.test3();
        k.test4();
        k.test5();
        k.test6();
    }


}
