package com.nastra.algorithms;

import com.nastra.algorithms.search.ArraySearch;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra
 */
public class ArraySearchTest {

    @Test
    public void testOccurrenceLargerThanKFinder() {
        int[] in = {-14, -10, 2, 108, 108, 243, 285, 285, 289, 401};

        int resultIndex = ArraySearch.firstOccurrenceLargerThan(in, 500);
        Assert.assertTrue(resultIndex == -1);

        resultIndex = ArraySearch.firstOccurrenceLargerThan(in, 5);
        Assert.assertTrue(resultIndex == 3);

        resultIndex = ArraySearch.firstOccurrenceLargerThan(in, 101);
        Assert.assertTrue(resultIndex == 3);

        resultIndex = ArraySearch.firstOccurrenceLargerThan(in, -23);
        Assert.assertTrue(resultIndex == 0);
    }
    
    @Test
    public void testElementEqualToIndex() {
        int[] in = {-4, -1, 2, 4, 5, 6, 9};
        int resultIndex = ArraySearch.elementEqualToIndex(in);
        Assert.assertTrue(resultIndex == 2);
        
        int[] in2 = {-4, -1, 3, 5, 9, 12, 17};
        resultIndex = ArraySearch.elementEqualToIndex(in2);
        Assert.assertTrue(resultIndex == -1);
    }
}