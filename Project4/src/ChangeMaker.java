/**
 * CSC 349-03 Project 4
 * 16 November 2018
 * Angel de la Torre    ardelato@calpoly.edu
 * Megan Washburn       mwashbur@calpoly.edu
 */
public class ChangeMaker {
    public static void main(String args[]) {
        int n = 87;
        int[] d = {100, 25, 10, 5, 1};

        int[] result = change_DP(n, d);
        int i = 0;
        for (int coin : result) {
            i++;
            System.out.println(i + "th denomination frequency: " + coin);
        }
    }

    public static int[] change_DP(int n, int[] d) {
        int j = n;
        int k = d.length;

        int[] C = new int[n];
        int[] A = new int[j];
        int[] B = new int[k];

        if (j == 0) { return B; }
        else {
            for (int i = 0; i < n; i++) {
                if (j >= d[i]) {
                    C[j] = C[j - d[i]];
                }
                return B;
            }
        }
        return B;
    }
}
