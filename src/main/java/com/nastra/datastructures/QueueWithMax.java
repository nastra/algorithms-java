package com.nastra.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implements a Queue that provides access to the max element in O(1) time. We use a simple queue to store all the elements and a Deque
 * (http://en.wikipedia.org/wiki/Double-ended_queue) for remembering the max element. The operations max() and dequeue() run in constant time. The
 * enqueue() operation could lead to many ejections in the Deque, however the amortized time of enqueue()/dequeue()/max() will be O(n).
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class QueueWithMax<T extends Comparable> {

    private Deque<T> max;
    private Queue<T> queue;

    public QueueWithMax() {
        max = new ArrayDeque<T>();
        queue = new LinkedList<T>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue(T value) {
        queue.offer(value);
        while (!max.isEmpty() && greaterThan(value, max.peekLast())) {
            max.pollLast();
        }
        max.addLast(value);
    }

    public T dequeue() {
        T value = queue.poll();
        if (equal(value, max.peekFirst())) {
            max.pollFirst();
        }
        return value;
    }

    public T max() {
        return max.peekFirst();
    }

    private boolean lessThan(T one, T two) {
        return one.compareTo(two) <= 0;
    }

    private boolean greaterThan(T one, T two) {
        return one.compareTo(two) > 0;
    }

    private boolean equal(T one, T two) {
        return one.compareTo(two) == 0;
    }
}
