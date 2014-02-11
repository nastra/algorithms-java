package com.nastra.datastructures;

/**
 * Represents an Edge with a given weight in a graph.
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class Edge implements Comparable<Edge> {

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int oneSide() {
        return v;
    }

    public int otherSide(int vertex) {
        if (vertex == v) {
            return w;
        } else if (vertex == w) {
            return v;
        }
        throw new RuntimeException("Inconsistent Edge!");
    }

    public int compareTo(Edge that) {
        if (this.weight() < that.weight()) {
            return -1;
        }
        if (this.weight() > that.weight()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);
    }
}
