package com.nastra.algorithms;

import com.nastra.datastructures.MaxPQ;
import com.nastra.datastructures.MinPQ;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class PQTest {

    @Test
    public void testRemovingArbitraryElementsFromMinHeap() {
        Integer[] keys = {4, 9, 3, 2, 1, 5, 8, 0, 23};
        MinPQ<Integer> heap = new MinPQ<Integer>(keys);
        Assert.assertTrue(heap.isMinHeap());
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < 10000; i++) {
            Integer indexToDelete = random.nextInt(1000);
            Integer value = random.nextInt(50000);
            heap.insert(value);
            if (indexToDelete > 0) {
                int size = heap.size();
                heap.deleteAt(size);
                Assert.assertTrue(heap.isMinHeap());
            }
        }
    }

    @Test
    public void testRemovingArbitraryElementsFromMaxHeap() {
        Integer[] keys = {4, 9, 3, 2, 1, 5, 8, 0, 23};
        MaxPQ<Integer> heap = new MaxPQ<Integer>(keys);
        Assert.assertTrue(heap.isMaxHeap());
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < 10000; i++) {
            Integer indexToDelete = random.nextInt(1000);
            Integer value = random.nextInt(50000);
            heap.insert(value);
            if (indexToDelete > 0) {
                int size = heap.size();
                heap.deleteAt(size);
                Assert.assertTrue(heap.isMaxHeap());
            }
        }
    }
}