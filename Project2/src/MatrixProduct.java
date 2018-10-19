/**
 * Angel de la Torre and Megan Washburn
 *
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MatrixProduct {
    public static int[][] A;
    public static int[][] B;

    // We can't have a main method for this part
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
        int ar = list.get(0);
        int ac = list.get(1);
        int lindex = 2;
        A = new int[ar][ac];
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < ac; j++) {
                A[i][j] = list.get(lindex);
                lindex++;
            }
        }
        // Printing out the matrix with a helper method
        System.out.println("Printing Matrix A");
        matrixPrint(A,ar,ac);
        System.out.println();

        int br = list.get(lindex);
        lindex++;
        int bc = list.get(lindex);
        lindex++;

        B = new int[br][bc];
        for (int i = 0; i < br; i++) {
            for (int j = 0; j < bc; j++) {
                B[i][j] = list.get(lindex);
                lindex++;
            }
        }
        System.out.println("Printing Matrix B");
        matrixPrint(B,br,bc);
        System.out.println();

        int[][] DAC_C;
        int[][] Strassen_C;

        double startTime, endTime, nanoTime;
        double dacTime, strassenTime;

        startTime = System.nanoTime();
        
        // Added try and catch
        try {
           DAC_C = matrixProduct_DAC(A,B);
           System.out.println("\nDAC Product matrix:");
           matrixPrint(DAC_C, DAC_C.length, DAC_C[0].length);
        } catch (IllegalArgumentException e){
           System.out.println(e.getMessage());
        }

        endTime = System.nanoTime();

        nanoTime = endTime - startTime;
        dacTime = nanoTime / 1000000;


        startTime = System.nanoTime();
        
        // Added try and catch
        try {
           Strassen_C = matrixProduct_Strassen(A,B);
           //Changed printout message DAC->Strassen
           System.out.println("\nStrassen Product matrix:");
           matrixPrint(Strassen_C, Strassen_C.length, Strassen_C[0].length);
        } catch (IllegalArgumentException e){
           System.out.println(e.getMessage());
        }

        endTime = System.nanoTime();

        nanoTime = endTime - startTime;
        strassenTime = nanoTime / 1000000;

        System.out.println("Time for DAC Matrix Product: " + dacTime);
        System.out.println("Time for Strassen Matrix Product: " + strassenTime);
    }

    /*
     * Computes the product of A, B matrices using "simple" DAC algorithm.
     */
    public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
        boolean aPow = checkPowTwo(A.length);
        boolean bPow = checkPowTwo(B.length);
        int aLen = A.length;
        int bLen = B.length;
         
        // Couldn't find where A dim = B dim test so I added it to the exception
        if ((aLen != A[0].length && bLen != B[0].length) && (!aPow && !bPow) &&
            aLen == bLen) {
            throw new IllegalArgumentException("\nNot square or a power of 2.");
        }

        // Defining C[1..n, 1..n] matrix. Confirmed aLen == A[0].length (#r = #c), and
        // A dim = B dim, so fine just to use aLen to check
        int n = aLen;
        int[][] C = new int[n][n];
        //TODO: Determine actual start rows and cols
        int startRowA = 0, startColA = 0, startRowB = 0, startColB = 0;
        C = matProd_DAC(A, startRowA, startColA, B, startRowB, startColB, n);

        return C;
    }

    /*
     * Returns matrix of brand new size, n x n
     */
    private static int[][] matProd_DAC(int[][] A, int startRowA, int startColA,
                                       int[][] B, int startRowB, int startColB,
                                       int n) {
        int[][] C = new int[n][n];
        // Base case check
        if (n == 1) {
            //Changed indexes to 0
            C[0][0] = A[startRowA][startColA] * B[startRowB][startColB];
        }
        else {
            int newN = n/2;

            //C11
            // (A11 * B11) + (A12 * B21)
            int [][] C11 =  ADD(
               matProd_DAC(A, startRowA, startColA, B, startRowB, startColB, newN),
               matProd_DAC(A, startRowA, startColA+newN, B, startRowB + newN, startColB, newN));
            //C12
            // (A11 * B12) + (A12 * B22)
            int[][] C12 = ADD(
               matProd_DAC(A, startRowA, startColA, B, startRowB, startColB + newN, newN),
               matProd_DAC(A, startRowA, startColA+newN, 
                  B, startRowB + newN, startColB + newN, newN));
            
            //C21
            // (A21 * B11) + (A22 * B21)
            int[][] C21 = ADD(
               matProd_DAC(A, startRowA + newN, startColA, B, startRowB, startColB, newN),
               matProd_DAC(A, startRowA + newN, startColA+newN, 
                  B, startRowB + newN, startColB,newN));
            
            //C22
            // (A21 * B12) + (A22 * B22)
            int[][] C22 = ADD(
               matProd_DAC(A, startRowA + newN, startColA, B, startRowB, startColB + newN, newN),
               matProd_DAC(A,startRowA + newN, startColA+newN, 
                  B, startRowB + newN, startColB + newN, newN));
            
            Merge(C,C11,C12,C21,C22);
        }
        
        return C;
    }

    /*
     * Computes the product of A, B matrices using Strassen's algorithm.
     */
    public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) {
        boolean aPow = checkPowTwo(A.length);
        boolean bPow = checkPowTwo(B.length);

        if ( (A.length != A[0].length && B.length != B[0].length) && (!aPow && !bPow)
           && A.length == B.length) {
            throw new IllegalArgumentException("\nNot square or a power of 2.");
        }
        return null;
    }


    /*
     * Helper method for adding the matricies
     */
    // Expected matricies do not have the right values in each slot, need to
    // correct it
    private static int[][] ADD( int[][]A, int[][]B){
       int n = A.length;
       int[][] C = new int[n][n];
       for(int i=0; i < n;i++){
          for(int j=0; j<n; j++){
             C[i][j]= A[i][j] + B[i][j];
          }
       }
       return C;
    }

    private static void Merge(int[][] C, int[][] C11, int[][]C12, int[][]C21, int[][]C22){
       int n = C11.length;
       
       for(int i = 0; i < n; i++){
          for(int j = 0; j < n;j++){
             C[i][j] = C11[i][j];
             C[i][j+n] = C12[i][j];
             C[i+n][j] = C21[i][j];
             C[i+n][j+n] = C22[i][j];
          }
       }
    }

    /*
     * Helper method to check if matrix lengths are powers of two
     */
    private static boolean checkPowTwo(int matrixLen) {
        int n = matrixLen;
        if (n > 0) {
            while (n % 2 == 0) {
                n /= 2;
            }
            if (n == 1) { return true; }
        }
        //else if (n == 0 || n != 1) { return false; }
        return false;
    }

    /* Made a helper method to help with printing and validating that the
     * matricies were made properly
     */
    private static void matrixPrint(int[][]matrix,int rows, int columns){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
