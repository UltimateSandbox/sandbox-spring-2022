package org.example.inheritance.polymorphism;

public class Dog implements Animal {

    @Override
    public void vocalize() {
        System.out.println("Woof!");
    }
}
