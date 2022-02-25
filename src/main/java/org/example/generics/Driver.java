package org.example.generics;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        Box<Crate<Integer>> box = new Box<>(new Crate());


    }
}
