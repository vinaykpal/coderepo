package graph_questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphTopologicalSort<T> {
	
	public Deque<Vertex<T>> topSort(GraphBase<T> g) {
		Deque<Vertex<T>> stack = new ArrayDeque<Vertex<T>>(); // holds result in revers
		Set<Vertex<T>> visited = new HashSet<Vertex<T>>(); // holds visitied vertexs
		
		for(Vertex<T> v : g.getAllVertex()) {
			if (visited.contains(v)) {
				continue;
			}		
			topSortUtilDFS(v, stack, visited);
		}		
		
		return stack;
	}
	
	private void topSortUtilDFS(Vertex<T> vertex, Deque<Vertex<T>> stack, Set<Vertex<T>> visited) {
		
		visited.add(vertex);
		
		for(Vertex<T> v : vertex.getAdjacentVertex()) {
			if (visited.contains(v)) {
				continue;
			}
			topSortUtilDFS(v, stack, visited);
		}
		
		stack.offer(vertex);
	}
		
	public static void main(String[] args) {
		GraphTopologicalSort<Integer> gSort = new GraphTopologicalSort<Integer>();
		GraphBase<Integer> g = new GraphBase<Integer>(true);
		g.addEdge(1, 3, 11);
		g.addEdge(1, 2, 12);
        g.addEdge(3, 4, 14);
        g.addEdge(5, 6, 17);
        g.addEdge(6, 3, 18);
        g.addEdge(3, 8, 19);
        g.addEdge(8, 9,16);
        
        g.printGraphVertexs();
        
        //Do topological Sort of Graph
        Deque<Vertex<Integer>> res =  gSort.topSort(g);
        
        for(Vertex<Integer> v : res) {
        	System.out.println("-> " + v.id);
        }
	}
}


class GraphBase<T>{
	private List<Edge<T>> allEdges;
	private Map<Long,Vertex<T>> allVertex;
	boolean isDirected = false;
	
	public GraphBase(boolean isDirected) {
		allEdges = new ArrayList<Edge<T>>();
		allVertex = new HashMap<Long, Vertex<T>>();
		
		this.isDirected = isDirected;			
	}
	
	public void addEdge(long id1, long id2) {
		addEdge(id1, id2);
	}
	
	public void addEdge(long id1, long id2, int w) {
		Vertex<T> vertex1 = null;
		if(allVertex.containsKey(id1)) {
			vertex1 = allVertex.get(id1);
		} else {
			vertex1 = new Vertex<T>(id1);
			allVertex.put(id1, vertex1);
		}
		
		Vertex<T> vertex2 = null;
		if(allVertex.containsKey(id2)) {
			vertex2 = allVertex.get(id2);
		} else {
			vertex2 = new Vertex<T>(id2);
			allVertex.put(id2, vertex2);
		}
		
		Edge<T> edge = new Edge<T>(vertex1, vertex2, isDirected, w);
		allEdges.add(edge);
		
		vertex1.addAdjacentVertex(edge, vertex2);
		if(!isDirected) {
			vertex2.addAdjacentVertex(edge, vertex1);
		}
	}
	
	public Collection<Vertex<T>> getAllVertex (){
		return allVertex.values();
	}	
	
	public void printGraphVertexs() {
		System.out.println("####################");
		System.out.println("graph vertex: ");
		
/*		for (Vertex<T> v : allVertex.values()) {
			for (Vertex<T> v1 : v.getAdjacentVertex()) {					
					System.out.println(v.id +" -> " + v1.id +" weight: ");
				
			}
			
		}*/
		for (Edge<T> e : allEdges) {
			System.out.println(e.getVertex1().id + " -> " + e.getVertex2().id + " w: " + e.getweigh());
		}
		System.out.println("####################");
		
		
	}
}

class Vertex<T>{
	long id;
	private List<Vertex<T>> adjacentVertex = new ArrayList<Vertex<T>>();
	private List<Edge<T>> edges = new ArrayList<Edge<T>>();
	
	Vertex(long id) {
		this.id = id;
	}
	
	public void addAdjacentVertex(Edge<T> e, Vertex<T> v) {
		edges.add(e);
		adjacentVertex.add(v);
	}
	
	public List<Vertex<T>> getAdjacentVertex() {
		return adjacentVertex;
	}
	
	public List<Edge<T>> getEdges() {
		return edges;
	}
	
}

class Edge<T>{
	private boolean isDirected = false;
	private Vertex<T> vertex1;
	private Vertex<T> vertex2;
	private int weigh;
	
	Edge(Vertex<T> v1, Vertex<T>v2){
		this.vertex1 = v1;
		this.vertex2 = v2;
	}
	
	Edge(Vertex<T> v1, Vertex<T>v2, boolean isDirected, int w){
		this.vertex1 = v1;
		this.vertex2 = v2;
		this.isDirected = isDirected;
		this.weigh = w;
	}
	
	public Vertex<T> getVertex1() {
		return vertex1;
	}
	
	public Vertex<T> getVertex2() {
		return vertex2;
	}
	
	public int getweigh() {
		return weigh;
	}
}
