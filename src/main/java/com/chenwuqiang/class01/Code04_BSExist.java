package com.chenwuqiang.class01;

public class Code04_BSExist {

    public static void main(String[] args) {
        SortTest.testBSExist();
    }

    public boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null && sortedArr.length == 0) {
            return false;
        }

        int left = 0;
        int right = sortedArr.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 2);
            if (num == sortedArr[mid]) {
                return true;
            } else if (num > sortedArr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}
