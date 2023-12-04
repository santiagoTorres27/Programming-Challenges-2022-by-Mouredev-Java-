package week45;

import java.util.Arrays;

public class Week45 {
    /*
     * Enunciado: Dado un array de números enteros positivos, donde cada uno
     * representa unidades de bloques apilados, debemos calcular cuantas unidades
     * de agua quedarán atrapadas entre ellos.
     *
     * - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
     *
     *         ⏹
     *         ⏹
     *   ⏹💧💧⏹
     *   ⏹💧⏹⏹💧⏹
     *   ⏹💧⏹⏹💧⏹
     *   ⏹💧⏹⏹⏹⏹
     *
     *   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades
     *   de agua. Suponemos que existe un suelo impermeable en la parte inferior
     *   que retiene el agua.
     */
    public static void main(String[] args) {
        int[] wall = new int[]{4, 0, 3, 6, 1, 3};
        int waterUnits = calculateWater(wall);
        System.out.println("We can fill " + waterUnits + " cubes of water in this wall");
    }

    private static int calculateWater(int[] wall) {
        int length = wall.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        int trappedWater = 0;

//      Check maximum height to the left of each position
        leftMax[0] = wall[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(wall[i], leftMax[i - 1]);
        }

//        Check maximum height to the right of each position
        rightMax[wall.length - 1] = wall[wall.length - 1];
        for (int i = wall.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(wall[i], rightMax[i + 1]);
        }

//        Check trapped water in each position
        for (int i = 0; i < wall.length; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - wall[i];
        }

        return trappedWater;
    }
}
