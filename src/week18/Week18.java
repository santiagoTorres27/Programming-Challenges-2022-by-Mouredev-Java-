package week18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week18 {
    /*
     * Crea una función que analice una matriz 3x3 compuesta por "X" y "O"
     * y retorne lo siguiente:
     * - "X" si han ganado las "X"
     * - "O" si han ganado los "O"
     * - "Empate" si ha habido un empate
     * - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta.
     *   O si han ganado los 2.
     * Nota: La matriz puede no estar totalmente cubierta.
     * Se podría representar con un vacío "", por ejemplo.
     */

    public static int[][] winScenarios;

    public static void main(String[] args) {
        String[][] game = {
                {"x", "o", "x"},
                {"x", "o", "o"},
                {"o", "x", "x"}
        };
        System.out.println(initGame(game));
    }

    private static String initGame(String[][] game) {
        loadData();
        List<String> gameArr = convertArray(game);
        ArrayList<String> row = new ArrayList<>();
        for (int[] winScenario : winScenarios) {
            for (int i : winScenario) {
                row.add(gameArr.get(i));
            }
            String result = checkRow(row);
            if (result != null) {
                return result + " has won!!";
            }
            row.clear();
        }
        return "Tied game";
    }

    private static String checkRow(ArrayList<String> row) {
        String firstElement = row.get(0);
        boolean win = row.get(1).equalsIgnoreCase(firstElement) && row.get(2).equalsIgnoreCase(firstElement);
        if (win) {
            return firstElement;
        } else {
            return null;
        }
    }

    private static List<String> convertArray(String[][] game) {
        List<String> result = new ArrayList<>();
        for (String[] strings : game) {
            result.addAll(Arrays.asList(strings));
        }
        return result;
    }

    private static void loadData() {
        winScenarios = new int[][]{
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };
    }
}
