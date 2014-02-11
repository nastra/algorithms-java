package com.nastra.algorithms.search;

/**
 * Further details to the Longest Increasing Subsequence problem can be found at http://en.wikipedia.org/wiki/Longest_increasing_subsequence
 * 
 * @author nastra - Eduard Tudenhoefner
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
                // element is somewhere in between, replace it with a ceil
                // element
                int index = ArraySearch.ceil(tail, s[i], 0, len);
                tail[index] = s[i];
            }
        }
        return len;
    }

    /**
     * This algorithm is slower than {@link LongestIncreasingSubsequence#longestIncreasingSubsequenceLength(int[])} . It runs in time O(n^2).
     * 
     * @param s
     * @return The length of the longest increasing subsequence.
     */
    public static int longestIncreasingSubsequenceLengthSlow(int[] s) {
        return lis(s).maxLength;
    }

    public static int[] longestIncreasingSubsequenceSlow(int[] s) {
        Result result = lis(s);
        int[] subsequence = new int[result.maxLength];
        int j = result.maxIndex;

        for (int i = subsequence.length - 1; i >= 0; i--) {
            subsequence[i] = s[j];
            j = result.prev[j];
        }
        return subsequence;
    }

    private static Result lis(int[] s) {
        if (null == s || s.length == 0) {
            return new Result(0, 0);
        }
        int[] len = new int[s.length];
        int[] prev = new int[s.length];
        Result result = longestIncreasingSubsequence(s, len, prev);
        result.len = len;
        result.prev = prev;
        return result;
    }

    private static Result longestIncreasingSubsequence(int[] s, int[] len, int[] prev) {
        int max = 0;
        int maxIndex = 0;
        init(len, prev);

        for (int i = 1; i < s.length; i++) {
            for (int j = 0; j < i; j++) {
                if (s[i] > s[j] && len[j] >= len[i]) {
                    prev[i] = j;
                    len[i] = len[j] + 1;
                }
            }
            if (len[i] > max) {
                max = len[i];
                maxIndex = i;
            }
        }
        return new Result(max, maxIndex);
    }

    private static void init(int[] len, int[] prev) {
        for (int i = 0; i < len.length; i++) {
            len[i] = 1;
            prev[i] = -1;
        }
    }

    private static class Result {

        int maxLength = 0;
        int maxIndex = 0;
        int[] len;
        int[] prev;

        public Result(int maxLength, int maxIndex) {
            this.maxIndex = maxIndex;
            this.maxLength = maxLength;
        }
    }
}