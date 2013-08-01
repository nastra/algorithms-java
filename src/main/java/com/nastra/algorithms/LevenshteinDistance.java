package com.nastra.algorithms;

/**
 * Given two character strings str1 and str2, the edit distance between them is the minimum number of edit operations required to transform str1 into
 * str2. Most commonly, the edit operations allowed for this purpose are: (i) insert a character into a string; (ii) delete a character from a string
 * and (iii) replace a character of a string by another character; for these operations, edit distance is sometimes known as Levenshtein distance .
 * For example, the edit distance between cat and dog is 3.
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class LevenshteinDistance {

    public static int computeDistance(char[] str1, char[] str2) {
        if (str1.length == 0) {
            return str2.length;
        }
        if (str2.length == 0) {
            return str1.length;
        }
        int[][] distance = new int[str1.length + 1][str2.length + 1];

        for (int i = 1; i <= str1.length; i++) {
            distance[i][0] = i;
        }
        for (int j = 1; j <= str2.length; j++) {
            distance[0][j] = j;
        }

        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                int dist = 0;
                if (str1[i - 1] != str2[j - 1]) {
                    dist = 1;
                }
                int a = distance[i - 1][j - 1] + dist;
                int b = distance[i - 1][j] + 1;
                int c = distance[i][j - 1];
                distance[i][j] = min(a, b, c);
            }
        }

        return distance[str1.length][str2.length];
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
