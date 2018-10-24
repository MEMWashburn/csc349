/**
 * CSC 349 Project 3
 * Angel de la Torre ardelato@calpoly.edu
 * Megan Washburn mwashbur@calpoly.edu
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class FactoryProblem {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter the input file name: ");
        String fileNameA = reader.nextLine();
        reader.close();

        File file = new File(fileNameA);
        BufferedReader bf = null;
        List<Integer> list = new ArrayList<Integer>();

        try {
            bf = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = bf.readLine()) != null) {
                String[] split = text.split("\\s+");
                for (int i = 0; i < split.length; i++) {
                    if (!split[i].isEmpty()) {
                        list.add(Integer.parseInt(split[i]));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Need to add logic for index proper values
        int n = list.get(0);
        int e1 = list.get(1);
        int e2 = list.get(2);
        int x1 = list.get(3);
        int x2 = list.get(4);
        int[] a1 = new int[n];
        int[] a2 = new int[n];
        int[] t1 = new int[n - 1];
        int[] t2 = new int[n - 1];

        int offset = 5;
        int a1o = n*0, a2o = n*1, t1o = a2o + 1*(n - 1) + 1, t2o = a2o + 2*(n - 1) + 1;
        for (int i = 0; i < n; i++) {
            a1[i] = list.get(i + offset + a1o);
            a2[i] = list.get(i + offset + a2o);
            if (i != n - 1) {
                t1[i] = list.get(i + offset + t1o);
                t2[i] = list.get(i + offset + t2o);

            }
        }

        int[] F1 = new int[n];
        int[] F2 = new int[n];

        for (int i = 0; i < n; i++) {
            F1[i] = calculateFastest(F1, F2, t2, a1, i - 1, i, e1);
            F2[i] = calculateFastest(F2, F1, t1, a2, i - 1, i, e2);
        }
        // Add exit (x) integers to last station/index
        F1[n-1] += x1;
        F2[n-1] += x2;
        
        // Print out fastest time
        System.out.println("Fastest time is: " + Math.min(F1[n-1],F2[n-1]) + "\n");
        
        optimalRoute(F1,F2,n);    
       
       /*
        for (Integer i : F1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (Integer i : F2) {
            System.out.print(i + " ");
        }
        System.out.println();
        */
         

    }

    // Did the hand calcs, it checks out
    private static int calculateFastest(int[] F1, int[] F2, int[] t, int[] a,
                                        int tindex, int aindex, int e) {
        if (aindex == 0) { return e + a[aindex]; }
        return Math.min( (F1[aindex - 1] + a[aindex]), (F2[aindex - 1] + t[tindex] + a[aindex]) );
    }
    
    // Iterative approach to printing the best route to take
    // Based on a simple Ternary Operator (min value corresponds to line #)
    private static void optimalRoute(int[] F1, int[] F2,int n){
       System.out.println("The optimal route is:");
       for (int i=0; i < n; i++)
          System.out.println("station " + (i+1) + ", line " + (F1[i] < F2[i] ? 1 : 2));
    }

}
