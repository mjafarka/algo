package april;

/**
 * cycle sort solution
 * 
 *  First Missing Positive - cycle sort
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
        
		
		int n = nums.length;
	
		for (int i = 0 ; i < nums.length ; i ++ ) {
			int num = nums[i];
			
			while (num <= n && num >= 1 && nums[num-1] != num) {
				swap(nums,i,num-1);
				
				num = nums[i];
			}
		}
		
		
		for (int i = 1 ; i <= n ; i++) {
			if (nums[i-1] != i) {
				return i;
			}
		}
		
		return n + 1;
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
