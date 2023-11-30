package week29;

import java.util.Arrays;

public class Week29 {
    /*
     * Crea una función que ordene y retorne una matriz de números.
     * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro
     *   adicional "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor
     *   o de mayor a menor.
     * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan
     *   automáticamente.
     */
    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 8, 6, 9};
        int[] arraySorted = sortArray(array, "Desc");
        System.out.println(Arrays.toString(arraySorted));
    }

    private static int[] sortArray(int[] array, String sortOption) {
        if (sortOption.equalsIgnoreCase("Asc")) {
            return sortAscendant(array);
        }
        return sortDescendant(array);
    }

    private static int[] sortDescendant(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    private static int[] sortAscendant(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
