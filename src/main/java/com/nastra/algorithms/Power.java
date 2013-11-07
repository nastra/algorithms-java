package com.nastra.algorithms;

import com.nastra.datastructures.ListNode;

/**
 *
 * @author nastra
 */
public class Power {

    public static void powerOf(int n) {
        if (n <= 0) {
            System.out.println(1);
        }
        if (n <= 64) {
            System.out.println(1 << n);
        }

        int count = 1;
        String out = new String("2");
        while (count < n) {
            out = calculate(out);
            count++;
        }
        System.out.println(out);
    }

    public static void powerOfEfficient(int n) {
        if (n <= 0) {
            System.out.println(1);
        }
        if (n <= 64) {
            System.out.println(1 << n);
            return;
        }

        int count = 1;
        ListNode<Integer> head = new ListNode<Integer>(2);
        while (count < n) {
            head = calculate(head);
            count++;
        }
        head = reverse(head);

        ListNode<Integer> x = head;
        while (null != x) {
            System.out.print(x.getValue());
            x = x.getNext();
        }
    }

    private static ListNode<Integer> calculate(ListNode<Integer> x) {
        int remainder = 0;
        ListNode<Integer> head = x;
        ListNode<Integer> prev = null;
        while (null != x) {
            Integer val = (x.getValue() * 2) + remainder;
            if (val >= 10) {
                remainder = 1;
                val -= 10;
            } else {
                remainder = 0;
            }
            x.setValue(val);
            prev = x;
            x = x.getNext();
        }
        if (remainder > 0 && null != prev) {
            prev.setNext(new ListNode<Integer>(1));
        }
        return head;
    }

    private static String calculate(String out) {
        String result = "";
        int remainder = 0;
        char[] chars = out.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            Integer val = Character.digit(chars[i], 10);
            val *= 2;
            val += remainder;
            if (val >= 10) {
                val = val - 10;
                remainder = 1;
            } else {
                remainder = 0;
            }
            chars[i] = String.valueOf(val).charAt(0);
        }
        if (remainder > 0) {
            result += remainder;
        }
        result += new String(chars);
        return result;
    }

    public static void main(String[] args) {
        Power.powerOf(8);
        System.out.println("--------------------------------------");
        Power.powerOf(10);
        System.out.println("--------------------------------------");
        Power.powerOf(20);
        System.out.println("--------------------------------------");
        Power.powerOf(65);
        Power.powerOfEfficient(65);
        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        Power.powerOf(80);
        System.out.println("--------------------------------------");
        Power.powerOfEfficient(80);
        System.out.println("");
        System.out.println("--------------------------------------");
        
        Power.powerOf(125);
        System.out.println("--------------------------------------");
        Power.powerOfEfficient(125);
        System.out.println("");
        System.out.println("--------------------------------------");
    }

    private static ListNode<Integer> reverse(ListNode<Integer> head) {
        if (null == head) {
            return null;
        }

        ListNode<Integer> x = head;
        ListNode<Integer> prev = null;
        while (null != x) {
            ListNode<Integer> next = x.getNext();
            x.setNext(prev);
            prev = x;
            x = next;
        }
        return prev;
    }
}
