package com.chenwuqiang.class01;

public class Code05_BSNearLeft {
    public static void main(String[] args) {
        SortTest.testNearLeft();
    }

    // 在arr上，找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int value) {
        int leftIndex = -1;
        if (arr == null || arr.length == 0) {
            return leftIndex;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 2);
            if (arr[mid] >= value) {
                leftIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return leftIndex;
    }

    public static int commonNearestIndex(int[] arr, int value) {
        int leftIndex = -1;
        if (arr == null || arr.length == 0) {
            return leftIndex;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }

        return leftIndex;
    }
}
