package graph_questions;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 997. Find the Town Judge
Easy

367

49

Add to List

Share
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
 * @author t0158551
 *
 */
class Graph {
	int vertices;
	//LinkedList<Integer> adjList[];

	ArrayList< LinkedList<Integer>> adjList1;
	Graph(int v) {
		this.vertices = v;
		
	//	adjList = new LinkedList[ vertices +1 ];  // type safety for unchecked conversion
												 // use ArrayList< LinkedList<Integer> >	
		adjList1 = new ArrayList<LinkedList<Integer>>(vertices+1);
		
		//System.out.println("vertices: " + this.vertices + " size: " + adjList1.size());
		for (int i =0; i <= vertices; i++) {
		//	adjList[i] = new LinkedList<Integer>();
			adjList1.add(i, new LinkedList<Integer>());
		}
		//System.out.println("vertices: " + this.vertices + " size: " + adjList1.size());
	}
	
	void addEdge(int startVertex, int endVertex) {
		//adjList[startVertex].add(endVertex);
		adjList1.get(startVertex).add(endVertex);
	}
	
	/*LinkedList<Integer>[] getGraph() {
		return adjList;
	}*/
	
	ArrayList<LinkedList<Integer>> getGraph1() {
		return adjList1;
	}
}
public class FindTheJudge {

	public int findJudge(int N, int[][]trust) {
		
		Graph graph = new Graph(N);
		for(int i =0; i < trust.length; i++ ) {
			graph.addEdge(trust[i][0], trust[i][1]);	
		}
		
	//	LinkedList<Integer>[] adj = graph.getGraph();
		ArrayList<LinkedList<Integer>> adj1 = graph.getGraph1();
		
		for(int i = 1; i < adj1.size(); i++) {
			if (adj1.get(i).size() == 0) {
				int judgeCandidate = i;
				boolean isJudge = true;
				
				for(int j =1 ; j < adj1.size() ; j++) {
					if(j ==i) {
						continue;
					}
					LinkedList<Integer> edges = adj1.get(j);
					if(!edges.contains(judgeCandidate)) {
						isJudge = false;
						break;
					}
				}
				
				if( isJudge) {
					return i;
				}
			}
		}
		/*for(int i = 1; i < adj.length; i++) {
			if (adj[i].size() == 0) {
				int judgeCandidate = i;
				boolean isJudge = true;
				
				for(int j =1 ; j < adj.length ; j++) {
					if(j ==i) {
						continue;
					}
					LinkedList<Integer> edges = adj[j];
					if(!edges.contains(judgeCandidate)) {
						isJudge = false;
						break;
					}
				}
				
				if( isJudge) {
					return i;
				}
			}
		}*/
		return -1;
	}
	
	public static void main(String[] args) {
		
		
		FindTheJudge o = new FindTheJudge();
		int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
		//int[][] trust = {{1,2},{2,3}};//,{2,3},{2,4},{4,3}};
		int N =4;
		System.out.println("FindThe Judge: " + o.findJudge(N, trust));
	}
	
}

