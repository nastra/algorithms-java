package com.nastra.algorithms;

import java.util.HashSet;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra
 */
public class SubSetGeneratorTest {

    @Test
    public void generateSubSetsTestOne() {
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        Set<Set<Integer>> subsets = SubSetGenerator.subsets(set);
        int expectedSize = Double.valueOf(Math.pow(2, set.size())).intValue();
        Assert.assertTrue(expectedSize == subsets.size());
        System.out.println(subsets);
    }

    @Test
    public void generateSubSetsTestTwo() {
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        Set<Set<Integer>> subsets = SubSetGenerator.subsets(set);
        int expectedSize = Double.valueOf(Math.pow(2, set.size())).intValue();
        Assert.assertTrue(expectedSize == subsets.size());
        System.out.println(subsets);
    }
}