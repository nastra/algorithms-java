package com.nastra.algorithms.tree;

import com.nastra.datastructures.TreeNode;

/**
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class BSTChecker {

    public static boolean isBST(TreeNode<Integer> n) {
        return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Algorithm runs in O(n).
     * 
     * @param n
     *            The current node.
     * @param min
     * @param max
     * @return True, if the tree is a binary search tree.
     */
    private static boolean isBST(TreeNode<Integer> n, int min, int max) {
        if (null == n) {
            return true;
        }

        if (n.getValue() < min || n.getValue() > max) {
            return false;
        }

        return isBST(n.getLeft(), min, n.getValue()) && isBST(n.getRight(), n.getValue(), max);
    }
}
