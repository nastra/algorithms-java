package com.nastra.algorithms;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra
 */
public class InfixToPostfixTranslatorTest {

    @Test
    public void testInfixToPostfixTranslation() {
        String infix = "A*B-(C*D)+E";
        String expectedPostfix = "AB*CD*-E+";
        String postfix = InfixToPostfixTranslator.translate(infix);
        Assert.assertEquals(infix + " could not be resolved to postfix. The result was: " + postfix, expectedPostfix, postfix);

        infix = "A*B-(C*D)*E";
        expectedPostfix = "AB*CD*E*-";
        postfix = InfixToPostfixTranslator.translate(infix);
        Assert.assertEquals(infix + " could not be resolved to postfix. The result was: " + postfix, expectedPostfix, postfix);

        infix = "2+(3*4)-6";
        expectedPostfix = "234*+6-";
        postfix = InfixToPostfixTranslator.translate(infix);
        Assert.assertEquals(infix + " could not be resolved to postfix. The result was: " + postfix, expectedPostfix, postfix);

        infix = "(A-B)*(C-D)-E*F";
        expectedPostfix = "AB-CD-*EF*-";
        postfix = InfixToPostfixTranslator.translate(infix);
        Assert.assertEquals(infix + " could not be resolved to postfix. The result was: " + postfix, expectedPostfix, postfix);
    }
}