package com.nastra.datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a directed graph
 * 
 * @author nastra
 */
public class Digraph {

    private final int verticesCount;
    private int edgeCount;
    private Set<Integer>[] adjacent;

    @SuppressWarnings("unchecked")
    public Digraph(int verticesCount) {
        this.verticesCount = verticesCount;
        adjacent = new Set[verticesCount];
        for (int v = 0; v < verticesCount; v++) {
            adjacent[v] = new HashSet<Integer>();
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
        edgeCount++;
    }

    public Iterable<Integer> adjacent(int v) {
        return adjacent[v];
    }

    public Digraph reverse() {
        Digraph reversedGraph = new Digraph(verticesCount);
        for (int v = 0; v < verticesCount; v++) {
            for (int w : adjacent[v]) {
                reversedGraph.addEdge(w, v);
            }
        }
        return reversedGraph;
    }
}
