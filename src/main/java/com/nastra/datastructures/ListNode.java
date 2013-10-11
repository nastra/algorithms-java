package com.nastra.datastructures;

/**
 *
 * @author nastra
 */
public class ListNode<T> {

    private ListNode<T> next;
    private T value;

    public ListNode(T value) {
        this.value = value;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
