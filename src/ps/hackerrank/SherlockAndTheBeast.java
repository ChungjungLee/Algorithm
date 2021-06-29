/*
    https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'decentNumber' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void decentNumber(int n) {
    // Write your code here
        int input = n;
        int num3 = (n >= 5) ? 0 : -1;
        int num5 = 0;
        
        
        while (n > 0) {
            if (n % 3 == 0) {
                num5 = (n / 3);
                break;
            }
            
            n = n - 5;
            num3++;
        }
        
        if (input == 7 || (num3 == 0 && num5 == 0)) {
            System.out.println("-1");
            return;
        }
        
        StringBuilder builder = new StringBuilder();
        for (int i = num5; i > 0; i--) {
            builder.append("555");
        }
        
        for (int i = num3; i > 0; i--) {
            builder.append("33333");
        }
        
        System.out.println(builder.toString());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                Result.decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
