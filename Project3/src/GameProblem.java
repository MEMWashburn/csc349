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

public class GameProblem {
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
        int m = list.get(1);
        int[][] A = new int[n][m];

        int listIndex = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = list.get(listIndex);
                listIndex++;
            }
        }
/*
        for (int i = 0; i < n; i++) {
           for(int j = 0; j < m;j++){
              System.out.print(A[i][j] + " ");
           }
           System.out.println();
        }
*/
        game(n, m, A);
    }

    public static void game(int n, int m, int[][] A) {
        // Will hold the max scores
        int[][] S = new int[n][m];
        // Auxiliary Table, will hold the route
        char[][] R = new char[n][m];

        // Starting Max value as the base element, i.e. bottom right corner
        int max = A[n - 1][m - 1];

        // values to hold the indexes for the starting position to have the
        // highest score
        int x = 0;
        int y = 0;

        //Building from bottom right corner up to upper left corner
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    S[i][j] = A[n - 1][m - 1];
                    R[i][j] = 'e';
                } else if (j == m - 1) {
                    S[i][j] = Math.max(S[i + 1][m - 1], 0) + A[i][m - 1];
                    R[i][j] = S[i + 1][m - 1] > 0 ? 'd' : 'e';
                } else if (i == n - 1) {
                    S[i][j] = Math.max(S[n - 1][j + 1], 0) + A[n - 1][j];
                    R[i][j] = S[n - 1][j + 1] > 0 ? 'r' : 'e';
                } else {
                    S[i][j] = Math.max(S[i + 1][j], S[i][j + 1]) + A[i][j];
                    R[i][j] = S[i + 1][j] > S[i][j + 1] ? 'd' : 'r';
                }

                if (max < S[i][j]) {
                    max = S[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println("Best score: " + max);
        bestRoute(R, x, y);
       /*
       System.out.println("Starting position is " +"[" + x + "]" +"[" + y + "]");
       System.out.println("S Table");      
       for(int i = 0; i < n; i++){
          for(int j = 0; j < m; j++){
             System.out.print(S[i][j] + " ");
          }
          System.out.println();
       }

       System.out.println("\nR Table");
       for(int i = 0; i < n; i++){
          for(int j = 0; j < m; j++){
             System.out.print(R[i][j] + " ");
          }
          System.out.println();
       }*/
    }

    public static void bestRoute(char[][] R, int rowIndex, int colIndex) {
        System.out.print("Best Route: ");

        // Indexing is supposed to be outputted as natural i.e. starts 1
        // so added 1 to indexes only to the print statments
        char c = R[rowIndex][colIndex];
        System.out.print("[" + (rowIndex + 1) + "," + (colIndex + 1) + "] to ");

        // If c is 'e' then the only path is to exit, so stop the loop
        while (c != 'e') {
            switch (c) {
                // Move to the right
                case 'r':
                    colIndex++;
                    System.out.print("[" + (rowIndex + 1) + "," + (colIndex + 1) + "] to ");
                    break;
                // Move down
                case 'd':
                    rowIndex++;
                    System.out.print("[" + (rowIndex + 1) + "," + (colIndex + 1) + "] to ");
                    break;

            }
            c = R[rowIndex][colIndex];
        }
        System.out.println("exit");
    }
}
