package org.example.inheritance.aggregation;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Aggregation {

    List<String> names;
    Set<String> values;
    Queue<String> items;
    String name;

    public Aggregation(List<String> names, Set<String> values, Queue<String> items, String name) {
        this.names = names;
        this.values = values;
        this.items = items;
        this.name = name;
    }
}
