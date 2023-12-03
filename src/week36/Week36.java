package week36;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Week36 {
    /*
     * Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales
     * a Sauron contra otras bondadosas que no quieren que el mal reine
     * sobre sus tierras.
     * Cada raza tiene asociado un "valor" entre 1 y 5:
     * - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3),
     *   Númenóreanos (4), Elfos (5)
     * - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2),
     *   Huargos (3), Trolls (5)
     * Crea un programa que calcule el resultado de la batalla entre
     * los 2 tipos de ejércitos:
     * - El resultado puede ser que gane el bien, el mal, o exista un empate.
     *   Dependiendo de la suma del valor del ejército y el número de integrantes.
     * - Cada ejército puede estar compuesto por un número de integrantes variable
     *   de cada raza.
     * - Tienes total libertad para modelar los datos del ejercicio.
     * Ej: 1 Peloso pierde contra 1 Orco
     *     2 Pelosos empatan contra 1 Orco
     *     3 Pelosos ganan a 1 Orco
     */

    public static HashMap<Race, Integer> races;

    public static void main(String[] args) {
        loadData();
        initBattle();
    }

    private static void initBattle() {

        ArrayList<Race> kindArmy = createRandomArmy(5, "kind");
        ArrayList<Race> evilArmy = createRandomArmy(5, "evil");

        int kindArmyTotalDamage = calculateArmyDamage(kindArmy);
        int evilArmyTotalDamage = calculateArmyDamage(evilArmy);

        System.out.println(kindArmy);
        System.out.println("KIND ARMY DAMAGE: " + kindArmyTotalDamage);
        System.out.println(evilArmy);
        System.out.println("EVIL ARMY DAMAGE: " + evilArmyTotalDamage);

        if (kindArmyTotalDamage > evilArmyTotalDamage) {
            System.out.println("\nKIND ARMY WINS :)");
        } else {
            System.out.println("\nEVIL ARMY WINS :(");
        }
    }

    private static int calculateArmyDamage(ArrayList<Race> army) {
        int damage = 0;
        for (Race i : army) {
            damage += races.get(i);
        }
        return damage;
    }

    private static ArrayList<Race> createRandomArmy(int armyLength, String kind) {
        ArrayList<Race> army = new ArrayList<>();
        Random random = new Random();
        Race[] races = Race.values();

        for (int i = 0; i < armyLength; i++) {
            int randomIndex;
            if (kind.equalsIgnoreCase("kind")) {
                randomIndex = random.nextInt(5);
            } else {
                randomIndex = random.nextInt(5) + 5;
            }
            army.add(races[randomIndex]);
        }
        return army;
    }

    private static void loadData() {
        races = new HashMap<>();
        races.put(Race.PELOSOS, 1);
        races.put(Race.SURENOS_BUENOS, 2);
        races.put(Race.ENANOS, 3);
        races.put(Race.NUMENOREANOS, 4);
        races.put(Race.ELFOS, 5);

        races.put(Race.SURENOS_MALOS, 2);
        races.put(Race.ORCOS, 2);
        races.put(Race.GOBLINS, 2);
        races.put(Race.HUARGOS, 3);
        races.put(Race.TROLLS, 5);
    }
}
