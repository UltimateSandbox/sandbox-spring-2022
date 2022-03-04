package org.example.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        Fruit f1 = new Fruit("Apple","desc", 10);
        Fruit f2 = new Fruit("Pear","desc", 10);
        Fruit f3 = new Fruit("Banana","desc", 50);
        Fruit f4 = new Fruit("Grape","desc", 100);
        Fruit f5 = new Fruit("Orange","desc", 1);
        Fruit f6 = new Fruit("Apple","desc", 100);

        List<Fruit> fruits = new ArrayList<>();

        fruits.add(f1);
        fruits.add(f2);
        fruits.add(f3);
        fruits.add(f4);
        fruits.add(f5);
        fruits.add(f6);

        Collections.shuffle(fruits);
        fruits.forEach(System.out::println);

        Collections.sort(fruits);
        fruits.forEach(System.out::println);

    }
}
