package array_questions;

public class SortArrayInEvenOdd {

	//public void swap(int)
	public static void sorArray(int[] arr) {
		int len = arr.length;
		for(int i =0; i < len; i++) {
			if(arr[i] % 2 == 1) {
		//		swap(arr[i], arr[len-i]);
				int t = arr[i];
				arr[i] = arr[len -1];
				arr[len -1] = t;
				i--;
				len--;
			}
		}
	}
	
	static void printArrary(int [] A) {
		
		for(int i : A ) { System.out.print(i + ","); }		
		//  for (int i =0 ; i < A.length ; i++) { System.out.print(A[i] +","); }
		 
	}
	
	public static void flipImage() {
		int[][] A = {
				{0,1,1}, 
				{1,0,0},
				{0,0,1},
				{0,1,1},
		};
		System.out.println("before flip:");
		for(int[] arr: A) {
			printArrary(arr);
			System.out.println("\n");
		}
		
		System.out.println("size: A: " + A.length +" size: A[0]" + A[0].length);
		
		for (int[] arr: A) {
			int i =0;
			int rlen = A[0].length;
			while (i <= rlen) {
				int t = arr[rlen-1];
				arr[rlen -1 ] = arr[i];
				arr[i] = t;
				i++;
				rlen--;
			}				
		}
		System.out.println("after flip:");
		for(int[] arr: A) {			
			printArrary(arr);
			System.out.println("\n");
		}
	}
	public static void main(String[] args) {
		System.out.println("sort array: ");
		int A[] = {1,3,4,6,5};
		printArrary(A);
		sorArray(A);
		System.out.println("after sort: ");
		printArrary(A);
		
		flipImage();
	}
}
