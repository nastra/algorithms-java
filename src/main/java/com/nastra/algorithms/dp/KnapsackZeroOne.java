package com.nastra.algorithms.dp;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words,
 * given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. Also given an integer
 * W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or
 * equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 * 
 * @see http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 * @see http://en.wikipedia.org/wiki/Knapsack_problem
 * @author nastra
 * 
 */
public class KnapsackZeroOne {

    /**
     * Time complexity is O(2^n).
     * 
     * @param val
     *            The values
     * @param weight
     *            The weights of each value
     * @param W
     *            The capacity of the knapsack
     * @return The max value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
     */
    public static int knapsack(int[] val, int[] weight, int W) {
        return knapsack(val, weight, W, val.length - 1);
    }

    private static int knapsack(int[] val, int[] weight, int W, int i) {
        if (i < 0 || W <= 0) {
            return 0;
        }
        // the item is not included in the optimal subset
        if (weight[i] > W) {
            return knapsack(val, weight, W, i - 1);
        }

        // case 1: item is included in the optimal subset
        // case 2: item is not included in the optimal subset
        // result = max(case1, case2)
        int a = val[i] + knapsack(val, weight, W - weight[i], i - 1);
        int b = knapsack(val, weight, W, i - 1);
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        System.out.println("Max value using naive approach: " + knapsack(val, wt, W));
        System.out.println("Max value using DP approach: " + knapsackDP(val, wt, W));

        int[] val2 = {80, 30, 55, 90, 120, 35, 30};
        int[] wt2 = {30, 10, 50, 35, 90, 15, 20};
        W = 150;
        System.out.println("Max value using naive approach: " + knapsack(val2, wt2, W));
        System.out.println("Max value using DP approach: " + knapsackDP(val2, wt2, W));

        int[] val3 = {80, 30, 55, 90, 120, 35, 30, 89, 55, 5, 99, 150};
        int[] wt3 = {30, 10, 50, 35, 90, 15, 20, 123, 24, 66, 232, 98};
        W = 370;
        System.out.println("Max value using naive approach: " + knapsack(val3, wt3, W));
        System.out.println("Max value using DP approach: " + knapsackDP(val3, wt3, W));
    }

    /**
     * Time complexity is O(n * W) where n is the number of values and W is the capacity of the knapsack.
     * 
     * @param val
     *            The values
     * @param weight
     *            The weights of each value
     * @param W
     *            The capacity of the knapsack
     * @return The max value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
     */
    public static int knapsackDP(int[] val, int[] weight, int W) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weight[i - 1] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
                }
            }
        }
        return dp[n][W];
    }
}
