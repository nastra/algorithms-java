package com.nastra.algorithms.graph;

import com.nastra.datastructures.Digraph;
import java.util.Stack;

/**
 * Uses depth-first search to detect cycles in a directed graph
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class CycleFinder {

    private boolean[] visited;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onCurrentStack;

    public CycleFinder(Digraph graph) {
        visited = new boolean[graph.verticesCount()];
        onCurrentStack = new boolean[graph.verticesCount()];
        edgeTo = new int[graph.verticesCount()];
        for (int v = 0; v < graph.verticesCount(); v++) {
            if (!visited[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(Digraph graph, int s) {
        visited[s] = true;
        onCurrentStack[s] = true;
        for (int w : graph.adjacent(s)) {
            if (containsCycle()) {
                return;
            } else if (!visited[w]) {
                edgeTo[w] = s;
                dfs(graph, w);
            } else if (onCurrentStack[w]) {
                determineEntireCyclePath(graph, s, w);
            }
        }
        onCurrentStack[s] = false;
    }

    public boolean containsCycle() {
        return null != cycle;
    }

    private void determineEntireCyclePath(Digraph graph, int s, int w) {
        cycle = new Stack<Integer>();
        for (int i = s; s != w; i = edgeTo[i]) {
            cycle.push(i);
        }
        cycle.push(w);
        cycle.push(s);
    }
}
