/**
 * CSC 349 - 03 Project 4
 * 20 November 2018
 * Angel de la Torre ardelato@calpoly.edu
 * Megan Wasburn mwashbur@calpoly.edu
 */

import java.util.*

public class DiGraph {
   private LinkedList<Integer>[] arr; 

   public DiGraph(int N){
      arr = (LinkedList<Integer>[]) new LinkedList[N];
   }

   // (from) and (to) identify vertices representing the edge that needs to added
   // to the graph.
   // (to) vertix added as from vertex's neighbor
   //
   // Notes: 
   //    The edge should not be added if it already exists, need to check before add
   //    Vertix-numbers are given in natural numbering (starting with 1) so you
   //    should "turn" them to Java-Indexing to reflext correct connection.
   public static void addEdge(int from, int to){
      if( !arr[from - 1].contains(Integer(to))){
         arr[from - 1 ].add(Integer(to));
      }
   }

   public static void deleteEdge(int from, int to){
      if( arr[from - 1].contains(Integer(to))){
         arr[from - 1].remove(Integer(to));
      }
   }


   
