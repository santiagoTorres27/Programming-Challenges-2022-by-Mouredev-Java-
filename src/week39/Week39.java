package week39;

import java.util.Arrays;

public class Week39 {
    /*
     * Enunciado: Implementa uno de los algoritmos de ordenación más famosos:
     * el "Quick Sort", creado por C.A.R. Hoare.
     * - Entender el funcionamiento de los algoritmos más utilizados de la historia
     *   Nos ayuda a mejorar nuestro conocimiento sobre ingeniería de software.
     *   Dedícale tiempo a entenderlo, no únicamente a copiar su implementación.
     * - Esta es una nueva serie de retos llamada "TOP ALGORITMOS",
     *   donde trabajaremos y entenderemos los más famosos de la historia.
     */
    public static void main(String[] args) {
        int[] numberArray = new int[]{9, -23, 34, 1, -45, 2};
        int[] sortedArray = quickSort(numberArray);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] quickSort(int[] numberArray) {
        return quickSortHelper(numberArray, 0, numberArray.length - 1);
    }

    public static int[] swap(int[] list, int index1, int index2) {
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
        return list;
    }

    private static int pivot(int[] list, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i < endIndex + 1; i++) {
            if (list[i] < list[pivotIndex]) {
                swapIndex += 1;
                swap(list, swapIndex, i);
            }
        }
        swap(list, pivotIndex, swapIndex);
        return swapIndex;
    }

    public static int[] quickSortHelper(int[] list, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(list, left, right);
            quickSortHelper(list, left, pivotIndex - 1);
            quickSortHelper(list, pivotIndex + 1, right);
        }
        return list;
    }
}
