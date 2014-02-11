package com.nastra.algorithms.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WARNING: Don't make n too large. <br>
 * Recall that the number of permutations is n! which can be very large, even when n is as small as 20 <br>
 * 20! = 2,432,902,008,176,640,000 and 21! is too big to fit into a Java long
 * 
 * @author nastra
 */
public class Permute {

    private static Map<Character, List<String>> map = new HashMap<Character, List<String>>();

    public static List<String> permuteIterative(String input) {
        return Collections.emptyList();
    }

    /**
     * Generates all permutations of a given string. This solution uses recursion and runs in time O(n!). Due to its recursive nature, this solution
     * is quite memory-inefficient.
     * 
     * @param input
     *            The input to permute.
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
        List<String> perms = generatePermutations(first, words, permutations);
        return perms;
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

    public static class Permuter {

        public static List<String> permutations = new ArrayList<String>();

        public static void permute(String input) {
            permute(input.toCharArray(), 0, input.length() - 1);
        }

        public static void swap(char[] str, int i, int j) {
            char temp;
            temp = str[j];
            str[j] = str[i];
            str[i] = temp;
        }

        public static void permute(char[] str, int start, int end) {
            if (start == end) {
                // System.out.println(str);
                permutations.add(new String(str));
            } else {
                for (int i = start; i <= end; i++) {
                    swap(str, start, i);
                    permute(str, start + 1, end);
                    swap(str, start, i);
                }
            }
        }
    }
}
