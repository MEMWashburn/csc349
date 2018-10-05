import java.lang.*;
import java.util.Random;

public class SortTimes {

   public static void main(String[] args){
      int[] copy1 = new int[160000];
      int[] copy2 = new int[160000];
      int[] copy3 = new int[160000];

      long startTime, endTime, nanoTime;
      long selectTime, mergeTime, quickTime;

      Sorts algSorts = new Sorts();
      Random rand = new Random();
      
      System.out.println("Running Times of three sorting algorithms:\n");
      for(int n = 5000; n <= 160000; n*=2) {
         for(int j = 0; j < 5; j++) {
            for(int i = 0; i < 160000; i++){
               copy1[i] = copy2[i] = copy3[i] = rand.nextInt(n);
            }
            startTime = System.nanoTime();
            algSorts.selectionSort(copy1, n);
            endTime = System.nanoTime();

            nanoTime = endTime - startTime;
            selectTime = nanoTime / 1000000;

            startTime = System.nanoTime();
            algSorts.mergeSort(copy2, n);
            endTime = System.nanoTime();

            nanoTime = endTime - startTime;
            mergeTime = nanoTime / 1000000;

            startTime = System.nanoTime();
            algSorts.quickSort(copy3, n);
            endTime = System.nanoTime();

            nanoTime = endTime - startTime;
            quickTime = nanoTime / 1000000;

            System.out.println("N=" + n + ": T_ss=" + selectTime + ",  T_ms=" + mergeTime + ", T_qs=" + quickTime);
         }
         System.out.println();
     }
     System.out.println("End of output");
  }
}

