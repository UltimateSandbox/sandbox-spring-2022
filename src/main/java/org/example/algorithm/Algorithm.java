package org.example.algorithm;

import java.util.HashMap;
import java.util.Map;

public class Algorithm {

    private static final Map<Integer, Long> dictionary = new HashMap<>();

    public static long fib(int n) {

        // base case
        if (n == 0) {
            return 0L;
        }

        // base case
        if (n == 1) {
            return 1L;
        }

        return memo(n - 1) + memo(n - 2);

    }

    private static long memo(int m) {

        // memoization
        Long value = dictionary.get(m);

        if (value != null) {
            return value;
        }

        value = fib(m);
        dictionary.put(Integer.valueOf(m), value);
        return value;
    }

    public static void main(String[] args) {

        System.out.println(Algorithm.fib(5));
        System.out.println(Algorithm.fib(10));
        System.out.println(Algorithm.fib(20));
        System.out.println(Algorithm.fib(50));

    }


}
