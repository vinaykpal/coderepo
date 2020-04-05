package binaryTreeQues;

/**
 * 302. Smallest Rectangle Enclosing Black Pixels
Hard
12033FavoriteShare
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e.,
there is only one black region. Pixels are connected horizontally and vertically.
Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
Example:
Input:
[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2

Output: 6
 * @author t0158551
 *
 */
public class SmallestAreaOfOne {

	private int top, bottom, left, right;
	/*
	 * Here E is the number of edges in the traversed graph. B is the total number of black pixels. Since each pixel have four edges at most, O(E)=O(B). In the worst case, O(B)=O(mn).
Space complexity : O(V)=O(B)=O(mn).
The space complexity is O(V) where V is the number of vertices in the traversed graph. In this problem O(V)=O(B). Again, in the worst case, O(B)=O(mn).

	 */
	public int smallestArea(char [][] image, int x, int y) {
	
		if((image.length ==0) || (image[0].length ==0)||(image[x][y] == '0')) {
			return 0;
		}
		
		top = bottom = x;
		left = right = y;
		
		recurseFind(image, x, y);
		
		System.out.println("smallest area of 1s: " + ((bottom - top) * (right - left)));
		
		return ((bottom - top) * (right - left));
		
	}
	
	void recurseFind(char [][]image, int x, int y) {
		System.out.println("x: "+ x +" y: "+ y+" top: "+ top+" bottom: "+ bottom+" left: "+ left+" right: "+ right);
		
		if(x < 0 || y < 0 || x >= image.length || y >= image[0].length || (image[x][y] == '0') ){
			return;
		}
		
		image[x][y] = '0';
		
		top = Math.min(top, x);
		bottom = Math.max(bottom, x+1);
		left = Math.min(left, y);
		right = Math.max(right, y+1);
		
		recurseFind(image, x, y+1);
		recurseFind(image, x, y-1);
		recurseFind(image, x+1, y);
		recurseFind(image, x-1, y);
		
	}
	
	public static void main(String[] args) {
		SmallestAreaOfOne obj = new SmallestAreaOfOne();
		char [] [] image = {
				{'0','0','1','0'},
				{'0','1','1','0'},
				{'0','1','0','0'},				
		};
		//obj.smallestArea(image, 1, 2);
		obj.smallestAreaP(image, 1, 2);
	}
	
	//************ practice
	
	public void smallestAreaP(char[][]img, int x, int y) {
		
		if(img.length==0 || img[0].length ==0 || img[x][y] == '0') {
			return;
		}
		
		//int top, bottom, left, right; defined in class scope
		top = bottom = x;
		left = right = y;
		
		findrecurP(img, x, y);
	
		System.out.println("area: " + ((bottom - top) * (right - left)));
	}
	void findrecurP(char[][] img, int x, int y) {
		if( x <0 || y <0 || x >= img.length || y >= img[0].length || img[x][y] == '0') {
			return;
		}
		img[x][y] ='0';
		top = Math.min(top, x);
		bottom = Math.max(bottom, x+1);
		
		left = Math.min(left, y);
		right = Math.max(right, y+1);
		
		findrecurP(img, x+1, y);
		findrecurP(img, x-1, y);
		findrecurP(img, x, y+1);
		findrecurP(img, x, y-1);
	}
	
	
	
	
}

