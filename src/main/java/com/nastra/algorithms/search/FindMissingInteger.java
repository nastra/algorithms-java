package com.nastra.algorithms.search;

/**
 * This class efficiently finds an integer value that is not contained in the
 * input list by using a bit vector. It requires ~512 MB of memory for storing
 * all positive integers. <br>
 * This is a solution to the following interview question: <br>
 * "Given an input file with four billion non-negative integers, provide an
 * algorithm to generate an integer which is not contained in the file.<br>
 * Assume that you have 1GB of memory available for this task."
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class FindMissingInteger {
    private static final int ONES = 0xFF;

    private static long maxInts = ((long) Integer.MAX_VALUE) + 1;
    private static byte[] bits = new byte[(int) (FindMissingInteger.maxInts / 8)];

    private void preprocess(Iterable<Integer> numbers) {
        for (int n : numbers) {
            bits[n / 8] |= 1 << (n % 8);
        }
    }

    public int findMissingValue(Iterable<Integer> numbers) {
        preprocess(numbers);
        for (int i = 0; i < bits.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bits[i] & (1 << j)) == 0) {
                    return i * 8 + j;
                }
            }
        }
        return -1;
    }

    public int findMissingValueAlternative(Iterable<Integer> numbers) {
        preprocess(numbers);
        for (int i = 0; i < bits.length; i++) {
            if (hasUnsetBit(bits[i])) {
                for (int j = 0; j < 8; j++) {
                    if (!nthBitSet(bits[i], j)) {
                        return i * 8 + j;
                    }
                }
            }
        }
        return -1;
    }

    private boolean nthBitSet(int x, int n) {
        return (x & (1 << n)) != 0;
    }

    private boolean hasUnsetBit(int x) {
        return (x ^ ONES) != 0;
    }
}
