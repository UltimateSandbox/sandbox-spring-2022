package org.example.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Analysis {

    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();
        List<String> myList2= new ArrayList<>();

        myList.add("One");  // O(1)
        myList.add("Two");

        myList.indexOf("One");  // O(n)

        // O(log n)
        // +
        // O(n)
        // =
        // O(n)

        myList.remove("Two"); // O(n)

        myList.addAll(myList2); // O(n)


    }
}
