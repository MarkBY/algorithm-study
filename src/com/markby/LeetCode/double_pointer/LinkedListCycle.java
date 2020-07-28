package com.markby.LeetCode.double_pointer;

import com.markby.offer.utils.ListNode;

// 141. Linked List Cycle (Easy)
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null){
            if (fast.next != null){
                slow = slow.next;
                fast = fast.next;
            }
            fast = fast.next;

            if (slow == fast)
                return true;

        }

        return false;
    }

    //=======================test==================================
    void test(String testName, ListNode head, boolean expected){
        System.out.println(testName + " begin:");

        boolean success = hasCycle(head);

        if (success == expected)
            System.out.println("passed.");
        else
            System.out.println("Failed.");

        System.out.println();
    }

    // 3 -> 2 -> 0 -> -4
    //      |          |
    //       <--------<
    void test1(){
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode0 = new ListNode(0);
        ListNode listNode_4 = new ListNode(-4);

        ListNode.connectListNodes(listNode3, listNode2);
        ListNode.connectListNodes(listNode2, listNode0);
        ListNode.connectListNodes(listNode0, listNode_4);
        ListNode.connectListNodes(listNode_4, listNode2);

        test("test1", listNode3, true);


    }

    void mainTest(){
        test1();
    }

    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        linkedListCycle.mainTest();
    }

}
