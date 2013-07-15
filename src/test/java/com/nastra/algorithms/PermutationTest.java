package com.nastra.algorithms;

import com.nastra.algorithms.permutation.StringPermutationIterable;
import com.nastra.algorithms.permutation.Permute;
import java.util.ArrayList;
import java.util.Iterator;
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
//    @Test
//    public void testPermutationsLong() {
//        String input = "cdefghmnopqrstuvw";
//        long expectedSize = Factorial.factorial(input.length());
//        Permute.Permuter.permute(input);
//        Assert.assertTrue(Permute.Permuter.permutations.size() == expectedSize);
//    }
//
//    @Test
//    public void testPermutationsVeryLong() {
//        String input = "cdefghmnopqrstuvw";
//        long expectedSize = Factorial.factorial(input.length());
//        List<String> permutations = Permute.permute(input);
//        Assert.assertTrue(permutations.size() == expectedSize);
//    }
//

    @Test
    public void testPermutationsShort() {
        String input = "cdcdcdcdeeeef";
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
}