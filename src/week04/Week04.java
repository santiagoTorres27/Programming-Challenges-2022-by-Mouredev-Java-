package week04;

import java.util.Scanner;

public class Week04 {
    /*
     * Crea una única función (importante que sólo sea una) que sea capaz
     * de calcular y retornar el área de un polígono.
     * - La función recibirá por parámetro sólo UN polígono a la vez.
     * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
     * - Imprime el cálculo del área de un polígono de cada tipo.
     */
    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        init();
    }

    private static void init() {
        while (true) {
            int currentOption = showOptions();
            switch (currentOption) {
                case 1:
                    calculateTriangle();
                    break;
                case 2:
                    calculateSquare();
                    break;
                case 3:
                    calculateRectangle();
                    break;
                default:
                    System.out.println("Incorrect option");
                    break;
            }
            System.out.println("Continue? Y/n");
            String continueProgram = sc.nextLine().toLowerCase();
            if(continueProgram.equalsIgnoreCase("n")) {
                return;
            }
        }
    }

    private static void calculateRectangle() {
        try {
            System.out.println("RECTANGLE");
            System.out.print("base: ");
            double base = Double.parseDouble(sc.nextLine());
            System.out.print("height: ");
            double height = Double.parseDouble(sc.nextLine());
            Rectangle r1 = new Rectangle(base, height);
            System.out.println("Area: " + r1.getArea());
        } catch (NumberFormatException e) {
            System.out.println("Letters are not allowed");
        }
    }

    private static void calculateSquare() {
        try {
            System.out.println("SQUARE");
            System.out.print("side: ");
            double side = Double.parseDouble(sc.nextLine());
            Square s1 = new Square(side);
            System.out.println("Area: " + s1.getArea());
        } catch (NumberFormatException e) {
            System.out.println("Letters are not allowed");
        }
    }

    private static void calculateTriangle() {
        try {
            System.out.println("TRIANGLE");
            System.out.print("base: ");
            double base = Double.parseDouble(sc.nextLine());
            System.out.print("height: ");
            double height = Double.parseDouble(sc.nextLine());
            Triangle t = new Triangle(base, height);
            System.out.println("Area: " + t.getArea());
        } catch (NumberFormatException e) {
            System.out.println("Letters are not allowed");
        }
    }

    private static int showOptions() {
        int option = 0;
        try {
            System.out.println("1. Triangle");
            System.out.println("2. Square");
            System.out.println("3. Rectangle");
            System.out.println("Please enter your option: ");
            option = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Letters are not allowed");
        }
        return option;
    }
}
