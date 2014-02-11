package com.nastra.algorithms.graph;

import com.nastra.datastructures.Digraph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This class uses depth-first search and allows clients to iterate in different orders through the verticesCount of a graph.
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class DepthFirstOrder {

    private boolean[] visited;
    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;
    private Stack<Integer> reversePostOrder;

    public DepthFirstOrder(Digraph graph) {
        preOrder = new LinkedList<Integer>();
        postOrder = new LinkedList<Integer>();
        reversePostOrder = new Stack<Integer>();
        visited = new boolean[graph.verticesCount()];
        for (int v = 0; v < graph.verticesCount(); v++) {
            if (!visited[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(Digraph graph, int s) {
        visited[s] = true;
        preOrder.add(s);
        for (int w : graph.adjacent(s)) {
            if (!visited[w]) {
                dfs(graph, w);
            }
        }
        postOrder.add(s);
        reversePostOrder.add(s);
    }

    public Iterable<Integer> preOrder() {
        return preOrder;
    }

    public Iterable<Integer> postOrder() {
        return postOrder;
    }

    public Iterable<Integer> reversePostOrder() {
        return reversePostOrder;
    }
}
