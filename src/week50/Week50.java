package week50;

public class Week50 {
    /*
     * Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto
     * utilizando el algoritmo de encriptación de Karaca
     * (debes buscar información sobre él).
     */
    public static void main(String[] args) {
        String text = "hola a todos";
        String result = encryptText(text);
        String result2 = desencryptText("0l3haca 0aca s3d3taca");
        System.out.println(result2);
    }

    private static String desencryptText(String text) {
        String[] textArr = text.split("\s");
        String result = "";
        for (String i : textArr) {
            result += desencryptWord(i) + " ";
        }
        return result.substring(0, result.length() - 1);
    }

    private static String desencryptWord(String word) {
        StringBuilder shortenedWord = new StringBuilder(word.substring(0, word.length() - 3)).reverse();
        StringBuilder desencryptedWord = new StringBuilder();
        for (int i = 0; i < shortenedWord.length(); i++) {
            String currentChar = String.valueOf(shortenedWord.charAt(i));
            switch (currentChar) {
                case "0" -> desencryptedWord.append("a");
                case "1" -> desencryptedWord.append("e");
                case "2" -> desencryptedWord.append("i");
                case "3" -> desencryptedWord.append("o");
                case "4" -> desencryptedWord.append("u");
                default -> desencryptedWord.append(currentChar);
            }
        }
        return desencryptedWord.toString();
    }

    private static String encryptText(String text) {
        String[] resultArr = text.split("\s");
        String result = "";
        for (String i : resultArr) {
            result += encryptWord(i) + " ";
        }
        return result.substring(0, result.length() - 1);
    }

    private static String encryptWord(String text) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            String currentChar = String.valueOf(text.charAt(i)).toLowerCase();
            switch (currentChar) {
                case "a" -> encryptedText.append("0");
                case "e" -> encryptedText.append("1");
                case "i" -> encryptedText.append("2");
                case "o" -> encryptedText.append("3");
                case "u" -> encryptedText.append("4");
                default -> encryptedText.append(currentChar);
            }
        }
        return encryptedText.reverse().append("aca").toString();
    }
}
