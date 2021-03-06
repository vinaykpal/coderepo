package graph_questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GraphTopologicalSort_Simple {

	public void DFSUtil(GraphSimple g, Integer v, Set<Integer> visited, Deque<Integer> stack) {
		visited.add(v);
		ArrayList<LinkedList<Integer>> adjList = g.getAdjList();
	//	System.out.println("adjList: "+ adjList);
		
		for (Integer i : adjList.get(v)){
		//	System.out.println("i : " + i);
			if(visited.contains(i)) {
				continue;
			}
			DFSUtil(g, i, visited, stack);
		}
		stack.offer(v);				
	}
	
	public void topSortGraphsimple(GraphSimple g) {
		Set<Integer> visited = new HashSet<Integer>();		
		Deque<Integer> stack = new ArrayDeque<Integer>();
		
		for(Integer v : g.getAllVertexs()) {
			//System.out.println("vertex : " + v);
			if(visited.contains(v)) {
				continue;
			}
			DFSUtil(g, v, visited, stack);
		}
		
		// print top sort result
		System.out.println("Top sort: ");
		for(Integer val : stack) {
			System.out.println(val + " ");
		}
	}
	
	
	private int find(int[] parent, int xx) {
		if (xx != parent[xx]) {
			xx = find(parent, parent[xx]);
		} 
		return xx;
	}
	
	private void union(int[] parent, int x, int y) {
		parent[y] = x;
	}
	
	public boolean detectCycle(GraphSimple g) {
		int parent[] = new int[g.V];
		for(int i =0; i < g.V; i++) {
			parent[i] = i;
		}
		
		for (EdgeSimple e : g.getAllEdge()) {
			System.out.println(" e.v1 " + e.v1 + " e.v2 " + e.v2);
			int  x = find(parent, e.v1);
			int  y = find(parent, e.v2);
			System.out.println(" x " + x +" y " + y);
			if (x ==y ) {
				return true;
			}
			
			union(parent, x, y);
						
		}
		return false;
	}
	
	public static void main(String[] args) {
		GraphSimple g = new GraphSimple(6);
		
		g.addEdge(1, 2, 11);
		g.addEdge(2, 4, 14);
		g.addEdge(2, 3, 13);
		g.addEdge(1, 5, 15);
		g.addEdge(3, 4, 15);
		

//		g.addEdge(1, 2, 12);
//		g.addEdge(2, 3, 12);
//		g.addEdge(1, 3, 12);
		
		//g.printGraph();
		System.out.println("allvertexs: " + g.getAllVertexs());
		System.out.println("getAdjList"+ g.getAdjList());
	/*	System.out.println("alledges: " );
		for(EdgeSimple e: g.getAllEdge()){
			System.out.println(e.v1 +" -> " + e.v2 +" w: " + e.w);
		}*/
		
		GraphTopologicalSort_Simple obj = new GraphTopologicalSort_Simple();
		obj.topSortGraphsimple(g);
		System.out.println("cycle: " + obj.detectCycle(g));
	}
}

class GraphSimple {
	int V;
	ArrayList<LinkedList<Integer>> adjListArray;
	//List<Integer> allVertexs;
	Set<Integer> allVertexs;
	private List<EdgeSimple> allEdges;
	
	public GraphSimple(int V) {
		// TODO Auto-generated constructor stub
		this.V = V;
		
		adjListArray = new ArrayList<LinkedList<Integer>>();
		//allVertexs = new ArrayList<Integer>();
		allVertexs = new HashSet<Integer>();
		allEdges = new ArrayList<EdgeSimple>();
		
		for(int i= 0; i< V; i++) {
			adjListArray.add(new LinkedList<Integer>());
		}
	}
	
	public void addEdge(int v1, int v2, int w) {
		adjListArray.get(v1).add(v2);
		if(!allVertexs.contains(v1)) {
			allVertexs.add(v1);	
		}
		if(!allVertexs.contains(v2)){
			allVertexs.add(v2);		
		}
		EdgeSimple e = new EdgeSimple(v1, v2, w);
		allEdges.add(e);
	}
	
	public Collection<Integer> getAllVertexs() {
		return allVertexs;
	}
	
	public Collection<EdgeSimple> getAllEdge (){
		return allEdges;
	}
	
	ArrayList<LinkedList<Integer>> getAdjList(){
		return  adjListArray;
	}
	public void printGraph() {
		for( int i =0 ; i < V; i++) {
			//System.out.println("vertex: " + adjListArray.get(i));
			for(Integer vchild : adjListArray.get(i)) {
				System.out.println(i +" -> " + vchild);	
			}
			
		}
	}
}

class EdgeSimple {
	int v1, v2;
	int w;
	
	EdgeSimple(int v1, int v2, int w) {
		this.v1 = v1;
		this.v2 = v2;
		this.w = w;
	}
}
