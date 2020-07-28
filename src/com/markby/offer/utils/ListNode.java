package com.markby.offer.utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static void connectListNodes(ListNode pCurrent, ListNode pNext) {
        if (pCurrent == null) {
            System.out.println("Error to connect two nodes.\n");
            return;
        }

        pCurrent.next = pNext;
    }

    public static void printListNode(ListNode pNode) {
        if (pNode == null) {
            System.out.println("The node is null.");
        } else {
            System.out.println("The key in node is " + pNode.val + ".");
        }
    }

    public static void printList(ListNode pHead) {
        System.out.println("PrintList starts.");

        ListNode pNode = pHead;
        while (pNode != null) {
            System.out.println(pNode.val + "\t");
            pNode = pNode.next;
        }

        System.out.println("\nPrintList ends.");
    }

    public static ListNode addToTail(ListNode pHead, int value) {
        ListNode pNew = new ListNode(value);

        if (pHead == null) {
            pHead = pNew;
        } else {
            ListNode pNode = pHead;
            while (pNode.next != null)
                pNode = pNode.next;

            pNode.next = pNew;
        }

        return pHead;
    }
}
