package week23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Week23 {
    /*
     * Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra
     * que calcule el mínimo común múltiplo (mcm) de dos números enteros.
     * - No se pueden utilizar operaciones del lenguaje que
     *   lo resuelvan directamente.
     */
    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 16;

        System.out.println(leastCommonMultiple(num1, num2));
        System.out.println(greatestCommonDivisor(num1, num2));
    }

    private static int greatestCommonDivisor(int num1, int num2) {
        return (num1 * num2) / leastCommonMultiple(num1, num2);
    }

    private static int leastCommonMultiple(int num1, int num2) {
        HashMap<Integer, Integer> divisors1 = findDivisors(num1);
        HashMap<Integer, Integer> divisors2 = findDivisors(num2);

        HashMap<Integer, Integer> divisors = new HashMap<>(divisors1);
        for (Map.Entry<Integer, Integer> entry : divisors2.entrySet()) {
            if (divisors.containsKey(entry.getKey()) && divisors.get(entry.getKey()) < entry.getValue()) {
                divisors.put(entry.getKey(), entry.getValue());
            } else if (!divisors.containsKey(entry.getKey())) {
                divisors.put(entry.getKey(), entry.getValue());
            }
        }

        int lcm = 1;
        for (Map.Entry<Integer, Integer> entry : divisors.entrySet()) {
            lcm *= (int) Math.pow(entry.getKey(), entry.getValue());
        }
        return lcm;
    }

    private static HashMap<Integer, Integer> findDivisors(int num) {
        int divisor = 2;
        ArrayList<Integer> divisors = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (num > 1) {
            if (num % divisor == 0) {
                divisors.add(divisor);
                num = num / divisor;
            } else {
                divisor += 1;
            }
        }

        for (Integer i : divisors) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, 1);
            } else {
                hashMap.put(i, hashMap.get(i) + 1);
            }
        }

        return hashMap;
    }
}
