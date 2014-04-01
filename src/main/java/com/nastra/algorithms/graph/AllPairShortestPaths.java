package com.nastra.algorithms.graph;

import com.nastra.datastructures.DirectedEdge;
import com.nastra.datastructures.EdgeWeightedDigraph;

/**
 * This very easy implementation uses Dijkstra's algorithm to solve the "All-Pair-Shortest Path Problem". It requires time of O(E*V lg V)
 * 
 * @author nastra - Eduard Tudenhoefner
 * 
 */
public class AllPairShortestPaths {
    private Dijkstra[] allPairs;

    public AllPairShortestPaths(EdgeWeightedDigraph graph) {
        allPairs = new Dijkstra[graph.verticesCount()];
        for (int v = 0; v < graph.verticesCount(); v++) {
            allPairs[v] = new Dijkstra(graph, v);
        }
    }

    public Iterable<DirectedEdge> path(int source, int target) {
        return allPairs[source].pathTo(target);
    }

    public double distance(int source, int target) {
        return allPairs[source].distanceTo(target);
    }
}
