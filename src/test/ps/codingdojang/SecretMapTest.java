package test.ps.codingdojang;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import ps.codingdojang.SecretMap;

public class SecretMapTest {
	@Test
	void testSolution() {
		SecretMap map = new SecretMap();
		
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		String[] result = {"#####","# # #", "### #", "#  ##", "#####"};
		
		assertArrayEquals(result, map.solution(n, arr1, arr2));
	}
}
