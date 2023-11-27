package week07;

import java.util.HashMap;
import java.util.Map;

public class Week07 {
    /*
     * Crea un programa que cuente cuantas veces se repite cada palabra
     * y que muestre el recuento final de todas ellas.
     * - Los signos de puntuación no forman parte de la palabra.
     * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
     * - No se pueden utilizar funciones propias del lenguaje que
     *   lo resuelvan automáticamente.
     */

    public static void main(String[] args) {
        String text = "Hello, this is a text, hello hello, text";
        countWords(text);
    }

    private static void countWords(String text) {
        String[] textArr = text.toLowerCase().split("[^a-zA-Z0-9]+");
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String i: textArr) {
            if(!hashMap.containsKey(i)) {
                hashMap.put(i, 1);
            } else {
                hashMap.put(i, hashMap.get(i) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry: hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
