package week30;

public class Week30 {
    /*
     * Crea una función que reciba un texto y muestre cada palabra en una línea,
     * formando un marco rectangular de asteriscos.
     * - ¿Qué te parece el reto? Se vería así:
     *   **********
     *   * ¿Qué   *
     *   * te     *
     *   * parece *
     *   * el     *
     *   * reto?  *
     *   **********
     */
    public static void main(String[] args) {
        String text = "¿Qué te    parece el reto?";
        makeFrame(text);
    }

    private static void makeFrame(String text) {
        String[] textArr = text.split("\s+");
        int longestWordLength = findLongestLength(textArr);

        System.out.println(printFullLine(longestWordLength));
        for (String i : textArr) {
            int blankSpaces = longestWordLength - i.length();
            System.out.print("* " + i);
            for (int j = 0; j < blankSpaces; j++) {
                System.out.print(" ");
            }
            System.out.println(" *");
        }
        System.out.println(printFullLine(longestWordLength));
    }

    private static String printFullLine(int longestWordLength) {
        String line = "";
        for (int i = 0; i < longestWordLength + 4; i++) {
            line += "*";
        }
        return line;
    }

    private static int findLongestLength(String[] textArr) {
        int index = 0;
        int maxLength = 0;
        for (int i = 0; i < textArr.length; i++) {
            if (textArr[i].length() > maxLength) {
                maxLength = textArr[i].length();
                index = i;
            }
        }
        return textArr[index].length();
    }
}
