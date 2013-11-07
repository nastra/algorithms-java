package com.nastra.datastructures;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * A very simple implementation of a LRU (least recently used) cache. <br>
 * The implementation of the cache is synchronized by using {@link Collections#synchronizedMap(java.util.Map)}. It uses almost the same interface as
 * {@link Map}.
 * <br>
 * This is the solution to the following interview question: "How would you design a LRU cache?"
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class LRUCache<K, V> {

    private static final long serialVersionUID = 6377955652444051755L;
    private int size;
    private Map<K, V> cache;

    public LRUCache(int initialCapacity) {
        cache = Collections.synchronizedMap(new LinkedHashMap<K, V>(initialCapacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
                return size() > size;
            }
        });
    }

    public int size() {
        return cache.size();
    }

    public boolean isEmpty() {
        return cache.isEmpty();
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    public boolean containsValue(V value) {
        return cache.containsValue(value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public V put(K key, V value) {
        return cache.put(key, value);
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        cache.putAll(m);
    }

    public void clear() {
        cache.clear();
    }

    public Set<K> keySet() {
        return cache.keySet();
    }

    public Collection<V> values() {
        return cache.values();
    }

    public Set<Entry<K, V>> entrySet() {
        return cache.entrySet();
    }
}
