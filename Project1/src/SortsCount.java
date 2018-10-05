/* CSC 349-03
 * Angel de la Torre & Megan Washburn
 * ardelato@calpoly.edu
 * mwashbur@calpoly.edu
 *
 * 10/5/2018
 * Project 1
 */

import java.lang.*;
import java.util.Random;

public class SortsCount {

    public static void main(String[] args){
        int[] copy1 = new int[12800];
        int[] copy2 = new int[12800];
        int[] copy3 = new int[12800];

        long selectCount, mergeCount, quickCount;

        Sorts1 algSorts = new Sorts1();
        Random rand = new Random();

        System.out.println("Average number of element-comparisons in three sorting algorithms:\n");
        for(int n = 100; n <= 12800; n*=2) {
            selectCount = mergeCount = quickCount = 0;
            for(int j = 0; j < 100; j++) {
                for(int i = 0; i < 12800; i++){
                    copy1[i] = copy2[i] = copy3[i] = rand.nextInt(n);
                }

                selectCount += algSorts.selectionSort(copy1, n);

                mergeCount += algSorts.mergeSort(copy2, n);

                quickCount += algSorts.quickSort(copy3, n);
            }
            long sc = selectCount / (long)100;
            long mc = mergeCount / (long)100;
            long qc = quickCount / (long)100;

            System.out.println("N=" + n + ": C_ss=" + sc + ", C_ms=" + mc + ", C_qs=" + qc);
        }
        System.out.println();
        System.out.println("End of output");
    }
}

