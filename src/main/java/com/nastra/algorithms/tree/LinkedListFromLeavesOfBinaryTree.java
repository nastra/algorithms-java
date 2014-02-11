package com.nastra.algorithms.tree;

import com.nastra.datastructures.ListNode;
import com.nastra.datastructures.TreeNode;

/**
 * The interview question is as following: "Given a binary tree, write a
 * function which forms a linked list from the leaves of the binary tree. The
 * leaves should appear in left-to-right order."
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class LinkedListFromLeavesOfBinaryTree<T> {

    private ListNode<T> head;
    private ListNode<T> current;

    public void listFromLeaves(TreeNode<T> n) {
        if (null == n) {
            return;
        }
        listFromLeaves(n.getLeft());

        if (null == n.getLeft() && null == n.getRight()) {
            if (null == head) {
                head = new ListNode<T>(n.getValue());
                current = head;
            } else {
                current.setNext(new ListNode<T>(n.getValue()));
                current.setNext(current);
            }
            return;
        }
        listFromLeaves(n.getRight());
    }

    public ListNode<T> head() {
        return head;
    }
}
