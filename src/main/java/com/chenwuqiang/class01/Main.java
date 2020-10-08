package com.chenwuqiang.class01;

public class Main {

    public class Solution {
        public int Fibonacci(int n) {
            if (n < 2) {
                return n;
            }

            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
}
