package org.example.stack;

public interface Stack<E extends Comparable> {

    boolean empty();
    E peek();
    E pop();
    void push(E element);
    int search(E e);
}
