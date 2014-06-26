package com.nastra.algorithms;

/**
 * Prints all possible combinations of n opening and closing parentheses. All possible combinations for n = 3 are: <br>
 * ((())) (()()) (())() ()(()) ()()()
 * 
 * @author nastra
 * 
 */
public class PrintParentheses {
    static void printAllCombinations(int n) {
        char[] curr = new char[n * 2];
        print(n, n, curr, 0);
    }

    private static void print(int opening, int closing, char[] curr, int index) {
        if (opening < 0 || opening > closing) {
            return;
        }

        if (opening == 0 && closing == 0) {
            System.out.println(String.copyValueOf(curr));
            return;
        }
        if (opening > 0) {
            curr[index] = '(';
            print(opening - 1, closing, curr, index + 1);
        }
        if (opening < closing) {
            curr[index] = ')';
            print(opening, closing - 1, curr, index + 1);
        }

    }

    public static void main(String[] args) {
        printAllCombinations(1);
        System.out.println();
        printAllCombinations(2);
        System.out.println();
        printAllCombinations(3);
        System.out.println();
        printAllCombinations(5);
    }
}
