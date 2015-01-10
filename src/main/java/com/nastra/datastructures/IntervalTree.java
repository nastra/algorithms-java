package com.nastra.datastructures;

/**
 * Represents a simple Interval Tree. Please note that this interval tree does not balance itself because it is not based e.g. on a Red-Black tree.
 * 
 * @see http://en.wikipedia.org/wiki/Interval_tree
 * @author nastra
 * 
 */
public class IntervalTree {
    private Node root;

    class Node {
        Interval in;
        double max;
        Node left;
        Node right;

        @Override
        public String toString() {
            return in.toString() + " max = " + max;
        }

    }

    public void insert(Interval in) {
        if (null == in) {
            throw new IllegalArgumentException("Interval must be set!");
        }
        root = insert(root, in);
    }

    private Node insert(Node x, Interval in) {
        if (null == x) {
            x = new Node();
            x.in = new Interval(in.left(), in.right());
            x.max = in.right();
            return x;
        }
        double left = x.in.left();

        if (in.left() < left) {
            x.left = insert(x.left, in);
        } else {
            x.right = insert(x.right, in);
        }

        // update max value of this ancestor
        if (x.max < in.right()) {
            x.max = in.right();
        }

        return x;
    }

    public Interval overlapSearch(Interval in) {
        if (null == in) {
            throw new IllegalArgumentException("Interval must be set!");
        }
        Node x = overlapSearch(root, in);
        if (null != x) {
            return x.in;
        }
        return null;
    }

    private Node overlapSearch(Node x, Interval in) {
        if (null == x) {
            return null;
        }
        // If given interval overlaps with root
        if (x.in.intersects(in)) {
            return x;
        }

        // If left child of root is present and max of left child is
        // greater than or equal to given interval, then i may
        // overlap with an interval is left subtree
        if (null != x.left && x.left.max >= in.left()) {
            return overlapSearch(x.left, in);
        }

        // Else interval can only overlap with right subtree
        return overlapSearch(x.right, in);
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node x) {
        if (null == x) {
            return;
        }
        inorder(x.left);
        System.out.println(x);
        inorder(x.right);
    }

    public static void main(String... args) {
        // Let us create interval tree shown in above figure
        Interval ints[] = {new Interval(15.0, 20.0), new Interval(10.0, 30.0), new Interval(17.0, 19.0), new Interval(5.0, 20.0),
                new Interval(12.0, 15.0), new Interval(30.0, 40.0)};

        IntervalTree tree = new IntervalTree();
        for (int i = 0; i < ints.length; i++) {
            tree.insert(ints[i]);
        }
        System.out.println("Inorder traversal of constructed Interval Tree is");
        tree.inorder();

        Interval x = new Interval(6.0, 7.0);

        System.out.println("Searching for interval " + x);
        Interval res = tree.overlapSearch(x);
        if (null == res)
            System.out.println("\nNo Overlapping Interval");
        else
            System.out.println("Overlaps with " + res);
    }
}
