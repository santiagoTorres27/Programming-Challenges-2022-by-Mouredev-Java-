package week02;

import java.util.Arrays;

public class Week02 {

    /*
     * Escribe una función que reciba dos palabras (String) y retorne
     * verdadero o falso (Bool) según sean o no anagramas.
     * - Un Anagrama consiste en formar una palabra reordenando TODAS
     *   las letras de otra palabra inicial.
     * - NO hace falta comprobar que ambas palabras existan.
     * - Dos palabras exactamente iguales no son anagrama.
     */

    public static void main(String[] args) {
        String word1 = "race";
        String word2 = "acre";
        System.out.println(isAnagram(word1, word2));
    }

    public static boolean isAnagram(String word1, String word2) {
        return sortWord(word1).equalsIgnoreCase(sortWord(word2));
    }

    public static String sortWord(String word) {
        char[] wordArr = word.toLowerCase().toCharArray();
        String sortedWord = "";
        Arrays.sort(wordArr);
        for (char i : wordArr) {
            sortedWord += i;
        }
        return sortedWord;
    }
}
