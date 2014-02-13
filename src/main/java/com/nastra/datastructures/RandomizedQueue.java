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
    private int size = 0;
    private Item[] q;

    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        q = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (null == item) {
            throw new NullPointerException("Item must not be null!");
        }
        if (size == q.length) {
            resize(q.length * 2);
        }
        q[size++] = item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = q[i];
        }
        q = temp;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size > 0 && size == q.length / 4) {
            resize(q.length / 2);
        }

        size--;
        randomSwap(q, size);
        Item item = q[size];
        q[size] = null;
        return item;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        randomSwap(q, size - 1);
        Item item = q[size - 1];
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
        Item[] copy = null;
        int curr = -1;

        @SuppressWarnings("unchecked")
        public RandomIterator() {
            copy = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                copy[i] = q[i];
            }
            StdRandom.shuffle(copy);

            curr = 0;
        }

        public boolean hasNext() {
            return curr < copy.length;
        }

        public Item next() {
            if (curr == copy.length) {
                throw new NoSuchElementException();
            }
            Item item = copy[curr++];
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
