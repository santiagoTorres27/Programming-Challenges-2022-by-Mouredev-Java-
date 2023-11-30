package week31;

public class Week31 {
    /*
     * Crea una función que imprima los 30 próximos años bisiestos
     * siguientes a uno dado.
     * - Utiliza el menor número de líneas para resolver el ejercicio.
     */
    public static void main(String[] args) {
        int year = 2020;
        calculateNext30LeapYears(year);
    }

    private static void calculateNext30LeapYears(int year) {
        int[] nextLeapYears = new int[30];
        int nextYear = nextLeapYear(year);
        for (int i = 0; i < nextLeapYears.length; i++) {
            nextLeapYears[i] = nextYear;
            nextYear += 4;
        }
        for (Integer i : nextLeapYears) {
            System.out.println(i);
        }
    }

    private static int nextLeapYear(int year) {
        int nextYear = year;
        if (isLeapYear(nextYear)) {
            return nextYear + 4;
        } else {
            while (true) {
                if (isLeapYear(nextYear)) {
                    return nextYear;
                } else {
                    nextYear++;
                }
            }
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
