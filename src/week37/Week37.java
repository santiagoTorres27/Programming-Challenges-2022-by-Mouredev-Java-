package week37;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Week37 {
    /*
     * Enunciado: ¡Han anunciado un nuevo "The Legend of Zelda"!
     * Se llamará "Tears of the Kingdom" y se lanzará el 12 de mayo de 2023.
     * Pero, ¿recuerdas cuánto tiempo ha pasado entre los distintos
     * "The Legend of Zelda" de la historia?
     * Crea un programa que calcule cuántos años y días hay entre 2 juegos de Zelda
     * que tú selecciones.
     * - Debes buscar cada uno de los títulos y su día de lanzamiento
     *   (si no encuentras el día exacto puedes usar el mes, o incluso inventártelo)
     */

    public static ArrayList<Game> gameList;
    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        loadData();

        while (true) {
            printGameList();
            calculateDaysBetweenGames();

            System.out.println("\nDo you want to calculate it again? Y/n");
            String option = sc.nextLine();
            if (!option.equalsIgnoreCase("y")) {
                return;
            }
        }
    }

    private static void calculateDaysBetweenGames() {
        try {
            System.out.print("Select the first game: ");
            int firstGameIndex = Integer.parseInt(sc.nextLine()) - 1;

            System.out.print("Select the second game: ");
            int secondGameIndex = Integer.parseInt(sc.nextLine()) - 1;

            if (firstGameIndex < 0 || firstGameIndex >= gameList.size() || secondGameIndex < 0 || secondGameIndex >= gameList.size()) {
                System.out.println("The index is incorrect, please try it again");
            } else {
                LocalDate date1 = LocalDate.parse(gameList.get(firstGameIndex).getLaunchDate());
                LocalDate date2 = LocalDate.parse(gameList.get(secondGameIndex).getLaunchDate());

                long daysDifference = ChronoUnit.DAYS.between(date1, date2);
                daysDifference = Math.abs(daysDifference);
                System.out.println("There are " + daysDifference + " days between: ");
                System.out.println(gameList.get(firstGameIndex).toString() + " and ");
                System.out.println(gameList.get(secondGameIndex).toString());
            }

        } catch (NumberFormatException e) {
            System.out.println("You cannot enter letters, please try it again");
        }
    }

    private static void printGameList() {
        System.out.println("======== The Legend of Zelda games ========");
        for (int i = 0; i < gameList.size(); i++) {
            System.out.println((i + 1) + ": " + gameList.get(i));

        }
    }

    private static void loadData() {
        gameList = new ArrayList<>();
        gameList.add(new Game("The Legend of Zelda", "1986-02-21"));
        gameList.add(new Game("Zelda II: The Adventure of Link", "1987-01-14"));
        gameList.add(new Game("The Legend of Zelda: A Link to the Past", "1991-11-21"));
        gameList.add(new Game("The Legend of Zelda: Link's Awakening", "1993-06-06"));
        gameList.add(new Game("The Legend of Zelda: Ocarina of Time", "1998-11-23"));
        gameList.add(new Game("The Legend of Zelda: Majora's Mask", "2000-04-27"));
        gameList.add(new Game("The Legend of Zelda: Oracle of Seasons", "2001-02-27"));
        gameList.add(new Game("The Legend of Zelda: Oracle of Ages", "2001-02-27"));
        gameList.add(new Game("The Legend of Zelda: Four Swords", "2002-12-02"));
        gameList.add(new Game("The Legend of Zelda: The Wind Waker", "2002-12-13"));
        gameList.add(new Game("The Legend of Zelda: Four Swords Adventures", "2004-06-07"));
        gameList.add(new Game("The Legend of Zelda: The Minish Cap", "2004-11-04"));
        gameList.add(new Game("The Legend of Zelda: Twilight Princess", "2006-11-19"));
        gameList.add(new Game("The Legend of Zelda: Phantom Hourglass", "2007-10-01"));
        gameList.add(new Game("The Legend of Zelda: Spirit Tracks", "2009-12-07"));
        gameList.add(new Game("The Legend of Zelda: Skyward Sword", "2011-11-18"));
        gameList.add(new Game("Hyrule Warriors", "2014-08-14"));
        gameList.add(new Game("The Legend of Zelda: A Link Between Worlds", "2013-11-22"));
        gameList.add(new Game("Tri Force Heroes", "2015-10-22"));
        gameList.add(new Game("The Legend of Zelda: Breath of the Wild", "2017-03-03"));
        gameList.add(new Game("Hyrule Warriors: Age of Calamity", "2020-11-20"));
    }
}
