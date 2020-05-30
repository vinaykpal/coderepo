/**
 * 
 */
package binaryTreeQues;

/**
 * @author t0158551
 *
 */
public class DivideWithoutOperator {

	/**
	 * 
	 */
	public DivideWithoutOperator() {
		// TODO Auto-generated constructor stub
	}

	private static void divideWithoutOperator(int dividend, int divisor) {
		long ans =0;
		long dvd = dividend;
		long dvs = divisor;
		while(dvd >= dvs) {
			long temp = dvs, m=1;
			while (dvd >= temp) {
				temp <<= 1;
				m <<=1;
			}
	
		dvd = dvd - temp;
		ans = ans + m;
		
		}		
		System.out.println("divideWithoutOperator res: " + ans);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Binary Tree package");
		//System.out.println("Int max: " +Integer.MAX_VALUE);
		//System.out.println("Int min: " +Integer.MIN_VALUE);
		divideWithoutOperator(15,3);
		
		

	}

}
