package com.markby.offer.robustness;

import com.markby.offer.utils.ListNode;

// 面试题25：合并两个排序的链表
// 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
// 照递增排序的。例如输入图3.11中的链表1和链表2，则合并之后的升序链表如链
// 表3所示。
public class MergeSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode result = null;
        if (l1.val < l2.val) {
            result = l1;
            result.next = mergeTwoLists(l1.next, l2);
        } else {
            result = l2;
            result.next = mergeTwoLists(l1, l2.next);
        }

        return result;
    }

    // ====================测试代码====================
    ListNode test(String testName, ListNode pHead1, ListNode pHead2) {
        if (testName != null)
            System.out.printf("%s begins:\n", testName);

        System.out.printf("The first list is:\n");
        ListNode.printList(pHead1);

        System.out.printf("The second list is:\n");
        ListNode.printList(pHead2);

        System.out.printf("The merged list is:\n");
        ListNode pMergedHead = mergeTwoLists(pHead1, pHead2);
        ListNode.printList(pMergedHead);

        System.out.printf("\n\n");

        return pMergedHead;
    }

    // list1: 1->3->5
    // list2: 2->4->6
    void test1() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode3);
        ListNode.connectListNodes(pNode3, pNode5);

        ListNode pNode2 = new ListNode(2);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode6 = new ListNode(6);

        ListNode.connectListNodes(pNode2, pNode4);
        ListNode.connectListNodes(pNode4, pNode6);

        ListNode pMergedHead = test("Test1", pNode1, pNode2);

    }

    // 两个链表中有重复的数字
    // list1: 1->3->5
    // list2: 1->3->5
    void test2() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode3);
        ListNode.connectListNodes(pNode3, pNode5);

        ListNode pNode2 = new ListNode(1);
        ListNode pNode4 = new ListNode(3);
        ListNode pNode6 = new ListNode(5);

        ListNode.connectListNodes(pNode2, pNode4);
        ListNode.connectListNodes(pNode4, pNode6);

        ListNode pMergedHead = test("Test2", pNode1, pNode2);

    }

    // 两个链表都只有一个数字
    // list1: 1
    // list2: 2
    void test3() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);

        ListNode pMergedHead = test("Test3", pNode1, pNode2);

    }

    // 一个链表为空链表
    // list1: 1->3->5
    // list2: 空链表
    void test4() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode3);
        ListNode.connectListNodes(pNode3, pNode5);

        ListNode pMergedHead = test("Test4", pNode1, null);

    }

    // 两个链表都为空链表
    // list1: 空链表
    // list2: 空链表
    void test5() {
        ListNode pMergedHead = test("Test5", null, null);
    }

    public static void main(String[] args) {
        MergeSortedLists merge = new MergeSortedLists();

        merge.test1();
        merge.test2();
        merge.test3();
        merge.test4();
        merge.test5();
    }
}
