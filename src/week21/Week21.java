package week21;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Week21 {
    /*
     * Lee el fichero "Challenge21.txt" incluido en el proyecto, calcula su
     * resultado e imprímelo.
     * - El .txt se corresponde con las entradas de una calculadora.
     * - Cada línea tendrá un número o una operación representada por un
     *   símbolo (alternando ambos).
     * - Soporta números enteros y decimales.
     * - Soporta las operaciones suma "+", resta "-", multiplicación "*"
     *   y división "/".
     * - El resultado se muestra al finalizar la lectura de la última
     *   línea (si el .txt es correcto).
     * - Si el formato del .txt no es correcto, se indicará que no se han
     *   podido resolver las operaciones.
     */

    public static void main(String[] args) {
        ArrayList<String> data = getData();
        calculate(data);
    }

    private static void calculate(ArrayList<String> data) {
        String lastOperator = null;
        int result = 0;

        for (String i : data) {
            if (i.equals("+") || i.equals("-") || i.equals("/") || i.equals("*")) {
                lastOperator = i;
            } else {
                if (lastOperator != null) {
                    switch (lastOperator) {
                        case "+" -> result += Integer.parseInt(i);
                        case "-" -> result -= Integer.parseInt(i);
                        case "*" -> result *= Integer.parseInt(i);
                        case "/" -> result /= Integer.parseInt(i);
                    }
                } else {
                    result = Integer.parseInt(i);
                }
            }
        }

        System.out.println(result);
    }

    private static ArrayList<String> getData() {
        String path = "/run/media/santiago/Data/Projects/JavaProjects/Programming Challenges 2022/src/week21/file.txt";
        ArrayList<String> result = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return result;
    }
}
