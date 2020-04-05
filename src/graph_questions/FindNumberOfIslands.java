/**
 * 200. Number of Islands
Medium

4047

150

Add to List

Share
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */
package graph_questions;

import java.util.HashMap;
import java.util.Map;

public class FindNumberOfIslands {

	int[] parent;
	int isLands =0;
	
	public int numOfIsland(int grid[][]) {
	
		int r = grid.length;
		int c = grid[0].length;
		
		parent = new int[r*c];
		
		for(int i = 0; i< r ; i++) { //row
			for(int j =0 ; j< c ; j++) { //col
				if(grid[i][j] == 1) {
					int index = i * c + j; 
					parent[index] = index;
					isLands++;
				}
			}
		}
			
		for(int i = 0; i< r ; i++) { //row
			for(int j =0 ; j< c ; j++) { //col
				if(grid[i][j] == 0) {
					continue;
				}
				if( i+1 < r && ( grid[i+1][j] == 1)) {
					union(i*c+j , (i+1)*c+j);
				}
				if( j+1 < c && ( grid[i][j+1] == 1)) {
					union(i*c+j , (i*c)+(j+1));
				}
				
			}
		}
		
		return isLands;				
	}
	void union(int x, int y) {
	
		int id1 = find(x);
		int id2 = find(y);
		
		if(id1 != id2) {
			parent[id1] = id2;
			isLands--;
		}		
	}
	
	int find(int x) {
		
		if(parent[x] !=x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public static void main(String[] args) {
		/*int[][] grid = {
				{1,1,0,0,0},
				{1,1,0,0,0},
				{0,0,1,0,0},
				{0,0,0,1,1}
		};*/
		int[][] grid = {
				{1,1,1,1,0},
				{1,1,0,1,0},
				{1,1,0,0,0},
				{0,0,0,0,1}
		};		
		
		FindNumberOfIslands ob = new FindNumberOfIslands();
		int num = ob.numOfIsland(grid);
		System.out.println("num: " + num);
		//System.out.println("num using concat: ".concat(Integer.toString(num))); // concat is better as + will use stringbuilder
	}
	
	
}



