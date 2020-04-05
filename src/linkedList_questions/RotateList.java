package linkedList_questions;
/**
 * 61. Rotate List
Medium
515782FavoriteShare
Given a linked list, rotate the list to the right by k places, where k is non-negative.
Example 1:
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
 * @author t0158551
 *
 *Some people used slow/fast pointers to find the tail node but I don't see the benefit 
 *(in the sense that it doesn't reduce the pointer move op) to do so. So I just used one loop to find the length first.
 */
public class RotateList {

	public static Node rotateList(Node head, int k) {
	
		if(head == null) {
			return head;
		}
		Node tail = head;
		Node newHead = head;
		
		int len = 1;
		while (tail.next != null) {
			tail = tail.next;
			len++;
		}
		System.out.println("len of list:" + len + " tail.val "+ tail.val);
		
		tail.next = head; //make it loop
		System.out.println("#####1 tail.val: " + tail.val);
		k = k%len;
		if(k > 0) {
			System.out.println("value of k: " + k);
			
			for(int i = 0; i< len-k; i++) {
				tail = tail.next;
				System.out.println("#####2 tail.val: " + tail.val);
			}
		}
		newHead = tail.next;
		
		tail.next = null;

		return newHead;
		
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
        System.out.println("List Before rotate:");
        ListNode.printList(list); 
        System.out.println("List After rotate:");
        list.head = rotateList(list.head, 2);
        ListNode.printList(list);
		
	}
	
}
