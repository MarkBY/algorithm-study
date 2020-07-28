package com.markby.offer.list;

import com.markby.offer.utils.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromTailToHead {
    public static void main(String[] args) {
        ListNode l0 = null;
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        ListNode.connectListNodes(l1, l2);
        ListNode.connectListNodes(l2, l3);
        ListNode.connectListNodes(l3, l4);
        ListNode.connectListNodes(l4, l5);
        ListNode.addToTail(l1, 6);

        ListNode.printList(l1);

        ArrayList resultList = printListFromTailToHead(l1);

        System.out.println(resultList);

    }


    public static ArrayList<Integer> resultList = new ArrayList<>();

    /**
     * 递归
     * <p>
     * 运行时间：19ms
     * 占用内存：9424k
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            resultList.add(listNode.val);
        }
        return resultList;
    }

    /**
     * 用栈
     * <p>
     * 运行时间：17ms
     * 占用内存：9428k
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        ListNode p = listNode;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            list.add(pop);
        }

        return list;
    }
}



