package com.nastra.algorithms;

import java.util.Stack;

/**
 * Class that reverses a stack without using any additional space. The running time is O(n^2) and the required space is O(n).
 *
 * @author nastra
 */
public class StackReverser<T> {

    public void reverse(Stack<T> stack) {
        if (null == stack || stack.isEmpty()) {
            return;
        }
        T value = stack.pop();
        reverse(stack);
        push(stack, value);
    }

    private void push(Stack<T> stack, T item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        T tempItem = stack.pop();
        push(stack, item);
        stack.push(tempItem);
    }
}
