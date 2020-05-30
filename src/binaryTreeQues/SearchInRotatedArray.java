package binaryTreeQues;

public class SearchInRotatedArray {

	/**
	 * nums= [4,5,6,7,0,1,2] target = 0
	 * o/p = 4
	 * @param nums
	 */
	private static boolean SearchInRotatedArray(int[] nums, int target) {
		int left = 0, right = nums.length-1, mid;
		
		while(left <= right) {
			mid = (left + right) >> 1;
			if(nums[mid] == target) {
				System.out.println("found number at index: "+ mid);
				return true;
			}
				
			System.out.println(" left: " + left + " right: " + right + " mid: " + mid);	//	f	      m         l
			if((nums[left] == nums[mid]) && (nums[right] == nums[mid])) { // something like 3 5 6 0 1 3 3 3 3 3 3
				++left;
				--right;
			} else if(nums[left] <= nums[mid]) { // first half in order
				if(nums[left] <= target && nums[mid] > target) {
					right = mid -1;
				} else {
					left = mid +1 ;
				}
				
			} else { 
				if(nums[mid] < target && nums[right] >= target) {
					left = mid + 1;
					
				} else {
					right = mid - 1;
				}
			}
		}
		System.out.println("Number NOT found");
		return false;
		
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("In package: bin tree: search in rotated array problem.");
		int[] nums = {3,3,4,0,1,2,3,3};//{4,5,6,7,0,1,2};
		SearchInRotatedArray(nums, 3);
	}

}
