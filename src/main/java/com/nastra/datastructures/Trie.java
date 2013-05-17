package com.nastra.datastructures;

import java.util.LinkedList;
import java.util.Queue;

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
        Node<T> node = get(root, key, 0);
        if (null != node) {
            return node.value;
        }
        return null;
    }

    private Node get(Node<T> node, String key, int len) {
        if (null == node) {
            return null;
        }
        if (len == key.length()) {
            return node;
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

    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> q = new LinkedList<String>();
        Node<T> x = get(root, prefix, 0);
        collect(x, prefix, q);
        return q;
    }

    private void collect(Node<T> node, String prefix, Queue<String> q) {
        if (null == node) {
            return;
        }
        if (null != node.value) {
            q.add(prefix);
        }
        for (char c = 0; c < R; c++) {
            collect(node.next[c], prefix + c, q);
        }
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }
}
