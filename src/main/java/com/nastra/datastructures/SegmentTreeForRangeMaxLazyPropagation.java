package com.nastra.datastructures;

/**
 * Given an array A[1 ... m], you want to perform the following operations: <br>
 * <li>a) report maximum element in a range A[i...j]</li><br>
 * <li>b) set A[i] = x.</li><br>
 * <li>c) update range [i..j] by a given value</li> <br>
 * Updates to leaf nodes are propagated in a lazy way.
 * 
 * @author nastra
 * 
 */
public class SegmentTreeForRangeMaxLazyPropagation {
    private int[] tree;
    private int[] lazy;
    private int startSegment;
    private int endSegment;
    private int root;

    public SegmentTreeForRangeMaxLazyPropagation(int[] a) {
        int n = a.length;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        tree = new int[maxSize];
        lazy = new int[maxSize];
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

        return getMaxLazy(startSegment, endSegment, queryStart, queryEnd, root);
    }

    private int getMaxLazy(int start, int end, int queryStart, int queryEnd, int node) {
        if (lazy[node] != 0) {
            // node needs to be updated
            tree[node] += lazy[node];
            if (start != end) {
                lazy[leftChild(node)] += lazy[node];
                lazy[rightChild(node)] += lazy[node];
            }
        }
        if (queryStart <= start && queryEnd >= end) {
            return tree[node];
        }
        if (end < queryStart || start > queryEnd) {
            return Integer.MIN_VALUE;
        }
        int mid = mid(start, end);
        int leftMax = getMaxLazy(start, mid, queryStart, queryEnd, leftChild(node));
        int rightMax = getMaxLazy(mid + 1, end, queryStart, queryEnd, rightChild(node));
        return Math.max(leftMax, rightMax);
    }

    public void update(int queryStart, int queryEnd, int newValue) {
        updateTreeLazy(startSegment, endSegment, queryStart, queryEnd, newValue, root);
    }

    private void updateTreeLazy(int start, int end, int queryStart, int queryEnd, int val, int node) {
        if (lazy[node] != 0) {
            tree[node] += lazy[node];
            if (start != end) {
                // it is not a leaf node
                lazy[leftChild(node)] += lazy[node];
                lazy[rightChild(node)] += lazy[node];
            }
            lazy[node] = 0;
        }
        if (start > end || start > queryEnd || end < queryStart) {
            // Current segment is not within range [queryStart, queryEnd]
            return;
        }
        if (start >= queryStart && end <= queryEnd) {
            // if node is fully within interval
            tree[node] += val;
            if (start != end) {
                lazy[leftChild(node)] += val;
                lazy[rightChild(node)] += val;
            }
            return;
        }
        int mid = mid(start, end);
        updateTreeLazy(start, mid, queryStart, queryEnd, val, leftChild(node));
        updateTreeLazy(mid + 1, end, queryStart, queryEnd, val, rightChild(node));
        tree[node] = Math.max(tree[leftChild(node)], tree[rightChild(node)]);
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
        System.out.println("..................");
        int[] b = {1, 1, 1, 1, 1, 1, 1, 1};

        s = new SegmentTreeForRangeMax(b);
        s.update(4, b.length - 1, 5); // Increment range [4, n-1] by 5
        System.out.println(s.getMax(0, 3));
        System.out.println(s.getMax(0, 4));

    }
}
