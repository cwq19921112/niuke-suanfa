package com.chenwuqiang.class01;

public class Code07_EvenTimesOddTimes {
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int v : arr) {
            eor ^= v;
        }
        System.out.println(eor);
    }

    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int v : arr) {
            eor ^= v;
        }

        // 取最右的1
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int value : arr) {
            if ((value & rightOne) != 0) {
                onlyOne ^= value;
            }
        }

        System.out.println(onlyOne + "---------" + (onlyOne ^ eor));
    }
}
