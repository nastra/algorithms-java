package com.nastra.datastructures;

/**
 * Implements a FenwickTree (also known as a Binary Indexed Tree). <br>
 * In a Fenwick Tree, the node at index <b>X</b> will store the frequencies of the range <b>'low..high'</b>, where <b>low = X - 2*r + 1</> and <b>high
 * = X</b>. </b>
 * <p>
 * The value <b>r</b> in this case is the position of the last 1 digit in the binary representation of X. <br>
 * For example, if <b>X = 12 (binary 1100)</b>, then the position of the last 1 digit is <b>2</b>, because it is zero-indexed.
 * <p>
 * <li>'low..high', where <b>low = X - 2*r + 1</> and <b>high = X</b></li>
 * <li>X = 12 (binary 1100), so node will store frequencies of the range 9..12</li>
 * <li>low = X - 2*r + 1 = 12 - 2*2 + 1</li>
 * <li>high = X = 12</li> <br>
 * 
 * @author nastra - Eduard Tudenhoefner
 * @see http://en.wikipedia.org/wiki/Fenwick_tree
 * 
 */
public class FenwickTree {

    private int[] tree;

    public FenwickTree(int size) {
        tree = new int[size + 1];
    }

    /**
     * 
     * @param idx
     * @return The cumulative frequency from the first entry up to the entry at position idx
     */
    public int frequencyTo(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }

    /**
     * 
     * @param idx
     * @return The frequency at position idx
     */
    public int frequencyAt(int idx) {
        return frequencyTo(idx) + frequencyTo(idx - 1);
    }

    /**
     * Updates the frequency from position idx up to the last position to the new value given by val
     * 
     * @param idx
     * @param val
     */
    public void update(int idx, int val) {
        while (idx < tree.length) {
            tree[idx] += val;
            idx += (idx & -idx);
        }
    }

    /**
     * 
     * @param left
     * @param right
     * @return The cumulative frequencies in the range left..right
     */
    public int rangeQuery(int left, int right) {
        return frequencyTo(right) - frequencyTo(left - 1);
    }
}
