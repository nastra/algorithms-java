package com.nastra.algorithms;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra
 */
public class PermutationTest {

    @Test
    public void testPermutations() {
        String input = "dogs";
        List<String> permutations = Permute.permute(input);
        long expectedSize = Factorial.factorial(input.length());
        Assert.assertTrue(permutations.size() == expectedSize);
    }

    @Test
    public void testPermutationsLong() {
        String input = "cdcdcdcdee";
        long expectedSize = Factorial.factorial(input.length());
        List<String> permutations = Permute.permute(input);
        Assert.assertTrue(permutations.size() == expectedSize);
    }
}