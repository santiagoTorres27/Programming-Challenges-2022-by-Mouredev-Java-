package week14;

import java.util.ArrayList;

public class Week14 {
    /*
     * Escribe una función que calcule si un número dado es un número de Armstrong
     * (o también llamado narcisista).
     * Si no conoces qué es un número de Armstrong, debes buscar información
     * al respecto.
     */
    public static void main(String[] args) {
        int number = 54748;
        System.out.println(isArmstrongNumber(number));
    }

    private static boolean isArmstrongNumber(int number) {
        int numberAux = number;
        ArrayList<Integer> digits = new ArrayList<>();
        while (numberAux > 0) {
            int res = numberAux % 10;
            digits.add(res);
            numberAux = numberAux / 10;
        }
        int exponent = digits.size();
        int result = 0;
        for(int i: digits) {
            result += (int)Math.pow(i, exponent);
        }
        return number == result;
    }
}
