package ps.rakuten;
/**
 * Rakuten WEB test.
 * 
 * Compute bitwise XOR product from M to N.
 * 
 * time complexity: O(log N)
 * space complexity: O(1)
 * 
 * @author CHUNGJUNG
 *
 */

public class XORbitwise2 {
	
	public static void main (String[] args) {
		System.out.println(xorRange(5, 8));
	}
	
	/**
	 * Compute bitwise XOR product from M until N.
	 * @param M starting integer.
	 * @param N finishing integer.
	 * @return bitwise XOR product from M to N.
	 */
	private static int xorRange(int M, int N) {
		return computeXOR(M - 1) ^ computeXOR(N);
	}

	/**
	 * Compute bitwise XOR product from 1 until input number.
	 * 
	 * 0001(1), 0010(2), 0011(3), 0100(4), 
	 * 0101(5), 0110(6), 0111(7), 1000(8), ...
	 * 
	 * n % 4 == 3; returns 0000
	 * n % 4 == 0; returns n
	 * n % 4 == 1; returns 0001
	 * n % 4 == 2; returns n + 0001
	 * 
	 * @param n number which the bitwise XOR computation until.
	 * @return bitwise XOR product from 1 to n.
	 */
	private static int computeXOR(int n) {
        if (n % 4 == 0)
            return n;
      
        if (n % 4 == 1)
            return 1;
      
        if (n % 4 == 2)
            return n + 1;
      
        return 0;
	}
}
