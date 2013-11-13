package com.nastra.algorithms;

/**
 * Provides different implementations to solve the 2-sum problem. The problem consists of the following statement:
 * <br>
 * Given an integer x and a sorted array of integers, describe an algorithm to determine whether two of the numbers add up to x.
 *
 * @author nastra
 */
public class TwoSumSolver {

    /**
     * Uses a binary search approach and requires O(n lg n) time.
     *
     * @param in The sorted array
     * @param targetSum The target sum
     * @return True, if the array contains two number that sum up to the target sum
     */
    public static boolean hasSum(int[] in, int targetSum) {
        if (null == in || in.length < 2) {
            return false;
        }

        for (int i = 0; i < in.length; i++) {
            int low = i + 1;
            int high = in.length - 1;
            if (targetSum < in[high]) {
                high = high - 1;
            }

            while (low <= high) {
                int mid = (low + high) / 2;
                int x = targetSum - in[i];
                if (x == in[mid]) {
                    return true;
                } else if (x < in[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    /**
     * @param in The sorted array
     * @param targetSum The target sum
     * @return True, if the array contains two number that sum up to the target sum
     */
    public static boolean hasSumOptimized(int[] in, int targetSum) {
        if (null == in || in.length < 2) {
            return false;
        }
        if (!largestSumPossible(in, targetSum)) {
            return false;
        }

        int start = 0;
        int end = in.length - 1;

        while (start < end) {
            int currentSum = in[start] + in[end];
            if (currentSum < targetSum) {
                start++;
            } else if (currentSum > targetSum) {
                end--;
            } else {
                return true;
            }
        }

        return false;
    }

    private static boolean largestSumPossible(int[] in, int targetSum) {
        return (in[in.length - 1] + in[in.length - 2]) >= targetSum;
    }
}
