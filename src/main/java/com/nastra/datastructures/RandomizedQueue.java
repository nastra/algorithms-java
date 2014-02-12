package com.nastra.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random from items in the data structure.
 * 
 * @author nastra - Eduard Tudenhoefner
 * 
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int tail = 0;
    private Item[] q;

    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        q = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return tail == 0;
    }

    public int size() {
        return tail;
    }

    public void enqueue(Item item) {
        if (null == item) {
            throw new NullPointerException("Item must not be null!");
        }
        if (tail == q.length) {
            resize(q.length << 1);
        }
        q[tail++] = item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int size) {
        Item[] copy = (Item[]) new Object[size];
        for (int i = 0; i < q.length; i++) {
            copy[i] = q[i];
        }
        q = copy;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        tail--;
        randomSwap(q, tail);
        Item item = q[tail];
        q[tail] = null;
        return item;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        randomSwap(q, tail - 1);
        Item item = q[tail - 1];
        return item;
    }

    private void randomSwap(Item[] queue, int t) {
        int index = StdRandom.uniform(t + 1);
        Item tmp = queue[index];
        queue[index] = queue[t];
        queue[t] = tmp;
    }

    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {
        Item[] copy = q;
        int t = tail;

        public boolean hasNext() {
            return t > 0;
        }

        public Item next() {
            if (t == 0) {
                throw new NoSuchElementException();
            }
            t--;
            randomSwap(copy, t);
            Item item = copy[t];
            copy[t] = null;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
