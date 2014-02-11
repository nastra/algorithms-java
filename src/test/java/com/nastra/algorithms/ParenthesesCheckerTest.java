package com.nastra.algorithms;

import com.nastra.algorithms.stack.ParenthesesChecker;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author nastra
 */
public class ParenthesesCheckerTest {

    @Test
    public void checkBalanced() {
        String in = "((())())()";
        Assert.assertTrue(ParenthesesChecker.isBalanced(in));
    }

    @Test
    public void checkUnbalanced() {
        String in = ")()(";
        Assert.assertFalse(ParenthesesChecker.isBalanced(in));
    }

    @Test
    public void checkUnbalancedTwo() {
        String in = "())";
        Assert.assertFalse(ParenthesesChecker.isBalanced(in));
    }

    @Test
    public void checkUnbalancedThree() {
        String in = "((())())())";
        Assert.assertFalse(ParenthesesChecker.isBalanced(in));
    }

    @Test
    public void checkUnbalancedFour() {
        String in = "((()) ())()";
        Assert.assertFalse(ParenthesesChecker.isBalanced(in));
    }
}