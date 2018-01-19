package ps.leetcode;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Q9_PalindromeNumber {
	
	/**
	 * 추가 메모리 공간(배열, 맵, ...)을 사용할 수 없다.
	 * 숫자 계산을 이용한다.
	 * @param x
	 * @return
	 * 제출 결과: 280ms.
	 */
	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		
		int former = x;
		int reversed = 0;
		
		while (x != 0) {
			reversed = reversed * 10 + (x % 10);
			x /= 10;
		}
		
		return (former == reversed);
	}
	
	/**
	 * 숫자의 절반까지만 계산을 하여 비교한다
	 * @param x
	 * @return
	 * 제출 결과: 180ms
	 */
	public boolean isPalindrome2(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) return false;
		if (x < 10) return true;
		
		int reversed = 0;
		
		while (x > reversed) {
			reversed = reversed * 10 + (x % 10);
			x /= 10;
		}
		
		if (x != reversed) {
			if (x == 0) return false;
			reversed /= 10;
		}
		
		return x == reversed;
	}
}
