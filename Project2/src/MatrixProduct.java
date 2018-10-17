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

        // Made try and catch for the matrix product
        int[][] DAC_C;
        int[][] Strassen_C;

        double startTime, endTime, nanoTime;
        double dacTime, strassenTime;

        startTime = System.nanoTime();

        DAC_C = matrixProduct_DAC(A,B);
        System.out.println("\nDAC Product matrix:");
        matrixPrint(DAC_C, DAC_C.length, DAC_C[0].length);

        endTime = System.nanoTime();

        nanoTime = endTime - startTime;
        dacTime = nanoTime / 1000000;


        startTime = System.nanoTime();

        Strassen_C = matrixProduct_Strassen(A,B);
        System.out.println("\nDAC Product matrix:");
        matrixPrint(Strassen_C, Strassen_C.length, Strassen_C[0].length);

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

        if ((aLen != A[0].length && bLen != B[0].length) && (!aPow && !bPow)) {
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
            C[1][1] = A[startRowA][startColA] * B[startRowA][startColB];
        }
        else {

        }
        return C;
    }

    /*
     * Computes the product of A, B matrices using Strassen's algorithm.
     */
    public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) {
        boolean aPow = checkPowTwo(A.length);
        boolean bPow = checkPowTwo(B.length);

        if ( (A.length != A[0].length && B.length != B[0].length) && (!aPow && !bPow)) {
            throw new IllegalArgumentException("\nNot square or a power of 2.");
        }
        return null;
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
