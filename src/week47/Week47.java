package week47;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

public class Week47 {
    /*
     * Enunciado: Crea un función que reciba un texto y retorne la vocal que
     * más veces se repita.
     * - Ten cuidado con algunos casos especiales.
     * - Si no hay vocales podrá devolver vacío.
     */
    public static void main(String[] args) {
        String text = "Cómo están todos? áÄááÁÁ";
        countVowels(text);
    }

    private static void countVowels(String text) {
        String textCleaned = cleanString(text).toLowerCase().replaceAll("\\s+", "");
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char maxCharKey = 0;
        int maxCharValue = 0;

        for (int i = 0; i < textCleaned.length(); i++) {
            char currentChar = textCleaned.charAt(i);
            if (!hashMap.containsKey(currentChar)) {
                hashMap.put(currentChar, 1);
            } else {
                hashMap.put(currentChar, hashMap.get(currentChar) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
            if (entry.getValue() > maxCharValue) {
                maxCharValue = entry.getValue();
                maxCharKey = entry.getKey();
            }
        }

        System.out.println("The greatest vowels is:");
        System.out.println(maxCharKey + ": " + maxCharValue + " times repeated");
    }

    private static String cleanString(String text) {
        String normalizedString = Normalizer.normalize(text, Normalizer.Form.NFD);
        normalizedString = normalizedString.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return normalizedString;
    }
}
