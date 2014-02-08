package com.nastra.algorithms;

import com.nastra.algorithms.stack.ArithmeticExpressionEvaluator;
import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class ArithmeticExpressionEvaluatorTest {

    @Test
    public void testEmpty() {
        Assert.assertEquals(Double.NaN, ArithmeticExpressionEvaluator.evaluate(null));
        Assert.assertEquals(Double.NaN, ArithmeticExpressionEvaluator.evaluate(new String[0]));
    }

    @Test
    public void testSimple() {
        String expression = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        Assert.assertEquals(101.0, ArithmeticExpressionEvaluator.evaluate(expression.split(" ")));
        expression = "( ( 1 + sqrt ( 5 ) ) / 2.0 )";
        Assert.assertEquals(1.618033988749895, ArithmeticExpressionEvaluator.evaluate(expression.split(" ")));

        expression = "( 1 ( ( 2 3 + ) ( 4 5 * ) * ) + )";
        Assert.assertEquals(101.0, ArithmeticExpressionEvaluator.evaluate(expression.split(" ")));
    }
}
