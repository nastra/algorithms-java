package com.nastra.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.testng.annotations.Test;

public class DequeTest {

    @Test(expectedExceptions = NoSuchElementException.class)
    public void removeFirstWhenEmpty() {
        Deque<Integer> d = new Deque<Integer>();
        d.removeFirst();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void removeLastWhenEmpty() {
        Deque<Integer> d = new Deque<Integer>();
        d.removeLast();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void addFirstNullValue() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void addLastNullValue() {
        Deque<Integer> d = new Deque<Integer>();
        d.addLast(null);
    }

    @Test
    public void testOneElement() {
        Deque<Integer> d = new Deque<Integer>();
        Integer item = Integer.valueOf(5);

        Assert.assertTrue(d.isEmpty());
        d.addFirst(item);
        Assert.assertTrue(d.size() == 1);
        Assert.assertFalse(d.isEmpty());
        Integer x = d.removeLast();
        Assert.assertTrue(x.equals(item));
        Assert.assertTrue(d.size() == 0);
        Assert.assertTrue(d.isEmpty());

        d.addLast(item);
        Assert.assertTrue(d.size() == 1);
        Assert.assertFalse(d.isEmpty());
        x = d.removeFirst();
        Assert.assertTrue(x.equals(item));
        Assert.assertTrue(d.size() == 0);
        Assert.assertTrue(d.isEmpty());
    }

    @Test
    public void testMultipleElements() {
        Deque<Integer> d = new Deque<Integer>();
        Assert.assertTrue(d.isEmpty());
        d.addFirst(5);
        Assert.assertFalse(d.isEmpty());
        Assert.assertTrue(d.size() == 1);
        d.addLast(10);
        Assert.assertFalse(d.isEmpty());
        Assert.assertTrue(d.size() == 2);
        d.addFirst(6);
        Assert.assertFalse(d.isEmpty());
        Assert.assertTrue(d.size() == 3);
        d.addLast(11);
        Assert.assertFalse(d.isEmpty());
        Assert.assertTrue(d.size() == 4);

        // now check that we get the correct elements back
        Integer x = d.removeFirst();
        Assert.assertFalse(d.isEmpty());
        Assert.assertTrue(d.size() == 3);
        Assert.assertFalse(d.isEmpty());
        Assert.assertTrue(x.intValue() == 6);
        x = d.removeLast();
        Assert.assertFalse(d.isEmpty());
        Assert.assertTrue(d.size() == 2);
        Assert.assertTrue(x.intValue() == 11);

        d.addLast(25);
        Assert.assertFalse(d.isEmpty());
        Assert.assertTrue(d.size() == 3);

        x = d.removeLast();
        Assert.assertFalse(d.isEmpty());
        Assert.assertTrue(d.size() == 2);
        Assert.assertTrue(x.intValue() == 25);

        x = d.removeFirst();
        Assert.assertFalse(d.isEmpty());
        Assert.assertTrue(d.size() == 1);
        Assert.assertTrue(x.intValue() == 5);
        x = d.removeLast();
        Assert.assertTrue(d.isEmpty());
        Assert.assertTrue(d.size() == 0);
        Assert.assertTrue(d.isEmpty());
    }

    @Test
    public void testIterator() {
        Deque<Integer> d = new Deque<Integer>();
        List<Integer> values = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 19, 21));

        for (Integer item : values) {
            d.addFirst(item);
        }

        List<Integer> reversed = new ArrayList<Integer>(values);
        Collections.reverse(reversed);
        int i = 0;
        for (Integer item : d) {
            Assert.assertEquals(reversed.get(i), item);
            i++;
        }
        Assert.assertTrue(i == reversed.size());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void iteratorThrowsException() {
        Deque<Integer> d = new Deque<Integer>();
        Iterator<Integer> it = d.iterator();
        it.next();
    }
}
