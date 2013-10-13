package com.nastra.datastructures;

/**
 * A singly linked list where each node consists of a <Key, Value> pair.
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class KeyValueList<K, V> {

    private KeyValueNode<K, V> head;
    private KeyValueNode<K, V> tail;

    public KeyValueList() {
    }

    /**
     * Inserting a new element is done in time O(n) in the worst case.
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        if (null == head) {
            head = new KeyValueNode(key, value);
            tail = head;
            return;
        }

        KeyValueNode<K, V> node = getNode(key);
        if (null != node) {
            // update the value
            node.setValue(value);
        } else {
            tail.setNext(new KeyValueNode(key, value));
            tail.setNext(tail.getNext());
        }
    }

    private KeyValueNode<K, V> getNode(K key) {
        KeyValueNode<K, V> n = head;
        while (null != n) {
            if (n.getKey().equals(key)) {
                return n;
            }
        }
        return null;
    }

    /**
     * Retrieving a node is done in time O(n) in the worst case.
     *
     * @param key The key to search for
     * @return The value associated with the given key.
     */
    public V get(K key) {
        KeyValueNode<K, V> node = getNode(key);
        if (null != node) {
            return node.getValue();
        }
        return null;
    }
}
