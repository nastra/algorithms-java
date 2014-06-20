package com.nastra.algorithms.dp;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * 
 * Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9 <br>
 * Output: True //There is a subset (4, 5) with sum 9.
 * 
 * @see http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 * @author nastra
 * 
 */
public class SubsetSum {

    /**
     * Uses a naive recursive algorithm an runs in non-polynomial time.
     * 
     * @param s
     * @param n
     * @param sum
     * @return
     */
    public static boolean isSubsetSum(int[] s, int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n <= 0 && sum != 0) {
            return false;
        }

        // include the last element in the search - exclude last element from search
        return isSubsetSum(s, n - 1, sum) || isSubsetSum(s, n - 1, sum - s[n - 1]);
    }

    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        System.out.println("Maximum Obtainable Value is: " + isSubsetSum(arr, arr.length, 9));
        System.out.println("Maximum Obtainable Value is: " + isSubsetSumDP(arr, arr.length, 9));
    }

    /**
     * Solves the subset sum problem using a dynamic programming approach. The time complexity is O(sum*n).
     * 
     * @param s
     * @param n
     * @param sum
     * @return
     */
    public static boolean isSubsetSumDP(int[] s, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= s[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - s[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }
}
