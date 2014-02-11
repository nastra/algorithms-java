package com.nastra.algorithms.tree;

import java.util.List;

/**
 * Solution to the following interview question: <br>
 * "Traverse a tree without using recursion or any other helper data structures."
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class MorrisTraversal<T> {

    private Node root;

    private Node getMax(Node node) {
        Node current = node;
        while (null != current && null != current.right) {
            current = current.right;
        }
        return current;
    }

    private Node<T> getParentOf(Node<T> temp, Node left) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private class Node<T> {

        T value;
        Node left;
        Node right;
    }

    /**
     * Traverses a tree without using recursion or any other helper data
     * structures
     * 
     * @param root
     *            The root of the tree
     * @param values
     *            The list where to store the traversed values of the tree.
     */
    public void traverse(Node root, List<T> values) {
        Node<T> current = root;
        while (null != current) {
            if (null != current.left) {
                Node<T> temp = getMax(current.left);
                if (temp.equals(current)) {
                    // restore the tree
                    Node<T> p = getParentOf(temp, current.left);
                    p.right = null;
                    current = current.right;
                } else {
                    temp.right = current;
                    current = current.left;
                }
            } else {
                values.add(current.value);
                current = current.right;
            }
        }
    }
}
