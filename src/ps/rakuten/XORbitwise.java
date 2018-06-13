package ps.rakuten;

public class XORbitwise {
	public static void main (String[] args) {
		for (int i = 1; i <= 32; i++) {
			System.out.println("1 ~ " + i + ": " + xorRange(1, i));
		}
		//System.out.println(xorRange(5, 8));
	}
	
	private static int xorRange(int M, int N) {
		
		int distance = N - M;
		
		double steps = Math.ceil( ((double) distance) / 2 );
		
		int start = M - 1;
		
		int result = 0;

		for ( long i = 0; i < steps ; i++) {
			
			//result ^= ++start ^ ++start;
			result ^= (start+1) ^ (start+2);
			start += 2;
		} 
		
		return (distance % 2 == 0) ?  result ^ N : result ;
		
	}
}
