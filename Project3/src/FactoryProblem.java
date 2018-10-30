/**
 * CSC 349 Project 3
 * 26 October 2018
 * Angel de la Torre ardelato@calpoly.edu
 * Megan Washburn mwashbur@calpoly.edu
 */

import java.io.*;
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
            String text;

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

        int[] l1 = new int[n-1];
        int[] l2 = new int[n-1];

        int offset = 5;
        int a1o = n * 0, a2o = n * 1, t1o = a2o + 1 * (n - 1) + 1, t2o = a2o + 2 * (n - 1) + 1;
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
        int fpt;
        int lpt;
        
        for (int i = 0; i < n; i++) {
            int[] vals1 = calculateFastest(F1, F2, t2, a1, i - 1, i, e1, 1);
            int[] vals2 = calculateFastest(F2, F1, t1, a2, i - 1, i, e2, 2);
            F1[i] = vals1[0];
            F2[i] = vals2[0];
            // l[]s are a size of 5 or n-1, and we don't care about
            // when i = 0
            if (i != 0) {
                l1[i-1] = vals1[1];
                l2[i-1] = vals2[1];
            }
        }
        // Added the l pointer like in the example
        // l* wil hold the last line from where to best exit from
        lpt = F1[n - 1] + x1 < F2[n - 1] + x2 ? 1:2;
        
        // Added the f pointer like in the example
        // f* will hold the min frim the last stations + exit values
        fpt = Math.min(F1[n - 1] + x1,F2[n - 1] + x2);

        // Print out fastest time
        System.out.println("Fastest time is: " + fpt + "\n");

        optimalRoute(lpt,l1, l2);
       
    }

    // Did the hand calcs, it checks out
    private static int[] calculateFastest(int[] F1, int[] F2, int[] t, int[] a,
                                          int tindex, int aindex, int e, int line) {
        int[] vals = new int[2];
        if (aindex == 0) {
            vals[0] = e + a[aindex];
            vals[1] = (line == 1? 1:2);
            return vals;
        }
        // Separated to check which precedent line yielded fastest path
        int f1 = (F1[aindex - 1] + a[aindex]);
        int f2 = (F2[aindex - 1] + t[tindex] + a[aindex]);

        if (f1 < f2 ) {
            if (line == 1) { vals[1] = 1; }
            if (line == 2) { vals[1] = 2; }
        } else {
            if (line == 1) { vals[1] = 2; }
            if (line == 2) { vals[1] = 1; }
        }
        vals[0] = Math.min(f1, f2);
        return vals;
    }

    // Iterative approach to printing the best route to take
    private static void optimalRoute(int lpt, int[] l1, int[] l2) {
        int l[] = new int[l1.length];
        int i; 
        /*System.out.println("l values:");
        for (int i = 0; i < l1.length; i++) {
            System.out.println((i + 2) + ":  l1: " + l1[i] + ", l2: " + l2[i]);
        }*/

        System.out.println("The optimal route is:");
        
        int currentLine = lpt;
        
        // Have to work our way backwards like the in example
        // Save the values so we can then iterate the print properly
        for (i = l1.length-1; i >= 0; i--) {
            if (currentLine == 1) {
                currentLine = l1[i];
            } else {
                currentLine = l2[i];

            }
            l[i] = currentLine;
        }
        
        for(i = 0; i < l.length; i++){
            System.out.println("station " + (i + 1) + ", line " + l[i]);
        }
        System.out.println("station " + (i+1) + ", line " + lpt);
    }
}
