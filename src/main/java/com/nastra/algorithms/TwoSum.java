package com.nastra.algorithms;

/**
 * Solves the 2Sum Problem using binary search and therefore requires O(n lg n) time. However, this could be improved to O(n) by using a Hashmap
 *
 * @author nastra
 */
public class TwoSum {

    public static boolean hasSum(int[] in, int target) {
        if (null == in || in.length < 2) {
            return false;
        }

        int low = 1;
        int high = in.length - 1;

        for (int i = 0; i < in.length; i++) {
            low = i + 1;
            if (target < in[high]) {
                high = high - 1;
            }

            while (low <= high) {
                int mid = (low + high) / 2;
                int x = target - in[i];
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
}
