package com.chenwuqiang.class01;

public class Code01_SelectionSort implements Sorted {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SortTest.testSort(new Code01_SelectionSort());
        }
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }

            ArrayUtils.swap(arr, i, minIndex);
        }
    }
}
