package com.nastra.algorithms.graph;

import com.nastra.datastructures.Edge;
import com.nastra.datastructures.EdgeWeightedGraph;
import com.nastra.datastructures.MinPQ;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Implements a lazy version of Prim's minimum spanning tree algorithm.
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class LazyPrimMST {

    private boolean[] visited;
    private Queue<Edge> minimumSpanningTree;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph graph) {
        visited = new boolean[graph.verticesCount()];
        pq = new MinPQ<Edge>();
        minimumSpanningTree = new LinkedList<Edge>();
        Random random = new Random();
        int startingVertex = random.nextInt(graph.verticesCount() + 1);
        visit(graph, startingVertex); // we assume a connected graph here
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.oneSide();
            int w = e.otherSide(v);
            if (visited[v] && visited[w]) {
                continue;
            }
            minimumSpanningTree.offer(e);
            if (!visited[v]) {
                visit(graph, v);
            }
            if (!visited[w]) {
                visit(graph, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph graph, int vertex) {
        visited[vertex] = true;
        for (Edge edge : graph.adjacent(vertex)) {
            if (!visited[edge.otherSide(vertex)]) {
                pq.insert(edge);
            }
        }
    }

    public double weight() {
        double total = 0.0d;
        for (Edge edge : minimumSpanningTree) {
            total += edge.weight();
        }
        return total;
    }
}
