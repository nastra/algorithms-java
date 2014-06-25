package com.nastra.algorithms.dp;

/**
 * @see http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * @author nastra
 * 
 */
public class EditDistance {

    public static int distance(char[] a, char[] b) {
        if (a.length == 0) {
            return b.length;
        }
        if (b.length == 0) {
            return a.length;
        }
        int m = a.length;
        int n = b.length;
        int[][] dist = new int[a.length + 1][b.length + 1];

        for (int i = 0; i <= m; i++) {
            dist[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dist[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1] == b[j - 1]) {
                    // characters are the same, so distance doesn't change
                    dist[i][j] = dist[i - 1][j - 1];
                } else {
                    int deletion = dist[i - 1][j] + 1;
                    int subst = dist[i][j - 1] + 1;
                    int insert = dist[i - 1][j - 1] + 1;
                    dist[i][j] = min(deletion, subst, insert);
                }
            }
        }

        return dist[m][n];
    }

    public static void main(String[] args) {
        String a = "house";
        String b = "hose";
        System.out.println("Distance for '" + a + "' and '" + b + "' is: " + distance(a.toCharArray(), b.toCharArray()));
        a = "hammer";
        b = "hard";
        System.out.println("Distance for '" + a + "' and '" + b + "' is: " + distance(a.toCharArray(), b.toCharArray()));

        a = "what is going on?";
        b = "what was going on";
        System.out.println("Distance for '" + a + "' and '" + b + "' is: " + distance(a.toCharArray(), b.toCharArray()));

        a = "SUNDAY";
        b = "SATURDAY";
        System.out.println("Distance for '" + a + "' and '" + b + "' is: " + distance(a.toCharArray(), b.toCharArray()));

        a = "hours";
        b = "our";
        System.out.println("Distance for '" + a + "' and '" + b + "' is: " + distance(a.toCharArray(), b.toCharArray()));

        a = "coding";
        b = "cracking";
        System.out.println("Distance for '" + a + "' and '" + b + "' is: " + distance(a.toCharArray(), b.toCharArray()));
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
