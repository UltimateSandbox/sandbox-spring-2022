package org.example.inheritance.composition;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Composition {

    List<String> names;
    Set<String> values;
    Queue<String> items;
    String name;

    // default or no-arg constructor
    public Composition(List<String> names, Set<String> values) {
        this.names = names;  // aggregation
        this.values = values;  // aggregation
        items = new LinkedList<>();  // composition
        name = "Ray"; // composition
    }
}
