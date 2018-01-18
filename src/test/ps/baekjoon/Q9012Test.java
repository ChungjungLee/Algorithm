package test.ps.baekjoon;

import org.junit.jupiter.api.Test;

import ps.baekjoon.Q9012;

public class Q9012Test {
	@Test
	void testMain() {
		String input = "";
		input += "6\n";
		input += "(())())\n";
		input += "(((()())()\n";
		input += "(()())((()))\n";
		input += "((()()(()))(((())))()\n";
		input += "()()()()(()()())()\n";
		input += "(()((())()(\n";
		
		String[] args = {input};
		
		Q9012.main(args);
	}
}
