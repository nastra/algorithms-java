package com.nastra.algorithms.sorting;

import com.nastra.datastructures.MinPQ;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author nastra
 */
public class MergingKSortedArrays {

    /**
     * This algorithm runs in time O(n log k) where n is the number of items and k is the number of different arrays. The algorithm uses a min heap
     * and requires requires O(k) space.
     * 
     * @param <T>
     * @param input
     *            A two-dimensional array consisting of k arrays where each array in itself is sorted.
     * @return A list that merges all the arrays.
     */
    public static List<Integer> merge(int[][] input) {
        if (null == input || input.length == 0) {
            return null;
        }
        MinPQ<Item> heap = new MinPQ<Item>();
        for (int i = 0; i < input.length; i++) {
            heap.insert(new Item(input[i][0], i, 1));
        }
        List<Integer> result = new ArrayList<Integer>();
        while (!heap.isEmpty()) {
            Item item = heap.delMin();
            result.add(item.value);
            if (item.currentRow < input.length && item.nextColumn < input[item.currentRow].length) {
                heap.insert(new Item(input[item.currentRow][item.nextColumn], item.currentRow, item.nextColumn + 1));
            }
        }

        return result;
    }

    private static class Item implements Comparable<Item> {

        Integer value;
        int currentRow = 0;
        int nextColumn = 0;

        public Item(Integer value, int currentRow, int nextColumn) {
            this.value = value;
            this.currentRow = currentRow;
            this.nextColumn = nextColumn;
        }

        public int compareTo(Item other) {
            return Integer.compare(this.value, other.value);
        }
    }
}
