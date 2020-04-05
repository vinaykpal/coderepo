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
		System.out.println("head1: ");
		ListNode.printList(head1);
		System.out.println("\n");
		System.out.println("head2: ");
		ListNode.printList(head2);
		System.out.println("\n");
		
		System.out.println("inList: ");
		ListNode.printList(inList);
		
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
        ListNode.printList(list); 
        //ListNode res = reOrder(list);
        System.out.println("ReorderList After reorder:");
        //ListNode.printList(res);
        
        //********** practice
        
        ReorderList ob1 = new ReorderList();
        Node res1 = ob1.reOrder_P(list.getHead());
        ListNode.printList(res1);
    } 
    
    public Node reOrder_P(Node head) {
    	
    	if (head ==null || head.next == null) {
    		return null;
    	}
    
    	Node h1 = head;
    	Node h2 = head;
    	// Split List to h1 and h2
    	while (h2.next.next != null) { // find mid of list
    		h1 = h1.next;//jump 1
    		h2 = h2.next.next;  // jump 2 times  		
    	}
    	h2 = h1.next; // set h2 to start of 2nd half
    	h1.next = null; // set end of 1st half to null
    	h1 = head;	// set h1 to start of 1st half
    	
    	ListNode.printList(h1);
    	System.out.println();
    	ListNode.printList(h2);
    	System.out.println();
    	
    	// reverse h2
    	Node reverNode = null;
    	while(h2 != null) {
    		Node tempNode = h2.next;
    		h2.next = reverNode;
    		reverNode = h2;
    		h2 = tempNode;    				
    	}
    	h2 = reverNode;
    	ListNode.printList(h2);
    	
    	// merge h1 and h2
    	while(h1 != null) {
    		Node t1 = h1.next;
        	Node t2 = h2.next;
    		h1.next = h2;
    		h2.next = t1;
    		h2 = t2;
    		h1 = t1;
    	}
    	return head;
    }

}
