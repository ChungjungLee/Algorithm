package ps.mailprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 문자열 배열(string array)이 주어지면, 제일 긴 공통된 접두사(prefix)의 길이를 찾으시오.
 * 
 * 예제)
 * Input: ["apple", "apps", "ape"]
 * Output: 2 // “ap”
 * 
 * Input: ["hawaii", "happy"]
 * Output: 2 // “ha”
 * 
 * Input: ["dog", "dogs", "doge"]
 * Output: 3 // “dog”
 * 
 * @author CHUNGJUNG
 * 
 */
public class SiliconValley14 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		
		String[] splited = input.split("\"");
		
		ArrayList<String> refinedInput = new ArrayList<>();
		
		System.out.println("---splited---");
		for (String str : splited) {
			if (str.equals("[") || str.equals("]") || str.equals(", ")) {
				continue;
			}
			refinedInput.add(str);
		}
		
		long startTime = System.nanoTime();		
		System.out.println(solution(buildStrArray(refinedInput)));
		System.out.println("Elapsed Time: "+(System.nanoTime()-startTime)/1000000.0+"ms");
		
	}
	
	/**
	 * 휴리스틱한 풀이법: 하나씩 처음부터 비교하기
	 * @param inputs
	 * @return
	 */
	private static String solution(String[] inputs) {
		String result = "";
		
		int index = 0;
		while (true) {
			for (int i = 0; i < inputs.length - 1; i++) {
				if (index >= inputs[i].length() || index >= inputs[i + 1].length()) {
					return result;
				}
				
				if (inputs[i].charAt(index) != inputs[i + 1].charAt(index)) {
					return result;
				}
			}
			
			result += inputs[0].charAt(index);
			index++;
		}
	}
	
	private static String[] buildStrArray(ArrayList<String> input) {
		String[] result = new String[input.size()];
		
		for (int i = 0; i < input.size(); i++) {
			result[i] = input.get(i);
		}
		
		return result;
	}
}













