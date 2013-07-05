package com.nastra.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author nastra
 */
public class Permute {

    public static List<String> permuteIterative(String input) {
        return Collections.emptyList();
    }

    /**
     * Generates all permutations of a given string. This solution uses recursion and runs in time O(n!). Due to its recursive nature, this solution
     * is quite memory-inefficient.
     *
     * @param input The input to permute.
     * @return A list of all permutations of the given input.
     */
    public static List<String> permute(String input) {
        if (null == input) {
            return Collections.emptyList();
        }
        List<String> permutations = new ArrayList<String>();
        if (input.isEmpty()) {
            permutations.add("");
            return permutations;
        }

        char first = input.charAt(0);
        String remainder = input.substring(1);
        List<String> words = permute(remainder);
        return generatePermutations(first, words, permutations);
    }

    private static List<String> generatePermutations(char first, List<String> words, List<String> permutations) {
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                permutations.add(insertCharBetween(word, first, j));
            }
        }
        return permutations;
    }

    private static String insertCharBetween(String word, char c, int i) {
        String front = word.substring(0, i);
        String back = word.substring(i);
        return front + c + back;
    }
}
