/**
 * 947. Most Stones Removed with Same Row or Column
Medium
On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5

Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Example 3:

Input: stones = [[0,0]]
Output: 0

Note:

1 <= stones.length <= 1000
0 <= stones[i][j] < 10000
 */
package graph_questions;

/*
 * Solution:
 * Problem:
we can remove a stone if and only if,
there is another stone in the same column OR row.
We try to remove as many as stones as possible.

One sentence to solve:
Connected stones can be reduced to 1 stone,
the maximum stones can be removed = stones number - islands number.
so just count the number of "islands".

4. Count the number of islands
We call a connected graph as an island.
One island must have at least one stone left.
The maximum stones can be removed = stones number - islands number

The whole problem is transferred to:
What is the number of islands?

You can show all your skills on a DFS implementation,
and solve this problem as a normal one.


5. Unify index
Struggle between rows and cols?
You may duplicate your codes when you try to the same thing on rows and cols.
In fact, no logical difference between col index and rows index.

An easy trick is that, add 10000 to col index.
So we use 0 ~ 9999 for row index and 10000 ~ 19999 for col.


6. Search on the index, not the points
When we search on points,
we alternately change our view on a row and on a col.

We think:
a row index, connect two stones on this row
a col index, connect two stones on this col.

In another view：
A stone, connect a row index and col.

Have this idea in mind, the solution can be much simpler.
The number of islands of points,
is the same as the number of islands of indexes.


7. Union-Find
I use union find to solve this problem.
As I mentioned, the elements are not the points, but the indexes.

for each point, union two indexes.
return points number - union number
Copy a template of union-find,
write 2 lines above,
you can solve this problem in several minutes.


Complexity
union and find functions have worst case O(N), amortize O(1)
The whole union-find solution with path compression,
has O(N) Time, O(N) Space

 * 
 */

import java.util.HashMap;
import java.util.Map;

public class RemoveStones {

	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	static int islands = 0;
/*
 * union(stones[i][0], ~stones[i][1]);   <---- Note use of ~ here
 * stones[i] is the i-th stone.
stones[i][0] is the row of the i-th stone
stones[i][1] is the column of the i-th stone

unary operator tilde (~) is equivalent to x = -x -1. This operation is being used to represent both row and columns in the same dimension. We could have also used:
row_rep = row_id
col_rep = 10000+col_id

In all,
union(stones[i][0], stones[i][1] ) joins the row and the column of the i-th stone.
 */
	//test code
    public static int removeStones(final int[][] stones) {
    	System.out.println("stones.length: " + stones.length);
        for (int i = 0; i < stones.length; ++i){
        	//int tempy = stones[i][1];
        	//tempy = ~tempy;
        	//System.out.println("islands: " + islands);
        	union(stones[i][0], stones[i][1]);
        	//union(stones[i][0], ~stones[i][1]);
        }
        System.out.println("number of isLands: " + islands);
        return stones.length - islands;
    }

    public static int find(int x) {
        if (map.putIfAbsent(x, x) == null) {        	
        	islands++;
        //	System.out.println("find and put islands++: " + islands +" x: " + x);
        }            
        if (x != map.get(x))
        	map.put(x, find(map.get(x)));
        return map.get(x);
    }

    public static void union(int x, int y) {
    	//System.out.println("union x: " + x + " y: " + y);
        x = find(x);
        y = find(y);
        if (x != y) {
        	map.put(x, y);
            islands--;
           // System.out.println("union islands-- : " + islands + "x: " + x+ "y: " + y  );
        }
    }
    
    public static void main(String[] args) {
    	//int[][] stones = {{0,0},{0,2},{1,1},{2,0},{2,2}};
    	int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
    //	removeStones(stones);
    	System.out.println("removestones: " + removeStones(stones));
	}
}
