package ps.codingdojang;

/*
 * 어떤 자연수 n이 있을 때, d(n)을 n의 각 자릿수 숫자들과 n 자신을 더한 숫자라고 정의하자.
 * 
 * 예를 들어
 * 
 * d(91) = 9 + 1 + 91 = 101
 * 
 * 이 때, n을 d(n)의 제네레이터(generator)라고 한다. 위의 예에서 91은 101의 제네레이터이다.
 * 어떤 숫자들은 하나 이상의 제네레이터를 가지고 있는데, 101의 제네레이터는 91 뿐 아니라 100도 있다. 
 * 그런데 반대로, 제네레이터가 없는 숫자들도 있으며, 이런 숫자를 인도의 수학자 Kaprekar가 셀프 넘버(self-number)라 이름 붙였다. 
 * 예를 들어 1,3,5,7,9,20,31 은 셀프 넘버 들이다.
 * 
 * 1 이상이고 5000 보다 작은 모든 셀프 넘버들의 합을 구하라.
 * 
 * 참조: http://codingdojang.com/scode/365?answer_mode=hide
 */
public class SelfNumber {
	
	/**
	 * 주어진 수 n까지의 총합에서 generator가 있는 숫자를 뺀 것이 self number의 총합
	 * @param n
	 * @return
	 */
	public int solution(int n) {
		boolean[] hasGenerator = new boolean[n];
		
		int result = n * (n + 1) / 2;
		
		for (int i = 1; i <= n; i++) {
			if (hasGenerator[i - 1]) result -= i;
			
			if (getGenerated(i) <= n) hasGenerator[getGenerated(i) - 1] = true;
		}
		
		return result;
	}
	
	public int getGenerated(int n) {
		int result = n;
		
		while (n > 0) {
			result += (n % 10);
			n /= 10;
		}
		
		return result;
	}
}




















