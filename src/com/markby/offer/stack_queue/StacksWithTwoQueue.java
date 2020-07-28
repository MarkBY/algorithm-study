package com.markby.offer.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class StacksWithTwoQueue {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        if (queue1.isEmpty())
            queue2.add(node);
        else
            queue1.add(node);
    }

    public int pop() {
        while (!queue1.isEmpty()) {
            int temp = queue1.remove();
            if (!queue1.isEmpty())
                queue2.add(temp);
            else
                return temp;
        }

        while (!queue2.isEmpty()) {
            int temp = queue2.remove();
            if (!queue2.isEmpty())
                queue1.add(temp);
            else
                return temp;
        }

        return queue1.remove();
    }

    // ====================测试代码====================
    void test(int actual, int expected) {
        if (actual == expected)
            System.out.printf("Test passed.\n");
        else
            System.out.printf("Test failed.\n");
    }

    public static void main(String[] args) {
        StacksWithTwoQueue stack = new StacksWithTwoQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        int head = stack.pop();
        stack.test(head, 3);

        head = stack.pop();
        stack.test(head, 2);

        stack.push(4);
        head = stack.pop();
        stack.test(head, 4);

        stack.push(5);
        head = stack.pop();
        stack.test(head, 5);

        head = stack.pop();
        stack.test(head, 1);


    }
}
