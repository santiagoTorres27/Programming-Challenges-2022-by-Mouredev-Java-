package week27;

public class Week27 {
    /*
     * Crea un programa que determine si dos vectores son ortogonales.
     * - Los dos array deben tener la misma longitud.
     * - Cada vector se podría representar como un array. Ejemplo: [1, -2]
     */
    public static void main(String[] args) {
        int[] vector1 = new int[]{1, 0};
        int[] vector2 = new int[]{0, 1};

        System.out.println(areOrthogonalVectors(vector1, vector2));
    }

    private static boolean areOrthogonalVectors(int[] vector1, int[] vector2) {
        int result = (vector1[0] * vector1[1]) + (vector2[0] * vector2[1]);
        return result == 0;
    }
}
