package com.nastra.algorithms;

import com.nastra.algorithms.search.ArraySearch;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author nastra
 */
public class ArraySearchTest {

    @Test
    public void testOccurrenceLargerThanKFinder() {
        int[] in = {-14, -10, 2, 108, 108, 243, 285, 285, 289, 401};

        int resultIndex = ArraySearch.ceil(in, 500);
        Assert.assertTrue(resultIndex == -1);

        resultIndex = ArraySearch.ceil(in, 5);
        Assert.assertTrue(resultIndex == 3);

        resultIndex = ArraySearch.ceil(in, 101);
        Assert.assertTrue(resultIndex == 3);

        resultIndex = ArraySearch.ceil(in, -23);
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

    @Test
    public void testArrayWithUnknownLength() {
        int[] in = {-4, -1, 2, 4, 5, 6, 9};
        int resultIndex = ArraySearch.binarySearchUnknownLength(in, 5);
        Assert.assertTrue(resultIndex == 4, "ResultIndex was " + resultIndex);

        resultIndex = ArraySearch.binarySearchUnknownLength(in, 9);
        Assert.assertTrue(resultIndex == 6, "ResultIndex was " + resultIndex);

        resultIndex = ArraySearch.binarySearchUnknownLength(in, 51);
        Assert.assertTrue(resultIndex == -1, "ResultIndex was " + resultIndex);

        resultIndex = ArraySearch.binarySearchUnknownLength(in, -23);
        Assert.assertTrue(resultIndex == -1, "ResultIndex was " + resultIndex);
    }

    @Test
    public void testLargeArrayWithUnknownLength() {
        for (int i = 0; i < 100; i++) {
            int[] in = generateRandomArray(10000, 100000);
            java.util.Random generator = new java.util.Random();
            int k = generator.nextInt(100000);
            int indexOfK = Arrays.binarySearch(in, k);
            if (indexOfK < 0) {
                indexOfK = -1;
            }

            int resultIndex = ArraySearch.binarySearchUnknownLength(in, k);
            Assert.assertTrue(resultIndex == indexOfK, "ResultIndex was " + resultIndex + " but we expected " + indexOfK);
        }
    }

    private int[] generateRandomArray(int arraySize, int maxElement) {
        int[] numbers = new int[arraySize];
        java.util.Random generator = new java.util.Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(maxElement);
        }
        Arrays.sort(numbers);
        return numbers;
    }

    @Test
    public void testFactorialZeroes() {
        System.out.println(countZeroes(100));

    }

    int countZeroes(int n) {
        int res = 0;
        int div = 5;
        while (div <= n) {
            res = res + (n / div);
            div = div * 5;
        }
        return res;
    }
}