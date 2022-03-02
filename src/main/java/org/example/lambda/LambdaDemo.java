package org.example.lambda;

import java.util.function.*;

public class LambdaDemo {

    public static void main(String[] args) {
        // x -> x * 2

        // 4 Types of Lambda Classes in Java
        // Supplier
        Supplier<String> supplier = () -> "Hello Lambda";

        // Consumer - takes a value, returns nothing
        Consumer<String> consumer = System.out::println;

        // Predicate - receive 1 (or more) value, return boolean
        Predicate<String> predicate = x -> x.startsWith("a");

        // Function - receive 1 value, return 1 value
        Function<Integer, Integer> function = x -> {
            x = x + 5;
            return x * 2;
        };

    }




}
