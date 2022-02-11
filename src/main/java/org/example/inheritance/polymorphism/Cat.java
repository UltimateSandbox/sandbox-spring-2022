package org.example.inheritance.polymorphism;

public class Cat implements Animal {

    @Override
    public void vocalize() {
        System.out.println("Meow!");
    }

    public void scratch() {
        System.out.println("I'm scratchin'!!");
    }

    public void scratch(String message) {
        System.out.println(message);
    }
}
