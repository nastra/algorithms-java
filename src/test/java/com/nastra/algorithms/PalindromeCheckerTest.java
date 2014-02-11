package com.nastra.algorithms;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author nastra
 */
public class PalindromeCheckerTest {

    @Test
    public void testOne() {
        String input = "bbaaabb";
        boolean result = PalindromeChecker.isPalindrome(input);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testTwo() {
        String input = "aca";
        boolean result = PalindromeChecker.isPalindrome(input);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testThree() {
        String input = "aca";
        boolean result = PalindromeChecker.isPalindrome(input);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testFour() {
        String input = "abbabbb";
        boolean result = PalindromeChecker.isPalindrome(input);
        Assert.assertEquals(false, result);
    }

    @Test
    public void testFive() {
        String input = "ddcceefeeccdd";
        boolean result = PalindromeChecker.isPalindrome(input);
        Assert.assertEquals(true, result);
    }
}