package com.nastra.algorithms.dp;

import java.util.Arrays;

/**
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that
 * appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of
 * “abcdefg”.
 * 
 * @see http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * 
 * @author nastra
 * 
 */
public class LongestCommonSubsequence {
    /**
     * Algorithm runs in time O(2^n) in the worst case (when all characters mismatch) due to overlapping subproblems.
     * 
     * @param a
     *            The first string
     * @param b
     *            The second string
     * @param m
     *            The index pointing to the last element of the first string
     * @param n
     *            The index pointing to the last element of the second string.
     * @return The length of the longest common subsequence of the strings a and b.
     */
    public static int lcs(char[] a, char[] b, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (a[m] == b[n]) {
            return 1 + lcs(a, b, m - 1, n - 1);
        }

        return Math.max(lcs(a, b, m - 1, n), lcs(a, b, m, n - 1));
    }

    public static void main(String[] args) {
        char[] a = "AGGTAB".toCharArray();
        char[] b = "GXTXAYB".toCharArray();
        // LCS is GTAB
        System.out.println("Length of LCS is: " + lcs(a, b, a.length - 1, b.length - 1));
        System.out.println("Length of LCS using DP is: " + lcsDP(a, b, a.length - 1, b.length - 1));

        a = "ABCDGH".toCharArray();
        b = "AEDFHR".toCharArray();
        // LCS is ADH
        System.out.println("Length of LCS is: " + lcs(a, b, a.length - 1, b.length - 1));
        System.out.println("Length of LCS using DP is: " + lcsDP(a, b, a.length - 1, b.length - 1));

        a = "ASD".toCharArray();
        b = "OPEIRPO".toCharArray();
        // no LSC
        System.out.println("Length of LCS is: " + lcs(a, b, a.length - 1, b.length - 1));
        System.out.println("Length of LCS using DP is: " + lcsDP(a, b, a.length - 1, b.length - 1));

        String x = "abbabaab";
        String y = "baababba";
        System.out.println(lcsDP(a, b, a.length - 1, b.length - 1));
        System.out.println(longest(x, y));
    }

    /**
     * The dynamic programming version runs in time O(m*n) and requires O(m*n) memory, which is much better than the worst case time complexity of
     * Naive Recursive implementation
     * 
     * @param a
     *            The first string
     * @param b
     *            The second string
     * @param m
     *            The index pointing to the last element of the first string
     * @param n
     *            The index pointing to the last element of the second string.
     * @return The length of the longest common subsequence of the strings a and b.
     */
    public static int lcsDP(char[] a, char[] b, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        int[][] lcs = new int[m + 1][n + 1];
        lcs[0][0] = a[0] == b[0] ? 1 : 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (a[i] == b[j]) {
                    int prev = (i == 0 || j == 0) ? 0 : lcs[i - 1][j - 1];
                    lcs[i][j] = 1 + prev;
                } else {
                    int one = j == 0 ? 0 : lcs[i][j - 1];
                    int two = i == 0 ? 0 : lcs[i - 1][j];
                    lcs[i][j] = Math.max(one, two);
                }
            }
        }

        return lcs[m][n];
    }

    public static String longest(String x, String y) {
        int M = x.length();
        int N = y.length();

        // opt[i][j] = length of LCS of x[i..M] and y[j..N]
        int[][] opt = new int[M + 1][N + 1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                else
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
            }
        }

        // recover LCS itself and print it to standard output
        String result = "";
        int i = 0, j = 0;
        while (i < M && j < N) {
            if (x.charAt(i) == y.charAt(j)) {
                result += x.charAt(i);
                // System.out.print(x.charAt(i));
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1])
                i++;
            else
                j++;
        }
        return result;
    }
}
