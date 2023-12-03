package week02;

import java.util.Arrays;

public class Week02 {

    /*
     * Escribe un programa que imprima los 50 primeros números de la sucesión
     * de Fibonacci empezando en 0.
     * - La serie Fibonacci se compone por una sucesión de números en
     *   la que el siguiente siempre es la suma de los dos anteriores.
     *   0, 1, 1, 2, 3, 5, 8, 13...
     */

    public static void main(String[] args) {
       int[] fibonacci = createSequence(50);
       for(int i: fibonacci) {
           System.out.println(i);
       }
    }

    public static int[] createSequence(int length) {
        int[] fibSequence = new int[length];
        fibSequence[0] = 0;
        fibSequence[1] = 1;
        for (int i = 2; i < fibSequence.length; i++) {
            fibSequence[i] = fibSequence[i - 1] + fibSequence[i - 2];
        }
        return fibSequence;
    }
}
