package com.nastra.algorithms.stack;

import java.util.Stack;

/**
 * A rudimentary implementation to translate from infix to postfix expressions. Currently the input is not checked for correctness and only the
 * following things are supported for now: <br>
 * - single digit operands are supported <br>
 * - The operators<br>
 * 
 * So basically we can translate "A*B-(C*D)+E" to "AB*CD*-E+" or "2+(3*4)-6" to its postfix representation "234*+6-"
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class InfixToPostfixTranslator {

    private static final String OPERAND_REGEX = "[A-Za-z0-9]";
    private static final char LEFT_PARENTHESIS = '(';
    private static final char RIGHT_PARENTHESIS = ')';

    public static void main(String... args) {
        System.out.println(translate("(a+(b*c))"));
        System.out.println(translate("((a+b)*(z+x))"));
        System.out.println(translate("((a+t)*((b+(a+c))^(c+d)))"));

    }

    public static String translate(String in) {
        if (null == in || in.isEmpty()) {
            return in;
        }
        StringBuilder out = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < in.length(); i++) {
            char current = in.charAt(i);
            if (isOperand(current)) {
                out.append(current);
            } else if (isLeftParenthesis(current) || isOperator(current)) {
                if (isOperator(current) && higherOrEqualOperatorOnStack(stack, current) && !isRightParenthesis(current)) {
                    out.append(stack.pop());
                }
                stack.push(current);
            } else if (isRightParenthesis(current)) {
                while (!isLeftParenthesis(stack.peek())) {
                    out.append(stack.pop());
                }
                stack.pop(); // pop the remaining '('
            }
        }

        while (!stack.isEmpty()) {
            out.append(stack.pop());
        }
        return out.toString();
    }

    private static boolean isOperand(char current) {
        return Character.valueOf(current).toString().matches(OPERAND_REGEX);
    }

    private static boolean isLeftParenthesis(char current) {
        return LEFT_PARENTHESIS == current;
    }

    private static boolean isRightParenthesis(char current) {
        return RIGHT_PARENTHESIS == current;
    }

    private static boolean isOperator(char current) {
        return Operator.PLUS.operator == current || Operator.MINUS.operator == current || Operator.MULTIPLY.operator == current
                || Operator.DIVIDE.operator == current || current == Operator.XOR.operator;
    }

    private static boolean higherOrEqualOperatorOnStack(Stack<Character> stack, char current) {
        return !stack.isEmpty() && (precedenceOf(stack.peek()) >= precedenceOf(current));
    }

    private static int precedenceOf(char operator) {
        if (operator == Operator.PLUS.operator || operator == Operator.MINUS.operator) {
            return Operator.PLUS.precedence;
        } else if (operator == Operator.MULTIPLY.operator || operator == Operator.DIVIDE.operator || operator == Operator.XOR.operator) {
            return Operator.MULTIPLY.precedence;

        }
        return 0;
    }

    private static enum Operator {

        PLUS('+', 1), MINUS('-', 1), MULTIPLY('*', 2), DIVIDE('/', 2), XOR('^', 2);
        private char operator;
        private int precedence;

        private Operator(char operator, int precedence) {
            this.operator = operator;
            this.precedence = precedence;
        }
    }
}
