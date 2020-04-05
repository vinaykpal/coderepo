package maps_questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class TwoSum {
	
	public static void findTwoSumIndecies(int[] nums, int target) {
		
		int[]res = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i= 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				res[1] = i;
				res[0] = map.get(target - nums[i]);
			} else {
				map.put(nums[i], i);
			}
		}
		
		System.out.println("In package: mapsquestions: two sum indeces are: ");
		for(int i = 0; i< res.length; i++) {
			System.out.println(res[i] + " ");
		}
		
	}
	
	public static void singleNum_Set(int[] nums) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int num : nums) {
			if(set.contains(num)) {
				set.remove(num);
			} else {
				set.add(num);
			}
		}
		
		System.out.println("singleNum: " + set.iterator().next());
		
	}
	
	public static void singleNum_ExOr(int[] nums) {
		int res =0;
		
		for(int i = 0; i < nums.length; i++) {
			res = res ^ nums[i];
		}
		
		System.out.println("single number is : " + res);
	}
	
	public static void numJwelInStone(String j, String s ) {
		int res =0;
		Set<Character> setj = new HashSet<Character>();
		for(int i = 0 , n = j.length(); i< n; i++) {
			setj.add(j.charAt(i));
		}
		for(int i = 0, n = s.length(); i< n; i++) {
			if(setj.contains(s.charAt(i))) {
				res ++;
			}
		}
		
		System.out.println("num of Jwels: " + res);
	}
	
	public static boolean isIsomorphic(String s, String t) {
		
		if (s.length() != t.length())
			return false;
		
		Map<Character, Character> m = new HashMap<Character, Character>();
		
		for (int i =0, n = s.length(); i<n; i++){
			char k = s.charAt(i);
			char v = t.charAt(i);
		
			if(m.containsKey(k)){
				if(m.get(k).equals(v)) {
					continue;
				} else {
					return false;
				}
			} else {
				if(m.containsValue(v)) {
					return false;
				} else {
					m.put(k, v);
				}
			}
		}
		
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("In package: mapsquestions: two sum.");
		
		int[] nums = {2, 7, 8, 19, 10};
		int target = 17;
				
		TwoSum.findTwoSumIndecies(nums, target);
		
		int nums1[] = {2, 2, 4, 355, 9, 4, 9};
		TwoSum.singleNum_Set(nums1);
		TwoSum.singleNum_ExOr(nums1);
		
		numJwelInStone("aAbBB", "aAAbb");
		
		System.out.println("isIsomorphic: " + isIsomorphic("egg", "add"));
	}
}
