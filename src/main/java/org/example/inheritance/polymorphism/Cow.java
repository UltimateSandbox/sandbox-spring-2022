package org.example.inheritance.polymorphism;

public class Cow implements Animal {

    @Override
    public void vocalize() {
        System.out.println("Moo!");
    }
}
