package com.markby.offer.stack_queue;

import java.util.Stack;

// 面试题9：用两个栈实现队列
// 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
// 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
public class QueueWithTwoStacks {
    Stack<Integer> stack1, stack2;

    public QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty())
            return -1;

        if (!stack2.isEmpty())
            return stack2.pop();

        while (!stack1.isEmpty()) {
            int temp = stack1.pop();
            stack2.push(temp);
        }
        return stack2.pop();
    }

    // ====================测试代码====================
    void test(int actual, int expected) {
        if (actual == expected)
            System.out.printf("Test passed.\n");
        else
            System.out.printf("Test failed.\n");
    }

    public static void main(String[] args) {
        QueueWithTwoStacks stack = new QueueWithTwoStacks();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        int head = stack.pop();
        stack.test(head, 1);

        head = stack.pop();
        stack.test(head, 2);

        stack.push(4);
        head = stack.pop();
        stack.test(head, 3);

        stack.push(5);
        head = stack.pop();
        stack.test(head, 4);

        head = stack.pop();
        stack.test(head, 5);


    }

}
