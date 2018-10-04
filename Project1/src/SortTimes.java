import java.lang.*;
import java.util.Random;

public class SortTimes {

   public static void main(String[] args){
      int[] og = new int[160000];
      int[] copy1 = new int[160000];
      int[] copy2 = new int[160000];
      int[] copy3 = new int[160000];

      long startTime,endTime,nanoTime;
      long selectTime,mergeTime,quickTime;

      Sorts algSorts = new Sorts();
      Random rand = new Random();

      for(int i = 0; i < 160000;i++){
         og[i] = rand.nextInt();
      }

      copy1 = copy2 = copy3 = og;
      
      System.out.println("Running Times of three sorting algorithms:\n");
      for(int n = 5000; n <= 160000; n*=2){
         for(int j = 0; j < 5;j++){
            startTime = System.nanoTime();
            algSorts.selectionSort(copy1,n);
            endTime = System.nanoTime();

            nanoTime = endTime - startTime;
            selectTime = nanoTime/1000000;

            startTime = System.nanoTime();
            algSorts.mergeSort(copy1,n);
            endTime = System.nanoTime();

            nanoTime = endTime - startTime;
            mergeTime = nanoTime/1000000;

            startTime = System.nanoTime();
            algSorts.quickSort(copy1,n);
            endTime = System.nanoTime();

            nanoTime = endTime - startTime;
            quickTime = nanoTime/1000000;

            System.out.println("N="+ n + ": T_ss=" + selectTime + ", T_ms=" + mergeTime + ", T_qs=" + quickTime);
         }
         System.out.println();
     }
     System.out.println("End of output");
  }
}

