package april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

//    Top K Frequent Elements
public class TopKFrequentElement {
	
	// will directly update at the address the count. then using that count sort the array
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, int[]> count = new HashMap<>();

		List<int[]> countAr = new ArrayList<>();

		for (int num : nums) {

			if (count.get(num) == null) {
				int[] a = new int[] { num, 0 };

				count.put(num, a);

				countAr.add(a);
			}

			count.get(num)[1]++; // which will increment count
		}

		Collections.sort(countAr, (a, b) -> {
			return -(a[1] - b[1]);
		});

		int[] res = new int[k];

		for (int i = 0; i < k; i++) {
			res[i] = countAr.get(i)[0];
		}

		return res;
	}
	
	// ------------------- bucket sort start ----------------------------//
	
	int[] unique;
    Map<Integer, Integer> count;

    public void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot_frequency = count.get(unique[pivot_index]);
        // 1. Move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. Move all less frequent elements to the left
        for (int i = left; i <= right; i++) {
            if (count.get(unique[i]) < pivot_frequency) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. Move the pivot to its final place
        swap(store_index, right);

        return store_index;
    }
    
    public void quickselect(int left, int right, int k_smallest) {
        /*
        Sort a list within left..right till kth less frequent element
        takes its place. 
        */

        // base case: the list contains only one element
        if (left == right) return;
        
        //Select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);  

        // Find the pivot position in a sorted list
        pivot_index = partition(left, right, pivot_index);

        // If the pivot is in its final sorted position
        if (k_smallest == pivot_index) {
            return;    
        } else if (k_smallest < pivot_index) {
            // go left
            quickselect(left, pivot_index - 1, k_smallest);     
        } else {
            // go right 
            quickselect(pivot_index + 1, right, k_smallest);  
        }
    }
    
    public int[] topKFrequentBucketSort(int[] nums, int k) {
        // Build hash map: character and how often it appears
        count = new HashMap();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        // Array of unique elements
        int n = count.size();
        unique = new int[n]; 
        int i = 0;
        for (int num: count.keySet()) {
            unique[i] = num;
            i++;
        }
        
        // kth top frequent element is (n - k)th less frequent.
        // Do a partial sort: from less frequent to the most frequent, till
        // (n - k)th less frequent element takes its place (n - k) in a sorted array. 
        // All elements on the left are less frequent.
        // All the elements on the right are more frequent. 
        quickselect(0, n - 1, n - k);
        // Return top k frequent elements
        return Arrays.copyOfRange(unique, n - k, n);
    }
	// ------------------- bucket sort end ------------------------------//

	// keep k element in the heap
	public int[] topKFrequentHeap(int[] nums, int k) {

		Map<Integer, Integer> count = new HashMap<>();

		for (int num : nums) {
			count.putIfAbsent(num, 0);

			count.put(num, count.get(num) + 1);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return (a[1] - b[1]);
		});

		for (int key : count.keySet()) {
			pq.add(new int[] { key, count.get(key) });

			if (pq.size() > k) {
				pq.remove();
			}
		}

		int[] res = new int[k];

		int i = 0;

		while (pq.isEmpty() == false) {
			res[i] = pq.remove()[0];
			i++;
		}
		return res;
	}
}
