package com.markby.LeetCode.sort.heap;

// 215. Kth Largest Element in an Array (Medium)
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        if(nums==null) return 0;
        return quickSort(nums,k-1,0,nums.length-1);
    }

    public int quickSort(int[] nums,int n,int start,int end){
        if(start>=end) return nums[n];
        int left=start,right=end;
        int pivot = nums[left+(right-left)/2];
        while(left<=right){
            while(left<=right && nums[left]>pivot) left++;
            while(left<=right && nums[right]<pivot) right--;
            if(left<=right) {
                int tmp = nums[left];
                nums[left]=nums[right];
                nums[right]=tmp;
                left++;right--;
            }
        }
        if(n<=right) return quickSort(nums,n,start,right);
        if(n>=left) return quickSort(nums,n,left,end);
        return pivot;
    }

    public int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    // 堆排序
    public int findKthLargest1(int[] nums, int k) {
        for (int i = nums.length / 2 - 1; i >= 0; i--)
            sink(nums, i, nums.length);

        for (int i = 0; i < k; i++) {
            int length = nums.length - 1 - i;
            swap(nums, 0, length);
            sink(nums, 0, length);
        }

        return nums[nums.length - k];
    }

    private void sink(int[] nums, int i, int length) {
        int tmp = nums[i];
        for (int j = i * 2 + 1; j < length; j = 2 * j + 1) {
            if (j + 1 < length && less(nums[j], nums[j + 1]))
                j++;

            if (less(tmp, nums[j])) {
                nums[i] = nums[j];
                i = j;
            } else
                break;
        }

        nums[i] = tmp;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean less(int num1, int num2) {
        return num1 - num2 < 0;
    }

    //=======================test==================================
    void test(String testName, int[] nums, int k, int expected) {
        System.out.println(testName + " begin:");

        int result = findKthLargest(nums, k);

        if (result == expected)
            System.out.println("passed.");
        else
            System.out.println("Failed.");

        System.out.println();
    }

    void test1() {
        //输入: [3,2,1,5,6,4] 和 k = 2
        //输出: 5
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int expected = 5;
        test("test1", nums, k, expected);

    }

    void mainTest() {
        test1();
    }

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        kthLargestElement.mainTest();
    }
}
