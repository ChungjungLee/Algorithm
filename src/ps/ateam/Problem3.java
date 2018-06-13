package ps.ateam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		
		int[] a = new int[n];
		
		String ps = in.readLine();
		String[] splited = ps.split(" ");
		
		int i = 0;
		for (String wo : splited ) { 
			a[i] = Integer.parseInt(wo);
			i++;
		}
		
		if(solution(a)) {
			System.out.println("YES");			
		} else {
			System.out.println("NO");
		}
	}
	
	private static boolean solution(int[] a) {
		
		double angle1, angle2;
		
		for (int i = 1; i <= a.length; i++) {
			for (int j = i + 1; j <= a.length - 1; j++) {
				angle1 = (double)(a[j-1] - a[i-1]) / (j - i);
				angle2 = (double)(a[j] - a[j-1]) / 1;
				
				if (angle1 <= angle2) {
					return false;
				}
			}
		}
		
		return true;
	}

}
