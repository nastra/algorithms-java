/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nastra.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra
 */
public class FindMissingIntegerTest {

    @Test
    public void findIntegerNotInList() {
        List<Integer> numbers = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int randInt = random.nextInt(Integer.MAX_VALUE);
            if (randInt >= 0) {
                numbers.add(randInt);
            }
        }

        FindMissingInteger finder = new FindMissingInteger();
        int value = finder.findMissingValue(numbers);
        Assert.assertTrue(!numbers.contains(value));
    }
}