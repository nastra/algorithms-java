package com.nastra.datastructures;

import java.util.Arrays;

/**
 * A simple segment tree that allows the following two operations in time O(log n):<br>
 * <li>Find the sum of elements from index l to r where 0 <= l <= r <= n-1</li><br>
 * <li>Change value of a specified element of the array arr[i] = x where 0 <= i <= n-1.</li><br>
 * <br>
 * The height of the tree is ceil(log(n)) where n is the number of elements that should be stored in the tree. The maximal size for storing internal
 * nodes and leaves is then 2*2^height-1.
 * 
 * @author nastra
 * 
 */
public class SegmentTreeForRangeSum {
    private int[] tree;
    private int n;
    private int startSeg;
    private int endSeg;
    private int root = 0;

    public SegmentTreeForRangeSum(int[] a) {
        n = a.length;
        int height = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        tree = new int[maxSize];
        startSeg = 0;
        endSeg = n - 1;
        constructTree(a, startSeg, endSeg, root);
    }

    private int mid(int startSegment, int endSegment) {
        return startSegment + (endSegment - startSegment) / 2;
    }

    public void update(int update, int updateAt, int[] a) {
        int diff = update - a[updateAt];
        a[updateAt] = update;
        updateTree(startSeg, endSeg, updateAt, diff, root);
    }

    public void update(int oldValue, int newValue, int updateAt) {
        int diff = newValue - oldValue;
        updateTree(startSeg, endSeg, updateAt, diff, root);
    }

    private void updateTree(int segmentStart, int segmentEnd, int updateAt, int diff, int index) {
        if (updateAt < segmentStart || updateAt > segmentEnd) {
            return;
        }
        tree[index] = tree[index] + diff;
        if (segmentStart != segmentEnd) {
            int mid = mid(segmentStart, segmentEnd);
            updateTree(segmentStart, mid, updateAt, diff, leftChild(index));
            updateTree(mid + 1, segmentEnd, updateAt, diff, rightChild(index));
        }
    }

    public int getSum(int queryStart, int queryEnd) {
        // Check for erroneous input values
        if (queryStart < startSeg || queryEnd > endSeg || queryStart > queryEnd) {
            return -1;
        }

        return getSum(startSeg, endSeg, queryStart, queryEnd, root);
    }

    private int getSum(int segmentStart, int segmentEnd, int queryStart, int queryEnd, int index) {
        // If segment of this node is a part of given range, then return the
        // sum of the segment -> range of node is within queryStart and queryEnd
        if (queryStart <= segmentStart && queryEnd >= segmentEnd)
            return tree[index];

        // If segment of this node is outside the given range
        if (segmentEnd < queryStart || segmentStart > queryEnd)
            return 0;

        int mid = mid(segmentStart, segmentEnd);
        return getSum(segmentStart, mid, queryStart, queryEnd, leftChild(index))
                + getSum(mid + 1, segmentEnd, queryStart, queryEnd, rightChild(index));
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int constructTree(int[] a, int low, int high, int index) {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (low == high) {
            tree[index] = a[low];
            return a[low];
        }
        int mid = mid(low, high);
        if (leftChild(index) < tree.length) {
            tree[index] += constructTree(a, low, mid, leftChild(index));
        }
        if (rightChild(index) < tree.length) {
            tree[index] += constructTree(a, mid + 1, high, rightChild(index));
        }
        return tree[index];
    }

    public static void main(String[] args) {
        int arr[] = {2, 6, 9, 1, 3, 5};
        SegmentTreeForRangeSum t = new SegmentTreeForRangeSum(arr);
        System.out.println(Arrays.toString(t.tree));
        System.out.println(Arrays.toString(arr));
        System.out.println(t.getSum(1, 3));
        t.update(-5, 2, arr);
        t.update(5, 2, arr);
        System.out.println(t.getSum(1, 3));
        System.out.println(t.getSum(0, 2));
        System.out.println(t.getSum(0, 5));
    }

}
