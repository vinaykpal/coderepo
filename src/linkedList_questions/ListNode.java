package linkedList_questions;

public class ListNode {
	
	Node head; // head of list 
	  
	public ListNode() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Node getHead() {
		return head;
	}
	// Method to insert a new node 
    public static ListNode insert(ListNode list, int data) 
    { 
        // Create a new node with given data 
        Node new_node = new Node(data); 
        new_node.next = null; 
  
        // If the Linked List is empty, 
        // then make the new node as head 
        if (list.head == null) { 
            list.head = new_node; 
        } 
        else { 
            // Else traverse till the last node 
            // and insert the new_node there 
            Node last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
  
            // Insert the new_node at last node 
            last.next = new_node; 
        } 
  
        // Return the list by head 
        return list; 
    } 
    
 // Method to print the LinkedList. 
    public static void printList(ListNode list) 
    { 
        Node currNode = list.head; 
   
        System.out.print("LinkedList: "); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.val + " "); 
   
            // Go to next node 
            currNode = currNode.next; 
        } 
    } 
 // Method to print the LinkedList. 
    public static void printList(Node head) 
    { 
        Node currNode = head; 
   
        System.out.print("LinkedList: "); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.val + " "); 
   
            // Go to next node 
            currNode = currNode.next; 
        } 
    } 
    
 // Driver code 
    public static void main(String[] args) 
    { 
        /* Start with the empty list. */
    	ListNode list = new ListNode(); 
  
        // 
        // ******INSERTION****** 
        // 
  
        // Insert the values 
        list = insert(list, 1); 
        list = insert(list, 2); 
        list = insert(list, 6); 
        list = insert(list, 7); 
        list = insert(list, 3); 
        list = insert(list, 4); 
        list = insert(list, 5); 
      
        list = insert(list, 8); 
  
        // Print the LinkedList 
        printList(list); 
    } 
    
	
}
