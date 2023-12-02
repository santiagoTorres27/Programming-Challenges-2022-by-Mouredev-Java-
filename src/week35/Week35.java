package week35;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Week35 {
    /*
     * Enunciado: Crea un programa que calcule el daño de un ataque durante
     * una batalla Pokémon.
     * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
     * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
     * - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico
     *   (buscar su efectividad)
     * - El programa recibe los siguientes parámetros:
     *  - Tipo del Pokémon atacante.
     *  - Tipo del Pokémon defensor.
     *  - Ataque: Entre 1 y 100.
     *  - Defensa: Entre 1 y 100.
     */

    public static ArrayList<Pokemon> pokemons;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initData();
        while (true) {
            printMenu();
            System.out.print("Enter you pokemon: ");
            int pokemonIndex = Integer.parseInt(sc.nextLine());
            System.out.println("Your pokemon is " + pokemons.get(pokemonIndex - 1).getName());

            initGame(pokemons.get(pokemonIndex - 1));

            System.out.println("Do you want to play again?Y/n");
            String option = sc.nextLine();
            if (!option.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    private static void initGame(Pokemon pokemon) {
        Pokemon rivalPokemon = getRivalPokemon(pokemon);
        if (rivalPokemon != null) {
            System.out.println("Your rival is: " + rivalPokemon.getName() + "!");
            initBattle(pokemon, rivalPokemon);
        }
    }

    private static void initBattle(Pokemon pokemon, Pokemon rivalPokemon) {
        String winner = "";
        boolean isBattleRunning = true;
        while (isBattleRunning) {
            int myAttack = pokemon.hit();
            int rivalAttack = rivalPokemon.hit();

            pokemon.receiveDamage(rivalAttack);
            rivalPokemon.receiveDamage(myAttack);

            if (pokemon.getLife() < 0) {
                winner = "\nWinner is: " + pokemon.getName() + "\nCONGRATS! You win!!";
                isBattleRunning = false;
            } else if (rivalPokemon.getLife() < 0) {
                winner = rivalPokemon.getName();
                isBattleRunning = false;
            } else {
                System.out.println();
                System.out.println(pokemon.getName() + " (me): " + pokemon.getLife());
                System.out.println(rivalPokemon.getName() + "(rival): " + rivalPokemon.getLife());
            }
        }

        System.out.println(winner);
    }

    private static Pokemon getRivalPokemon(Pokemon pokemon) {
        Random random = new Random();
        while (true) {
            int rivalPokemonIndex = random.nextInt(pokemons.size());
            Pokemon rival = pokemons.get(rivalPokemonIndex);
            if (!rival.getName().equalsIgnoreCase(pokemon.getName())) {
                return rival;
            }
        }
    }

    private static void printMenu() {
        System.out.println("====================================================================");
        System.out.println("Select your pokemon!");
        for (int i = 0; i < pokemons.size(); i++) {
            System.out.println((i + 1) + " -> " + pokemons.get(i));
        }
        System.out.println("====================================================================");
    }

    private static void initData() {
        pokemons = new ArrayList<>();
        Pokemon pikachu = new Pokemon("Pikachu", PokemonKind.ELECTRIC, 82, 65, 1.5);
        Pokemon charizard = new Pokemon("Charizard", PokemonKind.FIRE, 94, 78, 1.0);
        Pokemon bulbasur = new Pokemon("Bulbasur", PokemonKind.PLANT, 50, 40, 0.8);
        Pokemon squirtle = new Pokemon("Squirtle", PokemonKind.WATER, 60, 55, 1.2);
        Pokemon jolteon = new Pokemon("Jolteon", PokemonKind.ELECTRIC, 80, 70, 1.5);
        Pokemon venusaur = new Pokemon("Venusaur", PokemonKind.PLANT, 85, 75, 0.9);
        pokemons.add(pikachu);
        pokemons.add(charizard);
        pokemons.add(bulbasur);
        pokemons.add(squirtle);
        pokemons.add(jolteon);
        pokemons.add(venusaur);
    }
}
