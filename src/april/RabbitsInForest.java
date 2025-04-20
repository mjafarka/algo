package april;

import java.util.HashMap;
import java.util.Map;


// Rabbits in Forest 
/*
 * the question itself is somewhat incomplete
 * 
 * 1,1,1  means, the 1,1 are same color and the third one is in different color
 */
public class RabbitsInForest {
	public int numRabbits(int[] answers) {
		
		Map<Integer,Integer> rabCount = new HashMap<>();
		
		
		for (int num : answers) {
			rabCount.putIfAbsent(num, 0);

			rabCount.put(num, rabCount.get(num) + 1);
		}


		int count = 0;

		for (int key : rabCount.keySet()) {

			int answeredRab = rabCount.get(key);

			count += (((answeredRab / (key + 1)) + ((answeredRab % (key + 1)) > 0 ? 1 : 0)) * (key + 1));
		}
		return count;
	}
}
