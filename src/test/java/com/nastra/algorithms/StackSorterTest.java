package com.nastra.algorithms;

import com.nastra.algorithms.stack.StackSorter;
import java.util.Random;
import java.util.Stack;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra
 */
public class StackSorterTest {

    @Test
    public void testStackSorting() {
        Random random = new Random();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < 1000; i++) {
            stack.push(random.nextInt(10000));
        }
        StackSorter.sort(stack);

        Integer prev = null;
        for (Integer val : stack) {
            if (null != prev) {
                Assert.assertTrue(prev <= val, "The previous value '" + prev + "' was smaller than the current value '" + val + "'!");
            }
            prev = val;
        }
    }
}