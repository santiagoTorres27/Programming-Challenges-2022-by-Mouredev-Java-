package week26;

import java.util.Scanner;

public class Week26 {
    /*
     * Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
     * - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
     * - EXTRA: ¿Eres capaz de dibujar más figuras?
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("What figure do you want to draw?");
            System.out.println("1: square");
            System.out.println("2: triangle");
            int figure = Integer.parseInt(sc.nextLine());
            if (figure <= 0 || figure > 2) {
                System.out.println("Incorrect figure :(");
            } else {
                System.out.println("Enter the figure's length: ");
                int length = Integer.parseInt(sc.nextLine());
                drawFigure(length, figure);
            }
            System.out.println("Do you want to continue? Y/n");
            String option = sc.nextLine();
            if (!option.equalsIgnoreCase("y")) {
                return;
            }

        }
    }

    private static void drawFigure(int length, int figure) {
        switch (figure) {
            case 1 -> printSquare(length);
            case 2 -> printTriangle(length);
            default -> {
                System.out.println("Incorrect figure");
            }
        }

    }

    private static void printTriangle(int length) {
        for (int i = 1; i <= length; i++) {
            for (int k = length - i; k > 0; k--) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("x ");
            }
            System.out.println();
        }
    }

    private static void printSquare(int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
