package april;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//    Top K Frequent Elements
public class TopKFrequentElement {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer,int[]> count = new HashMap<>();
		
		List<int[]> countAr = new ArrayList<>();
		
		for (int num : nums) {
			
			if (count.get(num) == null) {
				int[] a = new int[] {num,0};
				
				count.put(num, a);
				
				countAr.add(a);
			}
			
			
			count.get(num)[1] ++; // which will increment count
		}
		
		Collections.sort(countAr, (a,b) -> {
			return - (a[1] - b[1]);
		});
		
		
		int[] res = new int[k];
		
		for (int i = 0 ; i < k ; i ++) {
			res[i] = countAr.get(i)[0];
		}
		
		return res;
	}
}
