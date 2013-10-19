package com.nastra.algorithms.search;

/**
 *
 * @author nastra
 */
public class SuffixArray {

    private final int length;
    private String[] suffixes;

    public SuffixArray(String text) {
        if (null == text) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        length = text.length();
        suffixes = new String[length];
        for (int i = 0; i < length; i++) {
            suffixes[i] = text.substring(i);
        }
    }

    public int length() {
        return length;
    }

    /**
     *
     * @param key
     * @return The number of suffixes less than key
     */
    public int rank(String key) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(suffixes[mid]);
            if (cmp == 0) {
                return mid;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * @param i
     * @return Index of select(i) where i is between 0 and length-1.
     */
    public int index(int i) {
        return length - suffixes[i].length();
    }

    public String select(int i) {
        return suffixes[i];
    }

    public int longestCommonPrefix(int i) {
        return longestCommonPrefix(suffixes[i], suffixes[i - 1]);
    }

    private int longestCommonPrefix(String one, String two) {
        int len = Math.min(one.length(), two.length());
        for (int i = 0; i < len; i++) {
            if (one.charAt(i) != two.charAt(i)) {
                return i;
            }
        }
        return len;
    }
}
