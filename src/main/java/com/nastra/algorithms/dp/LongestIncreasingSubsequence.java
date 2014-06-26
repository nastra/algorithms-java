package com.nastra.algorithms.dp;

/**
 * The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the
 * subsequence are sorted in increasing order. For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50,
 * 60, 80}.
 * 
 * @see http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * @author nastra
 * 
 */
public class LongestIncreasingSubsequence {

    public static int lis(int[] in, int n) {
        if (n == 0) {
            return 1;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int longest = lis(in, i);
            if (in[i] < in[n] && longest + 1 > max) {
                max = longest + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 45, 80};
        System.out.println(lis(arr, arr.length - 1));
        System.out.println(lisDP(arr, arr.length));

        int in[] = {2, 4, 3, 5, 1, 7, 6, 9, 8};
        System.out.println(lis(in, in.length - 1));
        System.out.println(lisDP(in, in.length));
    }

    /**
     * The dynamic programming algorithms runs in time O(n^2) and requires O(n) amount of space
     * 
     * @param in
     * @param n
     * @return
     */
    public static int lisDP(int[] in, int n) {
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (in[j] < in[i]) {
                    len[i] = Math.max(len[j] + 1, len[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, len[i]);
        }
        return max;
    }
}
