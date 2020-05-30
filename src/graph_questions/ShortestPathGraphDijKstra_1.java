package graph_questions;

import java.util.ArrayList;

public class ShortestPathGraphDijKstra_1 {

	// now we must create graph object and implement dijkstra algorithm
	  private Node[] nodes;
	  private int noOfNodes;
	  private EdgeDk[] edges;
	  private int noOfEdges;
	  
	  // constructor
	  public ShortestPathGraphDijKstra_1(EdgeDk[] edges) {		  
	    this.edges = edges;
	    // create all nodes ready to be updated with the edges
	    this.noOfNodes = calculateNoOfNodes(edges);
	    this.nodes = new Node[this.noOfNodes];
	    
	    for (int n = 0; n < this.noOfNodes; n++) {
	      this.nodes[n] = new Node();
	    }
	    // add all the edges to the nodes, each edge added to two nodes (to and from)
	    this.noOfEdges = edges.length;
	    
	    for (int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgeToAdd++) {
	      this.nodes[edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
	      this.nodes[edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
	    }
	  }
	  
	  private int calculateNoOfNodes(EdgeDk[] edges) {
	    int noOfNodes = 0;
	    for (EdgeDk e : edges) {
	      if (e.getToNodeIndex() > noOfNodes)
	        noOfNodes = e.getToNodeIndex();
	      if (e.getFromNodeIndex() > noOfNodes)
	        noOfNodes = e.getFromNodeIndex();
	    }
	    noOfNodes++;
	    return noOfNodes;
	  }
	  
	  // next video to implement the Dijkstra algorithm !!!
	  public void calculateShortestDistances() {
	    // node 0 as source
	    this.nodes[0].setDistanceFromSource(0);
	    int nextNode = 0;
	    // visit every node
	    for (int i = 0; i < this.nodes.length; i++) {
	      // loop around the edges of current node
	      ArrayList<EdgeDk> currentNodeEdges = this.nodes[nextNode].getEdges();
	      for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
	        int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);
	        // only if not visited
	        if (!this.nodes[neighbourIndex].isVisited()) {
	          int tentative = this.nodes[nextNode].getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getLength();
	          if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
	            nodes[neighbourIndex].setDistanceFromSource(tentative);
	          }
	        }
	      }
	      // all neighbours checked so node visited
	      nodes[nextNode].setVisited(true);
	      // next node must be with shortest distance
	      nextNode = getNodeShortestDistanced();
	   }
	  }
	  
	  // now we're going to implement this method in next part !
	  private int getNodeShortestDistanced() {
	    int storedNodeIndex = 0;
	    int storedDist = Integer.MAX_VALUE;
	    for (int i = 0; i < this.nodes.length; i++) {
	      int currentDist = this.nodes[i].getDistanceFromSource();
	      if (!this.nodes[i].isVisited() && currentDist < storedDist) {
	        storedDist = currentDist;
	        storedNodeIndex = i;
	      }
	    }
	    return storedNodeIndex;
	  }
	  
	  // display result
	  public void printResult() {
	    String output = "Number of nodes = " + this.noOfNodes;
	    output += "\nNumber of edges = " + this.noOfEdges;
	    for (int i = 0; i < this.nodes.length; i++) {
	      output += ("\nThe shortest distance from node 0 to node " + i + " is " + nodes[i].getDistanceFromSource());
	    }
	    System.out.println(output);
	  }
	  public Node[] getNodes() {
	    return nodes;
	  }
	  public int getNoOfNodes() {
	    return noOfNodes;
	  }
	  public EdgeDk[] getEdges() {
	    return edges;
	  }
	  public int getNoOfEdges() {
	    return noOfEdges;
	  }

	  public static void main(String[] args) {
		  EdgeDk[] edges = {
			      new EdgeDk(0, 2, 1), new EdgeDk(0, 3, 4), new EdgeDk(0, 4, 2),
			      new EdgeDk(0, 1, 3), new EdgeDk(1, 3, 2), new EdgeDk(1, 4, 3),
			      new EdgeDk(1, 5, 1), new EdgeDk(2, 4, 1), new EdgeDk(3, 5, 4),
			      new EdgeDk(4, 5, 2), new EdgeDk(4, 6, 7), new EdgeDk(4, 7, 2),
			      new EdgeDk(5, 6, 4), new EdgeDk(6, 7, 5)
			    };
		  ShortestPathGraphDijKstra_1 g = new ShortestPathGraphDijKstra_1(edges);
		  
		  g.calculateShortestDistances();
		  g.printResult();
		  
	}
}

class Node {
	  private int distanceFromSource = Integer.MAX_VALUE;
	  private boolean visited;
	  private ArrayList<EdgeDk> edges = new ArrayList<EdgeDk>(); // now we must create edges
	  public int getDistanceFromSource() {
	    return distanceFromSource;
	  }
	  public void setDistanceFromSource(int distanceFromSource) {
	    this.distanceFromSource = distanceFromSource;
	  }
	  public boolean isVisited() {
	    return visited;
	  }
	  public void setVisited(boolean visited) {
	    this.visited = visited;
	  }
	  public ArrayList<EdgeDk> getEdges() {
	    return edges;
	  }
	  public void setEdges(ArrayList<EdgeDk> edges) {
	    this.edges = edges;
	  }
}

class EdgeDk {
	  private int fromNodeIndex;
	  private int toNodeIndex;
	  private int length;
	  public EdgeDk(int fromNodeIndex, int toNodeIndex, int length) {
	    this.fromNodeIndex = fromNodeIndex;
	    this.toNodeIndex = toNodeIndex;
	    this.length = length;
	  }
	  public int getFromNodeIndex() {
	    return fromNodeIndex;
	  }
	  public int getToNodeIndex() {
	    return toNodeIndex;
	  }
	  public int getLength() {
	    return length;
	  }
	  // determines the neighbouring node of a supplied node, based on the two nodes connected by this edge
	  public int getNeighbourIndex(int nodeIndex) {
	    if (this.fromNodeIndex == nodeIndex) {
	      return this.toNodeIndex;
	    } else {
	      return this.fromNodeIndex;
	   }
	  }
}


