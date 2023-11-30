package week25;

import java.util.ArrayList;
import java.util.Set;

public class Week25 {
    /*
     * Crea un programa que calcule quien gana más partidas al piedra,
     * papel, tijera.
     * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
     * - La función recibe un listado que contiene pares, representando cada jugada.
     * - El par puede contener combinaciones de "R" (piedra), "P" (papel)
     *   o "S" (tijera).
     * - Ejemplo. Entrada: [("R","S"), ("S","R"), ("P","S")]. Resultado: "Player 2".
     */
    public static void main(String[] args) {
        String[][] listOfPlays = new String[][]{{"R", "S"}, {"S", "R"}, {"P", "S"}};
        checkPlays(listOfPlays);
    }

    private static void checkPlays(String[][] listOfPlays) {
        ArrayList<String> resultList = new ArrayList<>();
        for (String[] i : listOfPlays) {
            resultList.add(checkPlay(i));
        }
        String winner = checkWinner(resultList);
        System.out.println(winner);
    }

    private static String checkWinner(ArrayList<String> resultList) {
        int player1 = 0;
        int player2 = 0;
        int tie = 0;
        for (String i : resultList) {
            if (i.equals("player1")) {
                player1++;
            } else if (i.equals("player2")) {
                player2++;
            } else {
                tie++;
            }
        }

        if (player1 > player2 && player1 > tie) {
            return "Player 1 has won!!";
        } else if (player2 > player1 && player2 > tie) {
            return "Player 2 has won!!";
        } else {
            return "Tied game";
        }
    }

    private static String checkPlay(String[] i) {
        String winner = "";
        String player1 = i[0].toUpperCase();
        String player2 = i[1].toUpperCase();
        if (player1.equals("R") && player2.equals("R")) {
            winner = "tie";
        } else if (player1.equals("R") && player2.equals("S")) {
            winner = "player1";
        } else if (player1.equals("R") && player2.equals("P")) {
            winner = "player2";
        } else if (player1.equals("P") && player2.equals("R")) {
            winner = "player1";
        } else if (player1.equals("P") && player2.equals("P")) {
            winner = "tie";
        } else if (player1.equals("P") && player2.equals("S")) {
            winner = "player2";
        } else if (player1.equals("S") && player2.equals("R")) {
            winner = "player2";
        } else if (player1.equals("S") && player2.equals("P")) {
            winner = "player1";
        } else if (player1.equals("S") && player2.equals("S")) {
            winner = "tie";
        }
        return winner;
    }
}
