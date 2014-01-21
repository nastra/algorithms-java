package com.nastra.algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Solution to a Facebook interview question
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class SolutionFacebook {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int numberOfTestCases = Integer.parseInt(line);

        int[] numberOfWhitesPerTestCase = new int[numberOfTestCases];
        for (int i = 0; i < numberOfTestCases; i++) {
            String entireLine = br.readLine();
            String[] singleLine = entireLine.split(" ");
            int C = Integer.valueOf(singleLine[0]);
            int B = Integer.valueOf(singleLine[1]);
            int P = Integer.valueOf(singleLine[2]);

            numberOfWhitesPerTestCase[i] = calculateWhitesForTestCase(C, B, P);
        }

        for (int result : numberOfWhitesPerTestCase) {
            System.out.println(Integer.valueOf(result));
        }
    }

    private static int calculateWhitesForTestCase(int C, int B, int targetProbability) {
        double P = targetProbability / 100.0;
        double probabilityOfContainer = 1.0 / C;

        int minimum = 0;
        if (B < C) {
            minimum = C - B;
        }

        double one = P / probabilityOfContainer;
        double remainingProbability = calculateRemainingProbability(P, probabilityOfContainer, (int) one);

        double two = (remainingProbability * B) / (1.0 - remainingProbability);

        int sum = (int) (Math.ceil(one) + two);
        return Math.max(sum, minimum);
    }

    private static double calculateRemainingProbability(double P, double probabilityOfContainer, int one) {
        return (P - probabilityOfContainer * one) * probabilityOfContainer;
    }
}
