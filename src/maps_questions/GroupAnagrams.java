package maps_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GroupAnagrams {
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		
		if((strs == null) || (strs.length ==0)) 
			return new ArrayList<List<String>>();
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for(String s : strs) {
			System.out.println("string: " + s);
			
			char[] ca  = s.toCharArray();
			//System.out.println("before sort: " + String.valueOf(ca));
			Arrays.sort(ca);
			//System.out.println("after sort: " + String.valueOf(ca));
			
			String keyStr = String.valueOf(ca);
			// if sorter string as key not found in map, put it first
			if(!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<String>());
			map.get(keyStr).add(s);
		}
		return new ArrayList<List<String>>(map.values());
	}
	
	public static void main(String[] args) {
		String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println("group anagrams: " +groupAnagrams(s));
	}
}
