package week09;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Week09 {

    /*
     * Crea un programa que sea capaz de transformar texto natural a código
     * morse y viceversa.
     * - Debe detectar automáticamente de qué tipo se trata y realizar
     *   la conversión.
     * - En morse se soporta raya "—", punto ".", un espacio " " entre letras
     *   o símbolos y dos espacios entre palabras "  ".
     * - El alfabeto morse soportado será el mostrado en
     *   https://es.wikipedia.org/wiki/Código_morse.
     */

    public static HashMap<Character, String> morseCodeHashMap;
    public static HashMap<String, Character> textHashMap;

    public static void main(String[] args) {
        initHashMap();
        String text = "hola a todos";
        String text2 = ".... --- .-.. .-   .-   - --- -.. --- ...";
        translateText(text2);
    }

    private static void initHashMap() {
        // MORSE CODE HASHMAP
        morseCodeHashMap = new HashMap<>();
        // Letters
        morseCodeHashMap.put('A', ".-");
        morseCodeHashMap.put('B', "-...");
        morseCodeHashMap.put('C', "-.-.");
        morseCodeHashMap.put('D', "-..");
        morseCodeHashMap.put('E', ".");
        morseCodeHashMap.put('F', "..-.");
        morseCodeHashMap.put('G', "--.");
        morseCodeHashMap.put('H', "....");
        morseCodeHashMap.put('I', "..");
        morseCodeHashMap.put('J', ".---");
        morseCodeHashMap.put('K', "-.-");
        morseCodeHashMap.put('L', ".-..");
        morseCodeHashMap.put('M', "--");
        morseCodeHashMap.put('N', "-.");
        morseCodeHashMap.put('O', "---");
        morseCodeHashMap.put('P', ".--.");
        morseCodeHashMap.put('Q', "--.-");
        morseCodeHashMap.put('R', ".-.");
        morseCodeHashMap.put('S', "...");
        morseCodeHashMap.put('T', "-");
        morseCodeHashMap.put('U', "..-");
        morseCodeHashMap.put('V', "...-");
        morseCodeHashMap.put('W', ".--");
        morseCodeHashMap.put('X', "-..-");
        morseCodeHashMap.put('Y', "-.--");
        morseCodeHashMap.put('Z', "--..");

        // Letters
        morseCodeHashMap.put('0', "-----");
        morseCodeHashMap.put('1', ".----");
        morseCodeHashMap.put('2', "..---");
        morseCodeHashMap.put('3', "...--");
        morseCodeHashMap.put('4', "....-");
        morseCodeHashMap.put('5', ".....");
        morseCodeHashMap.put('6', "-....");
        morseCodeHashMap.put('7', "--...");
        morseCodeHashMap.put('8', "---..");
        morseCodeHashMap.put('9', "----.");

        // Special characters
        morseCodeHashMap.put('.', ".-.-.-");
        morseCodeHashMap.put(',', "--..--");
        morseCodeHashMap.put('?', "..--..");
        morseCodeHashMap.put('!', "-.-.--");
        morseCodeHashMap.put(' ', "/");  // Espacio

        textHashMap = new HashMap<>();
        // NATURAL TEXT TO MORSE CODE
        // Letters
        textHashMap.put(".-", 'A');
        textHashMap.put("-...", 'B');
        textHashMap.put("-.-.", 'C');
        textHashMap.put("-..", 'D');
        textHashMap.put(".", 'E');
        textHashMap.put("..-.", 'F');
        textHashMap.put("--.", 'G');
        textHashMap.put("....", 'H');
        textHashMap.put("..", 'I');
        textHashMap.put(".---", 'J');
        textHashMap.put("-.-", 'K');
        textHashMap.put(".-..", 'L');
        textHashMap.put("--", 'M');
        textHashMap.put("-.", 'N');
        textHashMap.put("---", 'O');
        textHashMap.put(".--.", 'P');
        textHashMap.put("--.-", 'Q');
        textHashMap.put(".-.", 'R');
        textHashMap.put("...", 'S');
        textHashMap.put("-", 'T');
        textHashMap.put("..-", 'U');
        textHashMap.put("...-", 'V');
        textHashMap.put(".--", 'W');
        textHashMap.put("-..-", 'X');
        textHashMap.put("-.--", 'Y');
        textHashMap.put("--..", 'Z');

        // Numbers
        textHashMap.put("-----", '0');
        textHashMap.put(".----", '1');
        textHashMap.put("..---", '2');
        textHashMap.put("...--", '3');
        textHashMap.put("....-", '4');
        textHashMap.put(".....", '5');
        textHashMap.put("-....", '6');
        textHashMap.put("--...", '7');
        textHashMap.put("---..", '8');
        textHashMap.put("----.", '9');

        // Special characters
        textHashMap.put(".-.-.-", '.');
        textHashMap.put("--..--", ',');
        textHashMap.put("..--..", '?');
        textHashMap.put("-.-.--", '!');
        textHashMap.put("/", ' ');
    }

    private static void translateText(String text) {
        String pattern = ".*[a-zA-Z].*";
        Pattern regex = Pattern.compile(pattern);
        boolean isNaturalText = regex.matcher(text).matches();
        if (isNaturalText) {
            convertTextToMorseCode(text);
        } else {
            convertMorseCodeToText(text);
        }
    }

    private static void convertTextToMorseCode(String text) {
        char[] textArr = text.toUpperCase().toCharArray();
        String textMorseCode = "";
        for (char i : textArr) {
            if (i == ' ') {
                textMorseCode += "  ";
            } else {
                textMorseCode += morseCodeHashMap.get(i) + " ";
            }
        }
        System.out.println(textMorseCode);
    }

    private static void convertMorseCodeToText(String text) {
        String[] textArr = text.split(" ");
        String translation = "";
        for(String i: textArr) {
            translation += textHashMap.get(i);
        }
        System.out.println(translation.replace("nullnull", " "));
    }
}
