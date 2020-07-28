package com.markby.sort;

// 堆排序
// 1.上浮和下沉
// 2.插入元素
// 3.删除最大元素
public class Heap<T extends Comparable<T>> {
    private T[] heap;
    private int N = 0;

    public Heap(int maxN) {
        this.heap = (T[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    public void insert(T v) {
        heap[++N] = v;
        swim(N);
    }

    public T delMax() {
        T max = heap[1];
        swap(1, N--);
        heap[N + 1] = null;
        sink(1);
        return max;
    }

    public static void main(String[] args) {
        Integer[] nums = {27, 10, 32, 9, 50, 24, 49, 11, 37, 46};
        Heap integerHeap = new Heap(nums.length);

        for (Integer num : nums) {
            integerHeap.insert(num);
        }
        System.out.println();

    }

}
