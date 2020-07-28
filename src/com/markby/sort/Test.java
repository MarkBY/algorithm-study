package com.markby.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {

    @org.junit.Test
    public void test1(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //Integer tmp = list.set(1, 5);
        list.set(0,list.set(1,list.get(0)));
        //System.out.println(tmp);
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(50);
        }
        System.out.println(Arrays.toString(arr));
//        HeapSort<Integer> sort = new HeapSort<>();
        QuickSort<Integer> sort = new QuickSort<>();

        sort.sort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
