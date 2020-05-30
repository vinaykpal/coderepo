import java.util.HashMap;

public class HashMapLeetCode {
	
	/*
	 * Input: J = "aA", S = "aAAbbbb"
	Output: 3
	 */
	public void findJewelAndStones (String J, String S) {
		int res =0;
		for (char c : S.toCharArray()) {
			//System.out.println("char: " + c);
			//System.out.println("IndexOf " + J.indexOf(c));
			
			if (J.indexOf(c) != -1) {
				
				res ++;
			}
		}
		System.out.print("output: " + res);
		
	
		
	}

	/*
	 * Input: s = "anagram", t = "nagaram"
		Output: true
	 */
	public boolean isValidAnagram (String S, String T) {
		HashMap<String, Integer> map = new HashMap();
		System.out.print(map);
//		for (char c : S) {
//			
//		}
	return false;
	}
}
