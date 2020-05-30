package suffix_prefix_pattern_matching;
/**
 * 
 * @author t0158551
 *Do pattern matching using KMP algorithm
 * 
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 * 
 */
public class SubstringSearch {

	public boolean hasSubstring(char[] s, char[] ss) {
		int i =0, j =0, k=0;
		
		while (i < s.length && j < ss.length) {
			if (s[i] == ss[j]) {
				i++;
				j++;
			} else {
				j = 0;
				k++;
				i = k;
			}
		}
		if(j == ss.length) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String text = "abcxabcdabcdabcy";
		String pattern = "abcdabcy";
		SubstringSearch ss = new SubstringSearch();
		System.out.println("has substring: " +ss.hasSubstring(text.toCharArray(), pattern.toCharArray()));
	}
}
