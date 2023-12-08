package week48;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week48 {
    /*
     * ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
     * 24 días, 24 regalos sorpresa relacionados con desarrollo de software,
     * ciencia y tecnología desde el 1 de diciembre.
     *
     * Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne
     * lo siguiente:
     * - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el regalo
     *   de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
     * - Si la fecha es anterior: Cuánto queda para que comience el calendario.
     * - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
     *
     * Notas:
     * - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00
     *   y finaliza a las 23:59:59.
     * - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos
     *   y segundos.
     * - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo
     *   del calendario de aDEViento hasta el día de su corrección
     *   (sorteo exclusivo para quien entregue su solución).
     */

    public static HashMap<String, String> adeventCalendar;
    public static LocalDate firstDay;
    public static LocalDate lastDay;

    public static void main(String[] args) {
        loadData();
        LocalDate date = LocalDate.of(2022, 11, 30);
        System.out.println(checkGift(date));
    }

    private static String checkGift(LocalDate date) {
        String dateStr = date.toString();
        String result = "";

        if (date.isBefore(firstDay)) {
            result = calculatePeriod(date, firstDay);
        } else if (date.isAfter(lastDay)) {
            result = calculatePeriod(date, lastDay);
        } else {
            for (Map.Entry<String, String> entry : adeventCalendar.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(dateStr)) {
                    result = "Hey!! Your gift is " + entry.getValue();
                }
            }
        }

        return result;
    }

    private static String calculatePeriod(LocalDate initDate, LocalDate lastDay) {
        boolean isBefore = initDate.isAfter(lastDay);
        LocalDate dateAux;

        if (initDate.isAfter(lastDay)) {
            dateAux = initDate;
            initDate = lastDay;
            lastDay = dateAux;
        }

        Period period = Period.between(initDate, lastDay);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        String totalYears = (years > 0 ? years + " years " : "");
        String totalMonths = (months > 0 ? months + " months " : "");
        String totalDays = (days > 0 ? days + " days" : "");

        if (isBefore) {
            return ("This date is after by: " + totalYears + totalMonths + totalDays);
        }
        return ("This date is before by: " + totalYears + totalMonths + totalDays);
    }

    private static void loadData() {
        firstDay = LocalDate.parse("2022-12-01");
        lastDay = LocalDate.parse("2022-12-24");

        adeventCalendar = new HashMap<>();
        adeventCalendar.put("2022-12-01", "Gift 1");
        adeventCalendar.put("2022-12-02", "Gift 2");
        adeventCalendar.put("2022-12-03", "Gift 3");
        adeventCalendar.put("2022-12-04", "Gift 4");
        adeventCalendar.put("2022-12-05", "Gift 5");
        adeventCalendar.put("2022-12-06", "Gift 6");
        adeventCalendar.put("2022-12-07", "Gift 7");
        adeventCalendar.put("2022-12-08", "Gift 8");
        adeventCalendar.put("2022-12-09", "Gift 9");
        adeventCalendar.put("2022-12-11", "Gift 11");
        adeventCalendar.put("2022-12-12", "Gift 12");
        adeventCalendar.put("2022-12-13", "Gift 13");
        adeventCalendar.put("2022-12-14", "Gift 14");
        adeventCalendar.put("2022-12-15", "Gift 15");
        adeventCalendar.put("2022-12-16", "Gift 16");
        adeventCalendar.put("2022-12-17", "Gift 17");
        adeventCalendar.put("2022-12-18", "Gift 18");
        adeventCalendar.put("2022-12-19", "Gift 19");
        adeventCalendar.put("2022-12-20", "Gift 20");
        adeventCalendar.put("2022-12-21", "Gift 21");
        adeventCalendar.put("2022-12-22", "Gift 22");
        adeventCalendar.put("2022-12-23", "Gift 23");
        adeventCalendar.put("2022-12-24", "Gift 24");
    }
}
