package org.example.generics;

public class Crate<S> {

    private S s;



    // Not actually cloning anything
    public <T> T clone(T t) {
        System.out.println(t.getClass().getSimpleName());
        return t;
    }

}
