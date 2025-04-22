package april;

// Find Minimum in Rotated Sorted Array
public class FindMinimumInRotatedSortedArray {

	// simple solution 
	public int findMinSimple(int[] nums) {

		int left = 0, right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else { // nums[mid] <= nums[right]
				right = mid;
			}
		}

		return nums[right];
	}

	// my solution

	public int findMin(int[] nums) {

		if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return Math.min(nums[0], nums[1]);
		}

		int l = 0;
		int r = nums.length - 1;

		while (l <= r) {
			int m = l + (r - l) / 2;

			if (m + 1 < nums.length && m - 1 >= 0) {
				if (nums[m] < nums[m + 1] && nums[m] < nums[m - 1])
					return nums[m];
			} else if (m + 1 < nums.length) {
				if (nums[m] < nums[m + 1])
					return nums[m];
			} else {
				if (nums[m] < nums[m - 1])
					return nums[m];
			}

			if (nums[m] >= nums[l]) {
				if (nums[l] > nums[r]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			} else {
				if (nums[l] > nums[r]) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray a = new FindMinimumInRotatedSortedArray();
		int[] nums = new int[] { 1, 2, 3, 4 };

		System.out.println(a.findMin(nums));
	}
}
