/**
 * CSC 349 - 03 Project 4
 * 20 November 2018
 * Angel de la Torre ardelato@calpoly.edu
 * Megan Wasburn mwashbur@calpoly.edu
 */

import java.util.*;
import java.lang.Integer;

public class DiGraph {
   static LinkedList<Integer>[] arr; 

   public DiGraph(int N){
      arr = (LinkedList<Integer>[]) new LinkedList[N];

      //Initialize array with empty lists
      for(int i = 0; i < N; i++)
         arr[i] = new LinkedList<Integer>();
 
   }

   // (from) and (to) identify vertices representing the edge that needs to added
   // to the graph.
   // (to) vertix added as (from) vertex's neighbor
   //
   // Notes: 
   //    The edge should not be added if it already exists, need to check before add
   //    Vertix-numbers are given in natural numbering (starting with 1) so you
   //    should "turn" them to Java-Indexing to reflext correct connection.
   public static boolean addEdge(int from, int to){
      Integer newTo = new Integer(to);
      if( !arr[from - 1].contains(newTo)){
         arr[from - 1 ].add(newTo);
         return true;
      }
      return false;
   }
   
   // (to) vertix is removed as (from) vertex's neighbor
   //
   // Notes:
   //    Nothing is done if the edge doesn't exist
   //    Need to turn the ints from natural numbering into Java-Indexing
   public static boolean deleteEdge(int from, int to){
      Integer newTo = new Integer(to);
      if( arr[from - 1].contains(newTo)){
         arr[from - 1].remove(newTo);
         return true;
      }
      return false;
   }

   // Computes and returns the number of edges in the graph
   //
   // Need to check for duplicates
   public int edgeCount(){
      int numEdges = 0;
      
      for(int i = 0; i < arr.length; i++){
         numEdges += arr[i].size();
      }
      return numEdges;
   }

   // Returns the number of vertices in the graph
   public int vertexCount(){
      return arr.length;
   }

   // Outputs the graph such that:
   //    For each vertex i (from 0 to N-1) outputs a line:
   //       i is connected to: x1, ..., xk (where x1, ..., xk are vertices that
   //          are adjacent to i)
   // Note:
   //    Numbering of vertices in the output should be natural, starting with 1
   //    Separate two neighbors with a comma (no comma after the last neighbor)
   public void print(){
      int alen = arr.length;

      for( int i = 0; i < alen; i++){
         // May have to do it as .toArray(new Integer[arr[alen].size()]) 
         LinkedList<Integer> edges = arr[i];

         System.out.print( (i+1) + " is connected to: ");
         for( int j = 0; j < edges.size(); j++){
            if( j == 0)
               System.out.print(edges.get(j));
            else {
               System.out.print(", " + edges.get(j));
            }
         }
         System.out.println();
      }
      System.out.println();
   }
}   
