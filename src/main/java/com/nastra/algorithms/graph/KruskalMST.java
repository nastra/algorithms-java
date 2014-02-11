package com.nastra.algorithms.graph;

import com.nastra.datastructures.Edge;
import com.nastra.datastructures.EdgeWeightedGraph;
import com.nastra.datastructures.MinPQ;
import com.nastra.datastructures.UnionFind;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implements Kruskal's minimum spanning tree algorithm.
 * 
 * @author nastra
 */
public class KruskalMST {

    private Queue<Edge> minimumSpanningTree;

    public KruskalMST(EdgeWeightedGraph graph) {
        minimumSpanningTree = new LinkedList<Edge>();
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : graph.edges()) {
            pq.insert(e);
        }
        UnionFind uf = new UnionFind(graph.verticesCount());
        while (!pq.isEmpty() && minimumSpanningTree.size() < graph.verticesCount() - 1) {
            Edge e = pq.delMin();
            int v = e.oneSide();
            int w = e.otherSide(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                minimumSpanningTree.offer(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return minimumSpanningTree;
    }

    public double weight() {
        double total = 0.0d;
        for (Edge edge : minimumSpanningTree) {
            total += edge.weight();
        }
        return total;
    }
}
