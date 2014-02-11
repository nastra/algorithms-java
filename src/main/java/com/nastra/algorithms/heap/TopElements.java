package com.nastra.algorithms.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Retrieves the top k elements in increasing order from a given list in an efficient way by using a priority queue. Its running time is O(n log k).
 * If the top k elements are not required to be in sorted order, then we use a selection-based approach.
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class TopElements {

    public static <T extends Comparable> List<T> findTopElements(List<T> unsortedInput, int topElements, boolean sortTopElements) {
        if (sortTopElements) {
            return getSortedTopElements(unsortedInput, topElements);
        }
        return getUnsortedTopElements(unsortedInput, topElements);
    }

    /**
     * We use an approach based on a binary heap (priority queue) to retrieve the top k elements in sorted order.
     * 
     * @param <T>
     * @param unsortedInput
     * @param topElements
     * @return
     */
    private static <T extends Comparable> List<T> getSortedTopElements(List<T> unsortedInput, int topElements) {
        List<T> result = new ArrayList<T>();
        PriorityQueue<T> queue = new PriorityQueue<T>(topElements);
        for (T item : unsortedInput) {
            if (queue.size() < topElements) {
                queue.add(item);
            } else if (lessThan(queue.peek(), item)) {
                queue.poll();
                queue.add(item);
            }
        }

        for (int i = 0; i < topElements; i++) {
            result.add(queue.poll());
        }

        return result;
    }

    /**
     * We use a selection-based approach here to retrieve the top k elements.
     * 
     * @param <T>
     * @param unsortedInput
     * @param topElements
     * @return
     */
    private static <T extends Comparable> List<T> getUnsortedTopElements(List<T> unsortedInput, int topElements) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    private static boolean lessThan(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}