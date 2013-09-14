package com.nastra.datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author nastra
 */
public class EdgeWeightedGraph {

    private final int vertices;
    private int edges;
    private Set<Edge>[] adjacent;

    public EdgeWeightedGraph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adjacent = (Set<Edge>[]) new Set[vertices];
        for (int v = 0; v < vertices; v++) {
            adjacent[v] = new HashSet<Edge>();
        }
    }

    public int vertices() {
        return vertices;
    }

    public int edges() {
        return edges;
    }

    public void addEdge(Edge e) {
        int v = e.oneSide();
        int w = e.otherSide(v);
        adjacent[v].add(e);
        adjacent[w].add(e);
        edges++;
    }

    public Iterable<Edge> adjacent(int vertex) {
        return adjacent[vertex];
    }
}
