package graph_questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1042. Flower Planting With No Adjacent
Easy

184

222

Add to List

Share
You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.

paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.

Also, there is no garden that has more than 3 paths coming into or leaving it.

Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.

Example 1:
Input: N = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]

Example 2:
Input: N = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]

Example 3:
Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
Output: [1,2,3,4]
 * @author t0158551
 *
 */
public class FlowerPlantingNoAdjacent {

	public static int[] gardenNoAdj(int N, int[][] paths) {
		
		//create a graph
		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		//... via adjacency list
		for(int i =0 ; i < N; i++) {
			graph.put(i, new HashSet<Integer>());
		}
		
		//Add the edges 
		for (int[] path : paths) {
			int x = path[0] -1; //Due to 1-based indexing 
			int y = path[1] -1; //Due to 1-based indexing 
		
			 //Undirected edge
			graph.get(x).add(y);
            graph.get(y).add(x);

		}
		
        //Here is our solution vector where res[i] represents color of garden i+1
		int[] res = new int[N];
		
		//Now run graph painting algorithm
        
        //For each garden
		for(int i = 0; i < N ; i++) {
			int[] colors = new int[5];//Use 5 instead of 4 so we can easily use 1-based indexing of the garden colors
			
			if(graph.containsKey(i)) {
				for(int neighbor : graph.get(i)) {
					colors[res[neighbor]] = 1; //Mark the color as used if neighbor has used it before.
				}
			}
			//Now just use a color that has not been used yet
			for(int c = 4; c >=1 ; c--) {
				if(colors[c] != 1) {//colors[c] == 0 => the color has not been used yet,
					res[i] = c;//so let's use that one
				}
			}
			
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int N = 3; int[][] paths = {{1,2},{2,3},{3,1}};
		int[] res = gardenNoAdj(N, paths);
		System.out.println("output");
		for(int i : res) {
			 System.out.print(i +",");
		}
	}
}
