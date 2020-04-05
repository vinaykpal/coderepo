/**
 * 1161. Maximum Level Sum of a Binary Tree
Medium

209

13

Add to List

Share
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

 

Example 1:



Input: [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
 * @author t0158551
 *
 */
package binaryTreeQues;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

//import binaryTreeQues.*;

public class MaxSumLevelOfBinaryTree {

	/*
	 * Method 1: BFS

Use BFS to find the sum of each level, then locate the level with largest sum.

Analysis:

Time & space: O(n), n is the number of total nodes.
	 */
	public static int maxLevelSumBFS(TreeNode head) {
		
		//Node root = head.getHead();
		TreeNode root = head;
		int max = Integer.MIN_VALUE;
		int maxLevel =1;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		
		for (int level = 1; !q.isEmpty() ; level++ ) {
			
			int sum =0;
			int qsize = q.size();
			
			while(qsize-- != 0) {
				
				TreeNode n = q.poll();
				sum += n.val;
				
				if(n.left != null) {
					q.offer(n.left);
				}
				if(n.right != null) {
					q.offer(n.right);
				}
				if(max < sum) {
					max = sum;
					maxLevel = level;
				}
				
			}
		}
				
		return maxLevel;
	}
	/*
	 * Method 2: DFS
Use DFS to compute and store the sum of each level in an ArrayList, then locate the level with largest sum.

Recurse down from root, level of which is 0, increase level by 1 for each recursion down;
Use the level as the index of an ArrayList to store the sum of the correspoinding level;
Find the index of the max sum, then plus 1.

	 */
	public static int maxLevelSumDFS(TreeNode head) {
		List<Integer> list = new ArrayList<Integer>();
		dfs(head, list, 0);
		
		
		int maxLevel =0;
		for(int i =0; i < list.size(); i++) {
			if (list.get(i) > list.get(maxLevel)) {
				maxLevel = i;
			}
		}
		return maxLevel +1;
		
		//Java 8 stream in the return statement, can be written as:
		//return 1 + IntStream.range(0, list.size()).reduce(0, (a, b) -> list.get(a) < list.get(b) ? b : a);
	}
	
	private static void dfs(TreeNode root, List<Integer> list, int level ) {
		
		if(root ==null) {
			return;
		}
		if(list.size() == level ) {// never reach this level before, add first value.
			list.add(root.val);
		} else {// reached the level before, accumulate current value to old value.
			list.set(level, list.get(level) + root.val);
		}
		dfs(root.left,list, level +1 );
		dfs(root.right, list, level + 1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("In package: graph_questions: check max level");
		
		BuildBinaryTree bt= new BuildBinaryTree(5);
		bt.add(4);
		bt.add(7);
		bt.add(1);
		bt.add(9);
		bt.add(11);
		/**
		 * print Tree in Breadth First Search
		 * In Order
		 * Pre Order
		 * Post Order
		 */
		bt.printBinTree();
System.out.println("Max level of sum BFS: " + maxLevelSumBFS(bt.getroot()));
System.out.println("Max level of sum DFS: " + maxLevelSumDFS(bt.getroot()));
	}
}
