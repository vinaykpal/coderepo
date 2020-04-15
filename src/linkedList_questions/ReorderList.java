package linkedList_questions;
/**
 * 
 * 143. Reorder List
Medium
74762FavoriteShare
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You may not modify the values in the list's nodes, only nodes itself may be changed.
Example 1:
Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
The basic idea is to split the list in half, then reverse the second half, and at last merge them. It is O(n) time, O(1) space. 
 *
 */
public class ReorderList {
	
	public static ListNode  reOrder(final ListNode inList) {
		
		if(inList == null || inList.head.next ==  null	) {
			return inList;
		}
		
		ListNode originalList = inList;
		Node head1, head2;
		//head1 = head2 = inList.head;
				
		//find mid point of lined list head2 point to middle of list
		head1 = inList.head;
		head2 = inList.head.next;
		while(head2 != null && head2.next != null) {
			head1 = head1.next;
			head2 = head2.next.next;
		}

		//reverse the second half
		head2 = head1.next;  // the head of the second half
		head1.next = null;
		/*while (head1 != null && head1.next.next != null) {
			head1 = head1.next.next;
			head2 = head2.next;
			//System.out.println("## 1 ###");
		}*/
		//reverse head2 list second half
		
		Node resNode = null; //result list with reverse node
		
		while(head2 != null) {
			//System.out.println("## 2 ###");
			Node tempNode = head2.next; 
			head2.next = resNode;
			resNode = head2;
			head2 = tempNode;			
		}
		
		//merge first and second half of nodes
		head2 = resNode;
		head1 = inList.head;
		head1 = originalList.head;
		
		System.out.println("\n"); 
		System.out.println("head1: "); //LinkedList: 1 2 3 4 

		ListNode.printList(head1);
		System.out.println("\n");
		System.out.println("head2: ");
		ListNode.printList(head2); //  LinkedList: 8 7 6 5 
		System.out.println("\n");
		
		System.out.println("inList: ");
		ListNode.printList(inList); //LinkedList: 1 2 3 4
		
		Node tempNode1, tempNode2;
		while(head1 != null) {
			//System.out.println("## 3 ###");
			tempNode1 = head1.next ;
			tempNode2 = head2.next ;
			
			head1.next = head2;
			
			if (tempNode1 == null) {
				break;
			}
			
			head2.next = tempNode1;
			
			head1 = tempNode1;
			head2 = tempNode2;
		}
//		while (head2 != null) {
//			Node next1 = head1.next;
//			
//			head1.next = head2;
//			head1 = head2;
//			head2 = next1;
//		}
		
		return inList;			
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
        list = ListNode.insert(list, 1); 
        list = ListNode.insert(list, 2); 
        list = ListNode.insert(list, 3); 
        list = ListNode.insert(list, 4); 
        list = ListNode.insert(list, 5); 
        list = ListNode.insert(list, 6); 
        list = ListNode.insert(list, 7);        
        list = ListNode.insert(list, 8); 
          // Print the LinkedList
        System.out.println("ReorderList Before reorder:");
        ListNode.printList(list); //LinkedList: 1 2 3 4 5 6 7 8
        ListNode res = reOrder(list);
        System.out.println("ReorderList After reorder:");
        ListNode.printList(res); //LinkedList: 1 8 2 7 3 6 4 5 
       
    } 
}
