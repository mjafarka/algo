package may;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FindMinimumTimeToReachTest {

	FindMinimumTimeToReach f = new FindMinimumTimeToReach();
	@Test
	void test() {
		int[][] moveTime = new int[][] {{0,4},{4,4}};
		
		int actual = f.minTimeToReach(moveTime);
		int expected = 6;
		
		assertEquals(expected,actual);
	}
	
	
	@Test
	void test1() {
		int[][] moveTime = new int[][] {{0,0,0},{0,0,0}};
		
		int actual = f.minTimeToReach(moveTime);
		int expected = 3;
		
		assertEquals(expected,actual);
	}
	
	@Test
	void test2() {
		int[][] moveTime = new int[][] {{1,1},{1,2}};
		
		int actual = f.minTimeToReach(moveTime);
		int expected = 3;
		
		assertEquals(expected,actual);
	}
	
	@Test
	void test3() {
		int[][] moveTime = new int[][] {{17,56},{97,80}};
		
		int actual = f.minTimeToReach(moveTime);
		int expected = 81;
		
		assertEquals(expected,actual);
	}

}
