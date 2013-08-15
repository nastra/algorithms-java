package com.nastra.datastructures;

/**
 *
 * @author nastra
 */
public class KeyValueList<K, V> {

    private KeyValueNode<K, V> head;

    public KeyValueList() {
    }

    public void put(K key, V value) {
        if (null == head) {
            head = new KeyValueNode(key, value);
            return;
        }

        KeyValueNode<K, V> node = getNode(key);
        if (null != node) {
            // update the value
            node.setValue(value);
        } else {
            node = new KeyValueNode(key, value);
            KeyValueNode<K, V> n = head;
            while (null != n.getNext()) {
                n.setNext(n.getNext());
            }
            n.setNext(node);
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

    public V get(K key) {
        KeyValueNode<K, V> node = getNode(key);
        if (null != node) {
            return node.getValue();
        }
        return null;
    }
}
