package org.example.label;

public class LabelDemo {

    public static void main(String[] args) {

        Outer:
        for (int x = 0; x <= 9; x++) {
            for (int y = 0; y <= 9; y++) {

                if (x == 5 && y == 5) {
                    break Outer;
                }
                System.out.print("\t" + x + ":" + y);
            }

            System.out.println();
        }


    }
}
