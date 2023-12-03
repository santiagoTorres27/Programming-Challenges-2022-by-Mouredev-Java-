package week15;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Week15 {

    /*
     * Crea una función que calcule y retorne cuántos días hay entre dos cadenas
     * de texto que representen fechas.
     * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
     * - La función recibirá dos String y retornará un Int.
     * - La diferencia en días será absoluta (no importa el orden de las fechas).
     * - Si una de las dos cadenas de texto no representa una fecha correcta se
     *   lanzará una excepción.
     */

    public static void main(String[] args) {
        String date1 = "29/11/2023";
        String date2 = "22/11/2023";
        System.out.println(daysCounter(date1, date2));
    }

    private static int daysCounter(String date1, String date2) {

        LocalDate initialDate = getLocalDate(date1);
        LocalDate finalDate = getLocalDate(date2);

        if (finalDate.isBefore(initialDate)) {
            LocalDate aux = initialDate;
            initialDate = finalDate;
            finalDate = aux;
        }

        return (int) ChronoUnit.DAYS.between(initialDate, finalDate);
    }

    private static LocalDate getLocalDate(String date1) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date1, formatter);
    }
}
