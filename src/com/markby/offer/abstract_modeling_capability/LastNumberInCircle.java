package com.markby.offer.abstract_modeling_capability;

// 面试题62：圆圈中最后剩下的数字
// 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
// 删除第m个数字。求出这个圆圈里剩下的最后一个数字。
public class LastNumberInCircle {

    public int lastRemaining(int n, int m) {
        if (n == 0 || m == 0)
            return -1;
        int last = 0;
        for (int i =2; i <= n; i++){
            last = (last + m) % i;
        }
        return last;
    }

    public int lastRemaining1(int n, int m) {
        if (n == 0 || m == 0)
            return -1;
        Circle circle = new Circle(0);
        Circle pNode = circle;
        for (int i = 1; i < n; i++){
            Circle tmp = new Circle(i);
            pNode.next = tmp;
            pNode = tmp;
        }

        pNode.next = circle;

        while (pNode.next != pNode){
            for (int i = m - 1; i > 0; i--)
                pNode = pNode.next;
            pNode.next = pNode.next.next;
        }

        return pNode.val;
    }

    // ====================测试代码====================
    void test(String testName, int n, int m, int expected) {
        if (testName != null)
            System.out.println(testName + " begins: \n");

        int result = lastRemaining(n, m);
        System.out.println(result);

        if (result == expected)
            System.out.println("passed.\n");
        else
            System.out.println("failed.\n");

    }

    void test1() {
        test("test1", 5, 3, 3);
    }

    void test2() {
        test("test2", 5, 2, 2);
    }

    void test3() {
        test("test3", 6, 7, 4);
    }

    void test4() {
        test("test4", 6, 6, 3);
    }

    void test5() {
        test("test5", 0, 0, -1);
    }

    void test6() {
        test("test6", 4000, 997, 1027);
    }

    void mainTest() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();

    }

    public static void main(String[] args) {
        LastNumberInCircle lastNumber = new LastNumberInCircle();

        lastNumber.mainTest();
    }
}
class Circle{
    int val;
    Circle next;

    public Circle(int val){
        this.val = val;
    }
}
