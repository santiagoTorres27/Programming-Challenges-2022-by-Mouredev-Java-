package week20;

import java.util.Timer;
import java.util.TimerTask;

public class Week20 {
    /*
     * Crea una función que sume 2 números y retorne su resultado pasados
     * unos segundos.
     * - Recibirá por parámetros los 2 números a sumar y los segundos que
     *   debe tardar en finalizar su ejecución.
     * - Si el lenguaje lo soporta, deberá retornar el resultado de forma
     *   asíncrona, es decir, sin detener la ejecución del programa principal.
     *   Se podría ejecutar varias veces al mismo tiempo.
     */
    public static void main(String[] args) {
        int[] numbers = new int[]{20, 10};
        int secondsToWait = 3;
        addNumbers(numbers, secondsToWait);
    }

    private static void addNumbers(int[] numbers, int secondsTowait) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                int result = numbers[0] + numbers[1];
                System.out.println("Result: " + result);
            }
        }, secondsTowait * 1000L);
    }
}
