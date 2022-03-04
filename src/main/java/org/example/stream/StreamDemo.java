package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        IntPredicate evenOnly = x -> x % 2 == 0;

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

        // int stream
        int totalSum = IntStream.iterate(0, x -> x + 1)
                                .skip(5)
                                .limit(5)
                                .filter(evenOnly)
                                .reduce(2, Integer::sum);
        System.out.println(totalSum);

        // IntStream generate method
        final AtomicInteger counter = new AtomicInteger(1);
        IntStream.generate(counter::getAndIncrement)
                 .filter(evenOnly)
                 .limit(10)
                 .forEach(System.out::println);

        // closures must be final or effectively final
        final AtomicInteger y = new AtomicInteger(5);
        Function<Integer, Integer> function = x -> x + y.getAndIncrement();

        // Generate a steam of random Strings
        String randomString = Stream.generate(new StringGenerator())
                .limit(64)
                .collect(Collectors.joining());
        System.out.println(randomString);
    }
}
