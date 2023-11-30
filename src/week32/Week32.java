package week32;

import java.util.Arrays;

public class Week32 {
    /*
     * Dado un listado de números, encuentra el SEGUNDO más grande.
     */
    public static void main(String[] args) {
        int[] list = new int[]{100, 23, 4, 1, 6, 7, 3, 45, 6, -34, -3442, 99, 34};
        System.out.println(getSecondGreatestNumber(list));
    }

    private static int getSecondGreatestNumber(int[] list) {
        int[] sortedList = sortList(list);
        return sortedList[1];
    }

    private static int[] sortList(int[] list) {
        for (int i = list.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list[j] < list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        return list;
    }
}
