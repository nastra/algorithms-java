package com.nastra.algorithms;

import com.nastra.datastructures.QueueWithMax;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author nastra
 */
public class QueueWithMaxTest {

    @Test
    public void testSimple() {
        QueueWithMax<Integer> q = new QueueWithMax<Integer>();
        q.enqueue(4);
        Assert.assertTrue(q.max().equals(4));
        q.enqueue(3);
        Assert.assertTrue(q.max().equals(4));
        q.enqueue(12);
        Assert.assertTrue(q.max().equals(12));
        q.dequeue();
        Assert.assertTrue(q.max().equals(12));
        q.dequeue();
        Assert.assertTrue(q.max().equals(12));
        q.dequeue();
        Assert.assertTrue(q.max() == null);

        q.enqueue(6);
        Assert.assertTrue(q.max().equals(6));
        q.enqueue(15);
        Assert.assertTrue(q.max().equals(15));
        q.enqueue(7);
        q.enqueue(8);
        Assert.assertTrue(q.max().equals(15));
        q.dequeue();
        q.dequeue();
        Assert.assertTrue(q.max().equals(8));
    }
}