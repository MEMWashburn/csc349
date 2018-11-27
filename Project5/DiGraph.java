/**
 * CSC 349 - 03 Project 4
 * 20 November 2018
 * Angel de la Torre ardelato@calpoly.edu
 * Megan Wasburn mwashbur@calpoly.edu
 */

import java.util.*;
import java.lang.*;

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
   // Returns a boolean as a way to provide feedback to the user
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
   // Returns a boolean as a way to provide feedback to the user
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

         System.out.print("   " + (i+1) + " is connected to: ");
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

   // Returns an array of integers representing the indegrees of all vertices in
   // the graph:
   //    The i-th integer in the resulting array is the indegree of the i-th
   //    vertex 
   private Integer[] indegrees(){
      Integer[] inD = new Integer[arr.length];
      
      Arrays.fill(inD,0);
      for(int i = 0; i < arr.length; i++){
         for(int j = 0; j < arr[i].size(); j++){
            Integer indexValue = arr[i].get(j);
            inD[indexValue - 1]++;
         }
      }

      // Prints out the array of indegrees
      for(int i = 0; i < inD.length; i++){
         System.out.print(inD[i] + " ");
      }
      System.out.println();
      

      return inD;
   }

   // Returns an array containing the list of topologically sorted vertices
   //    (values in the array should represent natural vertex-numbers)
   // Note:
   //    If the graph is cyclic, throw an IllegalArgumentException exception
   public Integer[] topSort() throws IllegalArgumentException {
      Integer[] in = indegrees();
      
      // Will hold the sorted vertices
      Integer[] sortedV = new Integer[arr.length];

      Queue<Integer> q = new LinkedList<Integer>();
      
      int i;
      // Check the indegree array for all the vertices with 0 indegrees
      for(i = 0; i < arr.length; i++){
         if( in[i] == 0)
            q.add(i+1);
      }
      
      // Check if the graph is cyclic
      //    i.e. all vertices have an indegree and so nothing was added to the
      //    queue
      if( q.size() == 0)
         throw new IllegalArgumentException("Cyclic Graph");

      i = 0;
      
      while(q.size() != 0){
         
         // System.out.println(q);

         // q is in java indexing
         Integer index = q.remove();
         // sortedV holds the values in a natural Index
         sortedV[i] = index;
         i++;
         
         // Decrease the indegrees
         for(int j = 0; j < arr[index-1].size(); j++){
            Integer v = arr[index-1].get(j);
            in[v-1]--;
            if(in[v-1] == 0)
               q.add(v);
         }
      }
      return sortedV;
   }  
}   
