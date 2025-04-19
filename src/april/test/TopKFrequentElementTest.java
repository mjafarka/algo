package april.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import april.TopKFrequentElement;

class TopKFrequentElementTest {

	
	TopKFrequentElement a = new TopKFrequentElement();
	@Test
	void test() {
		int[] num = new int[] {1,2,2,3,3,3};
		
		int k = 2;
		
		int[] res = new int[] {2,3};
		
		int[] out = a.topKFrequent(num, k);
		
		Arrays.sort(out);
		
		
		
		for (int i = 0 ;i < out.length ; i++) {
			assertEquals(res[i],out[i]);
		}
	}
	
	@Test
	void test1() {
		int[] num = new int[] {7,7};
		
		int k = 1;
		
		int[] res = new int[] {7};
		
		int[] out = a.topKFrequent(num, k);
		
		Arrays.sort(out);
		
		
		
		for (int i = 0 ;i < out.length ; i++) {
			assertEquals(res[i],out[i]);
		}
	}

}
