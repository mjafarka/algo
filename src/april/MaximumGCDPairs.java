package april;

import java.util.Arrays;


//Max GCD Pair
public class MaximumGCDPairs {
	
	/**
	 * find the maximum. and use a frequency array to story frequency.
	 * 
	 * if a number between max to 1, has its frequency or sum of its products frequency is greater than or equal to
	 * 2 then return that number. that will be the largest number. since we are taking from max to 1
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int maxGCDPair(int[] arr, int n) {
		int max = 0;
		// Find the maximum element in the array
		for (int i = 0; i < n; i++) {
			max = Math.max(max, arr[i]);
		}
		System.out.println("Maximum element in array: " + max);

		// Create and fill frequency array
		int[] freq = new int[max + 1];
		for (int i = 0; i < n; i++) {
			freq[arr[i]]++;
		}

		System.out.println("Frequency array:");
		for (int i = 1; i <= max; i++) {
			if (freq[i] > 0) {
				System.out.println("Number " + i + " appears " + freq[i] + " time(s)");
			}
		}

		// Traverse from the maximum element to 1
		for (int i = max; i >= 1; i--) {
			int count = 0;
			// Check multiples of i
			System.out.println("\nChecking for GCD candidate: " + i);
			for (int j = i; j <= max; j += i) {
				System.out.println(" checking for j="+j+" and freq[j]="+freq[j]);
				if (freq[j] > 0) {
					count += freq[j];
					System.out.println(" - Number " + j + " is divisible by " + i + ", count now " + count);
				}
				
				if (count >= 2) {
					System.out.println("Found at least 2 numbers divisible by " + i + ", so answer is " + i);
					return i;
				}
			}
			
		}

		System.out.println("No GCD > 1 found, returning 1");
		return 1; // If no GCD > 1 found
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {5,2,4,3,1};
		
		System.out.println(maxGCDPair(nums, 5));
		
		System.out.println("---------next test--------------\n\n");
		
int[] nums1 = new int[] {6,2,4,3,1};

System.out.println("with nums="+Arrays.toString(nums));
		
		System.out.println(maxGCDPair(nums1, 5));
		
		
		
		System.out.println("---------next test 3--------------\n\n");
		
		int[] nums3 = new int[] {7,3,1};

		System.out.println("with nums="+Arrays.toString(nums3));
				
				System.out.println(maxGCDPair(nums3, 3));
	}
}
