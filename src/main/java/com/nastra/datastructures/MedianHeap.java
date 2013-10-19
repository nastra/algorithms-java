package com.nastra.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements a median heap that consists of a max and a min heap to keep track of the running median.
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class MedianHeap implements Iterable<Integer> {

    private MinPQ<Integer> min;
    private MaxPQ<Integer> max;

    public MedianHeap() {
        min = new MinPQ<Integer>();
        max = new MaxPQ<Integer>();
    }

    public void insert(Integer x) {
        if (max.isEmpty()) {
            max.insert(x);
        } else if (lessOrEqual(x, max.max())) {
            max.insert(x);
        } else {
            min.insert(x);
        }
        balance();
    }

    public Double median() {
        int left = max.size();
        int right = min.size();
        if (left == right) {
            return (max.max() + min.min()) * 0.5;
        }
        if (left > right) {
            return max.max().doubleValue();
        }
        return min.min().doubleValue();
    }

    public boolean isEmpty() {
        return min.isEmpty() && max.isEmpty();
    }

    public Integer deleteMedian() {
        int left = max.size();
        int right = min.size();
        if (left == right || left < right) {
            return max.delMax();
        }
        return min.delMin();
    }

    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }

    private boolean lessOrEqual(Integer x, Integer y) {
        return Integer.compare(x, y) <= 0;
    }

    private void balance() {
        int left = max.size();
        int right = min.size();
        if ((left + 2) == right) {
            max.insert(min.delMin());
        } else if ((right + 2) == left) {
            min.insert(max.delMax());
        }
    }

    private class HeapIterator implements Iterator<Integer> {

        // create a new pq
        private MedianHeap copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            while (!max.isEmpty()) {
                copy.insert(max.delMax());
            }
            while (!min.isEmpty()) {
                copy.insert(min.delMin());
            }
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.deleteMedian();
        }
    }
}
