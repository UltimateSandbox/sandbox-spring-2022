package org.example.tree;

public class ElementNotFoundException extends Exception {

    public ElementNotFoundException() {
        super();
    }

    public ElementNotFoundException(String message) {
        super(message);
    }

    public ElementNotFoundException(String message, Throwable t) {
        super(message, t);
    }

    public ElementNotFoundException(Throwable t) {
        super(t);
    }

}
