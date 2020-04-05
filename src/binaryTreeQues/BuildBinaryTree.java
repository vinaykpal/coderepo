package binaryTreeQues;

import java.util.LinkedList;
import java.util.Queue;


public class BuildBinaryTree {
	TreeNode root;
	
	public TreeNode getroot(){
		return root;
	}
	public BuildBinaryTree() {
		// TODO Auto-generated constructor stub
		root = null; 
	}
	
	public BuildBinaryTree(int val) {
		root = new TreeNode(val);		
	}
	
	public void add(int val) {
		root = addRecursive(root, val);
	}
	
	public boolean containsValue(int val) {
		
		return true;
		
	}
	
	public void printBinTree() {
		System.out.println("Binary Tree in In Order");
		printInOrderBinTree(root);
		System.out.println("Binary Tree in Pre Order");
		printPreOrderBinTree(root);
		System.out.println("Binary Tree in Post Order");
		printPostOrderBinTree(root);
		System.out.println("Binary Tree in Breadth First Search");
		printBreadthFirstSearch(root);
	}
	
	public void printInOrderBinTree(TreeNode node) {
		if (node != null) {
			printInOrderBinTree(node.left);
			System.out.println("Tree val: " + node.val);
			printInOrderBinTree(node.right);
		}
	}
	
	public void printPreOrderBinTree(TreeNode node) {
		if (node != null) {
			System.out.println("Tree val: " + node.val);
			printInOrderBinTree(node.left);
			printInOrderBinTree(node.right);
		}
	}
	
	public void printPostOrderBinTree(TreeNode node) {
		if (node != null) {
			printInOrderBinTree(node.left);
			printInOrderBinTree(node.right);
			System.out.println("Tree val: " + node.val);
		}
	}
	
	public void printBreadthFirstSearch(TreeNode node) {
		
		if(node == null) {
			return;
		}
		
		Queue<TreeNode> nodesQue = new LinkedList<TreeNode>();
		
		nodesQue.add(node);
		
		while(!nodesQue.isEmpty()) {
			TreeNode tempNode = nodesQue.remove();
			
			System.out.println("->" + tempNode.val);
			if(tempNode.left != null) {
				nodesQue.add(tempNode.left);
			}
			
			if(tempNode.right != null) {
				nodesQue.add(tempNode.right);
			}
		}
	}
	
	private TreeNode addRecursive(TreeNode current, int val) {
		if(current == null) {
			//System.out.println("val: " + val);
			return new TreeNode(val);
		}
		
		if(val < current.val) {
		//	System.out.println("val: if " + val);
			current.left = addRecursive(current.left, val);
		} else if(val >= current.val) { // Note: if val already exists in tree and need to be added use >= and not need below else
		//	System.out.println("val: else if" + val);
			current.right = addRecursive(current.right, val);
		} else { // if val already exists and NOT need to be added use > above else if and use this else
		//	System.out.println("val: else " + val);
			return current;
		}
		
		return current;
		
	}
	public static void main(String[] args) {
		System.out.println("In build binary tree");
		BuildBinaryTree ob = new BuildBinaryTree();
		ob.add(3);
		ob.add(1);
		ob.add(3);
		ob.add(5);
		ob.add(8);
		ob.add(4);
		
		ob.printBinTree();
	}
}
