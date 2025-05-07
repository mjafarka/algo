package may.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import may.MinimumTotalDistance;

class MinimumTotalDistanceTest {

	
	MinimumTotalDistance a = new MinimumTotalDistance();
	@Test
	void test() {
		Integer[] robots = new Integer[] { 0, 4, 6};
		
		List<Integer> robotsList = new ArrayList<>(List.of(robots));
		int[][] factory = new int[][] {{2,2},{6,2}};
		
		long actual = a.minimumTotalDistance(robotsList, factory);
		
		long expected = 4;
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	void test2() {
		Integer[] robots = new Integer[] {1,-1};
		
		List<Integer> robotsList = new ArrayList<>(List.of(robots));
		int[][] factory = new int[][] {{-2,1},{2,1}};
		
		long actual = a.minimumTotalDistance(robotsList, factory);
		
		long expected = 2;
		
		assertEquals(expected, actual);
	}
	
	
	
	@Test
	void test3() {
		Integer[] robots = new Integer[] {9486709,305615257,214323605,282129380,763907021,-662831631,628054452,-132239126,50488558,381544523,-656107497,810414334,421675516,-304916551,571202823,478460906,-972398628,325714139,-86452967,660743346};
		
		List<Integer> robotsList = new ArrayList<>(List.of(robots));
		int[][] factory = new int[][] 	{{-755430217,18},{382914340,2},{977509386,4},{94299927,9},{32194684,16},{-371001457,2},{-426296769,13},{-284404215,8},{-421288725,0},{-893030428,2},{291827872,17},{-766616824,8},{-730172656,17},{-722387876,1},{510570520,20},{756326049,7},{-242350340,14},{6585224,19},{-173457765,15}};
		
		long actual = a.minimumTotalDistance(robotsList, factory);
		
		long expected = 3;
		
		assertEquals(expected, actual);
	}
	

}
