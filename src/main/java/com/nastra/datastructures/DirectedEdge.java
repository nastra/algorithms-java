package com.nastra.datastructures;

/**
 * Represents a directed Edge with a given weight in a graph.
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class DirectedEdge implements Comparable<DirectedEdge> {

    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public int compareTo(DirectedEdge that) {
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
