package week28;

import javax.swing.text.Style;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Week28 {
    /*
     * Simula el funcionamiento de una máquina expendedora creando una operación
     * que reciba dinero (array de monedas) y un número que indique la selección
     * del producto.
     * - El programa retornará el nombre del producto y un array con el dinero
     *   de vuelta (con el menor número de monedas).
     * - Si el dinero es insuficiente o el número de producto no existe,
     *   deberá indicarse con un mensaje y retornar todas las monedas.
     * - Si no hay dinero de vuelta, el array se retornará vacío.
     * - Para que resulte más simple, trabajaremos en céntimos con monedas
     *   de 5, 10, 50, 100 y 200.
     * - Debemos controlar que las monedas enviadas estén dentro de las soportadas.
     */

    public static HashMap<String, Integer> products;

    public static void main(String[] args) {
        loadData();
        initVendingMachine();
    }

    private static void initVendingMachine() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                printProducts();
                System.out.print("Your option: ");
                String selection = sc.nextLine();

                if (products.containsKey(selection)) {
                    System.out.print("Load money: ");
                    int money = Integer.parseInt(sc.nextLine());

                    int change = payProduct(selection, money);
                    System.out.println("Please grab your change: " + change);
                } else {
                    System.out.println("The product selected doesn't exist");
                }

                System.out.print("Do you want to continue? Y/n");
                String option = sc.nextLine();
                if (!option.equalsIgnoreCase("Y")) {
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid option");
            }

        }
    }

    private static int payProduct(String selection, int money) {
        int productPrice = products.get(selection);
        if (productPrice != 0) {
            int change = money - productPrice;
            int coins200 = 0;
            int coins100 = 0;
            int coins50 = 0;
            int coins10 = 0;
            int coins5 = 0;

            // TODO:
            while (change > 0) {
                if (change - 200 >= 0) {
                    coins200++;
                    change -= 200;
                } else if (change - 150 >= 0) {
                    coins100++;
                    change -= 100;
                } else if (change - 50 >= 0) {
                    coins50++;
                    change -= 50;
                } else if (change - 10 >= 0) {
                    coins10++;
                    change -= 10;
                } else if (change - 5 >= 0) {
                    coins5++;
                    change -= 5;
                }
            }

            System.out.println("=== Total change ===");
            System.out.println("200: " + coins200);
            System.out.println("100: " + coins100);
            System.out.println("50: " + coins50);
            System.out.println("10: " + coins10);
            System.out.println("5: " + coins5);

            return (coins200 * 200) + (coins100 * 100) + (coins50 * 50) + (coins10 * 10) + (coins5 * 5);
        }
        return 0;
    }

    private static void printProducts() {
        System.out.println("=== Product list ===");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("=== Product list ===");
    }

    private static void loadData() {
        products = new HashMap<>();
        products.put("pc", 350);
    }
}
