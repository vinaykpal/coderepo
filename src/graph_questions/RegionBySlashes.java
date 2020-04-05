package graph_questions;
/**
 * 959. Regions Cut By Slashes
Medium

In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.

(Note that backslash characters are escaped, so a \ is represented as "\\".)

Return the number of regions.

 

Example 1:

Input:
[
  " /",
  "/ "
]
Output: 2
Explanation: The 2x2 grid is as follows:

Example 2:

Input:
[
  " /",
  "  "
]
Output: 1
Explanation: The 2x2 grid is as follows:

Example 3:

Input:
[
  "\\/",
  "/\\"
]
Output: 4
Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)
The 2x2 grid is as follows:

Example 4:

Input:
[
  "/\\",
  "\\/"
]
Output: 5
Explanation: (Recall that because \ characters are escaped, "/\\" refers to /\, and "\\/" refers to \/.)
The 2x2 grid is as follows:

Example 5:

Input:
[
  "//",
  "/ "
]
Output: 3
Explanation: The 2x2 grid is as follows:

Note:

1 <= grid.length == grid[0].length <= 30
grid[i][j] is either '/', '\', or ' '.

 * @author t0158551
 *
 */
/*
 * Solution:
 * https://www.youtube.com/watch?v=tIZkh7mpIDo
 * Split 4 parts and Union Find
 * Split a cell in to 4 parts like this.
We give it a number top is 1, right is 2, bottom is 3 left is 4.

Two adjacent parts in different cells are contiguous regions.
In case '/', top and left are contiguous, botton and right are contiguous.
In case '\\', top and right are contiguous, bottom and left are contiguous.
In case ' ', all 4 parts are contiguous.

Congratulation.
Now you have another problem of counting the number of islands.

DFS will be good enough to solve it.
As I did in 947.Most Stones Removed with Same Row or Column
I solve it with union find.

Good luck and have fun.

Time Complexity:
O(N^2)
 */
public class RegionBySlashes {
	
	int count, n;
    int[] f;
    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        System.out.println("grid.len(): " + n);
        f = new int[n * n * 4];
        count = n * n * 4;
        for (int i = 0; i < n * n * 4; ++i)
            f[i] = i;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) union(g(i - 1, j, 2), g(i, j, 0));
                if (j > 0) union(g(i , j - 1, 1), g(i , j, 3));
                if (grid[i].charAt(j) != '/') {
                    union(g(i , j, 0), g(i , j,  1));
                    union(g(i , j, 2), g(i , j,  3));
                }
                if (grid[i].charAt(j) != '\\') {
                    union(g(i , j, 0), g(i , j,  3));
                    union(g(i , j, 2), g(i , j,  1));
                }
            }
        }
        return count;
    }

    public int find(int x) {
        if (x != f[x]) {
            f[x] = find(f[x]);
        }
        return f[x];
    }
    public void union(int x, int y) {
        x = find(x); y = find(y);
        if (x != y) {
            f[x] = y;
            count--;
        }
    }
    public int g(int i, int j, int k) {
    	System.out.println("i: "+ i +" j: "+ j +" k: " + k);
    	System.out.println("return: "+ ((i *n +j)*4 + k));
        return (i * n + j) * 4 + k;
    }
    
    public static void main(String[] args) {
    	String grid[] = {"\\/",
    					 "/\\"};
    					 
    	RegionBySlashes ob = new RegionBySlashes();
    	int numberOfregions = ob.regionsBySlashes(grid);
		System.out.println("region by slases: " + numberOfregions);
	}
}
