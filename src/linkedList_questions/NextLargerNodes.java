package linkedList_questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * 1019. Next Greater Node In Linked List
Medium
1148FavoriteShare
We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, 
node_3,.. etc.Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i,
node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list 
with a head node value of 2, second node value of 1, and third node value of 5.
 
Example 1:
Input: [2,1,5]
Output: [5,5,0]
Example 2:
Input: [2,7,4,3,5]
Output: [7,0,5,5,0]
 *
 */
public class NextLargerNodes {
	
	public static void nextLargestNodes(Node head) {
		List<Integer> res = new ArrayList<Integer>();
		List<Integer> index = new ArrayList<Integer>();
		
		for(Node node = head; node!= null; node = node.next) {
			//System.out.println("index.size: " + index.size() + " ");
			while((index.size() != 0) && res.get(index.get(index.size()-1))< node.val) {
				res.set(index.get(index.size()-1), node.val);
				index.remove(index.size()-1);
			}
			index.add(res.size());
			res.add(node.val);
		}
		
		System.out.println("next lagest nodes list: " + res.toString());
		
		for(int i: index) {
			res.set(i,0);
		}
		System.out.println("next lagest nodes list: " + res.toString());
	}
	/*public static void nextLargestNodes(Node head) {
		int[] res = new int[];
		List<Integer> index = new ArrayList<Integer>();
		
		for(Node node = head; node!= null; node = node.next) {
			System.out.println("index.size: " + index.size() + " ");
			while((index.size() != 0) && res.get(index.get(res.size()-1))< node.val) {
				res.add(node.val);
				index.remove(index.size()-1);
			}
			index.add(res.size());
			res.add(node.val);
		}
		
		System.out.println("next lagest nodes list: " + res.toString());
		
		for(int i: index) {
			res.
		}
	}*/
	
	public static void nextLargerNodes_LC3(Node head) {
	    
		// Keeps track of indices of values in nums
	   // Stack<Integer> stack = new Stack<Integer>();//Using Deque can greatly improve the runtime:
		Deque<Integer> stack = new LinkedList<Integer>();
		
		// Store node values as we go, 
		// updates to output value ("next greatest") within while loop as we see them
	    List<Integer> nums = new ArrayList<Integer>();
	    
	    Node n = head;
		
		// For generating the corresponding index in nums as we step through LinkedList
	    int index = 0;
	    
	    while (n != null) {
	      
	      nums.add(n.val);
	      
		  // Process anything that is less than current node value
		  // i.e. current node value is the "next"greatest for elements (index-referenced) in the stack
	      while (!stack.isEmpty() && nums.get(stack.peek()) < n.val) {
	        nums.set(stack.pop(), n.val);
	      }
	      
		  // Set up for next iteration. 
		  // Note: Every node gets into the stack.
	      stack.push(index);
	      n = n.next;
	      index++;
	    }
	    
	    // Handle remaining items in stack / write in 0 (no "next greatest" found for these)
	    while (!stack.isEmpty()) {
	      nums.set(stack.pop(), 0);
	    }
	    
	    // Format output
	    int[] result = new int[nums.size()];
	    for (int i = 0; i < result.length; i++) {
	      result[i] = nums.get(i);
	    }  	  	    
	    //return result;
	    System.out.println("result: " );
        for(int i : result) {
        	System.out.print(i +": "); //2: 3: 4: 5: 0: 
        }
	  }
	
	public static void nextLargerNodes_LC2(Node head) {
	    Integer[] arr = toArray(head);
	    
	    Deque<Integer> stack = new ArrayDeque<Integer>();
	    int[] result = new int[arr.length];
	    for (int i = 0; i < arr.length; i++) {
	        while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
	            result[stack.pop()] = arr[i];
	        }
	        stack.push(i);
	    }
	    System.out.println("result: " );
        for(int i : result) {
        	System.out.print(i +": "); //2: 3: 4: 5: 0: 
        }
	   // return result; 
	}

	private static Integer[] toArray(Node head) {
	    List<Integer> list = new ArrayList<Integer>();
	    for (Node node = head; node != null; node = node.next) {
	        list.add(node.val);
	    }
	    return list.toArray(new Integer[0]);
	}
	
	public static void nextLargerNodes_LC1(Node head) {
        //ArrayList<Integer> A = new ArrayList<>();
        List<Integer> A = new ArrayList<Integer>();
        
        for (Node node = head; node != null; node = node.next)
            A.add(node.val);
        
        int[] res = new int[A.size()];
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
                res[stack.pop()] = A.get(i);
            stack.push(i);
        }
        System.out.println("result: " );
        for(int i : res) {
        	System.out.print(i +": ");  //2: 3: 4: 5: 0: 
        }
        //return res;
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
    System.out.println("List Before reverse:"); //LinkedList: 1 2 3 4 5 
    ListNode.printList(list); 
    System.out.println("\nList After reverse:");
    //nextLargestNodes(list.head);
    //nextLargerNodes_LC1(list.head);
    
    //nextLargerNodes_LC2(list.head);
    nextLargerNodes_LC3(list.head); // result: 2: 3: 4: 5: 0: 
	}
}
