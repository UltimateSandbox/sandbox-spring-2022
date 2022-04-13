package org.example.records;

public class Driver {

    public static void main(String[] args) {

        Rectangle r = new Rectangle(4.0, 5.0);

        System.out.println(r);
        System.out.println(r.hashCode());
        System.out.println(r.equals(r));
        System.out.println(r.length());
        System.out.println(r.width());
        System.out.println(r.area());

    }
}
