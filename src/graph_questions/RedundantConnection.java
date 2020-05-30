package graph_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
/**
 * 685. Redundant Connection II
Hard

In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, 
plus every node has exactly one parent, except for the root node which has no parents. The given input is a directed graph that started as a rooted tree with N nodes 
(with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 * @author t0158551
 *
 */

public class RedundantConnection {
	
    /**
    *Union Find with explanation, O(n)

This problem is very similar to "Redundant Connection". But the description on the parent/child relationships is much better clarified.

There are two cases for the tree structure to be invalid.
1) A node having two parents;
including corner case: e.g. [[4,2],[1,5],[5,2],[5,3],[2,4]]
2) A circle exists
If we can remove exactly 1 edge to achieve the tree structure, a single node can have at most two parents. 

So my solution works in two steps.
1) Check whether there is a node having two parents. 
If so, store them as candidates A and B, and set the second edge invalid. 
2) Perform normal union find. 
If the tree is now valid 
       simply return candidate B
else if candidates not existing 
       we find a circle, return current edge; 
else 
       remove candidate A instead of B.
    * 
    *  
   */
   // Method: 1  - understood
   public int[] findRedundantDirectedConnection2(int[][] edges) {
	// can1 is before can2 and has higher priority
       int[] can1 = {-1, -1};
       int[] can2 = {-1, -1};
       int[] parent = new int[edges.length + 1];
       
       // step 1, check whether there is a node with two parents
       for (int i = 0; i < edges.length; i++) {
           if (parent[edges[i][1]] == 0) {
               parent[edges[i][1]] = edges[i][0];
           } else {
        	// the child already has father
               // the newest link
               can2 = new int[] {edges[i][0], edges[i][1]};
            // the older version of link
               can1 = new int[] {parent[edges[i][1]], edges[i][1]};
            // set the current link invalid
               edges[i][1] = 0;
           }
       }
       // step 2, union find
       // reuse the parent matrix, do union find
       for (int i = 0; i < edges.length; i++) {
           parent[i] = i;
       }
       
       for (int i = 0; i < edges.length; i++) {
           if (edges[i][1] == 0) {
        	// current link is not valid
               continue;
           }
           int child = edges[i][1], father = edges[i][0];
        // Now every node only has 1 parent, so root of v is implicitly v
           if (root(parent, father) == child) { // parent of father is equal to child. loop is here
        	// there is a cycle
        	   System.out.println("there is loop");
               if (can1[0] == -1) { // no candidate
            	   // candidate not exist
                   return edges[i];
               } else {
               // candidate exist
            	   return can1;
               }
           }
        // union
           parent[child] = father;
       }
       return can2;
   }

   int root(int[] parent, int i) {
       while (i != parent[i]) {
    	// path compression, optional
           parent[i] = parent[parent[i]];
           i = parent[i];
       }   
       return i;
   }
   
   // Method: 2
	    public int[] findRedundantDirectedConnection1(int[][] edges) {
	        int N = edges.length;
	        Map<Integer, Integer> parent = new HashMap<Integer, Integer>();// child to parent map. key child edge[1] -> parent edge[0]
	        List<int[]> candidates = new ArrayList<int[]>();
	        for (int[] edge: edges) {
	            if (parent.containsKey(edge[1])) {
	                candidates.add(new int[]{parent.get(edge[1]), edge[1]});
	                candidates.add(edge);
	            } else {
	                parent.put(edge[1], edge[0]);
	            }
	        }

	        int root = orbit(1, parent).node;
	        if (candidates.isEmpty()) {
	            Set<Integer> cycle = orbit(root, parent).seen;
	            int[] ans = new int[]{0, 0};
	            for (int[] edge: edges) {
	                if (cycle.contains(edge[0]) && cycle.contains(edge[1])) {
	                    ans = edge;
	                }
	            }
	            return ans;
	        }

	        Map<Integer, List<Integer>> children = new HashMap();
	        for (int v: parent.keySet()) {
	            int pv = parent.get(v);
	            if (!children.containsKey(pv))
	                children.put(pv, new ArrayList<Integer>());
	            children.get(pv).add(v);
	        }

	        boolean[] seen = new boolean[N+1];
	        seen[0] = true;
	        Stack<Integer> stack = new Stack<Integer>();
	        stack.add(root);
	        while (!stack.isEmpty()) {
	            int node = stack.pop();
	            if (!seen[node]) {
	                seen[node] = true;
	                if (children.containsKey(node)) {
	                    for (int c: children.get(node))
	                        stack.push(c);
	                }
	            }
	        }
	        for (boolean b: seen) if (!b)
	            return candidates.get(0);
	        return candidates.get(1);
	    }

	    public OrbitResult orbit(int node, Map<Integer, Integer> parent) {
	        Set<Integer> seen = new HashSet<Integer>();
	        while (parent.containsKey(node) && !seen.contains(node)) {
	            seen.add(node);
	            node = parent.get(node);
	        }
	        return new OrbitResult(node, seen);
	    }

	   // main
	   public static void main(String[] args) {
		   RedundantConnection ob = new RedundantConnection();
/*
 * Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
  
Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
 */
		  // int[][] edges = new int[][] {{1,2},{1,3}, {2,3}}; // two parent input
		 //int[][] edges = new int[][] {{1,2},{3,1}, {2,3}}; // only loop input
		   int[][] edges = new int[][] {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}}; // loop input
//		   for(int[] e : edges)
//			   System.out.println("edge: " + e[0] + " " + e[1]);
		   
		System.out.println("find redundant connections:");
		int[] res = ob.findRedundantDirectedConnection1(edges);
		System.out.println("method1: " + res[0] + " " + res[1]);
		
		int[] res2 = ob.findRedundantDirectedConnection2(edges);
		System.out.println("method2: " + res2[0] + " " + res2[1]);
	}
}

class OrbitResult {
    int node;
    Set<Integer> seen;
    OrbitResult(int n, Set<Integer> s) {
        node = n;
        seen = s;
    }
}
