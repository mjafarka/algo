package april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
		Integer[] result = new Integer[nums.length];
		int[][] arr = new int[nums.length][2]; // [num, original index]

		for (int i = 0; i < nums.length; i++) {
			arr[i][0] = nums[i];
			arr[i][1] = i;
		}

		mergeSort(arr, 0, nums.length - 1, result);
		// return Arrays.asList(result);

		for (int i = 0; i < result.length; i++) {
			if (result[i] == null) {
				result[i] = 0;
			}
		}

		return Arrays.asList(result);
	}

	private void mergeSort(int[][] arr, int left, int right, Integer[] result) {
		if (left >= right)
			return;

		int mid = (left + right) / 2;
		mergeSort(arr, left, mid, result);
		mergeSort(arr, mid + 1, right, result);
		merge(arr, left, mid, right, result);
	}

	private void merge(int[][] arr, int left, int mid, int right, Integer[] result) {
		List<int[]> temp = new ArrayList<>();
		int i = left, j = mid + 1;
		int rightCount = 0;

		while (i <= mid && j <= right) {
			if (arr[i][0] > arr[j][0]) {
				rightCount++;
				temp.add(arr[j++]);
			} else {
				result[arr[i][1]] = result[arr[i][1]] == null ? rightCount : result[arr[i][1]] + rightCount;
				temp.add(arr[i++]);
			}
		}

		while (i <= mid) {
			result[arr[i][1]] = result[arr[i][1]] == null ? rightCount : result[arr[i][1]] + rightCount;
			temp.add(arr[i++]);
		}

		while (j <= right) {
			temp.add(arr[j++]);
		}

		for (int k = left; k <= right; k++) {
			arr[k] = temp.get(k - left);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {5,2,6,1};
		
		CountOfSmallerNumbersAfterSelf s = new CountOfSmallerNumbersAfterSelf();
		
		System.out.println(Arrays.toString(s.countSmaller(nums).toArray()));
	}
}
