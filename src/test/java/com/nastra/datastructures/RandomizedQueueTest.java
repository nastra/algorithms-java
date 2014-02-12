package com.nastra.datastructures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RandomizedQueueTest {

    @Test(expectedExceptions = NoSuchElementException.class)
    public void dequeueWhenEmpty() {
        RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
        q.dequeue();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void sampleWhenEmpty() {
        RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
        q.sample();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void enqueueNullValue() {
        RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
        q.enqueue(null);
    }

    @Test
    public void testOneValue() {
        RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
        Integer item = 5;
        Assert.assertTrue(q.size() == 0);
        Assert.assertTrue(q.isEmpty());
        q.enqueue(item);
        Assert.assertTrue(q.size() == 1);
        Assert.assertFalse(q.isEmpty());

        Integer x = q.sample();
        Assert.assertFalse(q.isEmpty());
        Assert.assertTrue(q.size() == 1);
        Assert.assertEquals(x, item);

        x = q.dequeue();
        Assert.assertTrue(q.isEmpty());
        Assert.assertTrue(q.size() == 0);
        Assert.assertEquals(x, item);
    }

    @Test
    public void testMultipleValues() {
        Random r = new Random();
        RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
        Integer[] items = {1, 3, 5, 7, 9, 11, 13, 15};
        Assert.assertTrue(q.size() == 0);
        Assert.assertTrue(q.isEmpty());
        
        q.enqueue(items[r.nextInt(items.length)]);
        Assert.assertFalse(q.isEmpty());
        Assert.assertTrue(q.size() == 1);

        q.enqueue(items[r.nextInt(items.length)]);
        Assert.assertFalse(q.isEmpty());
        Assert.assertTrue(q.size() == 2);

        Integer x = q.dequeue();
        Assert.assertTrue(Arrays.binarySearch(items, x) >= 0);
        Assert.assertFalse(q.isEmpty());
        Assert.assertTrue(q.size() == 1);

        x = q.sample();
        Assert.assertTrue(Arrays.binarySearch(items, x) >= 0);
        Assert.assertFalse(q.isEmpty());
        Assert.assertTrue(q.size() == 1);

        x = q.dequeue();
        Assert.assertTrue(Arrays.binarySearch(items, x) >= 0);
        Assert.assertTrue(q.size() == 0);
        Assert.assertTrue(q.isEmpty());
    }

    @Test
    public void testIterator() {
        RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
        Integer[] items = {1, 3, 5, 7, 9, 11, 13, 15, 19, 21};

        // insert the items to the queue
        for (Integer item : items) {
            q.enqueue(item);
            Integer x = q.sample();
            Assert.assertTrue(Arrays.binarySearch(items, x) >= 0);
        }

        Assert.assertTrue(q.size() == items.length);

        // now check for the items that the iterator returns
        Set<Integer> alreadySeen = new HashSet<Integer>();
        for (Integer item : q) {
            Assert.assertFalse(alreadySeen.contains(item));
            alreadySeen.add(item);
            Assert.assertTrue(Arrays.binarySearch(items, item) >= 0);
        }

        Assert.assertTrue(q.size() == items.length);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void iteratorThrowsException() {
        RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
        Iterator<Integer> it = q.iterator();
        it.next();
    }
}
