/**
 * 841. Keys and Rooms
Medium

674

61

Add to List

Share
There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room. 

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0). 

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:  
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:

Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
 */
package graph_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class CanVisitAllRoomsKey {
	/*
	 * Recursive DFS:
Use a set to track rooms that have been visited.
Starting from room 0, add 0 to the visited set, for each key in room 0, 
if the key is not visited yet, add the key to visited and recursively visit keys in that room,
otherwise do not visit the room again.
We can visit all rooms only when the size of visited set equals to the size of the rooms.

Iterative BFS:
Use a queue to keep the keys we found in a room, only enqueue the keys not visited yet.
Repeat until the queue is empty, and check if size of visited set equals size of rooms.
	 */
	public static boolean canVisitAllRoomDFS(List<List<Integer>> rooms) {
		
		Stack<Integer> dfs = new Stack<Integer>();
		dfs.add(0);// room 0
		
		Set<Integer> visitedSet = new HashSet<Integer>();
		visitedSet.add(0);
		
		while(!dfs.isEmpty()) {
			int i = dfs.pop();
			for(int j : rooms.get(i)) {
				if(!visitedSet.contains(j)) {
					visitedSet.add(j);
					dfs.add(j);
					
					if(visitedSet.size() == rooms.size()) {
						return true;
					}
				}
			}			
		}
			return (visitedSet.size() == rooms.size());	
	}
	
	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		//lists.add(new ArrayList<Integer>( Arrays.asList(10, 20, 30) ));
		lists.add(Arrays.asList(1,3));
		lists.add(Arrays.asList(3,2,1));
		lists.add(Arrays.asList(2));
		lists.add(Arrays.asList(0));
		
		for (List<Integer> l : lists) {
			   System.out.println(l);
			}
		System.out.println("canVisitAllRoomDFS: " + canVisitAllRoomDFS(lists));
	}

}
