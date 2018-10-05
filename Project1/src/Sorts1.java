/* CSC 349-03
 * Angel de la Torre & Megan Washburn
 *
 * Project 1
 */

import java.lang.*;

public class Sorts1 {
    private static long mergeSortCount, quickSortCount;
    public Sorts1() {}

    public static long selectionSort(int[] arr, int N) {
        int temp;
        int minIndex;
        long compCount = 0;
        for (int i = 0; i < N; i++) {
            minIndex = i;
            for (int j = i+1; j < N; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                compCount++;
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return compCount;
    }

    public static long mergeSort(int[] arr, int N) {
        mergeSortCount = 0;
        mergeSort(arr,0,N-1);
        return mergeSortCount;
    }

    private static void mergeSort(int[] arr,int first, int last){
        if (first < last){
            int middle = (first +last)/2;
            mergeSort(arr,first,middle);
            mergeSort(arr,middle+1, last);
            mergeSortHalves(arr,first,middle,last);
        }
    }

    private static void mergeSortHalves(int[] arr,int left, int middle, int right){
        int temp[] = new int[right-left+1];
        int index1 = left;
        int index2 = middle + 1;
        int index = 0;

        while (index1 <=  middle && index2 <=  right) {
            if ( arr[index1] <= arr[index2] ) {
                temp[index] = arr[index1];
                index1++;
            }
            else {
                temp[index] = arr[index2];
                index2++;
            }
            mergeSortCount++;
            index++;
        }

        while ( index1 <= middle ){
            temp[index] = arr[index1];
            index1++;
            index++;
        }
        while ( index2 <= right){
            temp[index] = arr[index2];
            index2++;
            index++;
        }

        int x = left;
        for(int i = 0; i < temp.length; i++){
            arr[x] = temp[i];
            x++;
        }
    }

    public static long quickSort(int[] arr, int N) {
        quickSort(arr,0,N-1);
        return quickSortCount;
    }

    private static void quickSort(int[] arr, int first, int last){
        if (first < last){
            setPivotToEnd(arr,first,last);
            int pivotIndex = splitList(arr,first,last);
            quickSort(arr,first,pivotIndex-1);
            quickSort(arr,pivotIndex+1,last);
        }
    }

    private static void setPivotToEnd(int[] arr, int left, int right){
        int center = (left + right)/2;
        int temp;

        if (arr[left] > arr[center]){
            temp = arr[center];
            arr[center] = arr[left];
            arr[left] = temp;
        }
        if (arr[left] > arr[right]){
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
        if (arr[right] > arr[center]){
            temp = arr[right];
            arr[right] = arr[center];
            arr[center] = temp;
        }
        quickSortCount += 3;
    }

    private static int splitList(int[] arr,int left, int right){
        int indexL = left;
        int indexR = right-1;
        int pivot = arr[right];
        int temp;

        while (indexL < indexR) {
            while( arr[indexL] < pivot) {
                indexL++;
                quickSortCount++;
            }
            quickSortCount++;
            while(indexR > indexL) {
                if (arr[indexR] > pivot) {
                    indexR--;
                    quickSortCount++;
                }
                else
                    break;
            }
            if (indexL < indexR) {
                temp = arr[indexL];
                arr[indexL] = arr[indexR];
                arr[indexR] = temp;
                indexL++;
                indexR--;
            }
        }
        temp = arr[indexL];
        arr[indexL] = arr[right];
        arr[right] = temp;
        return indexL;
    }
}
