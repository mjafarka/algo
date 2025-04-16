package april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfNumberSmallerThanSelf {
	public List<Integer> countSmaller(int[] nums) {
		Integer[] result = new Integer[nums.length];
		int[][] arr = new int[nums.length][2]; // [num, original index]

		// nothing //
		for (int i = 0; i < nums.length; i++) {
			arr[i][0] = nums[i];
			arr[i][1] = i;
		}
		//normal merge sort
		mergeSort(arr, 0, nums.length - 1, result);
		return Arrays.asList(result);
	}

	private void mergeSort(int[][] arr, int left, int right, Integer[] result) {
		if (left >= right)
			return;

		int mid = (left + right) / 2;
		mergeSort(arr, left, mid, result);
		mergeSort(arr, mid + 1, right, result);
		
		//merge logic
		merge(arr, left, mid, right, result);
	}

	
	/**
	 * merging along with populating the answer.
	 * @param arr
	 * @param left
	 * @param mid
	 * @param right
	 * @param result
	 */
	private void merge(int[][] arr, int left, int mid, int right, Integer[] result) {
	    List<int[]> temp = new ArrayList<>();
	    int i = left, j = mid + 1;
	    int rightCount = 0;
	   // ------------------------------ start-----------------------------------// pure sorting logic
	    while (i <= mid && j <= right) {
	        if (arr[i][0] > arr[j][0]) {
	            rightCount++;               // wrong but for understanding. example =>  [2,5], [1,6], first, (2 > 1) rightCount increases, (2 < 6) then 2 assign with the value '1' right count, after that also , 5 < 6, 5 assign with 1.
	            temp.add(arr[j]);
	            System.out.println("Moved " + arr[j][0] + " (right) before " + arr[i][0] + " (left)");
	            j++;
	        } else {
	            result[arr[i][1]] = result[arr[i][1]] == null ? rightCount : result[arr[i][1]] + rightCount;
	            System.out.println("Count for " + arr[i][0] + " (index " + arr[i][1] + ") = " + result[arr[i][1]]);
	            temp.add(arr[i++]);
	        }
	    }

	    while (i <= mid) {
	        result[arr[i][1]] = result[arr[i][1]] == null ? rightCount : result[arr[i][1]] + rightCount;
	        System.out.println("Count for " + arr[i][0] + " (index " + arr[i][1] + ") = " + result[arr[i][1]]);
	        temp.add(arr[i++]);
	    }

	    // every value in right will be bigger than left values.
	    while (j <= right) {
	        temp.add(arr[j++]);
	    }

	    for (int k = left; k <= right; k++) {
	        arr[k] = temp.get(k - left);
	    }
		   // ------------------------------ end-----------------------------------//
}
	
	public static void main(String[] args) {
		int[] nums = new int[] {5,2,6,1}
		
		;
		
		CountOfNumberSmallerThanSelf s = new CountOfNumberSmallerThanSelf();
		
		System.out.println(Arrays.toString(s.countSmaller(nums).toArray()));
	}
}
