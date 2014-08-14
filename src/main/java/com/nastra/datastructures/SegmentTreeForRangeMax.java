package com.nastra.datastructures;

/**
 * Given an array A[1 ... m], you want to perform the following operations: <br>
 * <li>a) report maximum element in a range A[i ... j]</li><br>
 * <li>b) set A[i] = x.</li>
 * 
 * @author nastra
 * 
 */
public class SegmentTreeForRangeMax {
    private int[] tree;
    private int startSegment;
    private int endSegment;
    private int root;

    public SegmentTreeForRangeMax(int[] a) {
        int n = a.length;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        tree = new int[maxSize];
        startSegment = 0;
        endSegment = n - 1;
        root = 0;
        constructTree(a, startSegment, endSegment, root);
    }

    private int constructTree(int[] a, int start, int end, int node) {
        if (start == end) {
            tree[node] = a[start];
            return tree[node];
        }
        int mid = mid(start, end);
        int leftMax = constructTree(a, start, mid, leftChild(node));
        int rightMax = constructTree(a, mid + 1, end, rightChild(node));
        tree[node] = Math.max(leftMax, rightMax);
        return tree[node];
    }

    private int mid(int startSegment, int endSegment) {
        return startSegment + (endSegment - startSegment) / 2;
    }

    private int rightChild(int node) {
        return node * 2 + 2;
    }

    private int leftChild(int node) {
        return node * 2 + 1;
    }

    /**
     * 
     * @param queryStart
     * @param queryEnd
     * @return The max element within the given range as specified by queryStart and queryEnd
     */
    public int getMax(int queryStart, int queryEnd) {
        if (queryStart < startSegment || queryEnd > endSegment || queryStart > queryEnd) {
            throw new IllegalArgumentException("The given interval is not valid!");
        }

        return getMax(startSegment, endSegment, queryStart, queryEnd, root);
    }

    private int getMax(int start, int end, int queryStart, int queryEnd, int node) {
        if (queryStart <= start && queryEnd >= end) {
            return tree[node];
        }
        if (end < queryStart || start > queryEnd) {
            return Integer.MIN_VALUE;
        }
        int mid = mid(start, end);
        int leftMax = getMax(start, mid, queryStart, queryEnd, leftChild(node));
        int rightMax = getMax(mid + 1, end, queryStart, queryEnd, rightChild(node));
        return Math.max(leftMax, rightMax);
    }

    /**
     * Sets a[updateAt] to newValue and updates the required intervals as necessary.
     * 
     * @param newValue
     *            The new value
     * @param updateAt
     *            The position of the new value in the original array
     * @param a
     *            The original array holding the numbers.
     */
    public void update(int newValue, int updateAt, int[] a) {
        int diff = newValue - a[updateAt];
        a[updateAt] = newValue;
        updateTree(startSegment, endSegment, updateAt, diff, root);
    }

    private void updateTree(int start, int end, int updateAt, int val, int node) {
        if (updateAt < start || updateAt > end) {
            return;
        }
        if (start == end) {
            tree[node] += val;
            return;
        }
        int mid = mid(start, end);
        if (updateAt <= mid) {
            updateTree(start, mid, updateAt, val, leftChild(node));
        } else {
            updateTree(mid + 1, end, updateAt, val, rightChild(node));
        }

        tree[node] = Math.max(tree[leftChild(node)], tree[rightChild(node)]);
    }
    
    public void update(int queryStart, int queryEnd, int newValue) {
        
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 1, 4, 9, 3, 7, 6};
        SegmentTreeForRangeMax s = new SegmentTreeForRangeMax(a);
        System.out.println(s.getMax(0, 7));
        System.out.println(s.getMax(0, 1));
        System.out.println(s.getMax(0, 2));
        System.out.println(s.getMax(0, 3));
        System.out.println(s.getMax(0, 4));
        System.out.println(s.getMax(0, 5));
        System.out.println(s.getMax(0, 7));
        System.out.println(s.getMax(6, 7));
        System.out.println(s.getMax(5, 7));
        System.out.println(s.getMax(0, 7));
        System.out.println("updating...third element to 33");
        s.update(33, 2, a);
        System.out.println(s.getMax(0, 7));
        System.out.println(s.getMax(0, 1));
        System.out.println(s.getMax(0, 2));
        System.out.println(s.getMax(0, 3));
        System.out.println(s.getMax(0, 4));
        System.out.println(s.getMax(0, 5));
        System.out.println(s.getMax(0, 7));
        System.out.println(s.getMax(6, 7));
        System.out.println(s.getMax(5, 7));
        System.out.println(s.getMax(2, 4));
        System.out.println(s.getMax(4, 5));
    }

}
