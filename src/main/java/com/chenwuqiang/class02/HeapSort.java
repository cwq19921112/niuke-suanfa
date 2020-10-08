package com.chenwuqiang.class02;

import com.chenwuqiang.class01.ArrayUtils;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
        }

        int maxIndex = arr.length - 1;
        ArrayUtils.swap(arr, 0, maxIndex--);
        while (maxIndex > 0) {
//            heapify(arr, 0, maxIndex);
            ArrayUtils.swap(arr, 0, maxIndex--);
        }
    }
}
