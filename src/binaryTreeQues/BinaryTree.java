package binaryTreeQues;

import java.util.LinkedList;
import java.util.Queue;

class Node{
	int data;
	Node left, right;
	public Node(int item){
		data = item;
		left = right = null;
	}
}

public class BinaryTree {
	Node root;
	public BinaryTree(){
		root = null;
	}
	
	int getHeight(Node root){
		
		if(root == null)
			return 0;
		else{
			int lheight = getHeight(root.left);
			int rheight = getHeight(root.right);
			
			if(lheight > rheight)
				return lheight+1;
			else
				return rheight+1;
		}
		
	}
	void printLeveOrder(){
		int h = getHeight(root);
		for(int i =1; i<=h; i++){
			printGivenLevel(root, i);
		}
	}
	void printGivenLevel(Node root, int l){
		if(root == null){
			return ;
		}
		if(l == 1){
			System.out.print(root.data);
			System.out.print(" ");
		}
		else if(l>1){
			printGivenLevel(root.left, l-1);
			printGivenLevel(root.right, l-1);
		}
	}
	void printOrderUsingQueue(){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node tempNode = queue.poll();
			System.out.print(tempNode.data);
			if(tempNode.left != null)
				queue.add(tempNode.left);
			if(tempNode.right != null)
				queue.add(tempNode.right);
		}	
	}
	
	public static void maintest(String args[]){
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.print("level Order traversal of binary tree: ");
		//tree.printLeveOrder();//using recusive
		tree.printOrderUsingQueue();//using Queue
		
		
	}
}
