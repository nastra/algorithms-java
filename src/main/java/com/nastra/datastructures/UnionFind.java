package com.nastra.datastructures;

/**
 * **************************************************************************
 * Compilation: javac UF.java Execution: java UF < input.txt Dependencies: StdIn.java StdOut.java Data files:
 * http://algs4.cs.princeton.edu/15uf/tinyUF.txt http://algs4.cs.princeton.edu/15uf/mediumUF.txt http://algs4.cs.princeton.edu/15uf/largeUF.txt
 *
 * Weighted quick-union (without path compression).
 *
 * % java UF < tinyUF.txt 4 3 3 8 6 5 9 4 2 1 5 0 7 2 6 1 2 components
 *
 ***************************************************************************
 */
/**
 * The <tt>UF</tt> class represents a union-find data data structure. It supports the <em>union</em> and <em>find</em>
 * operations, along with a method for determining the number of disjoint sets.
 * <p>
 * This implementation uses weighted quick union. Creating a data structure with N objects takes linear time. Afterwards, all operations are
 * logarithmic worst-case time.
 * <p>
 * For additional documentation, see <a href="http://algs4.cs.princeton.edu/15uf">Section 1.5</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class UnionFind {

    private int[] id;    // id[i] = parent of i
    private int[] sz;    // sz[i] = number of objects in subtree rooted at i
    private int count;   // number of components

    /**
     * Create an empty union find data structure with N isolated sets.
     *
     * @throws java.lang.IllegalArgumentException if N < 0
     */
    public UnionFind(int N) {
        if (N < 0) {
            throw new IllegalArgumentException();
        }
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * Return the id of component corresponding to object p.
     *
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= p < N
     */
    public int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IndexOutOfBoundsException();
        }
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * Return the number of disjoint sets.
     */
    public int count() {
        return count;
    }

    /**
     * Are objects p and q in the same set?
     *
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Replace sets containing p and q with their union.
     *
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }

        // make smaller root point to larger one
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}
