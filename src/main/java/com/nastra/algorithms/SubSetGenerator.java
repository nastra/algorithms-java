/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nastra.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class provides different implementations to generate all subsets of a given set.
 *
 * @author nastra
 */
public class SubSetGenerator {

    /**
     * One solution to generate all subsets of a given set of integer values.
     * <br>
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
