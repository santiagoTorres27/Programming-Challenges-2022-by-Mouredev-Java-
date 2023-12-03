package week06;

public class Week06 {
    /*
     * Crea un programa que invierta el orden de una cadena de texto
     * sin usar funciones propias del lenguaje que lo hagan de forma automática.
     * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
     */

    public static void main(String[] args) {
        String text = "Hola mundo";
        System.out.println(reverseString(text));
    }

    public static String reverseString(String text) {
        String reversedText = "";
        for (int i = 0; i < text.length(); i++) {
            reversedText = String.valueOf(text.charAt(i)) + reversedText;
        }
        return reversedText;
    }
}
