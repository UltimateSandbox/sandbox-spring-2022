package org.example.records;

public record Rectangle(
        double width,
        double length) {

    public double area() {
        return width * length;
    }
}
