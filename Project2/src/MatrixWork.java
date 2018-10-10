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
        for (Integer elements : list) {
            System.out.println(elements);
        }

        int ar = list.get(0);
        int ac = list.get(0);
        int lindex = 2;
        A = new int[ar][ac];
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < ac; j++) {
                A[i][j] = list.get(lindex);
                lindex++;
            }
        }

        int br = list.get(ar+1);
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
