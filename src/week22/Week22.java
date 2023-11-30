package week22;

import java.util.HashSet;
import java.util.Set;

public class Week22 {
    /*
     * Crea una función que reciba dos array, un booleano y retorne un array.
     * - Si el booleano es verdadero buscará y retornará los elementos comunes
     *   de los dos array.
     * - Si el booleano es falso buscará y retornará los elementos no comunes
     *   de los dos array.
     * - No se pueden utilizar operaciones del lenguaje que
     *   lo resuelvan directamente.
     */
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(2);

        System.out.println(checkSet(set1, set2, false));
    }

    private static Set<Integer> checkSet(Set<Integer> set1, Set<Integer> set2, boolean commonItems) {
        Set<Integer> set = new HashSet<>();
        if (commonItems) {
            set = findCommonItems(set1, set2);
        } else {
            set = findNoCommonItems(set1, set2);
        }
        return set;
    }

    private static Set<Integer> findNoCommonItems(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> commonItems = findCommonItems(set1, set2);
        Set<Integer> set = new HashSet<>(set1);
        set.addAll(set2);
        for (Integer i : commonItems) {
            if (set.contains(i)) {
                set.remove(i);
            }
        }
        return set;
    }

    private static Set<Integer> findCommonItems(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : set1) {
            if (set2.contains(i)) {
                set.add(i);
            }
        }
        return set;
    }
}
