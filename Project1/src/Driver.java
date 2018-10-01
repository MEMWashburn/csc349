import java.lang.*;
import java.util.Arrays;

public class Driver {
    public static int[] listOne = {91, 55, 88, 7, 18, 66, 72, 62, 77, 52, 96, 56, 42, 4,
                      68, 23, 13, 78, 22, 60, 94, 89, 98, 80, 74, 47, 81, 
                      17, 65, 41, 45, 30, 8, 12, 83, 3, 9, 19, 90, 64, 87, 
                      25, 46, 97, 6, 5, 61, 38, 40, 53, 43, 92, 16, 29, 28, 
                      39, 86, 67, 34, 31, 82, 84, 99, 48, 36, 70, 73, 24, 
                      75, 27, 85, 2, 14, 37, 95, 10, 58, 20, 35, 76, 71, 79, 
                      1, 44, 69, 21, 54, 11, 93, 51, 33, 59, 63, 57, 15, 26, 
                      49, 32, 50, 100};

    public static int[] sortedListOne = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
                           15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 
                           27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
                           39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
                           51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 
                           63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
                           75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 
                           87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 
                           99, 100};
    
    public static void main(String[] args) {
      Sorts algSorts = new Sorts();
      int[] temp = listOne;

      algSorts.selectionSort(temp,100);
      System.out.println(Arrays.toString(temp));
      System.out.println("List one got sorted: " + Arrays.equals(temp,sortedListOne));
    
      temp = listOne;
      algSorts.mergeSort(temp,100);
      System.out.println(Arrays.toString(temp));
      System.out.println("List one got sorted: " + Arrays.equals(temp, sortedListOne));
    }
}
