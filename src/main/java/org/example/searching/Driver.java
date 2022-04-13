package org.example.searching;

import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
        int[] intArray = {1, 2, 4, 6, 5, 3, 1, -2, -1, 0};
        Integer[] integerArray = Arrays.stream(intArray)
                                       .boxed()
                                       .toArray(Integer[]::new);
        int[] sortedIntArray = Arrays.stream(intArray)
                                     .sorted()
                                     .toArray();

        System.out.println(SearchUtility.linearSearch(intArray, 1));
        System.out.println(SearchUtility.linearSearch(intArray, 10));

        System.out.println(SearchUtility.linearSearch(integerArray, 1));
        System.out.println(SearchUtility.linearSearch(integerArray, 10));

        System.out.println(SearchUtility.binarySearchIterative(sortedIntArray, 1));
        System.out.println(SearchUtility.binarySearchIterative(sortedIntArray, 10));
    }
}
