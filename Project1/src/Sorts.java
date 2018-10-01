/* CSC 349-03
 * Angel de la Torre & Megan Washburn
 *
 * Project 1
 */

import java.lang.*;

public class Sorts {
    public Sorts() {}

    public static void selectionSort(int[] arr, int N) {
        int temp;
        int minIndex = 0;
        for (int i = 0; i < N; i++) {
            minIndex = i; 
            for (int j = i+1; j < N; j++) {
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
      mergeSort(arr,0,N-1);
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
       int index1 = middle - left +1;
       int index2 = middle + 1;
       int index = 0;

       System.out.println("Size of temp array: " + temp.length);
       while (index1 !=  middle && index2 !=  right) {
            if ( arr[index1] <= arr[index2] ){
               temp[index] = arr[index1];
               index1++;
            }
            else {
               temp[index] = arr[index2];
               index2++;
            }
            index++;
       }
       System.out.println("Middle is: " + middle);

      
       while ( index1 <= middle ){
          System.out.println("Index 1 is: " + index1 + "\nIndex is: " + index);
          temp[index] = arr[index1];
          index1++;
          index++;
       }
        System.out.println("Right is: " + right);
       while ( index2 < right){
          System.out.println("Index 2 is: " + index2 + "\nIndex is: " + index);
          temp[index] = arr[index2];
          index2++;
          index++;
       }
       
       for(int i = left; i < right; i++){
         arr[i] = temp[i];
       }
    }

    public static void quickSort(int[] arr, int N) {

    }
}
