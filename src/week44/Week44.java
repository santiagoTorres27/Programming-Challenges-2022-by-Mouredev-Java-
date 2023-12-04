package week44;

import java.util.Arrays;

public class Week44 {
    /*
     * Enunciado: Crea una función que retorne el número total de bumeranes de
     * un array de números enteros e imprima cada uno de ellos.
     * - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números
     *   seguidos, en el que el primero y el último son iguales, y el segundo
     *   es diferente. Por ejemplo [2, 1, 2].
     * - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2]
     *   y [4, 2, 4]).
     */
    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 2, 3, 3, 4, 2, 4};
        checkBoomerangs(array);
    }

    private static void checkBoomerangs(int[] array) {
        int[] boomerang = new int[3];
        int totalBoomerangs = 0;
        boolean isBoomerang = false;
        for (int i = 0; i < array.length - 2; i++) {
            int positionAux = i;
            for (int j = 0; j < boomerang.length; j++) {
                boomerang[j] = array[positionAux];
                positionAux++;
            }
            isBoomerang = checkBoomerang(boomerang);
            if (isBoomerang) {
                totalBoomerangs++;
            }
            System.out.println(Arrays.toString(boomerang));
        }
        System.out.println("We have found " + totalBoomerangs + " boomerangs!");
    }

    private static boolean checkBoomerang(int[] boomerang) {
        return (boomerang[0] == boomerang[2]);
    }
}
