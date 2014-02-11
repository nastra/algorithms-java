package com.nastra.datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents an undirected graph
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class Graph {

    private final int verticesCount;
    private int edgeCount;
    private Set<Integer>[] adjacent;

    public Graph(int vertices) {
        this.verticesCount = vertices;
        adjacent = new Set[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacent[i] = new HashSet<Integer>();
        }
    }

    public int verticesCount() {
        return verticesCount;
    }

    public int edgeCount() {
        return edgeCount;
    }

    public void addEdge(int v, int w) {
        adjacent[v].add(w);
        adjacent[w].add(v);
        edgeCount++;
    }

    public Iterable<Integer> adjacent(int v) {
        return adjacent[v];
    }
}
