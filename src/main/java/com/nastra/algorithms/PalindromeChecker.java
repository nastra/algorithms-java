/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nastra.algorithms;

/**
 *
 * @author nastra
 */
public class PalindromeChecker {

    public static boolean isPalindrome(String input) {
        if (null == input || input.length() == 0) {
            return false;
        }
        return input.equals(new StringBuilder().append(input).reverse().toString());
    }
}
