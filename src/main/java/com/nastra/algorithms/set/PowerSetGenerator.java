package com.nastra.algorithms.set;

import java.util.Set;

/**
 * The power set is the set of all subsets of S, including the empty set and S itself.
 * <br>If S is the set {x, y, z}, then the subsets of S are:
 * <br>- {} (also denoted the empty set)
 * <br>- {x}
 * <br>- {y}
 * <br>- {z}
 * <br>- {x, y}
 * <br>- {x, z}
 * <br>- {y, z}
 * <br>- {x, y, z} and hence the power set of S is {{}, {x}, {y}, {z}, {x, y}, {x, z}, {y, z}, {x, y, z}}.
 *
 * @see http://en.wikipedia.org/wiki/Power_set
 *
 * @author nastra
 */
public class PowerSetGenerator {

    public static Set<Set<Integer>> powerSet(Set<Integer> originSet) {
        return SubSetGenerator.subsets(originSet);
    }
}
