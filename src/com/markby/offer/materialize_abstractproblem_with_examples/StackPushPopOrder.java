package com.markby.offer.materialize_abstractproblem_with_examples;

import java.util.Stack;

// 面试题31：栈的压入、弹出序列
// 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
// 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
// 5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
// 4、3、5、1、2就不可能是该压栈序列的弹出序列。
public class StackPushPopOrder {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length)
            return false;

        boolean result = false;

        Stack<Integer> stack = new Stack<>();
        int i = 0; // pushed
        int j = 0; // popped
        while (j < popped.length) {
            // 当辅助栈的栈顶元素不是要弹出的元素
            // 先压入一些数字入栈
            while (stack.isEmpty() || stack.peek() != popped[j]) {
                // 如果所有数字都压入辅助栈了，退出循环
                if (i == pushed.length)
                    break;
                stack.push(pushed[i]);
                i++;
            }

            if (stack.peek() != popped[j])
                break;

            stack.pop();
            j++;
        }

        if (stack.isEmpty() && j == popped.length)
            result = true;
        return result;
    }

    // ====================测试代码====================
    void test(String testName, int[] pPush, int[] pPop, boolean expected) {
        if (testName != null)
            System.out.printf("%s begins: ", testName);

        if (validateStackSequences(pPush, pPop) == expected)
            System.out.printf("Passed.\n");
        else
            System.out.printf("failed.\n");
    }

    void test1() {
        int push[] = {1, 2, 3, 4, 5};
        int pop[] = {4, 5, 3, 2, 1};

        test("Test1", push, pop, true);
    }

    void test2() {

        int push[] = {1, 2, 3, 4, 5};
        int pop[] = {3, 5, 4, 2, 1};

        test("Test2", push, pop, true);
    }

    void test3() {

        int push[] = {1, 2, 3, 4, 5};
        int pop[] = {4, 3, 5, 1, 2};

        test("Test3", push, pop, false);
    }

    void test4() {

        int push[] = {1, 2, 3, 4, 5};
        int pop[] = {3, 5, 4, 1, 2};

        test("Test4", push, pop, false);
    }

    // push和pop序列只有一个数字
    void test5() {

        int push[] = {1};
        int pop[] = {2};

        test("Test5", push, pop, false);
    }

    void test6() {

        int push[] = {1};
        int pop[] = {1};

        test("Test6", push, pop, true);
    }

    void test7() {
        test("Test7", null, null, false);
    }

    public static void main(String[] args) {
        StackPushPopOrder stack = new StackPushPopOrder();
        stack.test1();
        stack.test2();
        stack.test3();
        stack.test4();
        stack.test5();
        stack.test6();
        stack.test7();
    }


}
