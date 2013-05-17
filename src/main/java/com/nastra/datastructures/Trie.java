package com.nastra.datastructures;

/**
 * This class uses an R-way Trie to implement a symbol table
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class Trie<T> {

    private static final int R = 256;
    private Node<T> root;

    private class Node<T> {

        private T value;
        private Node[] next = new Node[R];
    }

    public void put(String key, T value) {
        root = put(root, key, value, 0);
    }

    private Node<T> put(Node<T> node, String key, T value, int len) {
        if (null == node) {
            node = new Node();
        }
        if (len == key.length()) {
            node.value = value;
            return node;
        }
        char c = key.charAt(len);
        node.next[c] = put(node.next[c], key, value, len + 1);
        return node;
    }

    public T get(String key) {
        return get(root, key, 0);
    }

    private T get(Node<T> node, String key, int len) {
        if (null == node) {
            return null;
        }
        if (len == key.length()) {
            return node.value;
        }
        char c = key.charAt(len);
        return get(node.next[c], key, len + 1);
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (null == node) {
            return 0;
        }
        int count = 0;
        if (null != node.value) {
            count++;
        }
        for (char c = 0; c < R; c++) {
            count = count + size(node.next[c]);
        }
        return count;
    }
}
