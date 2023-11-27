package week03;

public class Week03 {

    /*
     * Escribe un programa que se encargue de comprobar si un número es o no primo.
     * Hecho esto, imprime los números primos entre 1 y 100.
     */

    public static void main(String[] args) {
        int number = 17;
        System.out.println(isPrimeNumber(number));
    }

    public static boolean isPrimeNumber(int number) {
        for (int i = 2; i < number/2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
