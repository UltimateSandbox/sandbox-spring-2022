package org.example.inheritance.aggregation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();

        Aggregation agg = new Aggregation(myList, new HashSet<>(), new LinkedList<>(), "Ray");
    }
}
