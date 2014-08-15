package com.nastra.datastructures;

/**
 * A basic hash map that uses chaining for colliding hashes
 * 
 * @author nastra
 */
public class ChainingMap<K, V> {

    private int size = 997;
    private KeyValueList<K, V>[] table;

    public ChainingMap() {
        this(997);
    }

    @SuppressWarnings("unchecked")
    public ChainingMap(int size) {
        this.size = size;
        table = new KeyValueList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new KeyValueList<K, V>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        table[hash].put(key, value);
    }

    public V get(K key) {
        int hash = hash(key);
        return table[hash].get(key);
    }
}
