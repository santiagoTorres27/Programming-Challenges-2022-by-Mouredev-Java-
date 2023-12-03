package week41;

public class Week41 {
    /*
     * Enunciado: Crea una función que calcule el valor del parámetro perdido
     * correspondiente a la ley de Ohm.
     * - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y retornará
     *   el valor del tercero (redondeado a 2 decimales).
     * - Si los parámetros son incorrectos o insuficientes, la función retornará
     *   la cadena de texto "Invalid values".
     */
    public static void main(String[] args) {
        double[] values = new double[]{1, 30, 6};
        ohmsLaw(values);
    }

    private static void ohmsLaw(double[] values) {
        int nullValues = 0;
        String lostValue = "";
        double value = 0;

        for (Double i : values) {
            if (i == 0) {
                nullValues++;
            }
        }

        if (nullValues > 1) {
            System.out.println("Invalid values");
        } else if (nullValues == 0) {
            System.out.println("All values are filled");
        } else {
            double v = values[0];
            double r = values[1];
            double i = values[2];

            if (v == 0) {
                lostValue = "v";
                value = i * r;

            } else if (r == 0) {
                lostValue = "r";
                value = v / i;
            } else {
                lostValue = "i";
                value = v / r;
            }

            System.out.println("Lost value | " + lostValue + ": " + value);
        }
    }
}
