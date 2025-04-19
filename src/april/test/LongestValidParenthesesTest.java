package april.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import april.LongestValidParentheses;

class LongestValidParenthesesTest {

	LongestValidParentheses l = new LongestValidParentheses();
	
	
	@Test
	void test() {
		
		String s = ")()(())";
		
		
		assertEquals(6,l.longestValidParenthesesCORRECT(s));
	}
	

	@Test
	void test1() {
		
		String s = ")()())";
		
		
		assertEquals(4,l.longestValidParenthesesCORRECT(s));
	}
	
	@Test
	void test2() {
		
		String s = "(()";
		
		
		assertEquals(2,l.longestValidParenthesesCORRECT(s));
	}

}
