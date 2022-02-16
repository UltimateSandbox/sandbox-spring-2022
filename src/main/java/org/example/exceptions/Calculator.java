package org.example.exceptions;

public class Calculator {

    public static void main(String[] args) {
        System.out.println(Calculator.divide(4, 0));
        // FIXME start here on 2/17
        System.out.println(Calculator.divide(4.0f, 0.0f));
    }

    public static int divide(int a, int b) {

        int returnValue = 0;

        try {
            returnValue = a / b;
        } catch (ArithmeticException e) {
            System.err.println("Can't divide by zero.");
        }
        return returnValue;
    }

    public static float divide(float a, float b) throws DivideByZeroException {
        if (b == 0.0f) {
            throw new DivideByZeroException();
        }
        return a / b;
    }
}
