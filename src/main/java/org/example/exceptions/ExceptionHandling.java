package org.example.exceptions;

import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) {

        // try-catch
        try {
            // do something
        } catch (Exception e) {
            // handle exception
            e.printStackTrace();
        }
        // continue

        // try-catch-catch-(catch)
        try {

        } catch (NullPointerException e) {

        } catch (Exception e) {

        }

        // try-catch-finally
        Scanner scanner = new Scanner(System.in);
        try {
            scanner.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

        // try-finally
        try {

        } finally {

        }

        // try-multi-catch
        try {

        } catch (ArithmeticException | NullPointerException e) {
            e.printStackTrace();
        }

        // try-with-resources
        try (Scanner scanner2 = new Scanner(System.in);
             Scanner scanner3 = new Scanner(System.in)) {

        } catch (Exception ex) {

        }

    }
}
