package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

        // base example
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
              .filter(s -> s.startsWith("c"))
              .map(String::toUpperCase)
              .sorted()
              .forEach(System.out::println);

        // C1
        // C2

        // setup
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        List<String> names = Arrays.asList("Reflection", "Collection", "Stream", "Java");
        Predicate<Integer> evenOnlyPredicate = x -> x % 2 == 0;

        /*
         intermediate functions (0 or more)
         */

        // map
        List<Integer> square = numbers.stream()
                                      .map(x -> x * x) // monad
                                      .collect(Collectors.toList());
        square.forEach(System.out::println);

        // filter
        List<String> result = names.stream()
                                   .filter(s -> s.startsWith("S"))
                                   .collect(Collectors.toList());
        result.forEach(System.out::println);

        // sorted
        List<String> result2 = names.stream()
                                    .sorted()
                                    .collect(Collectors.toList());
        result2.forEach(System.out::println);
        names.forEach(System.out::println);

        /*
         terminal functions (1)
         */

        // collect
        Set<Integer> squared = numbers.stream()
                                      .map(x -> x * x)
                                      .collect(Collectors.toSet());
        squared.forEach(System.out::println);

        // foreach
        numbers.stream()
               .map(x -> x * x)
               .forEach(y -> System.out.println(y));
        numbers.forEach(y -> System.out.println(y));

        // reduce
        int sum = 0;
        for (int x = 1; x <= 5; x++) {
            if (x % 2 == 0) {
                sum += x;
            }
        }
        System.out.println("Even sum: " + sum);

        int evenSum = numbers.stream()
                             .filter(evenOnlyPredicate)
                             .reduce(0, (acc, x) -> acc + x);
        System.out.println("Even sum: " + evenSum);
    }
}
