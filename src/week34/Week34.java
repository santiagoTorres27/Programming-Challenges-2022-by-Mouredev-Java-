package week34;

import java.util.ArrayList;
import java.util.Arrays;

public class Week34 {
    /*
     * Enunciado: Dado un array de enteros ordenado y sin repetidos,
     * crea una función que calcule y retorne todos los que faltan entre
     * el mayor y el menor.
     * - Lanza un error si el array de entrada no es correcto.
     */
    public static void main(String[] args) {
        int[] numbers = new int[]{-2, 5, 6, 10};
        ArrayList<Integer> lostNumbers = getLostNumbers(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(lostNumbers);

    }

    private static ArrayList<Integer> getLostNumbers(int[] numbers) {
        int min = getMinValue(numbers);
        int max = getMaxValue(numbers);
        ArrayList<Integer> lostNumbers = new ArrayList<>();
        ArrayList<Integer> numbersArr = new ArrayList<>();
        for (Integer i : numbers) {
            numbersArr.add(i);
        }

        for (int i = min; i < max; i++) {
            if (!numbersArr.contains(i)) {
                lostNumbers.add(i);
            }
        }

        return lostNumbers;
    }

    private static int getMaxValue(int[] numbers) {
        int max = numbers[0];
        for (Integer i : numbers) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static int getMinValue(int[] numbers) {
        int min = numbers[0];
        for (Integer i : numbers) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}
