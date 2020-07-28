package com.markby.offer.Balance_of_time_efficiency_and_space_efficiency;

import com.markby.offer.utils.ListNode;

// 面试题52：两个链表的第一个公共结点
// 题目：输入两个链表，找出它们的第一个公共结点。
public class FirstCommonNodesInLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int lengthOfA = getListLength(headA);
        int lengthOfB = getListLength(headB);
        int less = lengthOfA - lengthOfB;

        ListNode pLong = headA;
        ListNode pShort = headB;

        if (lengthOfB > lengthOfA){
            pLong = headB;
            pShort = headA;
            less = lengthOfB - lengthOfA;
        }

        while (less != 0){
            pLong = pLong.next;
            less--;
        }

        while (pLong != null && pShort != null){
            if (pLong == pShort)
                return pLong;
            pLong = pLong.next;
            pShort = pShort.next;
        }

        return null;
    }

    public int getListLength(ListNode head){
        ListNode pNode = head;
        int res = 0;
        while (pNode != null){
            res++;
            pNode = pNode.next;
        }

        return res;
    }

    // ====================测试代码====================

    void test(String testName, ListNode pHead1, ListNode pHead2, ListNode pExpected) {
        if (testName != null)
            System.out.println(testName + " begins: ");

        ListNode pResult = getIntersectionNode(pHead1, pHead2);
        if (pResult == pExpected)
            System.out.println("Passed.\n");
        else
            System.out.println("Failed.\n");
    }

    // 第一个公共结点在链表中间
    // 1 - 2 - 3 \
    //            6 - 7
    //     4 - 5 /
    void test1() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);
        ListNode pNode6 = new ListNode(6);
        ListNode pNode7 = new ListNode(7);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode6);
        ListNode.connectListNodes(pNode4, pNode5);
        ListNode.connectListNodes(pNode5, pNode6);
        ListNode.connectListNodes(pNode6, pNode7);

        test("test1", pNode1, pNode4, pNode6);

    }

    // 没有公共结点
    // 1 - 2 - 3 - 4
    //
    // 5 - 6 - 7
    void test2() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);
        ListNode pNode6 = new ListNode(6);
        ListNode pNode7 = new ListNode(7);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode5, pNode6);
        ListNode.connectListNodes(pNode6, pNode7);

        test("test2", pNode1, pNode5, null);

    }

    // 公共结点是最后一个结点
    // 1 - 2 - 3 - 4 \
    //                7
    //         5 - 6 /
    void test3() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);
        ListNode pNode6 = new ListNode(6);
        ListNode pNode7 = new ListNode(7);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode7);
        ListNode.connectListNodes(pNode5, pNode6);
        ListNode.connectListNodes(pNode6, pNode7);

        test("test3", pNode1, pNode5, pNode7);

    }

    // 公共结点是第一个结点
    // 1 - 2 - 3 - 4 - 5
    // 两个链表完全重合
    void test4() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);

        test("test4", pNode1, pNode1, pNode1);
    }

    // 输入的两个链表有一个空链表
    void test5() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);

        test("test5", null, pNode1, null);
    }

    // 输入的两个链表有一个空链表
    void test6() {
        test("test6", null, null, null);
    }


    public static void main(String[] args) {
        FirstCommonNodesInLists lists = new FirstCommonNodesInLists();

        lists.test1();
        lists.test2();
        lists.test3();
        lists.test4();
        lists.test5();
        lists.test6();
    }

}
