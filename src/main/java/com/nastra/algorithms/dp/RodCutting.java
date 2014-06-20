package com.nastra.algorithms.dp;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value
 * obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given as
 * following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6).
 * 
 * @see http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 * 
 * @author nastra - Eduard Tudenhoefner
 * 
 */
public class RodCutting {

    /**
     * Naive, recursive solution where subproblems are calculated over and over again. The time complexity is O(2^n) because subproblems are solved
     * over and over again and because we have the number of possible recursive tree nodes is 2^n-1.
     * 
     * @param price
     * @param n
     * @return
     */
    public static int cutRod(int[] price, int n) {
        if (n == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, price[i] + cutRod(price, n - i - 1));
        }
        return max;
    }

    /**
     * Uses a dynamic programming approach. The time complexity of this solution is O(n^2) because each subproblem is solved exactly once.
     * 
     * @param price
     * @param n
     * @return
     */
    public static int cutRodDP(int[] price, int n) {
        if (n == 0) {
            return 0;
        }
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, price[j] + dp[i - j - 1]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Maximum Obtainable Value is: " + cutRod(arr, arr.length));
        System.out.println("Maximum Obtainable Value is: " + cutRodDP(arr, arr.length));
    }
}
