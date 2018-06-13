package ps.ateam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Given an integer N, find the value of f(N) where f(N) = c(1) + c(2) + ... + c(N)
 * c(n) is sum of all divisors of n. 
 * 
 * Restraint
 * 1 <= N <= 10^5
 * the result can exceed the number of 32bit integer.  
 * 
 * Limit
 * time limit: 2sec
 * space limit: 256MB
 * 
 * @author CHUNGJUNG
 *
 */
public class Problem1Advanced {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// input will be come through the standard input.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		
		long startTime = System.nanoTime();
		
		System.out.println("sum of all divisors of 1 to N: " + solution(N));
		System.out.println("Elapsed Time: "+(System.nanoTime()-startTime)/1000000.0+"ms");
	}

	/**
	 * Let's find the repeated pattern of f(N).
	 * f(N) = c(1) + c(2) + ... + c(N)
	 * 
	 * c(1) = 1
	 * c(2) = 1 + 2
	 * c(3) = 1 + 3
	 * c(4) = 1 + 2 + 4
	 * c(5) = 1 + 5
	 * c(6) = 1 + 2 + 3 + 6
	 * c(7) = 1 + 7
	 * c(8) = 1 + 2 + 4 + 8
	 * c(9) = 1 + 3 + 9
	 * 
	 * It can be found that the number i appears (N/i) times in f(N).
	 */
	private static long solution(int N) {
		long sum = 0;
		
		for (int i = 1; i <= N; i++) {
			sum += ((N / i) * i);
		}
		
		return sum;
	}
}













