package com.nastra.datastructures;

import java.util.Arrays;

/**
 * A simple segment tree that allows the following two operations in time O(log n):<br>
 * <li>Find the sum of elements from index l to r where 0 <= l <= r <= n-1</li><br>
 * <li>Change value of a specified element of the array arr[i] = x where 0 <= i <= n-1.</li><br>
 * 
 * @author nastra
 * 
 */
public class SegmentTree {
    private int[] tree;
    private int n;
    private int startSeg;
    private int endSeg;
    private int root = 0;

    public SegmentTree(int[] a) {
        n = a.length;
        int height = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int maxsize = 2 * (int) Math.pow(2, height) - 1;
        tree = new int[maxsize];
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
        updateTreeUtil(startSeg, endSeg, updateAt, diff, root);
    }

    public void update(int oldValue, int newValue, int updateAt) {
        int diff = newValue - oldValue;
        updateTreeUtil(startSeg, endSeg, updateAt, diff, root);
    }

    private void updateTreeUtil(int segmentStart, int segmentEnd, int updateAt, int update, int index) {
        if (updateAt < segmentStart || updateAt > segmentEnd) {
            return;
        }
        tree[index] = tree[index] + update;
        if (segmentStart != segmentEnd) {
            int mid = mid(segmentStart, segmentEnd);
            updateTreeUtil(segmentStart, mid, updateAt, update, index * 2 + 1);
            updateTreeUtil(mid + 1, segmentEnd, updateAt, update, index * 2 + 2);
        }
    }

    public int getSum(int queryStart, int queryEnd) {
        // Check for erroneous input values
        if (queryStart < 0 || queryEnd > n - 1 || queryStart > queryEnd) {
            return -1;
        }

        return getSum(startSeg, endSeg, queryStart, queryEnd, root);
    }

    private int getSum(int segmentStart, int segmentEnd, int queryStart, int queryEnd, int index) {
        // If segment of this node is a part of given range, then return the
        // sum of the segment
        if (queryStart <= segmentStart && queryEnd >= segmentEnd)
            return tree[index];

        // If segment of this node is outside the given range
        if (segmentEnd < queryStart || segmentStart > queryEnd)
            return 0;

        int mid = mid(segmentStart, segmentEnd);
        return getSum(segmentStart, mid, queryStart, queryEnd, index * 2 + 1) + getSum(mid + 1, segmentEnd, queryStart, queryEnd, index * 2 + 2);
    }

    private int constructTree(int[] a, int low, int high, int index) {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (low == high) {
            tree[index] = a[low];
            return a[low];
        }
        int mid = mid(low, high);
        if (index * 2 + 1 < tree.length) {
            tree[index] += constructTree(a, low, mid, index * 2 + 1);
        }
        if (index * 2 + 2 < tree.length) {
            tree[index] += constructTree(a, mid + 1, high, index * 2 + 2);
        }
        return tree[index];
    }

    public static void main(String[] args) {
        int arr[] = {2, 6, 9, 1, 3, 5};
        SegmentTree t = new SegmentTree(arr);
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
