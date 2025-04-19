package april;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MaximumNumberofIntegersToChooseFromARangeI {
	public int maxCount(int[] banned, int n, int maxSum) {
		Set<Integer> bannSet = Arrays.stream(banned).boxed().collect(Collectors.toSet());
				
		
		
		int count = 0;
		int sum = 0;
		for (int i = 1 ; i <= n ; i++ ) {
			
			if (bannSet.contains(i)) continue;
			
			sum += i;
			
			if (sum > maxSum) {
				return count;
			}
			
			count ++;
			
			
		}
		
		return count;
	
	}
}
