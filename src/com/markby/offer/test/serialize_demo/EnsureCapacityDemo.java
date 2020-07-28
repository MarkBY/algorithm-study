package com.markby.offer.test.serialize_demo;

import java.util.ArrayList;

//向 ArrayList 添加大量元素之前最好先使用ensureCapacity 方法，以减少增量重新分配的次数
public class EnsureCapacityDemo {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法前：" + (endTime - startTime));

        ArrayList<Object> list1 = new ArrayList<Object>();
        final int N1 = 10000000;
        list = new ArrayList<Object>();
        long startTime1 = System.currentTimeMillis();
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法后：" + (endTime1 - startTime1));

    }
}
