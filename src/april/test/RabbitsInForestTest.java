package april.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import april.RabbitsInForest;

class RabbitsInForestTest {


	RabbitsInForest a = new RabbitsInForest();


	@Test
	void test1() {
		int[] anwers = new int[] {1,1,2};
		
		int expected = 5;
		
		assertEquals(expected,a.numRabbits(anwers));
	}

	@Test
	void test2() {
		int[] anwers = new int[] {10,10,10};
		
		int expected = 11;
		
		assertEquals(expected,a.numRabbits(anwers));
	}

	

	@Test
	void test3() {
		int[] anwers = new int[] {1,0,1,0,0};
		
		int expected = 5;
		
		assertEquals(expected,a.numRabbits(anwers));
	}

	@Test
	void test4() {
		int[] anwers = new int[] {0,0,1,1,1};
		
		int expected = 6;
		
		assertEquals(expected,a.numRabbits(anwers));
	}

}
