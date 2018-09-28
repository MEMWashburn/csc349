/*
 *
 *
 */

import java.lang.*;

public class Sorts {
    public Sorts() {}

    public static void selectionSort(int[] arr, int N) {
        int temp;
        int minIndex = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void mergeSort(int[] arr, int N) {

    }

    public static void quickSort(int[] arr, int N) {

    }
}