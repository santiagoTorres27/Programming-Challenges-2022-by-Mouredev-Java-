package week10;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week10 {

    /*
     * Crea un programa que comprueba si los paréntesis, llaves y corchetes
     * de una expresión están equilibrados.
     * - Equilibrado significa que estos delimitadores se abren y cieran
     *   en orden y de forma correcta.
     * - Paréntesis, llaves y corchetes son igual de prioritarios.
     *   No hay uno más importante que otro.
     * - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
     * - Expresión no balanceada: { a * ( c + d ) ] - 5 }
     */

    public static void main(String[] args) {
        String expression = "{ a * ( c + d ) ] - 5 }";
        System.out.println(isBalanced(expression));
    }

    private static boolean isBalanced(String expression) {
        List<String> delimiters = getDelimiters(expression);
        Stack<String> stack = new Stack<>();
        ArrayList<String> openDelimiters = new ArrayList<>();
        openDelimiters.add("[");
        openDelimiters.add("{");
        openDelimiters.add("(");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("}", "{");
        hashMap.put(")", "(");
        hashMap.put("]", "[");

        for (String i : delimiters) {
            if (openDelimiters.contains(i)) {
                stack.add(i);
            } else {
                if (stack.isEmpty()) {
                    stack.add(i);
                } else if (stack.peek().equalsIgnoreCase(hashMap.get(i))) {
                    stack.pop();
                } else {
                    stack.add(i);
                }
            }
        }

        return stack.isEmpty();
    }

    private static List<String> getDelimiters(String expression) {
        String regex = "[\\(\\)\\{\\}\\[\\]]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        List<String> delimiters = new ArrayList<>();
        while (matcher.find()) {
            delimiters.add(matcher.group());
        }
        return delimiters;
    }
}
