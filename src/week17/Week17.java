package week17;

import java.util.ArrayList;

public class Week17 {
    /*
     * Crea una función que evalúe si un/a atleta ha superado correctamente una
     * carrera de obstáculos.
     * - La función recibirá dos parámetros:
     *      - Un array que sólo puede contener String con las palabras
     *        "run" o "jump"
     *      - Un String que represente la pista y sólo puede contener "_" (suelo)
     *        o "|" (valla)
     * - La función imprimirá cómo ha finalizado la carrera:
     *      - Si el/a atleta hace "run" en "_" (suelo) y "jump" en "|" (valla)
     *        será correcto y no variará el símbolo de esa parte de la pista.
     *      - Si hace "jump" en "_" (suelo), se variará la pista por "x".
     *      - Si hace "run" en "|" (valla), se variará la pista por "/".
     * - La función retornará un Boolean que indique si ha superado la carrera.
     * Para ello tiene que realizar la opción correcta en cada tramo de la pista.
     */
    public static void main(String[] args) {
        String race = "_|__|_";
        ArrayList<String> player = new ArrayList<>();
        player.add("run");
        player.add("jump");
        player.add("run");
        player.add("run");
        player.add("JUMP");
        player.add("run");

        System.out.println("Race is sucessfull: " + runRace(race, player));
    }

    private static boolean runRace(String race, ArrayList<String> player) {
        ArrayList<String> result = new ArrayList<>();
        if (race.length() != player.size()) {
            return false;
        }
        for (int i = 0; i < race.length(); i++) {
            if (String.valueOf(race.charAt(i)).equalsIgnoreCase("_")) {
                if (player.get(i).equalsIgnoreCase("run")) {
                    result.add("_");
                } else {
                    result.add("x");
                }
            } else {
                if (player.get(i).equalsIgnoreCase("jump")) {
                    result.add("|");
                } else {
                    result.add("/");
                }
            }
        }
        System.out.println(result);
        return !result.contains("x") || !result.contains("/");
    }
}
