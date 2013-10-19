package com.nastra.algorithms.graph;

import com.nastra.datastructures.Digraph;

/**
 * Allows to find a topological order for a given directed graph
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class TopologicalSorter {

    private Iterable<Integer> topologicalOrder;

    public TopologicalSorter(Digraph graph) {
        CycleFinder finder = new CycleFinder(graph);
        if (finder.containsCycle()) {
            return;
        }

        DepthFirstOrder dfs = new DepthFirstOrder(graph);
        topologicalOrder = dfs.reversePostOrder();
    }

    public Iterable<Integer> topologicalOrder() {
        return topologicalOrder;
    }

    public boolean isDAG() {
        return null != topologicalOrder;
    }
}
