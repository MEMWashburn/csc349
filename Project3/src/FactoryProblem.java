/**
 * CSC 349 Project 3
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

        for (Integer i : a1) {
            System.out.print(i);
        }
        System.out.println();
        for (Integer i : a2) {
            System.out.print(i);
        }
        System.out.println();
        for (Integer i : t1) {
            System.out.print(i);
        }
        System.out.println();
        for (Integer i : t2) {
            System.out.print(i);
        }
        System.out.println();
    }
}
