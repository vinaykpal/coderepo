package graph_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author t0158551
 * given graph 
 * 0 -> 1 w = 4
 * 0 -> 7 w = 8
 * 1 -> 2 w = 8
 * 1 -> 7 w = 11
 * 2 -> 3 w = 7
 * 2 -> 8 w = 2
 * 2 -> 5 w = 4
 * 3 -> 4 w = 9
 * 3 -> 5 w = 14
 * 4 -> 5 w = 10
 * 5 -> 6 w = 2
 * 6 -> 7 w = 1
 * 6 -> 8 w = 6
 * 7 -> 8 w = 7
 * 
 */
public class ShortestPathGraphDijkstra {
	
	private void shortestPathfromSourceDK(GraphSimpleDK g, int src) {
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("shortest path create graph DK:");
		GraphSimpleDK g = new GraphSimpleDK(9);
		g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 4, 9);
		g.addEdge(3, 5, 14);
		g.addEdge(4, 5, 10);
		g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(7, 8, 7);
		
		g.printGraphDK(g);
		
		ShortestPathGraphDijkstra ob1 = new ShortestPathGraphDijkstra();
		ob1.shortestPathfromSourceDK(g, 0);
	}

}

class GraphSimpleDK {
	int V;
	List<LinkedList<Integer>> adjList = new ArrayList<LinkedList<Integer>>();
	List<Edges> allEdges = new ArrayList<Edges>();
	//Map<Integer, Edges> edgesMap = new HashMap<Integer, Edges>();
	Set<Integer> allVertexes = new HashSet<Integer>();
	
	public GraphSimpleDK(int V) {
		// TODO Auto-generated constructor stub
		this.V = V;
		for(int v =0 ; v < V; v++) {
			adjList.add(new LinkedList<Integer>());
		}
	}
	
	public void addEdge(int u , int v, int w) {
		adjList.get(u).add(v);
		if (!allVertexes.contains(u)) {
			allVertexes.add(u);	
		}
		if (!allVertexes.contains(v)) {
			allVertexes.add(v);	
		}		
		Edges e = new Edges(u, v, w);
		allEdges.add(e);
		//edgesMap.put(u, e);
	}
	
	public List<Edges> getAllEdges () {
		return allEdges;
	}
	
	void printGraphDK(GraphSimpleDK g) {
		System.out.println("allEdges:");
		for (Edges e : g.allEdges) {
			System.out.println(e.u + " -> " + e.v + " " + e.w);
		}
		System.out.println("allvertexes:");
		for(int v : g.allVertexes) {
			System.out.println(" " + v +", ");
		}
	}
}

class Edges {
	int u, v, w;
	
	public Edges(int u , int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	
}