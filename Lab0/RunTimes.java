/* CPE 349-03-04 Lab 0
 * Megan Washburn & Angel de la Torre
 */
import java.lang.*;

class RunTimes {
    public static void main(String[] args) {
        long startTime;
        long endTime;
        long n, nanTime;

        Algorithms algs = new Algorithms();

        System.out.println("Logarithmic algorithm's running times:");
        for (n = (long)1000; n <= (long)100000000; n*=2) {
            startTime = System.nanoTime();
            algs.logarithmicAlgorithm(n);
            endTime = System.nanoTime();
            System.out.print("\tT(" + n + "): ");
            nanTime = endTime - startTime;
            System.out.println(nanTime / (long)1000000);
        }
        System.out.println();

        System.out.println("Linear algorithm's running times:");
        for (n = (long)1000; n <= (long)100000000; n*=2) {
            startTime = System.nanoTime();
            algs.linearAlgorithm(n);
            endTime = System.nanoTime();
            System.out.print("\tT(" + n + "): ");
            nanTime = endTime - startTime;
            System.out.println(nanTime / (long)1000000);
        }
        System.out.println();

        System.out.println("NlogN algorithm's running times:");
        for (n = (long)1000; n <= (long)100000000; n*=2) {
            startTime = System.nanoTime();
            algs.NlogNAlgorithm(n);
            endTime = System.nanoTime();
            System.out.print("\tT(" + n + "): ");
            nanTime = endTime - startTime;
            System.out.println(nanTime / (long)1000000);
        }
        System.out.println();

        System.out.println("Quadratic algorithm's running times:");
        for (n = (long)1000; n <= (long)512000; n*=2) {
            startTime = System.nanoTime();
            algs.quadraticAlgorithm(n);
            endTime = System.nanoTime();
            System.out.print("\tT(" + n + "): ");
            nanTime = endTime - startTime;
            System.out.println(nanTime / (long)1000000);
        }
        System.out.println();

        System.out.println("Cubic algorithm's running times:");
        for (n = (long)1000; n <= (long)8000; n*=2) {
            startTime = System.nanoTime();
            algs.cubicAlgorithm(n);
            endTime = System.nanoTime();
            System.out.print("\tT(" + n + "): ");
            nanTime = endTime - startTime;
            System.out.println(nanTime / (long)1000000);
        }
        System.out.println();
    }
}
