/**
 * CSC 349 Project 3
 * Angel de la Torre ardelato@calpoly.edu
 * Megan Washburn mwashbur@calpoly.edu
 *
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
        int n = list[0];
        int e1 = list[1];
        int e2 = list[2];
        int x1 = list[3];
        int x2 = list[4];
             
        for(int i = 5; i < n+5;i++){
           
     }
}
