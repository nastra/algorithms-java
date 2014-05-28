package com.nastra.algorithms;

public class MinCoins {

    public static int minCoins(int targetSum, int[] coins) {
        if (null == coins || coins.length == 0) {
            return Integer.MIN_VALUE;
        }
        int[] minCoins = new int[targetSum + 1];
        for (int i = 0; i < minCoins.length; i++) {
            minCoins[i] = Integer.MAX_VALUE;
        }
        minCoins[0] = 0;

        for (int i = 1; i <= targetSum; i++) {
            for (int j = 0; j < coins.length; j++) {
                int value = coins[j];
                if (value > i) {
                    break;
                }
                if (minCoins[i - value] + 1 < minCoins[i]) {
                    minCoins[i] = minCoins[i - value] + 1;
                }
            }

        }
        return minCoins[targetSum];
    }

    public static int min(int n, int[] coins) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        for (int i = 1; i <= n; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    res = Math.min(res, memo[i - coins[j]]) + 1;
                    memo[i] = res;
                }
            }
        }
        return memo[n];

    }
}
