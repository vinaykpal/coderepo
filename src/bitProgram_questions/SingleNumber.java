package bitProgram_questions;

import java.util.HashSet;
import java.util.Set;

/*
 * Single Number
Easy
220182FavoriteShare
Given a non-empty array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Example 1:
Input: [2,2,1]
Output: 1
Example 2:
Input: [4,1,2,1,2]
Output: 4
 */
public class SingleNumber {

	static int singleNumber(Integer[] A) {
		System.out.println(System.nanoTime());
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i =0; i < A.length; i ++) {
			if(!set.contains(A[i])) {
				set.add(A[i]);
			} else {
				set.remove(A[i]);
			}
		}
		System.out.println(System.nanoTime());
		
		return (set.iterator().hasNext() == true ? set.iterator().next() :0);
	}
	
	static int singleNumxOr(Integer[] A) {
		System.out.println(System.nanoTime());
		int res=0;
		for(int i =0 ; i < A.length; i++) {
			res = res^A[i];
		}
		System.out.println(System.nanoTime());
		return res;
	}
	public static void main(String[] args) {
		Integer[] A = new Integer[] {1,2,3,3,2,5,5};
		System.out.println("singleNumber(A): " + singleNumber(A));
		System.out.println("singleNumberxOr(A): " + singleNumxOr(A));
	}
}
