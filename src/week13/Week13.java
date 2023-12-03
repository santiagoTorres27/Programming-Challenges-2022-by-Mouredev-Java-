package week13;

public class Week13 {
    /*
     * Escribe una función que calcule y retorne el factorial de un número dado
     * de forma recursiva.
     */
    public static void main(String[] args) {
        int number = 4;
        System.out.println(recursiveFactorial(number));
    }

    private static int recursiveFactorial(int number) {
        if (number <= 1) {
            return number;
        }
        return number * recursiveFactorial(number - 1);
    }
}
