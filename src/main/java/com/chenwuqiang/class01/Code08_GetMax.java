package com.chenwuqiang.class01;

public class Code08_GetMax {
    // arr[L..R]范围上求最大值    		N
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return L;
        }

        int mid = L + (R - L) >> 2;
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);

        return Math.max(leftMax, rightMax);
    }
}
