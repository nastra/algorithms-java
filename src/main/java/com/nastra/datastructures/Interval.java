package com.nastra.datastructures;

import java.util.Comparator;

/**
 * Represents a one-dimensional closed interval
 * 
 * @author nastra
 * 
 */
public class Interval {

    /**
     * Compares two intervals by left endpoint.
     */
    public static final Comparator<Interval> LEFT_ENDPOINT_ORDER = new LeftComparator();

    /**
     * Compares two intervals by right endpoint.
     */
    public static final Comparator<Interval> RIGHT_ENDPOINT_ORDER = new RightComparator();

    /**
     * Compares two intervals by length.
     */
    public static final Comparator<Interval> LENGTH_ORDER = new LengthComparator();

    private double left;
    private double right;

    /**
     * Initializes an interval [left, right].
     * 
     * @param left
     *            the left endpoint
     * @param right
     *            the right endpoint
     * @throws IllegalArgumentException
     *             if the left endpoint is greater than the right endpoint
     * @throws IllegalArgumentException
     *             if either <tt>left</tt> or <tt>right</tt> is <tt>Double.NaN</tt>, <tt>Double.POSITIVE_INFINITY</tt> or
     *             <tt>Double.NEGATIVE_INFINITY</tt>
     */
    public Interval(double left, double right) {
        if (Double.isInfinite(left) || Double.isInfinite(right))
            throw new IllegalArgumentException("Endpoints must be finite");
        if (Double.isNaN(left) || Double.isNaN(right))
            throw new IllegalArgumentException("Endpoints cannot be NaN");

        if (left <= right) {
            this.left = left;
            this.right = right;
        } else
            throw new IllegalArgumentException("Illegal interval");
    }

    public double left() {
        return left;
    }

    public double right() {
        return right;
    }

    /**
     * Does this interval intersect that interval?
     * 
     * @param that
     *            the other interval
     * @return true if this interval intersects that interval; false otherwise
     */
    public boolean intersects(Interval that) {
        if (this.right < that.left)
            return false;
        if (that.right < this.left)
            return false;
        return true;
    }

    /**
     * Does this interval contain the value x?
     * 
     * @param x
     *            the value
     * @return true if this interval contains the value x; false otherwise
     */
    public boolean contains(double x) {
        return (left <= x) && (x <= right);
    }

    /**
     * Returns the length of this interval.
     * 
     * @return the length of this interval (right - left)
     */
    public double length() {
        return right - left;
    }

    public String toString() {
        return "[" + left + ", " + right + "]";
    }

    // ascending order of left endpoint, breaking ties by right endpoint
    private static class LeftComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            if (a.left < b.left)
                return -1;
            else if (a.left > b.left)
                return +1;
            else if (a.right < b.right)
                return -1;
            else if (a.right > b.right)
                return +1;
            else
                return 0;
        }
    }

    // ascending order of right endpoint, breaking ties by left endpoint
    private static class RightComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            if (a.right < b.right)
                return -1;
            else if (a.right > b.right)
                return +1;
            else if (a.left < b.left)
                return -1;
            else if (a.left > b.left)
                return +1;
            else
                return 0;
        }
    }

    // ascending order of length
    private static class LengthComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            double alen = a.length();
            double blen = b.length();
            if (alen < blen)
                return -1;
            else if (alen > blen)
                return +1;
            else
                return 0;
        }
    }

}
