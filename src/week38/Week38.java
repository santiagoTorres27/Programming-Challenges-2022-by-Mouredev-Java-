package week38;

public class Week38 {
    /*
     * Enunciado: Crea un programa se encargue de transformar un número binario
     * a decimal sin utilizar funciones propias del lenguaje que
     * lo hagan directamente.
     */
    public static void main(String[] args) {
        String binaryNumber = "10010101";
        int decimalNumber = binaryToDecimal(binaryNumber);
        if (decimalNumber < 0) {
            System.out.println("There was a problem doing the conversion");
        } else {
            System.out.println("Binary: " + binaryNumber);
            System.out.println("Decimal: " + decimalNumber);
        }
    }

    private static int binaryToDecimal(String binaryNumber) {
        if (binaryNumber.matches("[01]+$")) {
            // Reverse binaryNumber String
            char[] binaryNumberArr = new StringBuilder(binaryNumber).reverse().toString().toCharArray();
            int decimalNumber = 0;
            for (int i = 0; i < binaryNumberArr.length; i++) {
                int currentNumber = Integer.parseInt(String.valueOf(binaryNumberArr[i]));
                int number = (int) (Math.pow(2, i) * currentNumber);
                decimalNumber += number;
            }
            return decimalNumber;
        } else {
            System.out.println("The number entered does not correspond to a binary number");
            return -1;
        }
    }
}
