package april.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import april.PathsInMazeThatLeadsToSameRoom;

class PathsInMazeThatLeadsToSameRoomTest {

	
	PathsInMazeThatLeadsToSameRoom a = new PathsInMazeThatLeadsToSameRoom();
	@Test
	void test1() {
		int[][] nums = new int[][] {{1,2},{2,3},{3,1},{3,4},{4,2}};
		
		int expected = 2;
		
		assertEquals(expected, a.findConfusionScore(5, nums));
	}
	
	
	@Test
	void testNoConfusion() {
		int[][] nums = new int[][] {{1,2},{3,4}};
		
		int expected = 0;
		
		assertEquals(expected, a.findConfusionScore(2, nums));
	}

	
	
	
	
	@Test
	void testLeetcodeCode1() {
		int[][] nums = new int[][] {{1,2},{2,3},{3,1},{3,4},{4,2}};
		
		int expected = 2;
		
		assertEquals(expected, a.numberOfPaths(5, nums));
	}
	
	
	@Test
	void testLeetcodeCode2() {
		int[][] nums = new int[][] {{1,2},{3,4}};
		
		int expected = 0;
		
		assertEquals(expected, a.numberOfPaths(4, nums));
	}
}
