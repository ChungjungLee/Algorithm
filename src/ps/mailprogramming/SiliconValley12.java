package ps.mailprogramming;

/**
 * 
 * 정수로된 배열이 주어지면, 각 원소가 자신을 뺀 나머지 원소들의 곱셈이 되게하라.
 * 
 * 단, 나누기 사용 금지, O(n) 시간복잡도
 * 
 * 예제)
 * input: [1, 2, 3, 4, 5]
 * output: [120, 60, 40, 30, 24]
 * 
 * 2 3 4 5
 * 1 3 4 5
 * 1 2 4 5
 * 1 2 3 5
 * 1 2 3 4
 * => 1x4 2x4 3x4 4x4 5x4
 * 
 * input: [3, 5, 1, 2, 4]
 * output: [40, 24, 120, 60, 30]
 * 
 * @author CHUNGJUNG
 *
 */
public class SiliconValley12 {

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 5};
		
		int[] result = multiplied(input);
		
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * (풀지 못하고 인터넷 해답을 참조)
	 * 공간 제약이 없으므로 결과를 수식으로 표현한 배열을 선언하면 해결가능
	 * 
	 * 1,
	 * a[0],
	 * a[0] a[1],
	 * a[0] a[1] a[2],
	 * a[0] a[1] a[2] a[3]
	 * 
	 * a[1] a[2] a[3] a[4],
	 *      a[2] a[3] a[4],
	 *           a[3] a[4],
	 *                a[4],
	 *                   1
	 *                   
	 */
	private static int[] multiplied(int[] input) {
		int[] result = new int[5];
		
		int[] arr1 = new int[5];
		int[] arr2 = new int[5];
		int element = 1;
		
		for (int i = 0; i < input.length; i++) {
			arr1[i] = element;
			element = element * input[i];
		}
		
		element = 1;
		for (int i = input.length - 1; i >= 0; i--) {
			arr2[i] = element;
			element = element * input[i];
		}
		
		for (int i = 0; i < input.length; i++) {
			result[i] = arr1[i] * arr2[i];
		}
		
		return result;
	}
}





















