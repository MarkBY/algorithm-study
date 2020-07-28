package com.markby.offer.integrity;

import com.markby.offer.utils.ListNode;

// 面试题18（一）：在O(1)时间删除链表结点
// 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该
// 结点。
public class DeleteNodeInList {
    public ListNode deleteNode(ListNode pListHead, ListNode pToBeDeleted) {
        if (pListHead == null || pToBeDeleted == null)
            return null;
        // 要删除的节点不是尾节点
        if (pToBeDeleted.next != null) {
            ListNode pNode = pToBeDeleted.next;
            pToBeDeleted.val = pNode.val;
            pToBeDeleted.next = pNode.next;

            pNode = null;
        }
        // 链表只有一个节点，删除头节点（也是尾节点）
        else if (pListHead == pToBeDeleted) {
            pListHead = null;
        }
        // 链表中有多个节点，删除尾节点
        else {
            ListNode pNode = pListHead;
            while (pNode.next != pToBeDeleted) {
                pNode = pNode.next;
            }
            pNode.next = null;
        }
        return pListHead;
    }

    // ====================测试代码====================
    void test(ListNode pListHead, ListNode pNode) {
        System.out.printf("The original list is: \n");
        ListNode.printList(pListHead);

        System.out.printf("The node to be deleted is: \n");
        ListNode.printListNode(pNode);

        pListHead = deleteNode(pListHead, pNode);

        System.out.printf("The result list is: \n");
        ListNode.printList(pListHead);
    }

    // 链表中有多个结点，删除中间的结点
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

        test(pNode1, pNode3);

    }

    // 链表中有多个结点，删除尾结点
    void test2() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);

        test(pNode1, pNode5);

    }

    // 链表中有多个结点，删除头结点
    void test3() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);

        test(pNode1, pNode1);

    }

    // 链表中只有一个结点，删除头结点
    void test4() {
        ListNode pNode1 = new ListNode(1);

        test(pNode1, pNode1);
    }

    // 链表为空
    void test5() {
        test(null, null);
    }

    public static void main(String[] args) {
        DeleteNodeInList d = new DeleteNodeInList();
        d.test1();
        d.test2();
        d.test3();
        d.test4();
        d.test5();
    }

}
