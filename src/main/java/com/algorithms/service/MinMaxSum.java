package com.algorithms.service;

import java.math.BigInteger;
import java.util.Arrays;

public class MinMaxSum {
    public static void main(String[] args) {
        int[] arr = {256741038, 623958417, 467905213, 714532089, 938071625};
        miniMaxSum(arr);
    }
    // Primitive streams are limited mainly because of boxing overhead and because creating specialized streams for
    // other primitives isn't' that useful in many cases.
    private static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);

        long sum = addValues(arr);
        BigInteger min = BigInteger.valueOf(sum - arr[arr.length - 1]);
        BigInteger max = BigInteger.valueOf(sum - arr[0]);
        System.out.print(min + " " + max);
    }

    private static long addValues(int[] arr) {
        long sum = 0;
        for (int anArr : arr) {
            sum += anArr;
        }
        return sum;
    }
}
