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

        System.out.print("Enter the number of coin-denominations and " + 
            "the set of coin values: ");
        
        int k = reader.nextInt();        
        int[] d = new int[k];

        for(int i = 0; i < k;i++){
           d[i] = reader.nextInt();
        }

        //System.out.println(Arrays.toString(d));
        
        int n = 1;

        while(true){
            System.out.print("Enter a positive amount to be changed (0 to quit): ");
            if( (n = reader.nextInt()) == 0)
               break;
       
            int[] result = change_DP(n, d);
            System.out.println("DP algorithm results");
            printResults(result,d,n);
            
            result = change_greedy(n,d);
            System.out.println("Greedy algorithm results");
            printResults(result,d,n);

        }

        System.out.println("Thanks for playing. Good bye.");
    }
      
    public static int[] change_DP(int n, int[] d) {
        // C will hold the number of coins needed
        int[] C = new int[n+1];
        // A will hold the minimum index for a coin used
        int[] A = new int[n+1];
        // B will hold the frequency of each coin used for the change
        int[] B = new int[d.length];
         
        C[0] = 0;
        A[0] = 0;

        int min = d.length;
        int index = 0; 
        for(int j=1; j <= n;j++){
           min = d.length;
           for(int i = 0; i < d.length;i++){
              if( (j-d[i]) >= 0){
                 if(min > i){
                    min = i;
                    index = j-d[i];
                    A[j] = i;
                 }
              }
           }

           C[j] = 1 + C[index];
       }
       //System.out.println(Arrays.toString(C));
       //System.out.println(Arrays.toString(A));

       while( n > 0){
          index = A[n];
          B[index] += 1;
          n -= d[index];
       }
       //System.out.println(Arrays.toString(B));
       return B;
    }
    
    public static int[] change_greedy(int n, int[] d){
         int[] B = new int[d.length];
         
         int i = 0;
         while(n >= 0 && i < d.length){
            if( (n-d[i]) >= 0){
               B[i] += 1;
               n = n - d[i];
            }
            else {
               i++;
            }
         }
         return B;
    }

    private static void printResults(int[] result,int[] d,int n){
       System.out.println("Amount: " + n);

       System.out.print("Optimal distribution: ");
       boolean first = true;
       int coinCount = 0; 
       for(int i = 0; i < d.length; i++){
          if(result[i] != 0){
             if(first){
                System.out.print(result[i] + "*" + d[i] + "c ");
                first = false;
             }
             else{
                System.out.print("+ " + result[i] + "*" + d[i] + "c ");
             }
             coinCount += result[i];
          }
       }
       System.out.println("\nOptimal coin count: " + coinCount + "\n");
    }
               
}
