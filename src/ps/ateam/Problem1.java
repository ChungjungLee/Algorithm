package ps.ateam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int x = 0;
		try {
			x = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long result = 1;
		
		if (x != 1){
			for (int i = 2; i <= x; i++) {
				System.out.println(divSum(i));
				result = result + divSum(i);
			}
		}
		
		System.out.println(result);
	}
	
	private static long divSum(int num)
    {
        long result = 0;
      
        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            if (num % i == 0)
            {
                if (i == (num / i))
                    result += i;
                else
                    result += (i + num / i);
            }
        }
      
        return (result + 1 + num);
    }
}
