package week24;

import java.util.stream.IntStream;

public class Week24 {
    /*
     * Quiero contar del 1 al 100 de uno en uno (imprimiendo cada uno).
     * ¿De cuántas maneras eres capaz de hacerlo?
     * Crea el código para cada una de ellas.
     */
    public static void main(String[] args) {
//        iteration1();
//        iteration2();
//        iteration3();
        iteration4();
    }

    private static void iteration4() {
        IntStream.rangeClosed(1, 100).forEach(System.out::println);
    }

    private static void iteration3() {
        int counter = 1;
        do {
            System.out.println(counter);
            counter++;
        } while (counter <= 100);
    }

    private static void iteration2() {
        int counter = 1;
        while (counter <= 100) {
            System.out.println(counter);
            counter++;
        }
    }

    private static void iteration1() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }
}
