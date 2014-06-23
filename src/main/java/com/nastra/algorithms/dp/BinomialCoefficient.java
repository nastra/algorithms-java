package com.nastra.algorithms.dp;

/**
 * A binomial coefficient C(n, k) also gives the number of ways, disregarding order, that k objects can be chosen from among n objects; more formally,
 * the number of k-element subsets (or k-combinations) of an n-element set.
 * 
 * @see http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 * @author nastra
 * 
 */
public class BinomialCoefficient {

    /**
     * Uses dynamic programming approach and runs in time O(n*k) and uses the same amount of space.
     * 
     * @param n
     * @param k
     * @return
     */
    public static long binomialCoeff(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        System.out.println(binomialCoeff(48, 6));
        System.out.println(binomialCoeff(7, 3));
        System.out.println(binomialCoeff(7, 7));
        System.out.println(binomialCoeff(7, 8));
    }
}
