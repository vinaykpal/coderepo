package mix_practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 	g.addEdge(1, 2, 11);
		g.addEdge(2, 4, 14);
		g.addEdge(2, 3, 13);
		g.addEdge(1, 5, 15);
 * @author t0158551
 *
 */
// create a graph with all vertexes, all edges and Adjancy List
// traverse graph and push to stack if vertece has no more verteces connected.
//keep visited set of visited vertices
// return stack
public class GraphTopoPractice2 {	

	public void DfsUtil (GraphSimple1 g, Integer v, Set<Integer> visited, Deque<Integer> stack) {
		visited.add(v);
		
		for (Integer i : g.adjList.get(v)) {
			System.out.println("adjList: i : " + i);
			if (!visited.contains(i)) {
				DfsUtil(g, i, visited, stack);
			}
		}
		System.out.println("add to stack: " + v);
		stack.offer(v);
	}
	public void graphTopo_DFS(GraphSimple1 g) {
		Set<Integer> visited = new HashSet<Integer>(); //visited vertices
		Deque<Integer> stack = new ArrayDeque<Integer>(); //res
		
		for (Integer v : g.getAllVertecis()) {
			System.out.print("vertices: " + v);
			if (!visited.contains(v)) {
				DfsUtil( g,  v, visited, stack) ;					
				
			}
		}
		System.out.println("\ntopsort: ");
				
		for(Integer i : stack) {
			System.out.print(" " + i);
		}
	}
	
	public void graphTopo_BFS(GraphSimple1 g) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();		

			q.add(g.getAllVertecis().iterator().next());
			//System.out.print("New v: " + v +"\n");
			while(!q.isEmpty()) {
				int i = q.poll();
				System.out.print(" i: " + i +"\n");
				
				if (!visited.contains(i)) {
					visited.add(i);
					LinkedList<Integer> vList = g.getAdjList().get(i);
					for(Integer ii: vList) {
						System.out.print(" ii " + ii);
						q.add(ii);
					}
					System.out.println("\n");
				}
				System.out.println("add to stack: " + i +"\n");
				stack.offer(i);
			}				
		//}
		//print result topological sort in stack last first.
		
		while(!stack.isEmpty()) {
			System.out.print(" res: "+ stack.pollLast());
		}
		
		
	}
	public static void main(String[] args) {
		GraphSimple1 g = new GraphSimple1(5);
		g.addEdge(1, 2, 11);
		g.addEdge(2, 4, 14);
		g.addEdge(2, 3, 13);
		g.addEdge(1, 5, 15);
		
		GraphTopoPractice2 gp = new GraphTopoPractice2();
		
		gp.graphTopo_DFS(g);
		//gp.graphTopo_BFS(g);
	}
}

class GraphSimple1 {
	int V;
	List<LinkedList<Integer>> adjList = new ArrayList<LinkedList<Integer>>();
	List<Integer> allVert = new ArrayList<Integer>();
	List<Edge1> allEdges = new ArrayList<Edge1>();

	public GraphSimple1(int V) {
		// TODO Auto-generated constructor stub
		this.V = V;
		
		for(int i =0; i <= V; i++) {
			adjList.add(new LinkedList<Integer>());
		}
	}
	public void addEdge(int v1, int v2, int w) {
		adjList.get(v1).add(v2);
		
		if(!allVert.contains(v1)) {
			allVert.add(v1);
		}
		if(!allVert.contains(v2)) {
			allVert.add(v2);
		}
		
		Edge1 e = new Edge1(v1, v2, w);
		allEdges.add(e);		
	}
	
	public List<LinkedList<Integer>> getAdjList() {
		return adjList;
	}
	public Collection<Integer> getAllVertecis() {
		return allVert;
	}
	public Collection<Edge1> getAllEdges(){
		return allEdges;
	}
}

class Edge1 {
	int v1, v2, w;
	Edge1(int v1, int v2, int w){
		this.v1 = v1;
		this.v2 = v2;
		this.w = w;
	}
}

