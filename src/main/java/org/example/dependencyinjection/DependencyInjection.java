package org.example.dependencyinjection;

public class DependencyInjection {

    private String name;

    public DependencyInjection(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        DependencyInjection inj = new DependencyInjection("Ray");
    }

    public void setName(String name) {
        this.name = name;
    }
}
