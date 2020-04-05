package linkedList_questions;

/*
 * Insert into a Cyclic Sorted List
Medium
Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into the list such that it remains
a cyclic sorted list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the cyclic list.
If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the cyclic list should remain
 sorted. If the list is empty (i.e., given node is null), you should create a new single cyclic list and return the reference to that single node. 
 Otherwise, you should return the original given node.
 */
public class InsertIntoSortedList {

	public Node insert(int val, Node head) {
		
		if(head == null) {
			head = new Node();
			head.val = val;
			head.next = head;
			
			return head;
		}
		
		Node cur = head;
		Node next = head.next;
		
		while(cur != next) {
			//Increasing order or same
			if((cur.val == val) || (cur.val < val && next.val > val)) {
				
				Node newNode = new Node(val, next);			
				cur.next = newNode;
				
				return head;
			}
			//Decreasing order
			if(cur.val > next.val && (val > cur.val || val < next.val)) {
				Node newNode = new Node(val, next);
				cur.next = newNode;
				
				return head;
			}
			cur = next;
			next = next.next;
		}
		
		//insert before head
		Node newNode = new Node(val, next);
		head.next = newNode;
		
		return head;
	}
	
	public void printList(Node head) {
		
		if(head != null) {
			Node cur = head;
			do{
				System.out.print(" : " + cur.val);
				cur = cur.next;
			}while (cur != head);	
		}
		System.out.println("\n************");		
	}
	
	public Node removeNthNode(Node head, int Nth) {
		//Node first = head;
		Node second = head;
		
		//Node temp = head;
		int n =0;
		Node first = head;
		Node next = head.next;
		while(first.next != head) {
			System.out.println("n " + n+"val: " + first.val);
			first = first.next;
			//next = next.next;
			if(n >= Nth  ) { // +1 for one previous node of nth
				second = second.next;
			}
			n++;
				
		}		
		second.next = second.next.next;
		System.out.println("***");
		
		return head;		
	}
	
	public static void main(String[] args) {
		Node head = null;
		InsertIntoSortedList ob1 = new InsertIntoSortedList();
		
		head = ob1.insert(5, head);
		head = ob1.insert(7, head);
		head = ob1.insert(1, head);
		head = ob1.insert(9, head);
		head = ob1.insert(12, head);
		
		ob1.printList(head);
			
		System.out.println("remove nth from end");
		head = ob1.removeNthNode(head, 3);
		ob1.printList(head);
	}

}
