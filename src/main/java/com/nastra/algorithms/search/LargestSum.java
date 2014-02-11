package com.nastra.algorithms.search;

/**
 * @author nastra - Eduard Tudenhoefner
 */
public class LargestSum {

    /**
     * This algorithm uses a divide-and-conquer approach and runs in time O(n log n).
     * 
     * @param in
     *            The input containing positive and negative numbers.
     * @return The largest sum in a contiguous sequence of numbers.
     */
    public static int largestSum(int[] in) {
        return largestSum(in, 0, in.length - 1);
    }

    private static int largestSum(int[] in, int low, int high) {
        if (low == high) { // base case where there is only one element;
            return in[low];
        }
        int mid = (low + high) / 2;
        int leftSum = largestSum(in, low, mid);
        int rightSum = largestSum(in, mid + 1, high);

        int crossSum = findCrossingSum(in, low, mid, high);
        return determineMax(leftSum, rightSum, crossSum);
    }

    private static int findCrossingSum(int[] in, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int i = mid;
        while (low <= i) {
            sum = sum + in[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
            i--;
        }
        int j = mid + 1;
        sum = 0;
        while (j <= high) {
            sum = sum + in[j];
            if (sum > rightSum) {
                rightSum = sum;
            }
            j++;
        }
        return leftSum + rightSum;
    }

    private static int determineMax(int one, int two, int three) {
        if (one >= two && one >= three) {
            return one;
        }
        if (two >= one && two >= three) {
            return two;
        }
        return three;
    }
}
