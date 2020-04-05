package linkedList_questions;
/**
 * 206. Reverse Linked List
Easy
199757FavoriteShare
Reverse a singly linked list.
Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
 * @author t0158551
 *
 */
public class ReverseLinkedList {
	
	public static Node reverseList(Node head) {
		Node cur = head;
		Node prev = null;
		
		while(cur != null) {
			//System.out.println("cur: " + cur.val);
			Node tempNode = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tempNode;
			
		}
		return prev;
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
    	ListNode list = new ListNode(); 
  
        // 
        // ******INSERTION****** 
        // 
  
        // Insert the values 
        list = ListNode.insert(list, 1); 
        list = ListNode.insert(list, 2); 
        list = ListNode.insert(list, 3); 
        list = ListNode.insert(list, 4); 
        list = ListNode.insert(list, 5); 
         
          // Print the LinkedList
        System.out.println("List Before reverse:");
        ListNode.printList(list); 
        System.out.println("\nList After reverse:");
        list.head = reverseList(list.head);
        ListNode.printList(list);
		
	}
}
