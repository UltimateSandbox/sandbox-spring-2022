package org.example.collections;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {

        Map<Integer, String> numbers = new HashMap<>();

        numbers.put(2, "Two");
        numbers.put(1, "One");
        numbers.put(4, "Four");
        numbers.put(3, "Three");

        numbers.forEach((k,v) -> System.out.println(v));

    }
}
