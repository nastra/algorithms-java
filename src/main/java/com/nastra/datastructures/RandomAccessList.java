package com.nastra.datastructures;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * A random access list that is backed up by a hashmap in order to allow O(1) randomized access to elements.
 * 
 * @author nastra
 * 
 */
public class RandomAccessList {
    private int elements = 0;
    private Node head;
    private Node tail;

    private Map<Integer, Node> indexToNodeMap = new HashMap<Integer, Node>();

    private class Node {
        Node next;
        int value;
        int index;

        public Node(int value) {
            super();
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node [index=" + index + ", value=" + value + "]";
        }

    }

    /**
     * Elements can be added in O(1).
     * 
     * @param value
     */
    public void add(int value) {
        elements++;
        Node x = new Node(value);
        if (null == head) {
            x.index = 0;
            head = x;
            tail = x;
        } else {
            x.index = tail.index + 1;
            tail.next = x;
            tail = x;
        }
        indexToNodeMap.put(x.index, x);
    }

    /**
     * Last k elements can be deleted in time O(k)
     * 
     * @param k
     */
    public void deleteLastKNumbers(int k) {
        int index = elements - k;
        if (index < 0) {
            throw new IllegalArgumentException(k + " is larger than the number of elements, which is " + elements);
        }
        Node prev = indexToNodeMap.get(index - 1);
        Node x = indexToNodeMap.get(index);
        while (null != x) {
            indexToNodeMap.remove(x.index);
            elements--;
            x = x.next;
        }
        if (null != prev) {
            prev.next = null;
            tail = prev;
        } else {
            head = tail = null;
            elements = 0;
        }
    }

    /**
     * 
     * @param x
     * @param left
     * @param right
     * @return
     */
    public int xorMaxInRange(int x, int left, int right) {
        Node start = indexToNodeMap.get(left);
        Node end = indexToNodeMap.get(right + 1);
        Node n = start;
        int xorMax = 0;
        int maxValue = 0;
        while (n != end) {
            if (xorMax < (x ^ n.value)) {
                xorMax = x ^ n.value;
                maxValue = n.value;
            }
            n = n.next;
        }

        return maxValue;
    }

    /**
     * Runs in time O(right-left)
     * 
     * @param x
     * @param left
     * @param right
     * @return
     */
    public int numberOfIntsLessOrEqualTo(int x, int left, int right) {
        Node start = indexToNodeMap.get(left);
        Node end = indexToNodeMap.get(right + 1);
        Node n = start;
        int count = 0;
        while (n != end) {
            if (n.value <= x) {
                count++;
            }
            n = n.next;
        }
        return count;
    }

    public int selectKthOrderStatistic(int k, int left, int right) {
        Node start = indexToNodeMap.get(left);
        Node end = indexToNodeMap.get(right + 1);
        Node n = start;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(elements, new Comparator<Integer>() {

            public int compare(Integer one, Integer two) {
                return two.compareTo(one);
            }

        });
        int item = n.value;
        while (n != end) {
            pq.add(n.value);
            n = n.next;
        }
        int i = 0;
        while (i < k) {
            item = pq.remove();
        }
        return item;
    }

    public void printInorder() {
        Node start = head;
        while (start != null) {
            System.out.print(start + " -> ");
            start = start.next;
        }
        System.out.println();
    }

    public static void main(String... args) {
        RandomAccessList list = new RandomAccessList();
        System.out.println("add some elements");
        list.add(8);
        list.printInorder();
        list.add(4);
        list.printInorder();
        list.add(7);
        list.printInorder();
        list.add(3);
        list.printInorder();
        list.add(12);
        list.printInorder();

        System.out.println("delete last 4: ");
        list.deleteLastKNumbers(4);
        list.printInorder();

        System.out.println("add some elements...");
        list.add(4);
        list.printInorder();
        list.add(4);
        list.printInorder();
        list.add(4);
        list.printInorder();

        System.out.println("delete last 2: ");
        list.deleteLastKNumbers(2);
        list.printInorder();

        System.out.println("add some elements...");
        list.add(4);
        list.printInorder();
        list.add(4);
        list.printInorder();
        list.add(4);
        list.printInorder();

        System.out.println("delete all...");
        list.deleteLastKNumbers(list.elements);
        list.printInorder();

        System.out.println("XOR");
        list.add(8);
        list.add(2);
        System.out.println(list.xorMaxInRange(7, 1, 1));
        System.out.println(list.xorMaxInRange(7, 1, 1));
        list.add(1);
    }

}
