package com.nastra.algorithms;

/**
 * 
 * @author nastra
 */
public class Random {

    private static java.util.Random random = new java.util.Random();

    public static int randInt(int min, int max) {

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = random.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
