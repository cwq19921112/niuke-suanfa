package com.chenwuqiang.class01;

public class Code02_BubbleSort implements Sorted {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SortTest.testSort(new Code02_BubbleSort());
        }
    }

    @Override
    public void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }
            }
        }
    }
}
