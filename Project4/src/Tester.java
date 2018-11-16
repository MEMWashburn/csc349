/**
 * CSC 349-03 Project 4
 * 16 November 2018
 * Angel de la Torre    ardelato@calpoly.edu
 * Megan Washburn       mwashbur@calpoly.edu
 */

import java.util.*;

public class Tester {
    public static void main(String args[]) {

        int[] set1 = {100, 50, 25, 10, 5, 1};
        int[] set2 = {100, 50, 20, 15, 10, 5, 3, 2, 1};
        int[] set3 = {64, 32, 16, 8, 4, 2, 1};
        int[] set4 = {100, 50, 25, 10, 1};
        int[] set5 = {66, 25, 27, 18, 10, 1};

        int[] dpResult;
        int[] greedyResult;

        int n = 200;

        int set1Matches;
        int set2Matches;
        int set3Matches;
        int set4Matches;
        int set5Matches;

        set1Matches = set2Matches = set3Matches = set4Matches = set5Matches = 0;

        for (int j = 1; j <= n; j++) {
            //Set 1
            dpResult = ChangeMaker.change_DP(j, set1);
            greedyResult = ChangeMaker.change_greedy(j, set1);
            if (Arrays.equals(dpResult, greedyResult))
                set1Matches++;

            //Set 2
            dpResult = ChangeMaker.change_DP(j, set2);
            greedyResult = ChangeMaker.change_greedy(j, set2);
            if (Arrays.equals(dpResult, greedyResult))
                set2Matches++;

            //Set 3
            dpResult = ChangeMaker.change_DP(j, set3);
            greedyResult = ChangeMaker.change_greedy(j, set3);
            if (Arrays.equals(dpResult, greedyResult))
                set3Matches++;

            //Set 4
            dpResult = ChangeMaker.change_DP(j, set4);
            greedyResult = ChangeMaker.change_greedy(j, set4);
            if (Arrays.equals(dpResult, greedyResult))
                set4Matches++;

            //Set 5
            dpResult = ChangeMaker.change_DP(j, set5);
            greedyResult = ChangeMaker.change_greedy(j, set5);
            if (Arrays.equals(dpResult, greedyResult))
                set5Matches++;

        }

        System.out.println("Testing change_DP and change_greedy algorithms");
        System.out.println("Testing set1: " + set1Matches + " matches in " + n + " tests");
        System.out.println("Testing set2: " + set2Matches + " matches in " + n + " tests");
        System.out.println("Testing set3: " + set3Matches + " matches in " + n + " tests");
        System.out.println("Testing set4: " + set4Matches + " matches in " + n + " tests");
        System.out.println("Testing set5: " + set5Matches + " matches in " + n + " tests");
    }

}
