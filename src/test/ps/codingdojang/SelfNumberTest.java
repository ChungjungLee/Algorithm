package test.ps.codingdojang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ps.codingdojang.SelfNumber;

public class SelfNumberTest {
	
	/**
	 * 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97, 108, 110, 121, 
	 * 132, 143, 154, 165, 176, 187, 198, 209, 211, 222, 233, 244, 
	 * 255, 266, 277, 288, 299, 310, 312, 323, 334, 345, 356, 367, 
	 * 378, 389, 400, 411, 413, 424, 435, 446, 457, 468, 479, 490, ...
	 */
	@Test
	void solutionTest() {
		SelfNumber test = new SelfNumber();
		
		int n1 = 10;
		int n2 = 100;
		
		assertEquals(25, test.solution(n1));
		assertEquals(493, test.solution(n2));
		
	}
}
