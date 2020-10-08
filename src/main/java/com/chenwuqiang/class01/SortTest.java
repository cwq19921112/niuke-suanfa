package com.chenwuqiang.class01;

import java.util.Arrays;

public class SortTest {

    private static final int DEFAULT_MAX_SIZE = 100;

    private static final int DEFAULT_MAX_VALUE = 100;

    public static void testNearLeft() {
        long startTime = System.currentTimeMillis();
        Code05_BSNearLeft nearLeft = new Code05_BSNearLeft();
        boolean flag = true;
        for (int i = 0; i < 400000; i++) {
            int target = (int) (Math.random() * DEFAULT_MAX_SIZE) + 1;
            int[] arr = ArrayUtils.randomArr(DEFAULT_MAX_SIZE, DEFAULT_MAX_VALUE);
            Arrays.sort(arr);

            int commonLeft = Code05_BSNearLeft.commonNearestIndex(arr, target);
            int left = Code05_BSNearLeft.nearestIndex(arr, target);

            if (!(commonLeft == left)) {
                flag = false;
                System.out.println("two left do not equal,arr= " + Arrays.toString(arr) + "target=" + target + "," +
                        "commonLeft=" + commonLeft + ",left=" + left);
                break;
            }
        }
        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println(flag ? "OK" : "NO");
    }

    public static void testBSExist() {
        long startTime = System.currentTimeMillis();
        Code04_BSExist bsExist = new Code04_BSExist();
        boolean flag = true;
        for (int i = 0; i < 400000; i++) {
            int target = (int) (Math.random() * DEFAULT_MAX_SIZE) + 1;
            int[] arr = ArrayUtils.randomArr(DEFAULT_MAX_SIZE, DEFAULT_MAX_VALUE);
            Arrays.sort(arr);

            boolean exist1 = Arrays.binarySearch(arr, target) >= 0;
            boolean exist2 = bsExist.exist(arr, target);

            if (!(exist1 == exist2)) {
                flag = false;
                System.out.println("exist not equal array,arr=" + Arrays.toString(arr) + ",target=" + target + "," +
                        "exist1=" + exist1 + "exist2=" + exist2);
                break;
            }
        }
        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println(flag ? "OK" : "NO");
    }

    public static void testSort(Sorted sorted) {
        testSort(sorted, DEFAULT_MAX_SIZE, DEFAULT_MAX_VALUE);
    }

    public static void testSort(Sorted sorted, int maxSize, int maxValue) {
        boolean flag = true;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 400000; i++) {
            int[] arr = ArrayUtils.randomArr(maxSize, maxValue);
            int[] copyArr = ArrayUtils.copyArr(arr);

            sorted.sort(copyArr);
            Arrays.sort(arr);

            if (!ArrayUtils.arrayEqual(arr, copyArr)) {
                flag = false;
                System.out.println("not equal array,arr1=" + Arrays.toString(arr) + "array2=" + Arrays.toString(copyArr));
                break;
            }
        }
        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println(flag ? "OK" : "NO");
    }
}
