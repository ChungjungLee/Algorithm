package ps.leetcode;

/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class Q136_SingleNumber {
	
	/**
	 * XOR 연산을 이용한다.
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		int result = 0;
		int len = nums.length;
		
		for (int index = 0; index < len; index++) {
			result = result ^ nums[index];
		}
		
		return result;
	}
	
	/*
	 * 또 다른 풀이들: hash table을 이용하여 push, pop을 하고 나면 남는 하나가 다른 숫자.
	 */
}
