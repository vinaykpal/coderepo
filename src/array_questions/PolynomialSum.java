package array_questions;
/**
 * Program to add two polynomials
Given two polynomials represented by two arrays, write a function that adds given two polynomials.
Example:

Input:  A[] = {5, 0, 10, 6} 
        B[] = {1, 2, 4} 
Output: sum[] = {6, 2, 14, 6}

The first input array represents "5 + 0x^1 + 10x^2 + 6x^3"
The second array represents "1 + 2x^1 + 4x^2" 
And Output is "6 + 2x^1 + 14x^2 + 6x^3"
 * @author t0158551
 *
 */
public class PolynomialSum {

	// A utility function to return maximum of two integers  
    static int max(int m, int n) { 
        return (m > n) ? m : n; 
    } 
  
// A[] represents coefficients of first polynomial  
// B[] represents coefficients of second polynomial  
// m and n are sizes of A[] and B[] respectively  
    static int[] add(int A[], int B[], int m, int n) { 

    	int size = Math.max(m,n);
    	
    int[] sum = new int[size];
    int idx =0;
    while (m != 0 && n != 0) {
    	sum[idx] = A[idx] + B[idx];
    	idx++; m--; n--;
    }
    if(m > n) {
    	while (m!=0) {
    		sum[idx] = A[idx];
    		idx++; m--;
    	}
    } else if (m < n) {
    	while (n!=0) {
    		sum[idx] = B[idx];
    		idx++;
    		n--;
    	}
    }
    	/*
    	int size = max(m, n); 
        int sum[] = new int[size]; 
        
// Initialize the product polynomial  
        for (int i = 0; i < m; i++) { 
            sum[i] = A[i]; 
        } 
  
// Take ever term of first polynomial  
        for (int i = 0; i < n; i++) { 
            sum[i] += B[i]; 
        } 
  */
        return sum; 
    } 
  
// A utility function to print a polynomial  
    static void printPoly(int poly[], int n) { 
        for (int i = 0; i < n; i++) { 
            System.out.print(poly[i]); 
            if (i != 0) { 
                System.out.print("x^" + i); 
            } 
            if (i != n - 1) { 
                System.out.print(" + "); 
            } 
        } 
    } 
  
// Driver program to test above functions  
    public static void main(String[] args) { 
        // The following array represents polynomial 5 + 10x^2 + 6x^3  
        int A[] = {5, 0, 10, 6}; 
  
        // The following array represents polynomial 1 + 2x + 4x^2  
        int B[] = {1, 2, 4, 9, 2}; 
        int m = A.length; 
        int n = B.length; 
        System.out.println("First polynomial is"); 
        printPoly(A, m); 
        System.out.println("\nSecond polynomial is"); 
        printPoly(B, n); 
        int sum[] = add(A, B, m, n);
        int size = max(m, n); 
        System.out.println("\nsum polynomial is"); 
        printPoly(sum, size); 
  
    } 
	
}
