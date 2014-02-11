package com.nastra.algorithms.stack;

import java.util.Stack;

/**
 * Evaluates (fully parenthesized) arithmetic expressions using Dijkstra's two-stack algorithm.
 * 
 * % java ArithmeticExpressionEvaluator ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) => 101.0
 * 
 * % java ArithmeticExpressionEvaluator ( ( 1 + sqrt ( 5 ) ) / 2.0 ) => 1.618033988749895
 * 
 * 
 * 
 * Remarkably, Dijkstra's algorithm computes the same answer if we put each operator *after* its two operands instead of *between* them.
 * 
 * % java ArithmeticExpressionEvaluator ( 1 ( ( 2 3 + ) ( 4 5 * ) * ) + ) => 101.0
 * 
 * Moreover, in such expressions, all parentheses are redundant! Removing them yields an expression known as a postfix expression.
 * 
 * 1 2 3 + 4 5 * * +
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class ArithmeticExpressionEvaluator {

    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULT = "*";
    private static final String DIV = "/";
    private static final String POW = "^";
    private static final String SQRT = "sqrt";

    public static Double evaluate(String[] in) {
        if (null == in || in.length == 0) {
            return Double.NaN;
        }
        Stack<String> ops = new Stack<String>();
        Stack<Double> values = new Stack<Double>();

        for (String c : in) {
            if (LEFT_PARENTHESIS.equals(c)) {
                continue;
            } else if (isOperand(c)) {
                ops.push(c);
            } else if (RIGHT_PARENTHESIS.equals(c)) {
                String op = ops.pop();
                Double two = values.pop();
                Double result;
                if (SQRT.equals(op)) {
                    result = Math.sqrt(two);
                } else {
                    Double one = values.pop();
                    result = apply(one, op, two);
                }
                values.push(result);
            } else {
                values.push(Double.valueOf(c));
            }
        }
        return values.pop();
    }

    private static boolean isOperand(String c) {
        return PLUS.equals(c) || MINUS.equals(c) || DIV.equals(c) || MULT.equals(c) || POW.equals(c) || SQRT.equals(c);
    }

    private static Double apply(Double one, String op, Double two) {
        if (PLUS.equals(op)) {
            return one + two;
        } else if (MINUS.equals(op)) {
            return one - two;
        } else if (MULT.equals(op)) {
            return one * two;
        } else if (DIV.equals(op)) {
            return one / two;
        } else if (POW.equals(op)) {
            return Math.pow(one, two);
        }
        return Double.NaN;
    }
}
