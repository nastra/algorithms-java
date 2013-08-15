package com.nastra.datastructures;

/**
 * A simple linked list node that stores a key and a value
 *
 * @author nastra
 */
public class KeyValueNode<K, V> {

    private K key;
    private V value;
    private KeyValueNode<K, V> next;

    public KeyValueNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public KeyValueNode<K, V> getNext() {
        return next;
    }

    public void setNext(KeyValueNode<K, V> next) {
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
