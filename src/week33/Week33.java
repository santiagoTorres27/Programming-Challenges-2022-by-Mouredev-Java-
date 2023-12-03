package week33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Week33 {
    /*
     * Enunciado: Crea un función, que dado un año, indique el elemento
     * y animal correspondiente en el ciclo sexagenario del zodíaco chino.
     * - Info: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
     * - El ciclo sexagenario se corresponde con la combinación de los elementos
     *   madera, fuego, tierra, metal, agua y los animales rata, buey, tigre,
     *   conejo, dragón, serpiente, caballo, oveja, mono, gallo, perro, cerdo
     *   (en este orden).
     * - Cada elemento se repite dos años seguidos.
     * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter a year: ");
                int year = Integer.parseInt(sc.nextLine());
                String response = getChineseZodiac(year);
                System.out.println(response);
            } catch (NumberFormatException e) {
                System.out.println("You cannot enter letters");
            }

            System.out.println("Do you want to continue? Y/n");
            String option = sc.nextLine();
            if (!option.equalsIgnoreCase("y")) {
                return;
            }
        }
    }

    private static String getChineseZodiac(int year) {
        String[] elements = new String[]{"wood", "wood", "fire", "fire", "earth", "earth", "metal", "metal", "water", "water"};
        String[] animals = new String[]{"rat", "ox", "tiger", "rabbit", "dragon", "snake", "horse", "sheep", "monkey", "rooster", "dog", "pig"};

        ArrayList<String> elementsCycle = new ArrayList<>();
        ArrayList<String> animalsCycle = new ArrayList<>();

        int lastChineseYearStart = 1984;
        int difference = year - lastChineseYearStart;

        for (int i = 0; i < 6; i++) {
            elementsCycle.addAll(Arrays.asList(elements));
        }

        for (int i = 0; i < 5; i++) {
            animalsCycle.addAll(Arrays.asList(animals));
        }

        if (difference >= 60) {
            while (difference >= 60) {
                difference -= 60;
            }
        } else {
            while (difference < 0) {
                difference += 60;
            }
        }
        return "Year: " + year + "\nAnimal: " + animalsCycle.get(difference) + "\nElement: " + elementsCycle.get(difference);
    }
}
