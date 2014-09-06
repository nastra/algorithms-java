package com.nastra.datastructures;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CircularIntArrayTest {

    
    @Test
    public void testCCWOne() {
        int[] a = {1,2,3,4,5,6};
        CircularIntArray arr = new CircularIntArray(a);
        arr.rotateCounterClockwise(1);
        Assert.assertTrue(arr.get(1) == 6);
        Assert.assertTrue(arr.get(2) == 1);
        Assert.assertTrue(arr.get(3) == 2);
        Assert.assertTrue(arr.get(4) == 3);
        Assert.assertTrue(arr.get(5) == 4);
        Assert.assertTrue(arr.get(6) == 5);
    }
    
    @Test
    public void testCCWTwo() {
        int[] a = {1,2,3,4,5,6};
        CircularIntArray arr = new CircularIntArray(a);
        arr.rotateCounterClockwise(2);
        Assert.assertTrue(arr.get(1) == 5);
        Assert.assertTrue(arr.get(2) == 6);
        Assert.assertTrue(arr.get(3) == 1);
        Assert.assertTrue(arr.get(4) == 2);
        Assert.assertTrue(arr.get(5) == 3);
        Assert.assertTrue(arr.get(6) == 4);
    }
    
    @Test
    public void testCCWThree() {
        int[] a = {1,2,3,4,5,6};
        CircularIntArray arr = new CircularIntArray(a);
        arr.rotateCounterClockwise(3);
        Assert.assertTrue(arr.get(1) == 4);
        Assert.assertTrue(arr.get(2) == 5);
        Assert.assertTrue(arr.get(3) == 6);
        Assert.assertTrue(arr.get(4) == 1);
        Assert.assertTrue(arr.get(5) == 2);
        Assert.assertTrue(arr.get(6) == 3);
    }
    
    @Test
    public void testCWOne() {
        int[] a = {1,2,3,4,5,6};
        CircularIntArray arr = new CircularIntArray(a);
        arr.rotateClockwise(1);
        Assert.assertTrue(arr.get(1) == 2);
        Assert.assertTrue(arr.get(2) == 3);
        Assert.assertTrue(arr.get(3) == 4);
        Assert.assertTrue(arr.get(4) == 5);
        Assert.assertTrue(arr.get(5) == 6);
        Assert.assertTrue(arr.get(6) == 1);
    }
    
    @Test
    public void testCWTwo() {
        int[] a = {1,2,3,4,5,6};
        CircularIntArray arr = new CircularIntArray(a);
        arr.rotateClockwise(2);
        Assert.assertTrue(arr.get(1) == 3);
        Assert.assertTrue(arr.get(2) == 4);
        Assert.assertTrue(arr.get(3) == 5);
        Assert.assertTrue(arr.get(4) == 6);
        Assert.assertTrue(arr.get(5) == 1);
        Assert.assertTrue(arr.get(6) == 2);
    }
    
    @Test
    public void testCWThree() {
        int[] a = {1,2,3,4,5,6};
        CircularIntArray arr = new CircularIntArray(a);
        arr.rotateClockwise(3);
        Assert.assertTrue(arr.get(1) == 4);
        Assert.assertTrue(arr.get(2) == 5);
        Assert.assertTrue(arr.get(3) == 6);
        Assert.assertTrue(arr.get(4) == 1);
        Assert.assertTrue(arr.get(5) == 2);
        Assert.assertTrue(arr.get(6) == 3);
    }
}
