package maps_questions;
/**
 * 1311. Get Watched Videos by Your Friends
Medium

74

125

Add to List

Share
There are n people, each person has a unique id between 0 and n-1. Given the arrays watchedVideos and friends, where watchedVideos[i] and friends[i] contain the list of watched videos 
and the list of friends respectively for the person with id = i.

Level 1 of videos are all watched videos by your friends, level 2 of videos are all watched videos by the friends of your friends and so on. In general, the level k of videos are all 
watched videos by people with the shortest path exactly equal to k with you. Given your id and the level of videos, return the list of videos ordered by their frequencies (increasing). 
For videos with the same frequency order them alphabetically from least to greatest. 

Example 1:

Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
Output: ["B","C"] 
Explanation: 
You have id = 0 (green color in the figure) and your friends are (yellow color in the figure):
Person with id = 1 -> watchedVideos = ["C"] 
Person with id = 2 -> watchedVideos = ["B","C"] 
The frequencies of watchedVideos by your friends are: 
B -> 1 
C -> 2

Example 2:

Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
Output: ["D"]
Explanation: 
You have id = 0 (green color in the figure) and the only friend of your friends is the person with id = 3 (yellow color in the figure).

 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WatchedVideosByFriends {
		class Friend {
		    int fid;
		    int flevel;
		    Friend(int fid, int flevel) {
		        this.fid = fid;
		        this.flevel = flevel;
		    }
		}

		public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, 
		                                           int[][] friends, int id, int level) {
		    Map<String, Integer> map = new HashMap<String, Integer>();
		    Set<Integer> visited = new HashSet<Integer>();
		    visited.add(id);
		    
		    Queue<Friend> queue = new LinkedList<Friend>();
		    queue.offer(new Friend(id, level));
		    System.out.println("queue: id " + id + " level " + level);
		    
		    while (!queue.isEmpty()) {
		        int size = queue.size();
		        System.out.println("queue: size " + size);
		        
		        for (int i = 0; i < size; i++) {
		            Friend curr = queue.poll();		            
		            int fid = curr.fid;
		            int flevel = curr.flevel;
		            System.out.println("queue: fid " + fid + " flevel " + flevel);
		            if (flevel == 0) {
		                for (String video : watchedVideos.get(fid))
		                    map.put(video, map.getOrDefault(video, 0) + 1);
		                continue;
		            }
		            for (int friend : friends[fid]) {
		                if (!visited.contains(friend)) {
		                    visited.add(friend);
		                    queue.offer(new Friend(friend, flevel - 1));
		                }
		            }
		        }
		    }
		    
		    System.out.print( "map.values:  " + map.values());
		    System.out.print( "map.keySet:  " + map.keySet());
		    
		    List<String> ans = new ArrayList<String>();
		    for (String s : map.keySet()) {
		    	ans.add(s);
		    }
//		    Map<Integer, Set<String>> treemap = new TreeMap<Integer, Set<String>>();
//		    for (String key : map.keySet()) {
//		        int val = map.get(key);
//		        treemap.putIfAbsent(val, new TreeSet<String>());
//		        treemap.get(val).add(key);
//		    }
//		    
//		    List<String> ans = new ArrayList<String>();
//		    for (int key : treemap.keySet()) {
//		        ans.addAll(treemap.get(key));
//		    }
		    
		    System.out.println(" result:");
		    System.out.print(" " + ans);
		    return ans;		
		}
		
		public static void main(String[] args) {
			WatchedVideosByFriends ob1 = new WatchedVideosByFriends();
			List<List<String>> watchedVideos = new ArrayList<List<String>>();
			List<String> videos1 = new ArrayList<String>();
			videos1.add("A");
			videos1.add("B");						
			List<String> videos2 = new ArrayList<String>() {{add("C");}};
			List<String> videos3 = new ArrayList<String>() {{add("B");add("C");}};
			List<String> videos4 = new ArrayList<String>() {{add("D");}};
			watchedVideos.add(videos1);
			watchedVideos.add(videos2);
			watchedVideos.add(videos3);
			watchedVideos.add(videos4);
			
			System.out.println("input watchvideos: ");
			for(List<String> v : watchedVideos) {
				System.out.print(" " + v);
			}
			
			int[][] friends = new int[][] {{1,2},{0,3},{0,3},{1,2}};
			int id = 0; int level = 1;
			ob1.watchedVideosByFriends(watchedVideos, friends, id, level);
			//([["A","B"],["C"],["B","C"],["D"]]);
			//ob1.watchedVideosByFriends(watchedVideos, friends, id, level);
		}
}
