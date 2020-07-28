package com.markby.offer.materialize_abstractproblem_with_examples;

import java.util.Stack;

// 面试题30：包含min函数的栈
// 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min
// 函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。
public class MinStack {
    /**
     * initialize your data structure here.
     */
    private Stack<Integer> stack, auxiliaryStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.auxiliaryStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (auxiliaryStack.isEmpty() || auxiliaryStack.peek() >= x)
            auxiliaryStack.push(x);
//        if (auxiliaryStack.isEmpty())
//            auxiliaryStack.push(x);
//        else {
//            int temp = auxiliaryStack.peek();
//            if (temp < x)
//                auxiliaryStack.push(temp);
//            else
//                auxiliaryStack.push(x);
//        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        if (stack.pop().equals(auxiliaryStack.peek()))
            auxiliaryStack.pop();

//        if (stack.isEmpty())
//            return;
//        else {
//            stack.pop();
//            auxiliaryStack.pop();
//        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return auxiliaryStack.peek();
    }

    // ====================测试代码====================
    void test(String testName, MinStack stack, int expected) {
        if (testName != null)
            System.out.printf("%s begins: ", testName);

        if (stack.min() == expected)
            System.out.printf("Passed.\n");
        else
            System.out.printf("Failed.\n");
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(3);
        stack.test("Test1", stack, 3);

        stack.push(4);
        stack.test("Test2", stack, 3);

        stack.push(2);
        stack.test("Test3", stack, 2);

        stack.push(3);
        stack.test("Test4", stack, 2);

        stack.pop();
        stack.test("Test5", stack, 2);

        stack.pop();
        stack.test("Test6", stack, 3);

        stack.pop();
        stack.test("Test7", stack, 3);

        stack.push(0);
        stack.test("Test8", stack, 0);
    }
}
