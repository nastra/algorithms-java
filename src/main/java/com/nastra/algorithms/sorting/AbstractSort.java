/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nastra.algorithms.sorting;

/**
 *
 * @author nastra
 */
public abstract class AbstractSort {

    protected boolean lessThan(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected boolean greaterThan(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    public void showContent(Comparable[] input) {
        if (null == input || input.length == 0) {
            return;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            out.append(input[i]);
            out.append(" ");
        }
        System.out.println(out.toString());
    }

    /**
     * @param input
     * @return True, if the array entries are in order.
     */
    public boolean isSorted(Comparable[] input) {
        if (null == input || input.length == 0) {
            return false;
        }
        for (int i = 0; i < input.length - 1; i++) {
            if (greaterThan(input[i], input[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public abstract void sort(Comparable[] input);
}
