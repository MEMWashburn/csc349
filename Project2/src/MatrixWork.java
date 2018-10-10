/**
 * Header
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MatrixWork {
    public static int[][] A;
    public static int[][] B;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter the input file name: ");
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
                    list.add(Integer.parseInt(split[i]));
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

        // Check:
        System.out.println("Printing Elements in the List");
        for (Integer elements : list) {
            System.out.println(elements);
        }
        System.out.println();

        int ar = list.get(0);

        // Changed to from index 0 -> index 1
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


        // Assuming br is ar for Matrix B?
        // If so changed the index to lindex since
        // ar+1 is actually an element for Matrix A
        // according to the order of the list and value of ar
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
         
    }

    private static int[][] matrixProduct(int[][]A, int[][]B)
            throws IllegalArgumentException {
        int[][] C = new int[0][0];

        if (A.length != B[0].length) {
            throw new IllegalArgumentException("A col != B row");
        }
        return C;
    }
    
    // Made a helper method to help with printing and validating that the
    // matricies were made properly
    private static void matrixPrint(int[][]matrix,int rows, int columns){
      for(int i = 0; i < rows; i++){
         for(int j = 0; j < columns;j++){
            System.out.print(matrix[i][j] + " ");
         }
         System.out.println();
      }
    }
}
