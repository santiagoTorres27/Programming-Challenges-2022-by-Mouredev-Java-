package week11;

public class Week11 {
    /*
     * Crea una función que reciba dos cadenas como parámetro (str1, str2)
     * e imprima otras dos cadenas como salida (out1, out2).
     * - out1 contendrá todos los caracteres presentes en la str1 pero NO
     *   estén presentes en str2.
     * - out2 contendrá todos los caracteres presentes en la str2 pero NO
     *   estén presentes en str1.
     */
    public static void main(String[] args) {
        String text1 = "hola";
        String text2 = "mundo";

        String out1 = deletingCharacters(text1, text2);
        String out2 = deletingCharacters(text2, text1);
        System.out.println(out1);
        System.out.println(out2);
    }

    private static String deletingCharacters(String text1, String text2) {
        String result = "";
        boolean found = false;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result += String.valueOf(text1.charAt(i));
            }
            found = false;
        }
        return result;
    }
}
