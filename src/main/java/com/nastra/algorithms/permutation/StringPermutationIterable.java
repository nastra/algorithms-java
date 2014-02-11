/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nastra.algorithms.permutation;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implicit immutable collection of all permutations of a string with an iterator over the permutations.
 * <p>
 * implements Iterable&ltString&gt
 * 
 * @see #StringPermutationIterable(String)
 */
public class StringPermutationIterable implements Iterable<String> {

    // could implement Collection<String> but it's immutable, so most methods
    // are essentially vacuous
    protected final String string;

    /**
     * Creates an implicit Iterable collection of all permutations of a string
     * 
     * @param string
     *            String to be permuted
     * @see Iterable
     * @see #iterator
     */
    public StringPermutationIterable(String string) {
        this.string = string;
    }

    /**
     * Constructs and sequentially returns the permutation values
     */
    public Iterator<String> iterator() {

        return new Iterator<String>() {
            char[] array = string.toCharArray();
            int length = string.length();
            int[] index = (length == 0) ? null : new int[length];

            public boolean hasNext() {
                return index != null;
            }

            public String next() {

                if (index == null) {
                    throw new NoSuchElementException();
                }

                for (int i = 1; i < length; ++i) {
                    char swap = array[i];
                    System.arraycopy(array, 0, array, 1, i);
                    array[0] = swap;
                    for (int j = 1; j < i; ++j) {
                        index[j] = 0;
                    }
                    if (++index[i] <= i) {
                        return new String(array);
                    }
                    index[i] = 0;
                }
                index = null;
                return new String(array);
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
