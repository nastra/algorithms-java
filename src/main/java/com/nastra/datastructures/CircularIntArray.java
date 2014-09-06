package com.nastra.datastructures;

public class CircularIntArray {
    private final int[] elements;
    private final int len;
    private int rotation;

    public CircularIntArray(int[] elements) {
        this.elements = elements;
        this.len = elements.length;
    }

    public void rotateClockwise(int offset) {
        this.rotation += offset;
        // Clamp rotation such that 0 <= rotation < len
        this.rotation %= len;
        if (this.rotation < 0)
            this.rotation += len;
    }

    public void rotateCounterClockwise(int offset) {
        this.rotation -= offset;
        // Clamp rotation such that 0 <= rotation < len
        this.rotation %= len;
        if (this.rotation < 0)
            this.rotation += len;
    }

    public int get(int position) {
        // One-based indexing
        return this.elements[(position + rotation + len - 1) % len];
    }
}
