package com.nastra.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra
 */
public class StackReverserTest {

    @Test
    public void testStackReversal() {
        StackReverser<Integer> reverser = new StackReverser<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> items = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            items.add(i);
        }

        reverser.reverse(stack);
        for (Integer item : items) {
            Assert.assertEquals(item.intValue(), stack.pop().intValue());
        }
    }
}
