package com.nastra.datastructures;

/**
 * Uses DFS to find connected components in a graph.
 *
 * @author nastra
 */
public class ConnectedComponentsFinder {

    private boolean[] visited;
    private int[] group;
    private int count;

    public ConnectedComponentsFinder(Graph g) {
        visited = new boolean[g.verticesCount()];
        group = new int[g.verticesCount()];
        for (int i = 0; i < g.verticesCount(); i++) {
            if (!visited[i]) {
                dfs(g, i);
                count++;
            }
        }
    }

    private void dfs(Graph g, int source) {
        visited[source] = true;
        for (Integer adj : g.adjacent(source)) {
            if (!visited[adj]) {
                dfs(g, adj);
            }
        }
    }

    public boolean connected(int v, int w) {
        return group[v] == group[w];
    }

    public int groupOf(int v) {
        return group[v];
    }

    public int count() {
        return count;
    }
}
