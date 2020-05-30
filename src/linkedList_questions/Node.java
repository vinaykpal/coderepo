package linkedList_questions;

public class Node {
	int val;
	Node next;

	Node(){
		
	}
	
	Node(int val, Node next) {
		this.val = val;
		this.next = next;				
	}
	
	Node(int val) {
		this.val = val;
		this.next = null;
	}
	public int getVal() {
		return this.val;
	}
	
}
