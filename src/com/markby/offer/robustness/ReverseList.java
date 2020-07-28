package com.markby.offer.robustness;

import com.markby.offer.utils.ListNode;

// 面试题24：反转链表
// 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
// 头结点。
public class ReverseList {

    public ListNode reverseList1(ListNode head) {
        // 不能为空
        if (head == null)
            return null;

        // 需要记录相邻的三个节点
        ListNode pNode1 = head;
        ListNode pNode2 = null;
        ListNode pNode3 = null;
        if (head.next != null)
            pNode2 = head.next;
        else
            return head;    // 只有一个节点时

        if (head.next.next != null)
            pNode3 = head.next.next;
        else {
            // 只有两个节点时
            pNode1.next = null;
            pNode2.next = pNode1;
            return pNode2;
        }

        // 处理尾节点
        pNode1.next = null;
        while (pNode3.next != null) {
            pNode2.next = pNode1;

            pNode1 = pNode2;
            pNode2 = pNode3;
            pNode3 = pNode3.next;
        }

        pNode2.next = pNode1;
        pNode3.next = pNode2;

        return pNode3;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode pReversedHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;

            if (pNext == null)
                pReversedHead = pNode;

            pNode.next = pPrev;

            pPrev = pNode;
            pNode = pNext;
        }

        return pReversedHead;
    }


    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode ret = reverseList(head.next);
        // 反转
        head.next.next = head;
        head.next = null;
        return ret;

    }

    // ====================测试代码====================
    ListNode test(ListNode pHead) {
        System.out.printf("The original list is: \n");
        ListNode.printList(pHead);

        ListNode pReversedHead = reverseList(pHead);

        System.out.printf("The reversed list is: \n");
        ListNode.printList(pReversedHead);

        return pReversedHead;
    }

    // 输入的链表有多个结点
    void test1() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);

        ListNode pReversedHead = test(pNode1);

    }

    // 输入的链表只有一个结点
    void test2() {
        ListNode pNode1 = new ListNode(1);

        ListNode pReversedHead = test(pNode1);

    }

    // 输入空链表
    void test3() {
        test(null);
    }

    public static void main(String[] args) {
        ReverseList r = new ReverseList();
        r.test1();
        r.test2();
        r.test3();
    }
}
