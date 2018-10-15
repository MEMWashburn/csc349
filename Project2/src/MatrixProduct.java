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

    }

    private boolean checkPowTwo(int matrixLen) {
        n = matrixLen;
        if (n > 0) {
            while (n % 2 == 0) {
                n /= 2;
            }
            if (n == 1) { return true; }
        }
        else if (n == 0 || n != 1) { return false; }
    }

    /*
     * Computes the product of A, B matrices using "simple" DAC algorithm.
     */
    public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
        boolean aPow = checkPowTwo(A.length);
        boolean bPow = checkPowTwo(B.length);

        if ( (A.length != A[0].length && B.length != B[0].length) && (!aPow && !bPow)) {
            throw new IllegalArgumentException("\nNot square or a power of 2.");
        }

        return null;
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
}
