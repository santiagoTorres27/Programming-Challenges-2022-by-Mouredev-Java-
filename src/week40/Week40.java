package week40;

import java.util.ArrayList;
import java.util.Arrays;

public class Week40 {
    /*
     * Enunciado: Crea una función que sea capaz de dibujar el "Triángulo de Pascal"
     * indicándole únicamente el tamaño del lado.
     *
     * - Aquí puedes ver rápidamente cómo se calcula el triángulo:
     *   https://commons.wikimedia.org/wiki/File:PascalTriangleAnimated2.gif
     */
    public static void main(String[] args) {
        int triangleLength = 11;
        ArrayList<ArrayList<Integer>> triangle = generatePascalTriangle(triangleLength);
        printPascalTriangle(triangle);
    }

    private static void printPascalTriangle(ArrayList<ArrayList<Integer>> triangle) {
        for (ArrayList<Integer> row : triangle) {
            System.out.println(row);
        }
    }

    private static ArrayList<ArrayList<Integer>> generatePascalTriangle(int triangleLength) {
//        Initialize triangle (triangle)
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

//        Generate top triangle
        ArrayList<Integer> topRow = new ArrayList<>();
        topRow.add(1);
        triangle.add(topRow);

        if (triangleLength == 0) {
            return null;
        } else if (triangleLength == 1) {
            return triangle;
        } else {
//            Generate second line
            ArrayList<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            newRow.add(1);
            triangle.add(newRow);

//            Generate triangle greater than 2
            for (int i = 2; i < triangleLength; i++) {
                ArrayList<Integer> lastRow = generateNextRow(triangle.get(triangle.size() - 1));
                triangle.add(lastRow);
            }

            return triangle;
        }
    }

    private static ArrayList<Integer> generateNextRow(ArrayList<Integer> row) {
        ArrayList<Integer> newRow = new ArrayList<>();
        for (int i = 0; i < row.size() - 1; i++) {
            newRow.add(row.get(i) + row.get(i + 1));
        }
        newRow.add(0, 1);
        newRow.add(1);
        return newRow;
    }
}
