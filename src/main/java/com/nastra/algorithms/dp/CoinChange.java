package com.nastra.algorithms.dp;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways
 * can we make the change? The order of coins doesn’t matter.
 * 
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5,
 * 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 * 
 * @see http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * @author nastra
 * 
 */
public class CoinChange {

    public static int count(int[] s, int m, int amount) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        if (m <= 0) {
            return 0;
        }
        return count(s, m - 1, amount) + count(s, m, amount - s[m - 1]);
    }

    public static void main(String[] args) {
        int[] s = {1, 2, 3};
        System.out.println(count(s, s.length, 4));
        System.out.println(countDP(s, s.length, 4));

        int[] s2 = {2, 5, 3, 6};
        System.out.println(count(s2, s2.length, 10));
        System.out.println(countDP(s2, s2.length, 10));

    }

    /**
     * Runs in time O(m*amount)
     * 
     * @param s
     * @param m
     * @param amount
     * @return
     */
    public static int countDP(int[] s, int m, int amount) {
        int[][] dp = new int[amount + 1][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < m; j++) {
                int x = (j > 0) ? dp[i][j - 1] : 0;
                int y = (i - s[j] >= 0) ? dp[i - s[j]][j] : 0;
                dp[i][j] = x + y;
            }
        }
        return dp[amount][m - 1];
    }
}
