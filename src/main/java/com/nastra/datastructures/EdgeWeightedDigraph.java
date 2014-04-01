package com.nastra.datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents the data structure for a graph with directed edges. It maintains a vertex-indexed array of sets of directed edges, which represent the
 * adjacency lists. It also allows self-loops and parallel edges.
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class EdgeWeightedDigraph {

    private final int vertices;
    private int edges;
    private Set<DirectedEdge>[] adjacent;

    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adjacent = (Set<DirectedEdge>[]) new Set[vertices];
        for (int v = 0; v < vertices; v++) {
            adjacent[v] = new HashSet<DirectedEdge>();
        }
    }

    public int verticesCount() {
        return vertices;
    }

    public int edgeCount() {
        return edges;
    }

    public void addEdge(DirectedEdge e) {
        adjacent[e.from()].add(e);
        edges++;
    }

    public Iterable<DirectedEdge> adjacent(int vertex) {
        return adjacent[vertex];
    }

    public Iterable<DirectedEdge> edges() {
        Set<DirectedEdge> set = new HashSet<DirectedEdge>();
        for (int v = 0; v < vertices; v++) {
            for (DirectedEdge edge : adjacent[v]) {
                set.add(edge);
            }
        }
        return set;
    }
}
