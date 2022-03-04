package org.example.stream;

import java.util.Random;
import java.util.function.Supplier;

public class StringGenerator implements Supplier<String> {

    private Random random = new Random();
    private char[] letters = "0123456789abcdef".toCharArray();

    @Override
    public String get() {
        return "" + letters[random.nextInt(letters.length)];
    }
}
