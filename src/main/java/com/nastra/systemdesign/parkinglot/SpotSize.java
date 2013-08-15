package com.nastra.systemdesign.parkinglot;

/**
 *
 * @author nastra
 */
public enum SpotSize {

    SMALL(1), MEDIUM(3), LARGE(5);
    private int size;

    private SpotSize(int size) {
        this.size = size;
    }

    public int size() {
        return size;
    }
}
