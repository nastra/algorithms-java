package com.nastra.algorithms.search;

/**
 * Given an array of integers, write a method to find indices m and n such that if elements m through n are sorted, then entire array is sorted.
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class FindUnsortedSubsequence {

    private static int findStart(int[] s) {
        for (int i = 1; i < s.length; i++) {
            if (s[i] < s[i - 1]) {
                return i - 1;
            }
        }
        return s.length - 1;
    }

    private static int findEnd(int[] s) {
        for (int i = s.length - 2; i >= 0; i--) {
            if (s[i] > s[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }

    public static Result find(int[] s) {
        if (null == s || s.length <= 1) {
            return null;
        }
        int i = findStart(s);
        int j = findEnd(s);
        Result r = new Result(i, j);

        int min = findMin(s, i, j);
        int max = findMax(s, i, j);
        while (i >= 0) {
            if (s[i] > min) {
                r.start = i;
            }
            i--;
        }

        while (j < s.length) {
            if (s[j] < max) {
                r.end = j;
            }
            j++;
        }

        return r;
    }

    private static int findMin(int[] s, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (s[i] < min) {
                min = s[i];
            }
        }
        return min;
    }

    private static int findMax(int[] s, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (s[i] > max) {
                max = s[i];
            }
        }
        return max;
    }

    private static void findStart(int[] s, Result r, int min) {
        if (min < s[r.start]) {
            // find the start on the left side
            findStart(s, r, min, true);
        } else {
            // find the start on the right side
            findStart(s, r, min, false);
        }
    }

    private static void findStart(int[] s, Result r, int min, boolean searchLeft) {
        if (searchLeft) {
            int i = r.start - 1;
            while (i >= 0) {
                if (min < s[i]) {
                    r.start = i;
                }
                i--;
            }
        } else {
            int i = r.start;
            while (i < s.length) {
                if (min < s[i]) {
                    r.start = i;
                }
                i++;
            }
        }
    }

    private static void findEnd(int[] s, Result r, int max, boolean searchLeft) {
        if (searchLeft) {
            int i = r.start - 1;
            while (i >= 0) {
                if (max < s[i]) {
                    r.start = i;
                }
                i--;
            }
        } else {
            int i = r.start;
            while (i < s.length) {
                if (max < s[i]) {
                    r.start = i;
                }
                i++;
            }
        }
    }

    private static void findEnd(int[] s, Result r, int max) {
        if (max < s[r.end]) {
            findEnd(s, r, max, false);
        } else {
            findEnd(s, r, max, true);
        }
    }

    public static class Result {

        int start = 0;
        int end = 0;

        public Result(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
