package com.nastra.algorithms.graph;

import java.util.Stack;

import com.nastra.datastructures.DirectedEdge;
import com.nastra.datastructures.EdgeWeightedDigraph;
import com.nastra.datastructures.IndexMinPQ;

/**
 * Implements Dijkstra's shortest path algorithm for directed graphs that have non-negative weights. The algorithm itself runs in time O(E lg V),
 * where E represents the number of edges and V represents the number of vertices. It also requires O(V) additional space, since it uses a priority
 * queue
 * 
 * @author nastra - Eduard Tudenhoefner
 * 
 */
public class Dijkstra {
    private DirectedEdge edgeTo[];
    private double distanceTo[];
    private IndexMinPQ<Double> heap;

    public Dijkstra(EdgeWeightedDigraph graph, int sourceVertex) {
        edgeTo = new DirectedEdge[graph.verticesCount()];
        distanceTo = new double[graph.verticesCount()];
        heap = new IndexMinPQ<Double>(graph.verticesCount());
        for (int v = 0; v < graph.verticesCount(); v++) {
            distanceTo[v] = Double.POSITIVE_INFINITY;
        }
        distanceTo[sourceVertex] = 0.0;
        heap.insert(sourceVertex, 0.0);

        while (!heap.isEmpty()) {
            relaxEdges(graph, heap.delMin());
        }
    }

    private void relaxEdges(EdgeWeightedDigraph graph, int vertex) {
        for (DirectedEdge e : graph.adjacent(vertex)) {
            int w = e.to();
            if (distanceTo[w] > distanceTo[vertex] + e.weight()) {
                distanceTo[w] = distanceTo[vertex] + e.weight();
                edgeTo[w] = e;
                if (!heap.contains(w)) {
                    heap.insert(w, distanceTo[w]);
                } else {
                    heap.change(w, distanceTo[w]);
                }
            }
        }
    }

    public double distanceTo(int vertex) {
        return distanceTo[vertex];
    }

    public boolean hasPathTo(int vertex) {
        return Double.compare(distanceTo[vertex], Double.POSITIVE_INFINITY) < 0;
    }

    public Iterable<DirectedEdge> pathTo(int vertex) {
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        DirectedEdge e = edgeTo[vertex];
        while (null != e) {
            path.push(e);
            e = edgeTo[e.from()];
        }
        return path;
    }
}
