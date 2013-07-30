package com.nastra.algorithms;

import com.google.common.math.DoubleMath;

/**
 * We basically compute the square root of a double by using binary search. This is the solution to the following interview question:
 * <br>'Implement a square root function using only +,-,*,/'.
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class SquareRoot {

    private static final double EPSILON = 0.001;

    /**
     * Given x, we do a binary search where we start with a lower bound 'low' and an upper bound 'high'.
     * <br> Basically, we check in each iteration whether the square of the midpoint [low, high] is smaller than, equal to, or greater than x.
     * <br> When checking for equality, we currently use a tolerance of '0.001'. This is our eps.
     * <br> For the initial lower and upper bounds, the following strategy is used:
     * <br> - if x >= 1.0, we use 1.0 for the lower bound and x for the upper bound, since x >= 1.0 -> x^2 >= x
     * <br> - if x < 1.0, we use x for the lower bound and 1.0 for the upper bound, since x < 1.0 -> x^2 < x.
     *
     * <br> The time complexity of the algorithm is O(log x/eps)
     *
     * @param x
     * @return An approximation of the square root of x by using binary search.
     */
    public static double sqrt(double x) {
        double low;
        double high;
        if (x < 1.0) {
            low = x;
            high = 1.0;
        } else {
            low = 1.0;
            high = x;
        }

        while (Double.compare(low, high) < 0) {   // while low < high
            double mid = (low + high) / 2.0;
            double square = mid * mid;
            if (compare(square, x) < 0) {
                low = mid;
            } else if (compare(square, x) > 0) {
                high = mid;
            } else {
                return mid;
            }
        }
        return 1d;
    }

    /**
     * we do a fuzzy compare with a tolerance of EPSILON
     *
     * @param a
     * @param b
     * @return
     */
    private static int compare(double a, double b) {
        return DoubleMath.fuzzyCompare(a, b, EPSILON);
    }
}
