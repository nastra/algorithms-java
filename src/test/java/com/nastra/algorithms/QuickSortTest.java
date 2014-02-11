package com.nastra.algorithms;

import com.nastra.algorithms.sorting.Quick;
import java.util.Arrays;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class QuickSortTest {

    private Integer[] numbers;
    private final static int SIZE = 10000;
    private final static int MAX = 100000;

    @BeforeMethod
    public void setUp() throws Exception {
        numbers = new Integer[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    @Test
    public void testNull() {
        Quick.sort(null);
    }

    @Test
    public void testEmpty() {
        Quick.sort(new Integer[0]);
    }

    @Test
    public void testOneElement() {
        Integer[] test = new Integer[1];
        test[0] = 5;
        Quick.sort(test);
    }

    @Test
    public void testManyDuplicates() {
        Integer[] test = {5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5};
        Quick.sort(test);
        if (!validate(test)) {
            Assert.fail("Should not happen");
        }
        printResult(test);
    }

    @Test
    public void testQuickSort() {
        for (Integer i : numbers) {
            System.out.println(i + " ");
        }
        long startTime = System.currentTimeMillis();

        Quick.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quicksort " + elapsedTime);

        if (!validate(numbers)) {
            Assert.fail("Should not happen");
        }
        Assert.assertTrue(true);
    }

    @Test
    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);
        if (!validate(numbers)) {
            Assert.fail("Should not happen");
        }
        Assert.assertTrue(true);
    }

    private boolean validate(Integer[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private void printResult(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
        }
        System.out.println();
    }
}
