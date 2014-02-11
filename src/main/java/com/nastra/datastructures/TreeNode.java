package com.nastra.datastructures;

/**
 * 
 * @author nastra
 */
public class TreeNode<T> {

    private TreeNode<T> left;
    private TreeNode<T> right;
    private T value;

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
