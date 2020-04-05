package bitProgram_questions;

import java.util.Arrays;

/*
 * Count set bits in an integer
Write an efficient program to count number of 1s in binary representation of an integer.
Examples :
Input : n = 6
Output : 2
Binary representation of 6 is 110 and has 2 set bits
 */

public class BitSetInNumber {

	public static int countSetBitO_n(int num) {
		int count =0;
		while(num != 0) {
			num = num & num-1;
			count ++;
		}
		return count;
	}
	
	public static int countSetBitO_nXsizeofInt(int num) {
		Integer[] res = new Integer[num +1];
		Arrays.fill(res, 0);
		for(int i =1; i <= num ; i++) {
			res[i] = res[i >> 1] + (i&1); //number of 1's in result at i'th position 
			//(or i'th number) will be equals to 1's in i/2 Plus 1 if odd or 0 if even			
		}
		System.out.println("res.length " + res.length);
		return res[num];
	}
	
	public static void main(String[] args) {
		System.out.println("count 1's in: " + countSetBitO_n(0x11100111));
		System.out.println("count 1's in: " + countSetBitO_nXsizeofInt(0x11100111)); // not good will have On space not good for large number.
	}
}
