package week12;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week12 {
    /*
     * Escribe una función que reciba un texto y retorne verdadero o
     * falso (Boolean) según sean o no palíndromos.
     * Un Palíndromo es una palabra o expresión que es igual si se lee
     * de izquierda a derecha que de derecha a izquierda.
     * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
     * Ejemplo: Ana lleva al oso la avellana.
     */
    public static void main(String[] args) {
        String text = "Anita lava la tina";
        System.out.println(isPalindrome(text));
    }

    private static boolean isPalindrome(String text) {
        String textCleaned = cleanText(text);
        for (int i = 0; i < textCleaned.length() / 2; i++) {
            if(textCleaned.charAt(i) != textCleaned.charAt(textCleaned.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static String cleanText(String text) {
        Pattern patron = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = patron.matcher(text.toLowerCase());
        return matcher.replaceAll("");
    }
}
