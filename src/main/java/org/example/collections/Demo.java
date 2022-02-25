package org.example.collections;

import java.util.*;

public class Demo {

    public static void main(String[] args) {

        // List
        List<String> list = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        // Set
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new LinkedHashSet<>();
        Set<String> set3 = new TreeSet<>();

        // Queue
        Queue<String> queue1 = new PriorityQueue<>();
        Deque<String> queue2 = new LinkedList<>();
        Queue<String> queue3 = new LinkedList<>();

        // Map
        Map<String, String> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        Map<Integer, Integer> map3 = new HashMap<>();

        list.add("Hi");
        list.add("Hi");
        list.add("Hi");
        list.add("There");

        list.forEach(System.out::println);




    }
}
