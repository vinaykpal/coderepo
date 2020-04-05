package mix_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphTopologicalPractice {
	
	public static void main(String[] args) {
		Graph<Integer> g = new Graph<Integer>(false);
		g.addEdge(1, 3);
		g.addEdge(1, 5);
		g.addEdge(3, 2);
		
		g.printGraph();
		
		
	}
}

class Graph<T> {
	List<Edge<T>> allEdges;
	Map<Long, Vertex<T>> allVertexs;
	boolean isDirected;
	
	Graph (boolean isDirected) {
		allEdges = new ArrayList<Edge<T>>();
		allVertexs = new HashMap<Long, Vertex<T>>();
		this.isDirected = isDirected;
	}
	
	public void addEdge(long id1, long id2) {
		Vertex<T> v1 = null;
		Vertex<T> v2 = null;
		
		if(allVertexs.containsKey(id1)) {
			v1 = allVertexs.get(id1);
		} else {
			v1 = new Vertex<T>(id1);
			allVertexs.put(id1, v1);
		}
		if(allVertexs.containsKey(id2)) {
			v2 = allVertexs.get(id2);
		} else {
			v2 = new Vertex<T>(id2);
			allVertexs.put(id2, v2);
		}
		
		Edge<T> edge = new Edge<T>(v1, v2);
		allEdges.add(edge);
		v1.addAdjacentVertex(edge, v2);				
	}
	public void printGraph() {
		for(Edge<T> e : allEdges) {
			System.out.println(" " + e.getv1().id + " -> " + e.getv2().id);
		}
	}
}

class Vertex<T> {
	List<Edge<T>> edges = new ArrayList<Edge<T>>();
	List<Vertex<T>> vertexes = new ArrayList<Vertex<T>>();
	long id;
	
	Vertex (long id) {
		this.id = id;
	}
	
	public void addAdjacentVertex(Edge<T> e, Vertex<T> v) {
		edges.add(e);
		vertexes.add(v);
	}
	
	List<Vertex<T>> getAdjacentVertex() {
		return vertexes;
	}
	
}

class Edge<T> {
	private Vertex<T> v1;
	private Vertex<T> v2;
	
	Edge(Vertex<T> v1, Vertex<T> v2) {
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public Vertex<T> getv1(){
		return v1;
	}
	
	public Vertex<T> getv2(){
		return v2;
	}
}