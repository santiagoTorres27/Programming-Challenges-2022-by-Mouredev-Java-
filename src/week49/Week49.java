package week49;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week49 {
    /*
     * Enunciado: Crea una función que sea capaz de detectar y retornar todos los
     * handles de un texto usando solamente Expresiones Regulares.
     * Debes crear una expresión regular para cada caso:
     * - Handle usuario: Los que comienzan por "@"
     * - Handle hashtag: Los que comienzan por "#"
     * - Handle web: Los que comienzan por "www.", "http://", "https://"
     *   y finalizan con un dominio (.com, .es...)
     */
    public static void main(String[] args) {
        String text = "http://www.santiago.es";
        String response = handleText(text);
        System.out.println(response);
    }

    private static String handleText(String text) {
//        Regex patterns
        String userRegex = "^@.*";
        String hashtagRegex = "^#.*";
        String webRegex = "^(www\\.|http://|https://)[a-zA-Z0-9.-]+\\.(com|es|org|net)$";

        Pattern userPattern = Pattern.compile(userRegex);
        Pattern hashtagPattern = Pattern.compile(hashtagRegex);
        Pattern webPattern = Pattern.compile(webRegex);

        Matcher userMatcher = userPattern.matcher(text);
        Matcher hashtagMatcher = hashtagPattern.matcher(text);
        Matcher webMatcher = webPattern.matcher(text);

        if (userMatcher.find()) {
            return "user";
        } else if (hashtagMatcher.find()) {
            return "hashtag";
        } else if (webMatcher.find()) {
            return "website";
        }

        return "-";
    }
}
