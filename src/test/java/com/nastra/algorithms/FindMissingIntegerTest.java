package com.nastra.algorithms;

import com.nastra.algorithms.search.FindMissingInteger;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author nastra
 */
public class FindMissingIntegerTest {

    @Test
    public void findIntegerNotInList() {
        Set<Integer> numbers = new HashSet<Integer>();
        numbers.add(0);
        Random random = new Random();
        int expectedMissingValue = random.nextInt(100000);
        for (int i = 0; i < 100000; i++) {
            // int randInt = random.nextInt(Integer.MAX_VALUE);
            if (i != expectedMissingValue) {
                numbers.add(i);
            }
        }

        FindMissingInteger finder = new FindMissingInteger();
        int value = finder.findMissingValue(numbers);
        Assert.assertTrue(!numbers.contains(value));
        int missingValue = finder.findMissingValue(numbers);
        int missingValueAlternative = finder.findMissingValueAlternative(numbers);
        Assert.assertTrue(!numbers.contains(missingValue));
        Assert.assertTrue(!numbers.contains(missingValueAlternative));
        Assert.assertTrue(expectedMissingValue == missingValue);
        Assert.assertTrue(expectedMissingValue == missingValueAlternative);
    }
}