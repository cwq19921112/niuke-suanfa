package com.chenwuqiang.class01;

public class Code03_InsertionSort implements Sorted{

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SortTest.testSort(new Code03_InsertionSort());
        }
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                ArrayUtils.swap(arr, j, j + 1);
            }
        }
    }
}
