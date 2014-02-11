package com.nastra.algorithms.graph;

import com.nastra.datastructures.Edge;
import com.nastra.datastructures.EdgeWeightedGraph;
import com.nastra.datastructures.MinPQ;
import com.nastra.datastructures.UnionFind;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem statement is as following: Given a distance measure d and k, compute the k-clustering with maximum spacing
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class MaxSpacingKClustering {

    private Queue<Edge> minimumSpanningTree;
    private UnionFind uf;
    private Edge edgeWithMaxSpacing; // the next edge to be extracted after we
                                     // have k clusters

    public MaxSpacingKClustering(EdgeWeightedGraph graph, int k) {
        minimumSpanningTree = new LinkedList<Edge>();
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : graph.edges()) {
            pq.insert(e);
        }
        uf = new UnionFind(graph.verticesCount());
        while (!pq.isEmpty() && minimumSpanningTree.size() < graph.verticesCount() - k - 1) {
            Edge e = pq.delMin();
            int v = e.oneSide();
            int w = e.otherSide(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                minimumSpanningTree.offer(e);
            }
        }
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.oneSide();
            int w = e.otherSide(v);
            if (!uf.connected(v, w)) {
                edgeWithMaxSpacing = e;
                break;
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

    public double maxSpacing() {
        return edgeWithMaxSpacing.weight();
    }
}
