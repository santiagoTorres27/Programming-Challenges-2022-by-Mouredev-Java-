package week16;

public class Week16 {

    /*
     * Crea una función que reciba un String de cualquier tipo y se encargue de
     * poner en mayúscula la primera letra de cada palabra.
     * - No se pueden utilizar operaciones del lenguaje que
     *   lo resuelvan directamente.
     */

    public static void main(String[] args) {
        String text = "hola a todos, mi nombre es Santiago";
        System.out.println(convertToUpperCase(text));
    }

    private static String convertToUpperCase(String text) {
        String[] textArr = text.split(" ");
        String result = "";
        for (String i : textArr) {
            result += i.substring(0, 1).toUpperCase() + i.substring(1) + " ";
        }
        return result.substring(0, result.length() - 1);
    }
}
