package com.markby.offer.Knowledge_transfer_ability;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

// 面试题59（二）：队列的最大值
// 请定义一个队列并实现函数 max_value 得到队列里的最大值，
// 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
public class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;
    public MaxQueue() {
        deque = new ArrayDeque<>();
        queue = new ArrayDeque<>();
    }

    public int max_value() {
        return deque.size() > 0 ? deque.peekFirst() : -1;
    }

    public void push_back(int value) {
        queue.add(value);
        while (deque.size() > 0 && value >= deque.peekLast())
            deque.removeLast();
        deque.addLast(value);
    }

    public int pop_front() {
        int tmp = queue.size() > 0 ? queue.remove() : -1;

        if (!deque.isEmpty() && deque.peekFirst().equals(tmp))
            deque.removeFirst();

        return tmp;
    }
}
/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */