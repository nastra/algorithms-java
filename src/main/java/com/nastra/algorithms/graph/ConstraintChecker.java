package com.nastra.algorithms.graph;

import com.nastra.datastructures.ConnectedComponentsFinder;
import com.nastra.datastructures.Graph;
import java.util.List;

/**
 * Given a collection of equality constraints of the form xi = xj, and
 * inequality constraints of the form xi != xj, is it possible to satisfy all
 * the constraints simultaneously? For example, the constraints x1 = x2, x2 =
 * x3, x3 = x4, and x1 != x4 cannot be satisfied simultaneously. Such
 * constraints arise in checking the equivalence of loop-free programs with
 * uninterpreted functions.
 * 
 * <br>
 * The interview questions to this description is as following: "Design an
 * efficient algorithm that takes as input a collection of equality and
 * inequality constraints and decides whether the constraints can be satisfied
 * simultaneously."
 * 
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class ConstraintChecker {

    public static boolean canBeSatisfied(List<Constraint> equalityConstraints, List<Constraint> inequalityConstraints) {
        ConnectedComponentsFinder finder = createConnectedComponentGraph(equalityConstraints);

        for (Constraint constraint : inequalityConstraints) {
            if (finder.connected(constraint.one, constraint.two)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Represents a constraint of the form xi = xj or xi != xj.
     */
    public static class Constraint {

        int one;
        int two;
    }

    private static ConnectedComponentsFinder createConnectedComponentGraph(List<Constraint> equalityConstraints) {
        Graph g = new Graph(equalityConstraints.size());
        for (Constraint c : equalityConstraints) {
            g.addEdge(c.one, c.two);

        }
        return new ConnectedComponentsFinder(g);
    }
}
