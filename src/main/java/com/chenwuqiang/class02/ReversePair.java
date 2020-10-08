package com.chenwuqiang.class02;

import com.chenwuqiang.class01.ArrayUtils;

import java.util.Arrays;

public class ReversePair {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            testReversePairCount();
        }
    }

    private static void testReversePairCount() {
        boolean flag = true;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 400000; i++) {
            int[] arr = ArrayUtils.randomArr(100, 100);
            int[] copyArr = ArrayUtils.copyArr(arr);
            int[] printArr = ArrayUtils.copyArr(arr);
            int count1 = reversePairCount(arr);
            int count2 = comReversePairCount(copyArr);

            if (count1 != count2) {
                flag = false;
                System.out.println("count not equal array,arr=" + Arrays.toString(printArr) + "count1=" + count1 + ",count2=" + count2);
                break;
            }
        }
        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println(flag ? "OK" : "NO");
    }

    public static int reversePairCount(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return reversePairCount(arr, 0, arr.length - 1);
    }

    public static int reversePairCount(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return reversePairCount(arr, left, mid)
                + reversePairCount(arr, mid + 1, right)
                + merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int count = 0;
        while (p1 <= mid && p2 <= right) {
            count += arr[p1] > arr[p2] ? mid - p1 + 1 : 0;
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
        return count;
    }

    public static int comReversePairCount(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                count += arr[i] > arr[j] ? 1 : 0;
            }
        }
        return count;
    }
}
