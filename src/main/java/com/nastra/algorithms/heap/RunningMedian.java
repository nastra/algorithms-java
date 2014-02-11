package com.nastra.algorithms.heap;

import com.nastra.datastructures.MedianHeap;

/**
 * Solution to the following interview question:
 * "Design an algorithm to compute the running median of a sequence."
 * 
 * <br>
 * <br>
 * The running time of this algorithm is O(n log n).
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class RunningMedian {

    public static void printRunningMedian(int[] in) {
        MedianHeap heap = new MedianHeap();
        for (int value : in) {
            heap.insert(value);
            System.out.println("Last added element was: " + value + ". The Running median is: " + heap.median() + ". Heap Content: ");
        }
        System.out.println("Processed " + in.length + " elements");
    }

    public static void main(String... args) {
        int[] in = generateRandomArray(10, 100);

        printRunningMedian(in);
    }

    private static int[] generateRandomArray(int arraySize, int maxElement) {
        int[] numbers = new int[arraySize];
        java.util.Random generator = new java.util.Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(maxElement);
        }
        return numbers;
    }
}
