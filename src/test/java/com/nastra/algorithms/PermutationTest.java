package com.nastra.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nastra.algorithms.permutation.Permute;
import com.nastra.algorithms.permutation.Permute.Permuter;
import com.nastra.algorithms.permutation.StringPermutationIterable;

/**
 * 
 * @author nastra
 */
public class PermutationTest {

    @Test
    public void testPermutations() {
        String input = "aba";
        List<String> permutations = Permute.permute(input);
        long expectedSize = Factorial.factorial(input.length());
        Assert.assertTrue(permutations.size() == expectedSize);
    }

    @Test
    public void testPermutationsOne() {
        String input = "a";
        List<String> permutations = Permute.permute(input);
        long expectedSize = Factorial.factorial(input.length());
        Assert.assertTrue(permutations.size() == expectedSize);
    }

    @Test
    public void testPermutationsTwo() {
        String input = "ab";
        List<String> permutations = Permute.permute(input);
        long expectedSize = Factorial.factorial(input.length());
        Assert.assertTrue(permutations.size() == expectedSize);
    }

    @Test
    public void testPermutationsFour() {
        String input = "aaaa";
        List<String> permutations = Permute.permute(input);
        long expectedSize = Factorial.factorial(input.length());
        Assert.assertTrue(permutations.size() == expectedSize);
    }

    @Test
    public void testPermutationsShort() {
        String input = "cdcdeeeef";
        long expectedSize = Factorial.factorial(input.length());
        StringPermutationIterable p = new StringPermutationIterable(input);
        List<String> permutations = new ArrayList<String>();
        Iterator<String> iterator = p.iterator();
        while (iterator.hasNext()) {
            String permutation = iterator.next();
            permutations.add(permutation);
        }
        Assert.assertTrue(permutations.size() == expectedSize);
    }
    
    @Test
    public void test() {
        String in = "999999999";
        Permute.Permuter.permute(in);
//        List<String> out = Permute.Permuter.permutations;
        List<String> out = Permute.permute(in);
//        System.out.println(out);
    }
}