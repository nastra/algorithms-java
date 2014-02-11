package com.nastra.algorithms.permutation;

import java.util.HashSet;
import java.util.Set;

/**
 * This algorithm uses backtracking to generate all n! permutations of a given string. <br>
 * WARNING: Don't make n too large. <br>
 * Recall that the number of permutations is n! which can be very large, even when n is as small as 20 <br>
 * 20! = 2,432,902,008,176,640,000 and 21! is too big to fit into a Java long
 * 
 * @author nastra
 */
public class Permutations {

    private static Set<String> permutations = new HashSet<String>();

    /**
     * Uses backtracking to generate all permutations of a given string.
     * 
     * @param s
     *            The string from which permutations should be generated.
     */
    public static void generatePermutations(String s) {
        permutations.clear();
        int N = s.length();
        char[] a = new char[N];
        for (int i = 0; i < N; i++) {
            a[i] = s.charAt(i);
        }
        generatePermutations(a, N);
    }

    private static void generatePermutations(char[] in, int n) {
        if (n == 1) {
            permutations.add(new String(in));
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(in, i, n - 1);
            if (!permutations.contains(new String(in))) {
                generatePermutations(in, n - 1);
            }
            swap(in, i, n - 1);
        }
    }

    /**
     * @return A container containing all unique permutations
     */
    public static Iterable<String> getPermutations() {
        return permutations;
    }

    /**
     * swap the characters at indices i and j
     */
    private static void swap(char[] in, int i, int j) {
        char c = in[i];
        in[i] = in[j];
        in[j] = c;
    }
}