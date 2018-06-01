package ps.mailprogramming;

/**
 * 정수 배열(int array)이 주어지면 0이 아닌 정수 순서를 유지하며 모든 0을 배열 오른쪽 끝으로 옮기시오. 
 * 단, 시간복잡도는 O(n), 공간복잡도는 O(1)여야 합니다.
 * 
 * 예제)
 * Input: [0, 5, 0, 3, -1]
 * Output: [5, 3, -1, 0, 0]
 * 
 * Input: [3, 0, 3]
 * ﻿Output: [3, 3, 0]
 * 
 * @author CHUNGJUNG
 *
 */

public class SiliconValley09 {
	
	public static void main(String[] args) {
		int[] input = {0, 5, 0, 3, -1};
		
		int[] sorted = pushAllZerosToRight(input);
		
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i] + " ");
		}
		
	}
	
	/**
	 * 배열의 첫 원소부터 마지막까지 루프를 돌리면서 다음을 반복한다.
	 * 0이 아닌 값을 발견한다면 지금까지 쌓아왔던 원소의 다음 원소에 값을 저장
	 * 
	 * 반복문을 전부 완료한 뒤에는 지금까지 쌓아왔던 원소의 인덱스부터 끝까지 0으로 채우면 된다.
	 */
	private static int[] pushAllZerosToRight(int[] input) {
		int top = 0;
		
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 0) {
				continue;
			}
			
			input[top] = input[i];
			top++;
		}
		
		for ( ; top < input.length; top++) {
			input[top] = 0;
		}
		
		return input; 
	}
}
