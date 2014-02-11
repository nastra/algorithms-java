package com.nastra.algorithms.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class provides different implementations to generate all subsets of a given set. <br>
 * There are 2^n distinct subsets of an n-element set, including the empty set as well as the set itself. <br>
 * So for example, the eight subsets of {1, 2, 3} are {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}
 * 
 * @author nastra
 */
public class SubSetGenerator {

    /**
     * One solution to generate all subsets of a given set of integer values. <br>
     * Runs in time O(2^n) and requires space O(2^n)
     * 
     * @param originSet
     * @return A set of subsets.
     */
    public static Set<Set<Integer>> subsets(Set<Integer> originSet) {
        Set<Set<Integer>> result = new HashSet<Set<Integer>>();
        if (originSet.isEmpty()) {
            result.add(originSet);
            return result;
        }

        List<Integer> list = new ArrayList<Integer>(originSet);
        Integer head = list.remove(0);
        Set<Set<Integer>> subsets = subsets(new HashSet<Integer>(list));
        for (Set<Integer> subset : subsets) {
            Set<Integer> s = new HashSet<Integer>(subset);
            s.add(head);
            result.add(subset);
            result.add(s);
        }

        return result;
    }
}
