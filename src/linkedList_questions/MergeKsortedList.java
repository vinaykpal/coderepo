package linkedList_questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import binaryTreeQues.BuildBinaryTree;

/**
 * 23. Merge k Sorted Lists
Hard
2098130FavoriteShare
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 * @author t0158551
 *
 */
class ListComparator implements Comparator<Node> {
	
	public int compare(Node n1, Node n2) {
		if(n1.val >= n2.val){
			return 1;
		} else {
			return -1;
		}
	}
	
}
public class MergeKsortedList {
	
	public static Node mergeLists(final List<ListNode>aList) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new ListComparator());
		
		for(ListNode l : aList) {
			if(l != null ) {
				pq.add(l.head);	
			}			
		}
		
		if(pq.isEmpty()) {
			return null;
		}
		
		Node res = pq.poll();
		if(res.next != null) {
			pq.add(res.next);
		}
		
		Node tail = res;
		
		while(!pq.isEmpty()) {
			tail.next = pq.poll();
			tail = tail.next;
			if(tail.next != null) {
				pq.add(tail.next);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
    	ListNode list1 = new ListNode(); 
    	ListNode list2 = new ListNode();
    	ListNode list3 = new ListNode();
  
        // Insert the values 
        list1 = ListNode.insert(list1, 1); 
        list1 = ListNode.insert(list1, 2); 
        list1 = ListNode.insert(list1, 3); 
        list2 = ListNode.insert(list2, 4); 
        list2 = ListNode.insert(list2, 6); 
        list3 = ListNode.insert(list3, 5);
        list3 = ListNode.insert(list3, 5);
        list3 = ListNode.insert(list3, 5);
        list3 = ListNode.insert(list3, 5);
        
        List<ListNode> aList = new ArrayList<ListNode>();
        aList.add(list1);
        aList.add(list2);
        aList.add(list3);
        
        // Print the LinkedList
        System.out.println("List Before merg:");
        
        for(int i=0; i< aList.size(); i++) {  // LinkedList: 1 2 3 LinkedList: 4 6 LinkedList: 5 5 5 5 
        	ListNode.printList(aList.get(i));
        	System.out.println("\n");
        } 
        System.out.println("\nList After reverse:");
        
        ListNode res = new ListNode();
        res.head = mergeLists(aList);
        ListNode.printList(res); //List After reverse: LinkedList: 1 2 3 4 5 5 5 5 6 
               
        // merge using Binary tree
   //     System.out.println("\nmerge using Binary tree:");
   //     MergeKsortedList ob1 = new MergeKsortedList();
        
     //   ob1.mergeKsortedListUsingBinaryTree(aList);
        
	}
	
	public void mergeListsPractice(List<ListNode> aList) {
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new CompareList());
		for(ListNode l : aList) {
			if (l!= null) {
				pq.add(l.head);
			}
		}
	}
	
	public void mergeKsortedListUsingBinaryTree( List<ListNode> aList) {
		// test code:
        BuildBinaryTree ob = new BuildBinaryTree();
        
        for (ListNode l : aList) {
        	while (l.head != null) {
        		//System.out.print("val: " + l.head.val);
        		ob.add(l.head.val);
        		l.head = l.head.next;
        	}
        }
        ob.printInOrderBinTree(ob.getroot());
	}
}

class CompareList implements Comparator<Node>{
	
	public int compare(Node n1, Node n2) {
		if (n1.val >= n2.val) {
				return 1;
		}
		else {
			return -1;
		}			
	}
}
