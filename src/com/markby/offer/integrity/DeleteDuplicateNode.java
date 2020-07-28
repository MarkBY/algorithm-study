package com.markby.offer.integrity;

import com.markby.offer.utils.ListNode;

public class DeleteDuplicateNode {
    public void deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return;

        ListNode pPreNode = null;
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            boolean needDelete = false;
            if (pNext != null && pNext.val == pNode.val)
                needDelete = true;

            if (!needDelete) {
                pPreNode = pNode;
                pNode = pNode.next;
            } else {
                int value = pNode.val;
                ListNode pToBeDal = pNode;
                while (pToBeDal != null && pToBeDal.val == value) {
                    pNext = pToBeDal.next;

                    pToBeDal = null;
                    pToBeDal = pNext;
                }
                if (pPreNode == null)
                    pHead = pNext;
                else
                    pPreNode.next = pNext;
                pNode = pNext;
            }
        }
    }

    // ====================测试代码====================
    void test(String testName, ListNode pHead, int[] expectedValues, int expectedLength) {
        if (testName != null)
            System.out.printf("%s begins: ", testName);

        deleteDuplication(pHead);

        int index = 0;
        ListNode pNode = pHead;
        while (pNode != null && index < expectedLength) {
            if (pNode.val != expectedValues[index])
                break;

            pNode = pNode.next;
            index++;
        }

        if (pNode == null && index == expectedLength)
            System.out.printf("Passed.\n");
        else
            System.out.printf("FAILED.\n");
    }

    // 某些结点是重复的
    void test1() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(3);
        ListNode pNode5 = new ListNode(4);
        ListNode pNode6 = new ListNode(4);
        ListNode pNode7 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);
        ListNode.connectListNodes(pNode5, pNode6);
        ListNode.connectListNodes(pNode6, pNode7);

        ListNode pHead = pNode1;

        int expectedValues[] = {1, 2, 5};
        test("Test1", pHead, expectedValues, expectedValues.length);

    }

    // 没有重复的结点
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
        ListNode.connectListNodes(pNode4, pNode5);
        ListNode.connectListNodes(pNode5, pNode6);
        ListNode.connectListNodes(pNode6, pNode7);

        ListNode pHead = pNode1;

        int expectedValues[] = {1, 2, 3, 4, 5, 6, 7};
        test("Test2", pHead, expectedValues, expectedValues.length);

    }

    // 除了一个结点之外其他所有结点的值都相同
    void test3() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(1);
        ListNode pNode3 = new ListNode(1);
        ListNode pNode4 = new ListNode(1);
        ListNode pNode5 = new ListNode(1);
        ListNode pNode6 = new ListNode(1);
        ListNode pNode7 = new ListNode(2);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);
        ListNode.connectListNodes(pNode5, pNode6);
        ListNode.connectListNodes(pNode6, pNode7);

        ListNode pHead = pNode1;

        int expectedValues[] = {2};
        test("Test3", pHead, expectedValues, expectedValues.length);


    }

    // 所有结点的值都相同
    void test4() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(1);
        ListNode pNode3 = new ListNode(1);
        ListNode pNode4 = new ListNode(1);
        ListNode pNode5 = new ListNode(1);
        ListNode pNode6 = new ListNode(1);
        ListNode pNode7 = new ListNode(1);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);
        ListNode.connectListNodes(pNode5, pNode6);
        ListNode.connectListNodes(pNode6, pNode7);

        ListNode pHead = pNode1;

        test("Test4", pHead, null, 0);


    }

    // 所有结点都成对出现
    void test5() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(1);
        ListNode pNode3 = new ListNode(2);
        ListNode pNode4 = new ListNode(2);
        ListNode pNode5 = new ListNode(3);
        ListNode pNode6 = new ListNode(3);
        ListNode pNode7 = new ListNode(4);
        ListNode pNode8 = new ListNode(4);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);
        ListNode.connectListNodes(pNode5, pNode6);
        ListNode.connectListNodes(pNode6, pNode7);
        ListNode.connectListNodes(pNode7, pNode8);

        ListNode pHead = pNode1;

        test("Test5", pHead, null, 0);


    }

    // 除了两个结点之外其他结点都成对出现
    void test6() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(1);
        ListNode pNode3 = new ListNode(2);
        ListNode pNode4 = new ListNode(3);
        ListNode pNode5 = new ListNode(3);
        ListNode pNode6 = new ListNode(4);
        ListNode pNode7 = new ListNode(5);
        ListNode pNode8 = new ListNode(5);

        ListNode.connectListNodes(pNode1, pNode2);
        ListNode.connectListNodes(pNode2, pNode3);
        ListNode.connectListNodes(pNode3, pNode4);
        ListNode.connectListNodes(pNode4, pNode5);
        ListNode.connectListNodes(pNode5, pNode6);
        ListNode.connectListNodes(pNode6, pNode7);
        ListNode.connectListNodes(pNode7, pNode8);

        ListNode pHead = pNode1;

        int expectedValues[] = {2, 4};
        test("Test6", pHead, expectedValues, expectedValues.length);


    }

    // 链表中只有两个不重复的结点
    void test7() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);

        ListNode.connectListNodes(pNode1, pNode2);

        ListNode pHead = pNode1;

        int expectedValues[] = {1, 2};
        test("Test7", pHead, expectedValues, expectedValues.length);


    }

    // 结点中只有一个结点
    void test8() {
        ListNode pNode1 = new ListNode(1);

        ListNode.connectListNodes(pNode1, null);

        ListNode pHead = pNode1;

        int expectedValues[] = {1};
        test("Test8", pHead, expectedValues, expectedValues.length);


    }

    // 结点中只有两个重复的结点
    void test9() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(1);

        ListNode.connectListNodes(pNode1, pNode2);

        ListNode pHead = pNode1;

        test("Test9", pHead, null, 0);


    }

    // 空链表
    void test10() {
        ListNode pHead = null;

        test("Test10", pHead, null, 0);
    }

    public static void main(String[] args) {
        DeleteDuplicateNode d = new DeleteDuplicateNode();
        d.test1();
        d.test2();
        d.test3();
        d.test4();
        d.test5();
        d.test6();
        d.test7();
        d.test8();
        d.test9();
        d.test10();
    }

}
