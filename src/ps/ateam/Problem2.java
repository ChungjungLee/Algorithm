package ps.ateam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		
		int[] p = new int[n];
		
		String ps = in.readLine();
		String[] splited = ps.split(" ");
		
		int i = 0;
		for (String wo : splited ) { 
			p[i] = Integer.parseInt(wo);
			i++;
		}
		
		System.out.println(solution(p));
	}
	
	private static int solution(int[] p) {
		int result = p[0];
		int limit = p[0];
		
		for (int i = 0; i < p.length - 1; i++) {
			if (p[i] < p[i+1]) {
				limit = (p[i] < limit) ? p[i] : limit;
				result += limit;
			} else {
				if (limit < p[i+1]) {
					result += limit;
				} else {
					result += p[i+1];
				}
			}
		}
		
		return result;
	}

}
