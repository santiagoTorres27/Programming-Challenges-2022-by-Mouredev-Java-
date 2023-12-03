package week08;

public class Week08 {

    /*
     * Crea un programa se encargue de transformar un número
     * decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
     */

    public static void main(String[] args) {
        int number = 100;
        System.out.println(decimalToBinary(number));
    }

    private static String decimalToBinary(int number) {
        int res = 0;
        String binaryNumber = "";
        while(number > 0) {
            res = number % 2;
            binaryNumber = String.valueOf(res) + binaryNumber;
            number = number / 2;
        }
        return binaryNumber;
    }
}
