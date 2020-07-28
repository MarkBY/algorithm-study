package com.markby.offer.robustness;

import com.markby.offer.utils.ListNode;

// 面试题23：链表中环的入口结点
// 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
// 环的入口结点是结点3。
public class EntryNodeInListLoop {
    public ListNode entryNodeOfLoop1(ListNode pHead) {
        // 不能为空
        if (pHead == null)
            return null;

        // 1. 判断是否有环
        ListNode pSlow = pHead;
        ListNode pFast = null;
        if (pHead.next != null && pHead.next.next != null)
            pFast = pHead.next.next;
        else
            return null;

        while (pFast != pSlow) {
            if (pFast.next != null && pFast.next.next != null)
                pFast = pFast.next.next;
            else
                return null;

            pSlow = pSlow.next;
        }

        // 2. 记录环中节点数目
        int count = 1;
        pFast = pFast.next;
        while (pFast != pSlow) {
            pFast = pFast.next;
            count++;
        }
        System.out.println(count);
        // 3. 找到环的入口
        pFast = pHead;
        pSlow = pHead;
        // 先移动pFast，次数为环中结点的数目
        for (int i = 0; i < count - 1; i++) {
            pFast = pFast.next;
        }
        // 再移动pFast和pSlow
        while (pFast.next != pSlow) {
            pFast = pFast.next;
            pSlow = pSlow.next;
        }

        return pSlow;
    }

    ListNode meetingNode(ListNode pHead) {
        if (pHead == null)
            return null;

        ListNode pSlow = pHead.next;
        if (pSlow == null)
            return null;

        ListNode pFast = pSlow.next;
        while (pFast != null & pSlow != null) {
            if (pFast == pSlow) {
                return pFast;
            }

            pSlow = pSlow.next;

            pFast = pFast.next;
            if (pFast != null)
                pFast = pFast.next;
        }

        return null;
    }

    ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null)
            return null;

        // 得到环中结点的数目
        int nodesInLoop = 1;
        ListNode pNode1 = meetingNode;
        while (pNode1.next != meetingNode) {
            pNode1 = pNode1.next;
            nodesInLoop++;
        }

        // 先移动pFast，次数为环中结点的数目
        pNode1 = pHead;
        for (int i = 0; i < nodesInLoop; i++) {
            pNode1 = pNode1.next;
        }

        // 再移动pFast和pSlow
        ListNode pNode2 = pHead;
        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }

        return pNode1;
    }

    // ==================== Test Code ====================
    void Test(String testName, ListNode pHead, ListNode entryNode) {
        if (testName != null)
            System.out.printf("%s begins: ", testName);

        if (entryNodeOfLoop(pHead) == entryNode)
            System.out.printf("Passed.\n");
        else
            System.out.printf("FAILED.\n");
    }

    // A list has a node, without a loop
    void test1() {
        ListNode pNode1 = new ListNode(1);

        Test("Test1", pNode1, null);

    }

    // A list has a node, with a loop
    void test2() {
        ListNode pNode1 = new ListNode(1);
        ListNode.connectListNodes(pNode1, pNode1);

        Test("Test2", pNode1, pNode1);


    }

    // A list has multiple nodes, with a loop
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
        ListNode.connectListNodes(pNode5, pNode3);

        Test("Test3", pNode1, pNode3);


    }

    // A list has multiple nodes, with a loop
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
        ListNode.connectListNodes(pNode5, pNode1);

        Test("Test4", pNode1, pNode1);

    }

    // A list has multiple nodes, with a loop
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
        ListNode.connectListNodes(pNode5, pNode5);

        Test("Test5", pNode1, pNode5);

    }

    // A list has multiple nodes, without a loop
    void test6() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);

        Test("Test6", pNode1, null);

    }

    // Empty list
    void test7() {
        Test("Test7", null, null);
    }

    public static void main(String[] args) {
        EntryNodeInListLoop loop = new EntryNodeInListLoop();
        loop.test1();
        loop.test2();
        loop.test3();
        loop.test4();
        loop.test5();
        loop.test6();
        loop.test7();
    }

}
