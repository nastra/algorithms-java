package com.nastra.algorithms.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author nastra
 */
public class HeapPermute {

    private List<String> permutations = new ArrayList<String>();

    public List<String> getPermutations() {
        return permutations;
    }

    private void swap(char[] v, int i, int j) {
        char t = v[i];
        v[i] = v[j];
        v[j] = t;
    }

    private void permute(String input, int n) {
        if (n == 1) {
            permutations.add(input);
        } else {
            for (int i = 0; i < n; i++) {
                permute(input, n - 1);
                if (n % 2 == 1) {
                    swap(input.toCharArray(), 0, n - 1);
                } else {
                    swap(input.toCharArray(), i, n - 1);
                }
            }
        }
    }

    public void permute(String input) {
        if (null == input || "".equals(input)) {
            return;
        }
        permutations.clear();
        permute(input, input.length());
    }
}