package com.nastra.datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents an undirected graph
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class Graph {

    private final int vertices;
    private int edges;
    private Set<Integer>[] adjacent;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacent = new Set[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacent[i] = new HashSet<Integer>();
        }
    }

    public int vertices() {
        return vertices;
    }

    public int edges() {
        return edges;
    }

    public void addEdge(int v, int w) {
        adjacent[v].add(w);
        adjacent[w].add(v);
        edges++;
    }

    public Iterable<Integer> adjacent(int v) {
        return adjacent[v];
    }
}
