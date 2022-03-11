package org.example.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayListStack<E extends Comparable> implements Stack<E> {

    private List<E> stack;

    public ArrayListStack() {
        this.stack = new ArrayList<E>();
    }

    @Override
    public boolean empty() {
        return this.stack.isEmpty();
    }

    @Override
    public E peek() {
        return this.stack.get(0);
    }

    @Override
    public E pop() {
        return this.stack.remove(0);
    }

    @Override
    public void push(E element) {
        this.stack.add(0, element);
    }

    @Override
    public int search(E e) {
        return this.stack.indexOf(e);
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("ArrayListStack {");
        sb.append("stack=")
          .append(stack);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListStack<?> that = (ArrayListStack<?>) o;
        return Objects.equals(stack, that.stack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stack);
    }
}
