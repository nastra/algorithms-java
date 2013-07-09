package com.nastra.algorithms;

import com.nastra.algorithms.permutation.HeapPermute;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra
 */
public class HeapPermuteTest {

    @Test
    public void test() {
        HeapPermute p = new HeapPermute();
        String input = "cdcdcdcdeef";
        p.permute(input);
        long expectedSize = Factorial.factorial(input.length());
        Assert.assertEquals(p.getPermutations().size(), expectedSize);
    }
}
