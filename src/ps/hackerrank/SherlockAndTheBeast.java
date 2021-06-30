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
        
        int numOfFive = 0;
        while (n > 0) {
            if (n % 3 == 0) {
                numOfFive = n / 3;
                break;
            }
            
            n -= 5;
        }
        
        int numOfThree = 0;
        if ((input - (numOfFive * 3)) % 5 == 0) {
            numOfThree = (input - (numOfFive * 3)) / 5;
        }
        
        if (numOfFive == 0 && numOfThree == 0) {
            System.out.println("-1");
            return;
        }
        
        StringBuilder builder = new StringBuilder();
        while (numOfFive > 0) {
            builder.append("555");
            numOfFive--;
        }
        
        while (numOfThree > 0) {
            builder.append("33333");
            numOfThree--;
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
