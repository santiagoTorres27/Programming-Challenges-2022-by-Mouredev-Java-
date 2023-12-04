package week43;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Week43 {
    /*
     * Enunciado: Este es un reto especial por Halloween.
     * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco
     * o Trato" y un listado (array) de personas con las siguientes propiedades:
     * - Nombre de la niña o niño
     * - Edad
     * - Altura en centímetros
     *
     * Si las personas han pedido truco, el programa retornará sustos (aleatorios)
     * siguiendo estos criterios:
     * - Un susto por cada 2 letras del nombre por persona
     * - Dos sustos por cada edad que sea un número par
     * - Tres sustos por cada 100 cm de altura entre todas las personas
     * - Sustos: 🎃 👻 💀 🕷 🕸 🦇
     *
     * Si las personas han pedido trato, el programa retornará dulces (aleatorios)
     * siguiendo estos criterios:
     * - Un dulce por cada letra de nombre
     * - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
     * - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
     * - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩
     */

    public static ArrayList<Person> personList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadData();
        while (true) {
            System.out.println("(1) Trick or (2) Treat?");
            String response = sc.nextLine();

            switch (response.toLowerCase()) {
                case "1" -> makeTrick();
                case "2" -> makeTreat();
                default -> {
                    System.out.println("Invalid answer :(");
                }
            }

            System.out.println("Do you want to continue? Y/n");
            String option = sc.nextLine();

            if (!option.equalsIgnoreCase("y")) {
                return;
            }
        }
    }

    private static void makeTreat() {
        int candiesByName = 0;
        int candiesByAge = 0;
        int heightSum = 0;
        int candiesByHeight = 0;
        int totalCandies = 0;

        for (Person p : personList) {
            candiesByName += p.getName().length();
            if (p.getAge() <= 10) {
                candiesByAge += p.getAge() / 3;
            }
            if (p.getHeight() <= 150) {
                heightSum = p.getHeight() / 50;
            }
        }

        candiesByHeight = heightSum * 2;
        totalCandies = candiesByName + candiesByAge + candiesByHeight;
        generateItems(totalCandies, "treat");
    }

    private static void makeTrick() {
        int namesLength = 0;
        int heightSum = 0;
        int scaresByName = 0;
        int scaresByAge = 0;
        int scaresByHeight = 0;
        int totalScares = 0;

        for (Person i : personList) {
            namesLength += i.getName().length();
            if (i.getAge() % 2 == 0) {
                scaresByAge = scaresByAge + 2;
            }
            heightSum += i.getHeight();
        }

        scaresByName = namesLength / 2;
        scaresByHeight = heightSum / 100;
        totalScares = scaresByName + scaresByHeight + scaresByAge;
        generateItems(totalScares, "trick");
    }

    private static void generateItems(int length, String kind) {
        String[] scares = new String[]{"🎃", "👻", "💀", "🕷", "🕸", "🦇"};
        String[] candies = new String[]{"🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"};
        ArrayList<String> itemsList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            if (kind.equalsIgnoreCase("trick")) {
                itemsList.add(scares[random.nextInt(scares.length)]);
            } else {
                itemsList.add(candies[random.nextInt(candies.length)]);
            }
        }

        System.out.println("You will receive " + length + (kind.equalsIgnoreCase("trick") ? " scares" : " candies"));
        System.out.println(itemsList);
    }

    private static void loadData() {
        personList = new ArrayList<>();
        personList.add(new Person("Santiago", 13, 160));
        personList.add(new Person("Ana", 10, 140));
        personList.add(new Person("Santiago", 12, 156));
        personList.add(new Person("Santiago", 15, 162));
    }
}
