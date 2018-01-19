package ps.leetcode;

/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class Q136_SingleNumber {
	
	/**
	 * XOR ������ �̿��Ѵ�.
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
	 * �� �ٸ� Ǯ�̵�: hash table�� �̿��Ͽ� push, pop�� �ϰ� ���� ���� �ϳ��� �ٸ� ����.
	 */
}
