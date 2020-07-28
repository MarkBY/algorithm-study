package com.markby.sort;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--)
            sink(nums, i, nums.length);

        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);

            sink(nums, 0, i);
        }
    }

    private void sink(T[] nums, int i, int length) {
        T temp = nums[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && less(nums[j], nums[j + 1]))
                j++;

            if (less(nums[j], temp)) {
                break;
            } else {
                nums[i] = nums[j];
                i = j;
            }
        }

        nums[i] = temp;

    }
}
