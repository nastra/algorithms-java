package com.nastra.algorithms;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

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
}