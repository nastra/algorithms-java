package com.nastra.algorithms.search;

/**
 *
 * @author nastra
 */
public class LongestIncreasingSubsequence {

    /**
     * Algorithm runs in time O(n log n). The longest subsequence in {10, 22, 9, 33, 21, 50, 41, 60} has the length=5, having {10, 22, 33, 50, 60}
     *
     * @param s
     * @return The length of the longest increasing subsequence
     */
    public static int longestIncreasingSubsequenceLength(int[] s) {
        if (null == s || s.length == 0) {
            return 0;
        }
        if (s.length == 1) {
            return 1;
        }
        int[] tail = new int[s.length];
        int len = 1;
        tail[0] = s[0];

        for (int i = 1; i < s.length; i++) {
            if (s[i] < tail[0]) {
                // we start a potential new sequence
                tail[i] = s[i];
            } else if (s[i] > tail[len - 1]) {
                // s[i] is bigger and therefore increases the subsequence
                tail[len] = s[i];
                len++;
            } else {
                // element is somewhere in between, replace it with a ceil element
                int index = ArraySearch.ceil(tail, s[i], 0, len);
                tail[index] = s[i];
            }
        }
        return len;
    }
}