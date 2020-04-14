package string_questions;
/**
 * 686. Repeated String Match
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
 * @author t0158551
 *
 */
public class RepeatedStringMatch {
	
	 public static int repeatedStringMatch(String A, String B) {
	        int i = 0, j = 0;
	        if (A.length() == 0) {
	        	return -1;
	        }
	        while (i < A.length()) {
	            j = 0;
	            while (j < B.length() && A.charAt((i + j) % A.length()) == B.charAt(j)) {
	            	System.out.println(" i: " + i + " j: " + j);
	                j++;	                
	            }
	            if (j == B.length()) {
	            	System.out.println(" j == i: " + i + " j: " + j);
	            	System.out.println(" i+j: " + (i +j) + " j: " + j);
	                return ((i + j) / A.length()) + ((i + j) % A.length() == 0 ? 0 : 1);
	            }
	            i++;
	        }
	        return -1;
	    }
	 
	 public static void stringTest() {
		 StringBuilder sb = new StringBuilder();
		 sb.append("c");
		 sb.append("b");
		 sb.append("a");
		 System.out.println(sb);
		 System.out.println(sb.reverse());
		 System.out.println(sb.substring(2));
	 }
	 
	 public static void main(String[] args) {
		 
		System.out.println("string match: " + repeatedStringMatch("abcd", "cdabcdab"));
		//stringTest();
	}
}
