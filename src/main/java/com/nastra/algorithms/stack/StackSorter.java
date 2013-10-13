package com.nastra.algorithms.stack;

import java.util.Stack;

/**
 * Solution to the following interview question: "Sort a stack of numbers in descending order. The following operations are allowed:
 * push/pop/top/isEmpty."
 *
 * @author nastra
 */
public class StackSorter {

    /**
     * Sorts a stack without using additional data structures. Requires O(n^2) time and O(n) space.
     *
     * @param stack The stack to be sorted
     */
    public static void sort(Stack<Integer> stack) {
        if (null == stack) {
            return;
        }
        if (!stack.isEmpty()) {
            Integer val = stack.pop();
            sort(stack);
            insert(stack, val);
        }
    }

    private static void insert(Stack<Integer> stack, Integer val) {
        if (stack.isEmpty() || stack.peek() <= val) {
            stack.push(val);
        } else {
            Integer x = stack.pop();
            insert(stack, val);
            stack.push(x);
        }
    }
}
