package maps_questions;

import java.util.HashMap;
import java.util.Map;
/**
 * Find the longest subarray not more than k distinct elements
 * input: karappa
 * output: appa
 * @author t0158551
 *
 */
public class LengthOfLongestSubstring {
	
	public static void lengthOfLongestSubstring(String s){
		
		int max =0;
		Map<Character, Integer> map = new HashMap<Character, Integer>(); 
		for(int i =0, j =0; i< s.length() ; ++i ) {
			System.out.println("i: " +i+ "j :"+ j);
			
			if(map.containsKey(s.charAt(i))){			
				j = Math.max(j, map.get(s.charAt(i))+1);
				System.out.println("j after:"+ j);
			}
			
			map.put(s.charAt(i), i);		
			max = Math.max(max, i-j+1);			
		}
		System.out.println("max after loop:"+ max);
		
	}
	
	public static void longestSubarrayNotMoreThanKDistinctElements(String s, int k) {
		
		int start =0, end =0, now=0, l =0;
		
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		
		for(int i =0; i< s.length(); i++ ) {
		//	System.out.println("map values before:" + freq.keySet()+ " values: " + freq.values() );
			freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
		//	System.out.println("map values after:" + freq.keySet() + " values: " + freq.values());
			if(freq.get(s.charAt(i)) == 1) {
				now++;
			}
			while(now > k) {
				freq.put(s.charAt(l), freq.get(s.charAt(l))-1);
				//System.out.println("map values in while" + freq.keySet() + " values: " + freq.values());
				if(freq.get(s.charAt(l)) == 0){
					now--;
				} 
				l++;					
			}
			
			start = l;
			end = i;
			
		}
//		System.out.println("string is : "  + start + " " + end );

		while(end >= start) {
			System.out.print(s.charAt(start));
			start++;
		}
	}
	public static void main(String[] args) {
		//lengthOfLongestSubstring("abcabcbb");
	//	lengthOfLongestSubstring("karappa");
		//longestSubarrayNotMoreThanKDistinctElements("12312114", 2);
		longestSubarrayNotMoreThanKDistinctElements("karappa", 2);
	}

}
