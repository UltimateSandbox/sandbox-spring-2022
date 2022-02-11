package org.example.inheritance.composition;

import java.util.*;

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
