package com.nastra.algorithms.stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Give an algorithm that returns true if a string contains properly nested and balanced parentheses, and false otherwise. For example, the string
 * "((())())()" contains properly nested pairs, whereas ")()(" and "())" do not.
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class ParenthesesChecker {

    private static final char LEFT = '(';
    private static final char RIGHT = ')';

    public static boolean isBalanced(String in) {
        if (null == in || "".equals(in)) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char c : in.toCharArray()) {
            if (LEFT == c) {
                stack.push(c);
            } else if (RIGHT == c && !tryPop(stack)) {
                System.out.println("Imbalanced parenthesis located at index: " + in.indexOf(c));
                return false;
            } else if (LEFT != c && RIGHT != c) {
                System.out.println("Imbalance at character: " + c + " located at index: " + in.indexOf(c));
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean tryPop(Stack<Character> s) {
        try {
            s.pop();
        } catch (EmptyStackException e) {
            return false;
        }
        return true;
    }
}
