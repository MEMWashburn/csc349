/**
 * Header
 */

import java.io.*;
import java.util.Scanner;

public class MatrixWork {
    private static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the input file name, A: ");
        String fileNameA = reader.nextLine();

        System.out.println("Enter the input file name, B: ");
        String fileNameB = reader.nextLine();

        reader.close();
    }

    private static int[][] matrixProduct(int[][]A, int[][]B)
            throws IllegalArgumentException {
        int[][] C = new int[0][0];

        if (A.length != B[0].length) {
            throw new IllegalArgumentException("A col != B row");
        }
        return C;
    }
}
