package com.nastra.algorithms.sorting;

/**
 *
 * @author nastra
 */
public abstract class SortUtil {

    public static boolean lessThan(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static boolean greaterThan(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    public static void showContent(Comparable[] input) {
        if (null == input || input.length == 0) {
            return;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            out.append(input[i]);
            out.append(" ");
        }
        System.out.println(out.toString());
    }

    /**
     * @param input
     * @return True, if the array entries are in order.
     */
    public static boolean isSorted(Comparable[] input) {
        if (null == input || input.length == 0) {
            return false;
        }
        for (int i = 0; i < input.length - 1; i++) {
            if (greaterThan(input[i], input[i + 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param input
     * @return True, if the array entries are in reverse sorted order.
     */
    public static boolean isSortedInReverse(Comparable[] input) {
        if (null == input || input.length == 0) {
            return false;
        }
        for (int i = 0; i < input.length - 1; i++) {
            if (lessThan(input[i], input[i + 1])) {
                return false;
            }
        }
        return true;
    }
}
