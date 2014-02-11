package com.nastra.algorithms.search;

/**
 * There are N integers in an array A. All but one integer occurs in pairs. Your task is to find out that number that occurs only once.
 * 
 * @author nastra
 */
public class LonelyIntegerSearch {

    public static Integer findNumber(int[] s) {
        if (null == s || s.length == 0) {
            return null;
        }
        int result = 0;
        for (int value : s) {
            result ^= value;
        }
        return result;
    }
}
