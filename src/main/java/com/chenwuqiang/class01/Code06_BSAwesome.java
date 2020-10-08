package com.chenwuqiang.class01;

public class Code06_BSAwesome {
    public static int getLessIndex(int[] arr) {
        int lessIndex = -1;
        if (arr == null || arr.length == 0) {
            return lessIndex;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length-1] < arr[arr.length-2]) {
            return arr.length -1;
        }

        int mid = -1;
        int left = 1;
        int right = arr.length -2;
        while (left <= right) {
            mid = left + ((right - left) >> 2);
            if ((arr[mid] < arr[mid-1]) && (arr[mid] > arr[mid + 1])) {
                return mid;
            } else if (arr[mid - 1] < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return lessIndex;
    }
}
