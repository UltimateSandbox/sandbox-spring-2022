package org.example.inheritance.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        Animal cat = new Cat();
        Animal cow = new Cow();
        Animal dog = new Dog();

/*        cat.vocalize();
        cow.vocalize();
        dog.vocalize();*/

        List<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(cow);
        animals.add(dog);

        for (Animal animal : animals) {
            animal.vocalize(); // dynamic polymorpic method call
        }

        animals.forEach(a -> a.vocalize());

        ((Cat) cat).scratch();

    }
}
