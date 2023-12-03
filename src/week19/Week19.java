package week19;

public class Week19 {
    /*
     * Crea una función que reciba días, horas, minutos y segundos (como enteros)
     * y retorne su resultado en milisegundos.
     */
    public static void main(String[] args) {
        int[] time = new int[]{1, 1, 1, 1};
        int milliseconds = convertTime(time);
        System.out.println(milliseconds);
    }

    private static int convertTime(int[] time) {
        int daysToMillis = 86400 * time[0];
        int hoursToMillis = 3600 * time[1];
        int minutesToMillis = 60 * time[2];
        int secondsToMillis = time[3];
        return (daysToMillis + hoursToMillis + minutesToMillis + secondsToMillis) * 1000;
    }
}
