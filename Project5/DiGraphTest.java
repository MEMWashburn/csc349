/**
 * CSC 349 - 03 Project 4
 * 20 November 2018
 * Angel de la Torre ardelato@calpoly.edu
 * Megan Wasburn mwashbur@calpoly.edu
 */

import java.util.*;

public class DiGraphTest {

    public static void main(String[] args){
        /**
         * Part III and VI
         * i, l, s
         */

        /**
         * Part I and II
         * a, d, t
         */
        Scanner reader = new Scanner(System.in);

        // Prompt user for number of vertices
        System.out.print("Enter the number of vertices: ");
        DiGraph graph = new DiGraph(reader.nextInt());

        // Print menu for the user (only print once)
        // As long as the user does not choose to quit, do the following:
        //    * Analyze the choice and execute via a switch statement
        //       * Default case will print "invalid menu choice"
        //    * Prompt the user for the appropriate parameters in addEdge &
        //       deleteEdge
        //    * For every request, output feedback
        //       * Added/Deleted - "Edge (x,y) was added/deleted"
        //       * Edge/Vertex Count - "Number of edges | vertices is: "
        //       * Print Graph - "The graph is the following: "
        //
        // Note:
        //    In all communications with the user, the vertex numbering is
        //    natural, starting at 1

        String menu = "Choose one of the following operations:\n"
                + "   -add edge (enter a)\n"
                + "   -delete edge (enter d)\n"
                + "   -edge count (enter e)\n"
                + "   -vertex count (enter v)\n"
                + "   -print graph (enter p)\n"
                + "   -topological sort (enter t)\n"
                + "   -is there a path (enter i)\n"
                + "   -length of the path (enter l)\n"
                + "   -shortest path (enter s)\n"
                + "   -print breadth-first-tree (enter b)\n"
                + "   -Quit (enter q)\n";

        System.out.print(menu + "\n> ");

        // Read a line
        String option = reader.nextLine();
        char o = ' ';

        while(o != 'q') {
            if (option.length() == 0){
                while(reader.hasNext() && option.length() == 0)
                    option = reader.nextLine();
            }

            if(option.length() > 2)
                System.out.println("Invalid menu choice");

            else{
                o = option.charAt(0);
                switch (o){
                    case 'a':
                        helperAdd(graph, reader);
                        break;
                    case 'd':
                        helperDelete(graph, reader);
                        break;
                    case 'e':
                        System.out.println("Number of edges is: " + graph.edgeCount() + "\n");
                        break;
                    case 'v':
                        System.out.println("Number of vertices is: " + graph.vertexCount() + "\n");
                        break;
                    case 'p':
                        System.out.println("The graph is the following: ");
                        graph.print();
                        break;
                    case 't':
                        helperTSort(graph);
                        break;
                    case 'q':
                        break;
                    case 'i':
                        helperBoolPath(graph,reader);
                        break;
                    case 'l':
                        helperLengthPath(graph,reader);
                        break;
                    case 's':
                        helperPrintPath(graph,reader);
                        break;
                    case 'b':
                        helperPrintBFT(graph,reader);
                        break;
                    default:
                        System.out.println("Invalid menu choice");
                }
            }
            System.out.print("> ");
            if(reader.hasNext())
                option = reader.nextLine();
        }
        System.out.println("Good bye");
    }

    // Helper Method to carry out the functionality for the add command
    private static void helperAdd(DiGraph graph,Scanner reader){
        System.out.print("Enter the 'from' and 'to' vertices of the edge to add: ");

        int from = reader.nextInt();
        int to = reader.nextInt();

        if(graph.addEdge(from,to))
            System.out.println("Edge (" + from + ", " + to + ") was added\n");
        else {
            System.out.println("Edge has already been added to the graph\n");
        }
    }

    // Helper Method to carry out the functionality for the delete command
    private static void helperDelete(DiGraph graph,Scanner reader){
        System.out.print("Enter the 'from' and 'to' vertices of the edge to delete: ");

        int from = reader.nextInt();
        int to = reader.nextInt();

        if(graph.deleteEdge(from,to))
            System.out.println("Edge (" + from + ", " + to + ") was deleted\n");
        else {
            System.out.println("Edge does not already exist in the graph\n");
        }
    }

    // Helper Method to carry out the functionality for the topological sort
    // command
    private static void helperTSort(DiGraph graph){
        Integer[] sortedList;
        try {
            sortedList = graph.topSort();
            System.out.print("The topologically sorted sequence of vertices: ");

            for(int i = 0; i < sortedList.length; i++){
                if( i == 0)
                    System.out.print(sortedList[i]);
                else{
                    System.out.print(", " + sortedList[i]);
                }
            }
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    // Helper Method to carry out the functionality for isTherePath command
    private static void helperBoolPath(DiGraph graph, Scanner reader){
      System.out.println("Enter the 'from' and 'to' vertices to see if there is a path: ");

      int from = reader.nextInt();
      int to = reader.nextInt();

      if(graph.isTherePath(from,to))
         System.out.println("There is a path from vertex " + from + " to the vertex " + to);
      else {
         System.out.println("There is no path from vertex " + from + " to the vertex " + to);
      }
      System.out.println();

    }

    private static void helperLengthPath(DiGraph graph, Scanner reader){
      System.out.println("Enter the 'from' and 'to' vertices to see the length of the path: ");

      int from = reader.nextInt();
      int to = reader.nextInt();
      
      System.out.println("The length for the path from vertex " + from + " to the vertex " + to + " is " + graph.lengthOfPath(from,to));
      System.out.println();
    }
    
    private static void helperPrintPath(DiGraph graph, Scanner reader){
      System.out.println("Enter the 'from' and 'to' vertices to see if there is a path: ");

      int from = reader.nextInt();
      int to = reader.nextInt();

      graph.printPath(from,to);
      System.out.println();
    }

    private static void helperPrintBFT(DiGraph graph, Scanner reader){
      System.out.println("Enter the source vertex: ");

      int s = reader.nextInt();

      graph.printTree(s);
    }

}
