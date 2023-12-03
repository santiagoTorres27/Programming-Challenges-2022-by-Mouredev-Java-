package week42;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week42 {
    /*
     * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit
     * y viceversa.
     *
     * - Para que un dato de entrada sea correcto debe poseer un símbolo "°"
     *   y su unidad ("C" o "F").
     * - En caso contrario retornará un error.
     * - ¿Quieres emplear lo aprendido en este reto?
     *   Revisa el reto mensual y crea una App:
     *   https://retosdeprogramacion.com/mensuales2022
     */
    public static void main(String[] args) {
        String temperature = "422fº";
        temperatureConversor(temperature);
    }

    private static void temperatureConversor(String input) {
        String temperature = input.replaceAll("\\s", "").toUpperCase();
        String lastElement = String.valueOf(temperature.charAt(temperature.length() - 1));
        String thermalUnit = String.valueOf(temperature.charAt(temperature.length() - 2));

        if (lastElement.equals("º") && (thermalUnit.equals("C")) || thermalUnit.equals("F")) {
            String valueStr = temperature.substring(0, temperature.length() - 2);
            try {
                double value = Double.parseDouble(valueStr);
                double convertedValue = 0;

                if (thermalUnit.equals("C")) {
                    convertedValue = (value * 9.0 / 5.0) + 32;
                    System.out.println(convertedValue + "Fº");
                } else {
                    convertedValue = (5.0 / 9.0) * (value - 32);
                    System.out.println(convertedValue + "Cº");
                }


            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try it again");
            }
        } else {
            System.out.println("Invalid input, please try it again");
        }
    }
}
