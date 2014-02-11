package com.nastra.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two (dictionary) words as Strings, determine if they are isIsomorphic. Two words are called isIsomorphic if the letters in one word can be
 * remapped to get the second word. Remapping a letter means replacing all occurrences of it with another letter while the ordering of the letters
 * remains unchanged. No two letters may map to the same letter, but a letter may map to itself.
 * 
 * Example: given "foo", "app"; returns true we can map 'f' -> 'a' and 'o' -> 'p'
 * 
 * given "bar", "foo"; returns false we can't map both 'a' and 'r' to 'o'
 * 
 * given "turtle", "tletur"; returns true we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' ->'r'
 * 
 * given "ab", "ca"; returns true we can map 'a' -> 'c', 'b' -> 'a'
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class Isomorphic {

    /**
     * Algorithm runs in time O(n+m) where n is the length of the first string and m is the string of the second string. To be isomorphic, both
     * strings need to have the same length. The algorithm requires O(n+m) space in the worst case.
     * 
     * @param one
     * @param two
     * @return True if the strings are isomorphic
     */
    public static boolean isIsomorphic(String one, String two) {
        if (null == one || null == two) {
            return false;
        }
        if (one.length() != two.length()) {
            return false;
        }
        if (one.length() == 1) {
            return true;
        }

        Map<Character, Integer> mapA = countFrequencies(one);
        Map<Character, Integer> mapB = countFrequencies(two);
        Map<Integer, List<Character>> reversedTable = reverseTable(mapB);

        for (Map.Entry<Character, Integer> entry : mapA.entrySet()) {
            Integer frequency = entry.getValue();
            List<Character> list = reversedTable.get(frequency);
            if (null == list || list.isEmpty()) {
                return false;
            }
            list.remove(0);
        }

        // now check if all characters/frequencies were removed
        for (List<Character> values : reversedTable.values()) {
            if (!values.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> countFrequencies(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(s.length());
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    private static Map<Integer, List<Character>> reverseTable(Map<Character, Integer> map) {
        Map<Integer, List<Character>> reversed = new HashMap<Integer, List<Character>>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character character = entry.getKey();
            Integer integer = entry.getValue();
            if (!reversed.containsKey(integer)) {
                reversed.put(integer, new ArrayList<Character>());
            }
            reversed.get(integer).add(character);
        }
        return reversed;
    }
}
