package ps.mailprogramming;

import java.util.HashMap;

/**
 * String이 주어지면, 중복된 char가 없는 가장 긴 서브스트링 (substring)의 길이를 찾으시오.
 * 
 * 예제)
 * Input: “aabcbcbc”
 * Output: 3 // “abc”
 * 
 * Input: “aaaaaaaa”
 * Output: 1 // “a”
 * 
 * Input: “abbbcedd”
 * ﻿Output: 4 // “bced”
 * 
 * @author CHUNGJUNG
 *
 */

public class SiliconValley10 {
	
	public static void main(String[] args) {
		String input = "abcdecfgh";
		
		System.out.println(maxLengthNonDuplicate(input));
	}
	
	/**
	 * 받은 문자열을 처음부터 끝까지 지나가며 다음을 반복한다.
	 * 해시맵에 해당 문자에 대한 value가 존재하는지 확인한다.
	 * 만약 존재하지 않는다면 문자와 인덱스를 쌍으로 해시맵에 넣고 다음 문자로 넘어간다.
	 * 만약 존재한다면 지금까지의 서브스트링 길이를 측정한다.(index - top)
	 * 그리고 이 길이와 최대 길이를 비교하여 갱신한다.
	 * 마지막으로 top 포인터를 이동시킨다.(해당 문자의 value + 1)
	 */
	private static int maxLengthNonDuplicate(String input) {
		int maxLength = 0;
		int top = 0;
		HashMap<Character, Integer> substring = new HashMap<>();
		
		for (int i = 0; i < input.length(); i++) {
			if (substring.containsKey(input.charAt(i))) {
				System.out.println("top: " + top + ", i: " + i);
				maxLength = (maxLength < i - top) ? i - top : maxLength;
				top = substring.get(input.charAt(i)) + 1;
			}
			
			substring.put(input.charAt(i), i);
		}
		
		maxLength = (maxLength < input.length() - top) ? input.length() - top : maxLength;
		
		return maxLength;
	}

}



