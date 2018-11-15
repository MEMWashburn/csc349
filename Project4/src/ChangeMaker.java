/**
 * CSC 349-03 Project 4
 * 16 November 2018
 * Angel de la Torre    ardelato@calpoly.edu
 * Megan Washburn       mwashbur@calpoly.edu
 */

import java.util.*;

public class ChangeMaker {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter the number of coins: ");
        int k = reader.nextInt();
        
        System.out.print("Enter the values for k coins in decreasing order: ");
        int[] d = new int[k];

        for(int i = 0; i < k;i++){
           d[i] = reader.nextInt();
        }
        System.out.println(Arrays.toString(d));
        
        System.out.print("Enter the change you would like ( 0 to quit): ");
        
        int n;

        if( (n = reader.nextInt()) == 0){
            return;
        }
       
        int[] result = change_DP(n, d);
        printResults(result,d,n);
    }
      
    public static int[] change_DP(int n, int[] d) {
        int j = n;
        int k = d.length;

        int[] C = new int[n];
        int[] A = new int[j];
        int[] B = new int[k];

        C[0] = 0;     

        for (int i = 1; i < n; i++) {
            if (j >= d[i]) {
               C[j] = C[j - d[i]];
            }
                return B;
            }
        }
        return B;
    }

    private static void printResults(result,d,n){
       System.out.println("DP algorithm results");
       System.out.println("Amount" + n);

       System.out.print("Optimal distribution: ");
       int first = 1;
       int coinCount = 0; 
       for(int i = 0; i < d.length; i++){
          if(result[i] != 0){
             if(first){
                System.out.print(result[i] + "*" + d[i] + "c ");
                frist = 0;
             }
             else{
                System.out.print("+ " + result[i] + "*" + d[i] + "c ");
             }
             coinCount += result[i];
          }
       }
       System.out.println("\nOptimal coin count: " + coinCount);
    }
               
}
