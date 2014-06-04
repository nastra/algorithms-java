package com.nastra.algorithms.tree;

/**
 * A <a href="http://en.wikipedia.org/wiki/Fenwick_tree">Fenwick Tree</a> that supports point queries and range updates. All operations run in time
 * O(log n).
 * 
 * @author nastra - Eduard Tudenhoefner
 * 
 */
public class FenwickTree {
    long[] tree;

    public FenwickTree(int size) {
        tree = new long[size + 1];
    }

    public long query(int index) {
        long sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }

        return sum;
    }

    public void update(int index, long val) {
        while (index < tree.length) {
            tree[index] += val;
            index += index & (-index);
        }

    }

    public void update(int left, int right, long val) {
        update(left, val);
        update(right + 1, -val);
    }
}
